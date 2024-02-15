package com.belicones.APIRest.model.dao;

import com.belicones.APIRest.model.entity.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoDao extends CrudRepository<Pedido,Integer> {
}
