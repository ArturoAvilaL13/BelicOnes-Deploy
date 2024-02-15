package com.belicones.APIRest.model.entity.tipos.carne;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tipo_de_corte")
public class TipoDeCarne implements Serializable {
    @Id
    @Column(name = "id_tipo_de_corte")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoDeCorte;
    @Column(name = "tipo_de_corte")
    private String tipoDeCorte;
}
