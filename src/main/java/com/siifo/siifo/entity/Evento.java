package com.siifo.siifo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;

    @Column(name = "nombreEvento", nullable = true, columnDefinition = "VARCHAR(45)")
    private String nombreEvento;

    
    @Column(name = "descripcionEvento", nullable = true, columnDefinition = "VARCHAR(200)")
    private String descripcionEvento;
}
