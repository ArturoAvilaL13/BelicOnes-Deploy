package com.belicones.APIRest.model.dto.tipos.entrega;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class TipoEntregaDto {
    private int idTipoDeEntrega;
    private String tipoDeEntrega;
}
