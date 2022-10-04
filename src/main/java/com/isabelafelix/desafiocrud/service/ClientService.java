package com.isabelafelix.desafiocrud.service;

import com.isabelafelix.desafiocrud.dto.ClientDto;
import com.isabelafelix.desafiocrud.entities.ClientEntity;
import com.isabelafelix.desafiocrud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    //INJETAR O REPOSITORY DENTRO DO SERVICE
    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public List<ClientDto> findAll(){
        List<ClientEntity> clientEntityList = repository.findAll();

        return clientEntityList.stream().map(x -> new ClientDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ClientDto findById(Long id) {
        Optional<ClientEntity> entity = repository.findById(id);
        ClientEntity client = entity.get();

        return new ClientDto(client);
    }
}
