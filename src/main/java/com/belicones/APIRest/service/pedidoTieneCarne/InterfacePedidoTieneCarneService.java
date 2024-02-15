package com.belicones.APIRest.service.pedidoTieneCarne;

import com.belicones.APIRest.model.dto.PedidoTieneCarneDto;
import com.belicones.APIRest.model.entity.PedidoTieneCarne;

import java.util.List;

public interface InterfacePedidoTieneCarneService {
    List<PedidoTieneCarne> listAll();
    List<PedidoTieneCarne> listByIdPedido(int Id);

    PedidoTieneCarne save(PedidoTieneCarneDto pedidoTieneCarneDto);
}
