package com.KevinDeLaFuente.supermercado.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "Sucursal")
@Entity
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "ubicación",nullable = false)
    private String ubicación;

    @Column(name = "email",nullable = false)
    private String email;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private java.util.Set<Personal> personal = new HashSet<>();

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private java.util.Set<Producto> producto = new HashSet<>();
}
