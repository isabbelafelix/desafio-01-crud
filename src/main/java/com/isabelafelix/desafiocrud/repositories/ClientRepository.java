package com.isabelafelix.desafiocrud.repositories;

import com.isabelafelix.desafiocrud.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
