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
            IBAN
        ));
        return createdClient;
    }

    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }
}
