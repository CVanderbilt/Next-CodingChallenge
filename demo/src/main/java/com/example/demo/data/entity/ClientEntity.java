package com.example.demo.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Each client represents a bank account that is associated with only a single card
@Document(collection = "clients")
public class ClientEntity {
    @Id
    private String id;
    private float balance;
    private boolean isActivated;
    private boolean isCredit;
    private String pin;
    private String iban;
}