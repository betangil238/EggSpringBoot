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
@Table(name = "casa")
public class Casa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true )
    private long id;
    private String calle;
    private int numero;
    private String codPostal;
    private String ciudad;
    private String pais;
    @Column(columnDefinition = "DATETIME")
    private Date fechaDesde;
    @Column(columnDefinition = "DATETIME")
    private Date fechaHasta;
    private int minDias;
    private int maxDias;
    private double precio;
    private String tipoVivienda;
    private Long idFamilia;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFamilia",referencedColumnName = "id",insertable = false,updatable = false)
    private Familia familiaCasa;

    @OneToOne(mappedBy = "casaEstancia", fetch = FetchType.EAGER)
    private Estancia estancia;

    @OneToOne(mappedBy = "casaComentario", fetch = FetchType.EAGER)
    private Comentario comentario;
}
