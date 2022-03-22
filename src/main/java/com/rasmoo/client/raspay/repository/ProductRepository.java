package com.rasmoo.client.raspay.repository;

import com.rasmoo.client.raspay.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<ProductModel,String> {

    Optional<ProductModel> findByAcronym(String acronym);

}
