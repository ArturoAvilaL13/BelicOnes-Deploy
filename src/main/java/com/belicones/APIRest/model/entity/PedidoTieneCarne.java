package com.belicones.APIRest.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "pedido_tiene_carne")
@IdClass(PedidoTieneCarne.class) //*Anotacion extra para cuando no se tiene un id definido en la tabla
public class PedidoTieneCarne implements Serializable {
    @Id//*Anotacion extra para cuando no se tiene un id definido en la tabla
    @Column(name = "fk_id_pedido")
    private int fkIdPedido;
    @Id//*Anotacion extra para cuando no se tiene un id definido en la tabla
    @Column(name = "fk_id_carne")
    private int fkIdCarne;
    @Column(name = "cantidad_carne")
    private int cantidadCarne;
}
