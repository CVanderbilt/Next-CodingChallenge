package com.example.demo.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;;

// Each client represents a bank account that is associated with only a single card
@Document(collection = "clients")
@Data
@AllArgsConstructor
public class ClientEntity {
    @Id
    private String id;
    private float balance;
    private boolean isActivated;
    private boolean isCredit;
    private boolean requirePin;
    private String pin;
    private String iban;
    private String[] movements; // type, amount, date. Type can be: deposit, withdraw, transfer, commission
    private float creditLimit;
}
