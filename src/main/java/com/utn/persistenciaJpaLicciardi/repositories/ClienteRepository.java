package com.utn.persistenciaJpaLicciardi.repositories;

import com.utn.persistenciaJpaLicciardi.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
