package com.siifo.siifo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "detalleEvento")
public class Detalle_evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleEvento;

    @ManyToOne
    @JoinColumn(name = "usuarios_idUsuarios")
    private Usuario usario;

    @OneToOne
    @JoinColumn(name = "evento_idEvento")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "cliente_idCliente")
    private Cliente cliente;

    @Column(name = "fechaMovimiento", nullable = true)
    private Date fechaMovimiento;

    @Column(name = "aforoEvento", nullable = true)
    private int aforoEvento;

    @Column(name = "valorEvento", nullable = true, columnDefinition = "DECIMAL(10)")
    private Double valorEvento;

    @Column(name = "observacion", nullable = true, columnDefinition = "VARCHAR(200)")
    private String observacion;

    @Column(name = "paqueteEvento", nullable = true, columnDefinition = "ENUM('Orange', 'Blue', 'Platinum')")
    private String paqueteEvento;

    @Column(name = "direccionEvento", nullable = true, columnDefinition = "VARCHAR(200)")
    private String direccionEvento;
}

