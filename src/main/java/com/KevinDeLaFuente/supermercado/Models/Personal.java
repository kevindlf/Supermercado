package com.KevinDeLaFuente.supermercado.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "Personal")
@Entity
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "apellido",nullable = false)
    private String apellido;

    @Column(name = "email",nullable = false)
    private String email;


@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "sucursal_id")
@JsonIgnoreProperties("personal")  // Evita la serialización de la lista 'personal' dentro de 'Sucursal'
private Sucursal sucursal;

}
