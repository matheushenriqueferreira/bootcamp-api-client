package com.matheus.apiclient.services;

import com.matheus.apiclient.dto.ClientDTO;
import com.matheus.apiclient.entities.Client;
import com.matheus.apiclient.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(Pageable page) {
        Page<Client> entity = repository.findAll(page);
        return entity.map(cli -> new ClientDTO(cli));
    }

}
