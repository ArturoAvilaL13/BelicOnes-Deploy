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
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "correo")
    private String correo;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fk_id_tipo_de_usuario")
    private int idTipoDeUsuario;
}
