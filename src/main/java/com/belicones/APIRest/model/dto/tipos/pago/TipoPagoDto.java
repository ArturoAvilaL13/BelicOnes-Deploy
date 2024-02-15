package com.belicones.APIRest.model.dto.tipos.pago;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class TipoPagoDto {
    private int idMetodoDePago;
    private String metodoDePago;
}
