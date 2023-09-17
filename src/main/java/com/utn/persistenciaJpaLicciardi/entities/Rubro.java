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
@Table (name = "Rubro")
public class Rubro extends BaseEntity {

    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro_id")

    @Builder.Default
    List<Producto> productos = new ArrayList<>();

    public void agregarProductos( Producto producto){
        productos.add(producto);
    }


}
