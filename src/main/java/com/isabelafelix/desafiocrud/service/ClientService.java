package com.isabelafelix.desafiocrud.service;

import com.isabelafelix.desafiocrud.entities.ClientEntity;
import com.isabelafelix.desafiocrud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    //INJETAR O REPOSITORY DENTRO DO SERVICE
    //PRECISA DE UMA DEPENDENCIA COM O REPOSITORY
    @Autowired
    private ClientRepository repository;

    //ACESSAR O REPOSITORY E CHAMAR NO BANCO DE DADOS OS CLIENTES
    public List<ClientEntity> findAll(){
        //METODO RETORNA O REPOSITORY
        return repository.findAll();

    }
}
