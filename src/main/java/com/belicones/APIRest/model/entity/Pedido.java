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
@Table(name = "pedido")
public class Pedido implements Serializable {
    @Id
    @Column(name = "id_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;
    @Column(name = "total_pedido")
    private float totalPedido;
    @Column(name = "fk_id_usuario")
    private int fkIdUsuario;
    @Column(name = "fk_id_metodo_de_pago")
    private int fkIdMetodoDePago;
    @Column(name = "fk_id_tipo_de_envio")
    private int fkIdTipoDeEnvio;
}
