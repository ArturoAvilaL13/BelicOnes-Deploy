package com.belicones.APIRest.model.entity.tipos.pago;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "metodo_de_pago")
public class TipoPago implements Serializable {
    @Id
    @Column(name = "id_metodo_de_pago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMetodoDePago;
    @Column(name = "metodo_de_pago")
    private String metodoDePago;
}
