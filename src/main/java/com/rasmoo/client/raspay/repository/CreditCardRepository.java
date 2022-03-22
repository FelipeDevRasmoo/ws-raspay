package com.rasmoo.client.raspay.repository;

import com.rasmoo.client.raspay.model.CreditCardModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CreditCardRepository extends MongoRepository<CreditCardModel,String> {

    List<CreditCardModel> findByNumber(String number);
}
