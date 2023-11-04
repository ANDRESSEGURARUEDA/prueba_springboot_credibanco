package com.pruebaspringboot.service.impl;

import com.pruebaspringboot.entity.StatusCard;
import com.pruebaspringboot.repository.IStatusCardRepository;
import com.pruebaspringboot.service.IStatusCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StatusCardService implements IStatusCardService {

    @Autowired
    IStatusCardRepository cardRepository;

    @Override
    public StatusCard getStatusCard(long id) {
        Optional<StatusCard> statusCard = cardRepository.findById(id);
        return statusCard.isPresent() ? statusCard.get() : null;
    }


}
