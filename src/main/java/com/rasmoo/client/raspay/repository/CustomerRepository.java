package com.rasmoo.client.raspay.repository;

import com.rasmoo.client.raspay.model.CustomerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<CustomerModel,String> {

    Optional<CustomerModel> findByEmail(String email);

    Optional<CustomerModel> findByCpf(String cpf);
}
