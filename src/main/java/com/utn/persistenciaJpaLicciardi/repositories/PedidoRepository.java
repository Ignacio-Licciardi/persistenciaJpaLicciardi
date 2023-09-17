package com.utn.persistenciaJpaLicciardi.repositories;

import com.utn.persistenciaJpaLicciardi.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
