package com.belicones.APIRest.service.pedido;

import com.belicones.APIRest.builder.Builders;
import com.belicones.APIRest.model.dao.PedidoDao;
import com.belicones.APIRest.model.dto.PedidoDto;
import com.belicones.APIRest.model.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class PedidoImplementsService implements  InterfacePedido{
    @Autowired
    private PedidoDao pedidoDao;
    @Transactional
    @Override
    public List<Pedido> listAll() {
        List<Pedido> pedidos = (List<Pedido>) pedidoDao.findAll();
        if(pedidos.isEmpty()){
            return null;
        }
        return pedidos;
    }

    @Transactional
    @Override
    public Pedido findById(int id) {
        return pedidoDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public List<Pedido> findByIdUsuario(int id) {
        List<Pedido> getPedidos = (List<Pedido>) pedidoDao.findAll();
        List<Pedido> pedidosUsuario = new ArrayList<>();
        if(getPedidos.isEmpty()){
            return null;
        }
        for(Pedido pedido:getPedidos){
            if(pedido.getFkIdUsuario()==id){
                pedidosUsuario.add(pedido);
            }
        }
        if (pedidosUsuario.isEmpty()){
            return null;
        }
        return pedidosUsuario;
    }
    @Transactional
    @Override
    public Pedido save(PedidoDto pedidoDto) {
        Pedido pedido = new Builders().builderPedido(pedidoDto);
        return pedidoDao.save(pedido);
    }
    @Transactional
    @Override
    public void delete(Pedido pedido) {
    pedidoDao.delete(pedido);
    }
}
