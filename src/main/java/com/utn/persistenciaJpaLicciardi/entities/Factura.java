package com.utn.persistenciaJpaLicciardi.entities;

import com.utn.persistenciaJpaLicciardi.enumerations.FormaDePago;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Factura")

public class Factura extends BaseEntity {

    private int numero;

    private Date fecha;

    private double descuento;

    @Enumerated(EnumType.STRING) // Esta anotación es crucial para decirle a JPA cómo persistir el enum

    private FormaDePago formaPago; //

    private int total;


}
