package com.pruebaspringboot.service;


import com.pruebaspringboot.dto.*;
import com.pruebaspringboot.entity.CardEntity;

public interface ICreateCardService {

    public ResponseCard createCard(RequestCard responseCard);

    ResponseEnroll enRollCard(RequestEnroll requestEnroll);

    ResponseSearchCard getCard(Long validationNumber);

    ResponseDeletCard deleteCard(RequestEnroll requestEnroll);

    CardEntity getCardByTransaction(String hash);
}
