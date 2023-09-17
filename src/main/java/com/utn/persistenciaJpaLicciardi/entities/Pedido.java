package com.utn.persistenciaJpaLicciardi.entities;

import com.utn.persistenciaJpaLicciardi.enumerations.Estado;
import com.utn.persistenciaJpaLicciardi.enumerations.TipoDeEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Pedido")

public class Pedido extends BaseEntity {

    @Enumerated(EnumType.STRING) // Esta anotación es crucial para decirle a JPA cómo persistir el enum
    private Estado estado;

    private Date fecha;

    @Enumerated(EnumType.STRING) // Esta anotación es crucial para decirle a JPA cómo persistir el enum
    private TipoDeEnvio tipoEnvio; //

    private double total;

    // Relacion pedido y detalle pedido
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")

    @Builder.Default
    private List<DetallePedido> detalles = new ArrayList<>();

    // Relacion pedido y factura

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "factura_id")

    private Factura factura;

    public void agregarDetalles (DetallePedido detalle){
        detalles.add(detalle);
    }


}

