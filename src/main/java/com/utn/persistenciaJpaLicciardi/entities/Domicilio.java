package com.utn.persistenciaJpaLicciardi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Domicilio")

public class Domicilio extends BaseEntity {

    private String calle;

    private int numero;

    private String localidad;


}
