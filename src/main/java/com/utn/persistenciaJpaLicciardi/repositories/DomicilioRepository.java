package com.utn.persistenciaJpaLicciardi.repositories;

import com.utn.persistenciaJpaLicciardi.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {
}
