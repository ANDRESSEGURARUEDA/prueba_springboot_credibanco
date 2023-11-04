package com.pruebaspringboot.service.impl;


import com.pruebaspringboot.dto.*;
import com.pruebaspringboot.entity.CardEntity;
import com.pruebaspringboot.entity.TypeCardEntity;
import com.pruebaspringboot.repository.ICardRepository;
import com.pruebaspringboot.service.ICreateCardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

@Service
public class CardService implements ICreateCardService {

    @Autowired
    ICardRepository cardRepository;
    @Autowired
    TypeCardService typeCardService;
    @Value ("${exitoso}")
    String exitoso;
    @Value ("${fallido}")
    String fallido;
    @Autowired
    ModelMapper modelMapper = new ModelMapper();

    public ResponseCard createCard(RequestCard requestCard) {
        ResponseCard responseCard = new ResponseCard();
        try {
            CardEntity cardEntity = modelMapper.map(requestCard, CardEntity.class);
            cardEntity.setValidationNumber((long) new Random().nextInt(100));
            cardEntity.setHash((Arrays.toString(MessageDigest.getInstance("MD5").digest(String.valueOf(requestCard.getPan()).getBytes()))));
            TypeCardEntity typeCardEntity = typeCardService.getTypeCardEntity(requestCard.getTipoTarjeta());
            if (typeCardEntity != null) {
                cardEntity.setEstadoTarjetaId("Inactiva");
                cardEntity.setTipoTarjeta(typeCardEntity);
                cardEntity.setFechaCreacion(LocalDateTime.now());
                cardEntity.setUltimaModificacion(LocalDateTime.now());
                cardEntity = cardRepository.save(cardEntity);
                if (cardEntity.getId() != null) {
                    responseCard.setStatus("00");
                    responseCard.setMessage(exitoso);
                    responseCard.setNumeroValidacion(cardEntity.getValidationNumber());
                    responseCard.setPan(panEncriptado(String.valueOf(cardEntity.getPan())));
                    responseCard.setIdentificadorDelSisitema(cardEntity.getHash());
                    return responseCard;
                }
            }
            responseCard.setStatus("01");
            responseCard.setMessage(fallido);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return responseCard;
    }

    @Override
    public ResponseEnroll enRollCard(RequestEnroll requestEnroll) {
        ResponseEnroll responseEnroll = new ResponseEnroll();
        CardEntity card = cardRepository.findByHash(requestEnroll.getHash());
        if (card == null) {
            responseEnroll.setStatus("01");
            responseEnroll.setMessage("Tarjeta no existe");
            return responseEnroll;
        }
        if (card.getValidationNumber().equals(requestEnroll.validationNumber)) {
            card.setEstadoTarjetaId("Enrolada");
            card.setUltimaModificacion(LocalDateTime.now());
            card = cardRepository.save(card);
            responseEnroll.setStatus("00");
            responseEnroll.setMessage("Exito");
            responseEnroll.setPan(panEncriptado(String.valueOf(card.getPan())));
            return responseEnroll;
        }
        if (card.getValidationNumber() != requestEnroll.validationNumber) {
            responseEnroll.setStatus("02");
            responseEnroll.setMessage("Número de validación inválido");
            responseEnroll.setPan(panEncriptado(String.valueOf(card.getPan())));
            return responseEnroll;
        }
        return responseEnroll;
    }

    public ResponseSearchCard getCard(Long validationNumber) {
        ResponseSearchCard responseSearchCard = new ResponseSearchCard();
        CardEntity card = cardRepository.findByValidationNumber(validationNumber);
        if (card == null) {
            return responseSearchCard;
        }
        modelMapper.map(card, responseSearchCard);
        responseSearchCard.setPan(panEncriptado(String.valueOf(card.getPan())));
        return responseSearchCard;
    }
    @Override
    public ResponseDeletCard deleteCard(RequestEnroll requestEnroll) {
        ResponseDeletCard deletCard = new ResponseDeletCard();
        CardEntity cardHash = cardRepository.findByHash(requestEnroll.getHash());
        CardEntity cardValidationNumber = cardRepository.findByValidationNumber(requestEnroll.getValidationNumber());
        if (cardHash != null && cardValidationNumber != null) {
            cardRepository.delete(cardValidationNumber);
            deletCard.setStatus("00");
            deletCard.setMessage("Se ha eliminado la tarjeta");
            return deletCard;
        }
        deletCard.setStatus("01");
        deletCard.setMessage("No se ha eliminado la tarjeta");
        return deletCard;
    }

    @Override
    public CardEntity getCardByTransaction(String hash) {
        CardEntity card = cardRepository.findByHash(hash);
        return card != null ? card : null;
    }

    public String panEncriptado(String pan) {
        String pan1 = pan.substring(0, 6);
        String pan2 = "";
        String pan3 = pan.substring(pan.length() - 4);
        int pan4 = pan1.length() + pan3.length();
        for (int i = pan4; i < pan.length(); i++) {
            pan2 += "*";
        }
        return pan1 + pan2 + pan3;
    }

}
