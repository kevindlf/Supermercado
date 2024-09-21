package com.KevinDeLaFuente.supermercado.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JoinColumn(name = "sucursal_id")
    @JsonIgnoreProperties("producto")  // Evita la serialización de la lista 'personal' dentro de 'Sucursal'
    private Sucursal sucursal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties("producto")
    private Categoria categoria;

    @ManyToMany(mappedBy = "producto")
    @JsonIgnoreProperties("producto")
    private List<Venta> venta;

    @ManyToMany
    @JoinTable(
            name = "producto_proveedor",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "proveedor_id")
    )
    @JsonIgnoreProperties("producto")
    private List<Proveedores> proveedores;

}
