package com.belicones.APIRest.model.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class PedidoDto {
    private int idPedido;
    private float totalPedido;
    private int fkIdUsuario;
    private int fkIdMetodoDePago;
    private int fkIdTipoDeEnvio;
}
