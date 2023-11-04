package com.pruebaspringboot.controller;

import com.pruebaspringboot.dto.RequestCancelTransactions;
import com.pruebaspringboot.dto.RequestTransactions;
import com.pruebaspringboot.dto.ResponseTransaction;
import com.pruebaspringboot.service.impl.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping(path = "create-transaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseTransaction> createTransaction(@RequestBody RequestTransactions requestTransactions){
        ResponseTransaction responseTransaction = new ResponseTransaction();
        responseTransaction = transactionService.createTransaction(requestTransactions);
        return ResponseEntity.status(responseTransaction.getStatusCode().equals("00") ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(responseTransaction);
    }

    @PostMapping(path = "cancel-transaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseTransaction> cancelTransaction(@RequestBody RequestCancelTransactions cancelTransactions){
        ResponseTransaction responseTransaction = transactionService.cancelTransaction(cancelTransactions);
        return ResponseEntity.status(responseTransaction.getStatusCode().equals("00") ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(responseTransaction);
    }

}
