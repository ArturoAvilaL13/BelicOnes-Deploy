package com.belicones.APIRest.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class UsuarioDto {
    private int idUsuario;
    private String correo;
    private String contrasena;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private int idTipoDeUsuario;
}
