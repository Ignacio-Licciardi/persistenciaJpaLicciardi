package com.utn.persistenciaJpaLicciardi.repositories;

import com.utn.persistenciaJpaLicciardi.entities.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido,Long> {
}
