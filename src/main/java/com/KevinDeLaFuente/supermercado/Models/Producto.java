package com.KevinDeLaFuente.supermercado.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Producto")
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "precio",nullable = false)
    private Integer precio;

    @Column(name = "fechaElaboracion",nullable = false)
    private String fechaElaboracion;

    @Column(name = "vencimiento",nullable = false)
    private String vencimiento;

    @Column(name = "marca",nullable = false)
    private String marca;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToMany(mappedBy = "productos")
    private List<Venta> ventas;

    @ManyToMany
    @JoinTable(
            name = "producto_proveedor",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "proveedor_id")
    )
    private List<Proveedores> proveedores;

}
