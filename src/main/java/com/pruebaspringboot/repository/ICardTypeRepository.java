package com.pruebaspringboot.repository;


import com.pruebaspringboot.entity.TypeCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICardTypeRepository extends JpaRepository<TypeCardEntity, Long> {

}
