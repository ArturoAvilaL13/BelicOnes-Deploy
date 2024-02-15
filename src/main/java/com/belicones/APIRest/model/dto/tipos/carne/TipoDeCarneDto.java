package com.belicones.APIRest.model.dto.tipos.carne;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class TipoDeCarneDto {
    private int idTipoDeCorte;
    private String tipoDeCorte;
}
