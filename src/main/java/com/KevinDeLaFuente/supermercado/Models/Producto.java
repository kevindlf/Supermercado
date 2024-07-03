package com.KevinDeLaFuente.supermercado.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
