package com.example.demo.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.data.entity.ClientEntity;

public interface ClientRepository extends MongoRepository<ClientEntity, String> {
    // Define custom query methods here (if needed)
}

