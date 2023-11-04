package com.pruebaspringboot.repository;


import com.pruebaspringboot.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICardRepository extends JpaRepository<CardEntity, Long> {

    CardEntity findByHash(String hash);
    CardEntity findByValidationNumber(Long validationNumber);

    CardEntity deleteByValidationNumber(Long validationNumber);
}
