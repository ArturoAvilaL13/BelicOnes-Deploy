package com.belicones.APIRest.service.pedido;

import com.belicones.APIRest.model.dto.PedidoDto;
import com.belicones.APIRest.model.entity.Pedido;

import java.util.List;

public interface InterfacePedido {
    List<Pedido> listAll();
    Pedido findById(int id);
    List<Pedido> findByIdUsuario(int id);
    Pedido save(PedidoDto pedidoDto);
    void delete(Pedido pedido);
}
