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
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true )
    private Long id;
    @Column(length = 255,unique = true)
    private String alias;
    @Column(unique = true)
    private String email;
    private String clave;
    @Column(columnDefinition = "DATETIME")
    private Date fechaIngreso;
    @Column(columnDefinition = "DATETIME")
    private Date fechaSalida;

    @OneToOne(mappedBy ="usuarioFamilia"  ,fetch = FetchType.EAGER)
    private Familia familia;

    @OneToOne(mappedBy = "usuarioCliente", fetch = FetchType.EAGER)
    private Cliente cliente;

}
