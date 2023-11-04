package com.pruebaspringboot.service;

import com.pruebaspringboot.dto.RequestCancelTransactions;
import com.pruebaspringboot.dto.RequestTransactions;
import com.pruebaspringboot.dto.ResponseTransaction;
import com.pruebaspringboot.entity.TransactionEntity;


public interface ITransactionService {

    ResponseTransaction createTransaction(RequestTransactions requestTransactions);
    ResponseTransaction cancelTransaction(RequestCancelTransactions cancelTransactions);



}
