package com.estancias.ejercicio.Persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "estancia")
public class Estancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true )
    private Long id;
    private String huesped;
    @Column(columnDefinition = "DATETIME")
    private Date fechaInicio;
    @Column(columnDefinition = "DATETIME")
    private Date fechaFinal;
    private Long idCliente;
    private Long idCasa;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente", referencedColumnName = "id", updatable = false,insertable = false)
    private Cliente clienteEstancia;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCasa",referencedColumnName = "id",insertable = false,updatable = false)
    private Casa casaEstancia;

}
