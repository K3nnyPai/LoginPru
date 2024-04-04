package com.siifo.siifo.entity;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "OrdenCompra")
public class Orden_Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagos;

    @Column(name = "estadoOrden", nullable = true, columnDefinition = "ENUM('Pagado', 'Vencido')")
    private String estadoOrden;

    @ManyToOne
    @JoinColumn(name="cliente_idCliente)")
    private Cliente cliente;

    @OneToMany
    @JoinColumn(name="pago_idPagos)")
    private List<Pago> pago;

    @OneToOne
    @JoinColumn(name="detalleEvento_idDetalleEvento)")
    private Detalle_evento detalleEvento;
}
