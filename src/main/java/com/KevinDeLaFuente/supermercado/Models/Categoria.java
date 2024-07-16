package com.KevinDeLaFuente.supermercado.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "Categoria")
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

}
