package com.isabelafelix.desafiocrud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private Instant birthDate;
    private Integer children;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
