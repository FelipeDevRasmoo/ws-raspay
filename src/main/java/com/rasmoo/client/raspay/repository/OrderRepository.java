package com.rasmoo.client.raspay.repository;

import com.rasmoo.client.raspay.model.OrderModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepository extends MongoRepository<OrderModel,String> {
    Optional<OrderModel> findByCustomerId(String customerId);
}
