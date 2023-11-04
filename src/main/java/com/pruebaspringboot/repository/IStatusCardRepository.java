package com.pruebaspringboot.repository;


import com.pruebaspringboot.entity.StatusCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusCardRepository extends JpaRepository<StatusCard, Long> {

}
