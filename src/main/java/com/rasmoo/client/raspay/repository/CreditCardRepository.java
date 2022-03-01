package com.rasmoo.client.raspay.repository;

import com.rasmoo.client.raspay.model.CreditCardModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CreditCardRepository extends MongoRepository<CreditCardModel,String> {

    Optional<CreditCardModel> findByNumber(String number);
}
