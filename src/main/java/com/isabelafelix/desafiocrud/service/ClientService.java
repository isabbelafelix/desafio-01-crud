package com.isabelafelix.desafiocrud.service;

import com.isabelafelix.desafiocrud.dto.ClientDto;
import com.isabelafelix.desafiocrud.entities.ClientEntity;
import com.isabelafelix.desafiocrud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    //INJETAR O REPOSITORY DENTRO DO SERVICE
    //PRECISA DE UMA DEPENDENCIA COM O REPOSITORY
    @Autowired
    private ClientRepository repository;

    //ACESSAR O REPOSITORY E CHAMAR NO BANCO DE DADOS OS CLIENTES
    @Transactional(readOnly = true)

    public List<ClientDto> findAll(){
        List<ClientEntity> clientEntityList = repository.findAll();

        return clientEntityList.stream().map(ClientDto::new).collect(Collectors.toList());

    }
}
