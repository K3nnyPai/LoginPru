package com.siifo.siifo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagos;

    @ManyToOne
    @JoinColumn(name = "metodoDePagoPrincipal_idMetodoDePagoPrincipal")
    private Metodo_de_pago metodoDePagoPrincipal;

    @Column(name = "fechaPago", nullable = true)
    private Date fechaPago;

    @ManyToOne
    @JoinColumn(name = "detalleEvento_idDetalleEvento")
    private Detalle_evento detalleEvento;

    @Column(name = "numeroTarjeta", nullable = true, columnDefinition = "INT(11)")
    private int numeroTarjeta;

    @Column(name = "valor", nullable = true, columnDefinition = ("FLOAT"))
    private double valor;
}

