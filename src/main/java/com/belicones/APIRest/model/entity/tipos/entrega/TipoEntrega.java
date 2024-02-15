package com.belicones.APIRest.model.entity.tipos.entrega;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tipo_de_entrega")
public class TipoEntrega implements Serializable {
    @Id
    @Column(name = "id_tipo_de_entrega")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoDeEntrega;
    @Column(name = "tipo_de_entrega")
    private String tipoDeEntrega;
}
