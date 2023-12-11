package com.estancias.ejercicio.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true )
    private Long id;
    private String descripcion;
    private Long idCasa;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCasa", referencedColumnName = "id",insertable = false,updatable = false)
    private Casa casaComentario;
}
