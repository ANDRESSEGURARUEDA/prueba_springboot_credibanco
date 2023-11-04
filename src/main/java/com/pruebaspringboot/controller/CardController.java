package com.pruebaspringboot.controller;


import com.pruebaspringboot.dto.*;
import com.pruebaspringboot.service.impl.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("api")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping (path = "create-card", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseCard> createCard(@Validated @RequestBody RequestCard requestCard, BindingResult result) {
        ResponseCard responseCard = new ResponseCard();
        if (result.hasErrors()) {
            responseCard.setMessage("Fallido");
            responseCard.setStatus("01");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseCard);
        }
        responseCard = cardService.createCard(requestCard);
        return ResponseEntity.status(responseCard.getStatus().equals("00") ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(responseCard);
    }

    @PutMapping (path = "enroll-card", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseEnroll> enRollCard(@RequestBody RequestEnroll requestEnroll){
        ResponseEnroll responseEnroll = new ResponseEnroll();
        responseEnroll = cardService.enRollCard(requestEnroll);
        return ResponseEntity.status(responseEnroll.getStatus().equals("00") ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(responseEnroll);
    }

    @GetMapping("get-card{validationNumber}")
    public ResponseEntity<ResponseSearchCard> getCard(@RequestParam  Long validationNumber){
        ResponseSearchCard responseSearchCard = new ResponseSearchCard();
        responseSearchCard = cardService.getCard(validationNumber);
        if (responseSearchCard.getPan() != null) {
            return ResponseEntity.status(HttpStatus.OK).body(responseSearchCard);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseSearchCard);
    }

    @DeleteMapping("delete-card")
    public ResponseEntity<ResponseDeletCard> deleteCard(@RequestBody RequestEnroll requestEnroll){
        ResponseDeletCard deletCard = cardService.deleteCard(requestEnroll);
        return ResponseEntity.status(deletCard.getStatus().equals("00") ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(deletCard);
    }
}
