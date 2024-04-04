package com.siifo.siifo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "encuestaSatisfaccion")
public class Encuesta_satisfaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEncuestaSatisfaccion;

    @Column(name = "fechaEncuesta", nullable = true)
    private Date fechaMovimiento;

    @Column(name = "calificacion", nullable = true)
    private int calificacion;

    @Column(name = "comentario", nullable = true, columnDefinition = "ENUM('Orange', 'Blue', 'Platinum')")
    private String paqueteEvento;

    @OneToOne
    @JoinColumn(name = "detalle_idDetalleEvento")
    private Detalle_evento detalle_evento;
}
