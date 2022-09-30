package com.isabelafelix.desafiocrud.controller;

import com.isabelafelix.desafiocrud.entities.ClientEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @GetMapping
    public ResponseEntity<List<ClientEntity>> findAll() {
        //DECLARAR UMA LISTA DO TIPO CLIENTENTITY E INSTANCIAR
        List<ClientEntity> clientEntityList = new ArrayList<>();

        //ADICIONAR ALGUNS ELEMENTOS NESSA LISTA
        //PASSANDO OS OBJETOS DO TIPO CLIENTENTITY
        clientEntityList.add(new ClientEntity(1L, "Isabela", "003.456.279-79", 3000D, Instant.now(), null));
        clientEntityList.add(new ClientEntity(2L, "Mariana", "657.856.789-79", 2000D, Instant.now(), null));
        clientEntityList.add(new ClientEntity(3L, "Monaliza", "987.456.964-79", 1200D, Instant.now(), null));

        //PEDIR PRO METODO FINDALL RETORNAR A LISTA, NO CORPO DA RESPOSTA HTTP DESSA REQUISIÇÃO
        //PRA INSTANCIAR O OBJETO RESPONSEENTITY, USAR OS METODOS BUILDER DELE
        return ResponseEntity.ok().body(clientEntityList);


    }
}
