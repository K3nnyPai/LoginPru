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
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;

    @Column(name = "ciudad", nullable = true, columnDefinition = "VARCHAR(45)")
    private String ciudad;

    @Column(name = "nit", nullable = true, columnDefinition = "INT(10)")
    private int nit;

    @Column(name = "nombreProveedor", nullable = true, columnDefinition = "VARCHAR(100)")
    private String nombreProveedor;
}
