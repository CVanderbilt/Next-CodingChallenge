package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.data.entity.ClientEntity;
import com.example.demo.data.repository.ClientRepository;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    public static final String IBAN = "DE89370400440532013000"; // Represents the IBAN of our bank (dummy)

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientEntity createClient() {
        ClientEntity createdClient = clientRepository.save(new ClientEntity(
            null,
            0,
            false,
            false,
            false,
            "0000",
            IBAN,
            new String[] {},
            0
        ));
        return createdClient;
    }

    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    public void withdraw(String clientId, float amount) {
        ClientEntity client = clientRepository.findById(clientId).orElseThrow();
        if (!client.isActivated()) {
            throw new RuntimeException("Client is not activated");
        }
        if (client.isCredit()) {
            if (client.getBalance() - amount < -client.getCreditLimit()) {
                throw new RuntimeException("Not enough credit");
            }
        } else {
            if (amount > client.getBalance()) {
                throw new RuntimeException("Not enough balance");
            }
        }
        client.setBalance(client.getBalance() - amount);
        clientRepository.save(client);
    }

    public void deposit(String clientId, float amount) {
        ClientEntity client = clientRepository.findById(clientId).orElseThrow();
        if (!client.isActivated()) {
            throw new RuntimeException("Client is not activated");
        }
        client.setBalance(client.getBalance() + amount);
        clientRepository.save(client);
    }

    public void activate(String clientId) {
        System.out.println("Activating client " + clientId);
        ClientEntity client = clientRepository.findById(clientId).orElseThrow();
        if (client.isActivated()) {
            throw new RuntimeException("Client is already activated");
        }
        client.setActivated(true);
        clientRepository.save(client);
    }

    private String buildMovementString(String type, float amount) {
        return String.format("%s, %f, %s", type, amount, java.time.LocalDateTime.now().toString());
    }
}
