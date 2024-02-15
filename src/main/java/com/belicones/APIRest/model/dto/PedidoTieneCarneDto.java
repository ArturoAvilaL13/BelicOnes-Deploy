package com.belicones.APIRest.model.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class PedidoTieneCarneDto {
    private int fkIdPedido;
    private int fkIdCarne;
    private int cantidadCarne;
}
