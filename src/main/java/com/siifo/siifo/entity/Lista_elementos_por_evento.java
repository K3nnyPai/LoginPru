package com.siifo.siifo.entity;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "listaElementosPorEvento")
public class Lista_elementos_por_evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idListaDeElementosPorEvento;

    @OneToMany
    @JoinColumn(name = "productos_idProductos")
    private List<Producto> producto;

    @OneToOne
    @JoinColumn(name = "detalleEvento_idDetalleEvento")
    private Detalle_evento detalleEvento;

    @Column(name = "cantidad", nullable = true)
    private int cantidad;

    @OneToOne
    @JoinColumn(name = "usuarios_idUsuarios")
    private Usuario usuario;
}
