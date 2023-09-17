package com.utn.persistenciaJpaLicciardi.repositories;

import com.utn.persistenciaJpaLicciardi.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
