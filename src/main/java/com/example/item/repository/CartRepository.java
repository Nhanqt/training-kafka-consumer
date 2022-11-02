package com.example.item.repository;

import com.example.item.entity.CartEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CartRepository extends MongoRepository<CartEntity, String> {
}
