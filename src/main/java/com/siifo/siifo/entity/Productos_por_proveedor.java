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
@Table(name = "productosPorProvedor")
public class Productos_por_proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductosPorProveedor;

    @ManyToOne
    @JoinColumn(name = "prodcutos_idProdcutos")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "proveedor_idProveedor")
    private Proveedor proveedor;

    @Column(name = "fechaCompra", nullable = true)
    private Date fechaEntrega;

    @Column(name = "cantidad", nullable = true)
    private int cantidad;

    @Column(name = "valor", nullable = true)
    private double valor;

    @Column(name = "categoria", nullable = true, columnDefinition = "ENUM('Sonido', 'Luces', 'Decoraciones', 'Accesorios', 'Colegios', 'Otros')")
    private String categoria;
}
