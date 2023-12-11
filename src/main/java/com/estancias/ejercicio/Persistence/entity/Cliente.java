package com.estancias.ejercicio.Persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true )
    private Long id;
    private String nombre;
    private String calle;
    private Integer numero;
    private String codPostal;
    private String ciudad;
    private String pais;
    private String email;
    private Long idUsuario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", referencedColumnName = "id",insertable = false,updatable = false)
    private Usuario usuarioCliente;

    @OneToOne(mappedBy = "clienteEstancia", fetch = FetchType.EAGER)
    private Estancia estancia;

}
