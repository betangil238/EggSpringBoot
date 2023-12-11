package com.estancias.ejercicio.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "familia")
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true )
    private Long id;
    private String nombre;
    private int edadMin;
    private int edadMax;
    private int numHijos;
    private String email;
    private long idUsuario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", referencedColumnName = "id",insertable = false,updatable = false)
    private Usuario usuarioFamilia;

    @OneToOne(mappedBy = "familiaCasa",fetch = FetchType.EAGER)
    private Casa casa;
}
