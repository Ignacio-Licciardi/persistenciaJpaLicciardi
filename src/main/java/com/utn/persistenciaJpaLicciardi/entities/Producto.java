package com.utn.persistenciaJpaLicciardi.entities;

import com.utn.persistenciaJpaLicciardi.enumerations.TipoProducto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Producto")
public class Producto extends BaseEntity {
    @Enumerated(EnumType.STRING) // Esta anotación es crucial para decirle a JPA cómo persistir el enum
    private TipoProducto tipo; //

    private int tiempoEstimadoCocina;

    private String denominacion;

    private double precioVenta;

    private double precioCompra;

    private int stockMinimo;

    private int stockActual;

    private String unidadMedida;

    private String receta;


}
