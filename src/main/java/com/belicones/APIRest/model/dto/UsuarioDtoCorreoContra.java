package com.belicones.APIRest.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class UsuarioDtoCorreoContra {
    private String correo;
    private String contrasena;
}
