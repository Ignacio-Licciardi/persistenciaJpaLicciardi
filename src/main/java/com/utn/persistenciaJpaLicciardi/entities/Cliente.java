package com.utn.persistenciaJpaLicciardi.entities;


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
@Table(name = "Cliente")
public class Cliente extends BaseEntity {

    private String nombre;

    private String apellido;

    private String email;

    private  int telefono;

    // Relacion entre cliente y domicilio

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")    // FK cliente_id

    @Builder.Default // Para que no de error lombok
    List<Domicilio> domicilios = new ArrayList<>();

    // Relacion entre cliente y pedido

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")    // FK cliente_id

    @Builder.Default // Para que no de error lombok
    List<Pedido> pedidos = new ArrayList<>();

    public void agregarDomicilio(Domicilio domicilio){
        domicilios.add(domicilio);
    }


    public void agregarPedidos(Pedido pedido){
        pedidos.add(pedido);
    }

}



