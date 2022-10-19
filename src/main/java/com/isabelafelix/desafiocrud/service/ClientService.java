package com.isabelafelix.desafiocrud.service;

import com.isabelafelix.desafiocrud.dto.ClientDto;
import com.isabelafelix.desafiocrud.entities.ClientEntity;
import com.isabelafelix.desafiocrud.repositories.ClientRepository;
import com.isabelafelix.desafiocrud.service.exceptions.DatabaseException;
import com.isabelafelix.desafiocrud.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    //INJETAR O REPOSITORY DENTRO DO SERVICE
    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDto> findAllPaged(PageRequest pageRequest){
        Page<ClientEntity> clientEntityList = repository.findAll(pageRequest);

        return clientEntityList.map(x -> new ClientDto(x));
    }

    @Transactional(readOnly = true)
    public ClientDto findById(Long id) {
        Optional<ClientEntity> entity = repository.findById(id);
        ClientEntity client = entity.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        return new ClientDto(client);
    }

    @Transactional
    public ClientDto insert(ClientDto clientDto) {
        ClientEntity entity = new ClientEntity();
        entity.setName(clientDto.getName());
        entity.setCpf(clientDto.getCpf());
        entity.setIncome(clientDto.getIncome());
        entity.setBirthDate(clientDto.getBirthDate());
        entity.setChildren(clientDto.getChildren());

        entity = repository.save(entity);

        return new ClientDto(entity);
    }

    @Transactional
    public ClientDto update(Long id, ClientDto clientDto) {
        try{
            ClientEntity entity = repository.getReferenceById(id);
            entity.setName(clientDto.getName());
            entity.setCpf(clientDto.getCpf());
            entity.setIncome(clientDto.getIncome());
            entity.setBirthDate(clientDto.getBirthDate());
            entity.setChildren(clientDto.getChildren());

            entity = repository.save(entity);

            return new ClientDto(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not found" + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
}
