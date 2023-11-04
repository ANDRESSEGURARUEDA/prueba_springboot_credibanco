package com.pruebaspringboot.service.impl;

import com.pruebaspringboot.entity.TypeCardEntity;
import com.pruebaspringboot.repository.ICardTypeRepository;
import com.pruebaspringboot.service.ITypeCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TypeCardService implements ITypeCardService {

    @Autowired
    ICardTypeRepository cardTypeRepository;

    @Override
    public TypeCardEntity getTypeCardEntity(long id) {
       Optional<TypeCardEntity> typeCardEntity = cardTypeRepository.findById(id);
        return typeCardEntity.isPresent() ? typeCardEntity.get() : null;
    }
}
