package com.pruebaspringboot.service.impl;

import com.pruebaspringboot.dto.RequestCancelTransactions;
import com.pruebaspringboot.dto.RequestTransactions;
import com.pruebaspringboot.dto.ResponseTransaction;
import com.pruebaspringboot.entity.CardEntity;
import com.pruebaspringboot.entity.TransactionEntity;
import com.pruebaspringboot.repository.ITransactionRepository;
import com.pruebaspringboot.service.ITransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    ITransactionService transactionService;

    @Autowired
    ITransactionRepository transactionRepository;
    @Autowired
    CardService cardService;

    @Autowired
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ResponseTransaction createTransaction(RequestTransactions requestTransactions) {
        ResponseTransaction responseTransaction = new ResponseTransaction();
        TransactionEntity transactionEntity = new TransactionEntity();
        CardEntity cardEntity = cardService.getCardByTransaction(requestTransactions.getHash());
        TransactionEntity transaction = transactionRepository.findByNumberReference(requestTransactions.getNumberReference());
        if (cardEntity == null) {
            responseTransaction.setStatusCode("01");
            responseTransaction.setMessage("Tarjeta no existe");
            responseTransaction.setStatusTransaction("rechazada");
            responseTransaction.setNumberReference(requestTransactions.numberReference);
            return responseTransaction;
        }
        if (transaction != null && transaction.getNumberReference() == requestTransactions.getNumberReference()) {
            responseTransaction.setStatusCode("04");
            responseTransaction.setMessage("Numero de referncia ya existe");
            responseTransaction.setStatusTransaction("rechazada");
            responseTransaction.setNumberReference(requestTransactions.numberReference);
            return responseTransaction;
        }
        if (cardEntity != null && cardEntity.getEstadoTarjetaId().equals("Enrolada")) {
            transactionEntity = modelMapper.map(requestTransactions, TransactionEntity.class);
            transactionEntity.setStatusTransaction("Aprobada");
            transactionEntity.setCreateDate(LocalDateTime.now());
            transactionEntity.setLastModifiedDate(LocalDateTime.now());
            transactionRepository.save(transactionEntity);
            responseTransaction.setStatusCode("00");
            responseTransaction.setMessage("Compra Exitosa");
            responseTransaction.setStatusTransaction("Aprobada");
            responseTransaction.setNumberReference(requestTransactions.numberReference);
            return responseTransaction;
        }
        if (!cardEntity.getEstadoTarjetaId().equals("Enrolada")) {
            responseTransaction.setStatusCode("02");
            responseTransaction.setMessage("Tarjeta no enrolada");
            responseTransaction.setStatusTransaction("rechazada");
            responseTransaction.setNumberReference(requestTransactions.numberReference);
            return responseTransaction;
        }
        return null;
    }

    @Override
    public ResponseTransaction cancelTransaction(RequestCancelTransactions cancelTransactions) {
        ResponseTransaction responseTransaction = new ResponseTransaction();
        TransactionEntity transactionEntity = transactionRepository.findByNumberReference(cancelTransactions.getNumberReference());
        if (transactionEntity == null || transactionEntity.getNumberReference() != cancelTransactions.getNumberReference()) {
            responseTransaction.setStatusCode("01");
            responseTransaction.setMessage("Numero de referencia invalido");
            responseTransaction.setNumberReference(cancelTransactions.getNumberReference());
            return responseTransaction;
        }
        if (transactionEntity != null && Duration.between(transactionEntity.getCreateDate(), LocalDateTime.now()).toMinutes() <= 5) {
            transactionEntity.setStatusTransaction("Anulada");
            transactionRepository.save(transactionEntity);
            responseTransaction.setStatusCode("00");
            responseTransaction.setMessage("Compra Anulada");
            responseTransaction.setNumberReference(cancelTransactions.getNumberReference());
            return responseTransaction;
        }
        if (transactionEntity != null && Duration.between(transactionEntity.getCreateDate(), LocalDateTime.now()).toMinutes() > 5) {
            responseTransaction.setStatusCode("02");
            responseTransaction.setMessage("No se puede anular transacción");
            responseTransaction.setNumberReference(cancelTransactions.getNumberReference());
            return responseTransaction;
        }
        return null;
    }

}
