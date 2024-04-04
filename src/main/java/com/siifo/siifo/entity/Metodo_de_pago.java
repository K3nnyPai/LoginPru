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
@Table(name = "metodoDePago")
public class Metodo_de_pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmetodoDePago;

    @Column(name = "nombreMetodoDePago", nullable = true, columnDefinition = "ENUM('Tarjeta Debito', 'Efectivo', 'Medio_Mano', 'Tarjeta Credito')")
    private String nombreMetodoDePago;
}
