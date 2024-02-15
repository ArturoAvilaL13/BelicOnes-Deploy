package com.belicones.APIRest.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "carne")
public class Carne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carne")
    private int idCarne;
    @Column(name = "nombre_carne")
    private String nombreCarne;
    @Column(name = "descripcion_carne")
    private String descripcionCarne;
    @Column(name = "precio_carne")
    private double precioCarne;
    @Lob
    @Column(name = "imagen_carne",columnDefinition = "LONGTEXT")
    private String imagenCarne;
    @Column(name = "fk_id_tipo_de_corte")
    private int fkIdTipoDeCorte;

}
