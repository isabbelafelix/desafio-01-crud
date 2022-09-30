package com.isabelafelix.desafiocrud.controller;

import com.isabelafelix.desafiocrud.dto.ClientDto;
import com.isabelafelix.desafiocrud.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    //DECLARAR UMA DEPENDENCIA PARA O SERVICE E INJETAR
    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientDto>> findAll() {
        //QUERO UMA LISTA VINDO DO BANCO DE DADOS
        //CRIO UMA VARIAVEL DE CLIENTES, RECEBENDO O SERVICE
        List<ClientDto> dtoList = service.findAll();
        //RETORNO A LISTA NA REQUISIÇÃO
        return ResponseEntity.ok().body(dtoList);


    }
}
