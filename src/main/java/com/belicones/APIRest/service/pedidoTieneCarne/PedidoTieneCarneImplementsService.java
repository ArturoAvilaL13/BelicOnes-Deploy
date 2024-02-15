package com.belicones.APIRest.service.pedidoTieneCarne;

import com.belicones.APIRest.builder.Builders;
import com.belicones.APIRest.model.dao.PedidoTieneCarneDao;
import com.belicones.APIRest.model.dto.PedidoTieneCarneDto;
import com.belicones.APIRest.model.entity.PedidoTieneCarne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoTieneCarneImplementsService implements InterfacePedidoTieneCarneService{
    @Autowired
    private PedidoTieneCarneDao pedidoTieneCarneDao;
    @Transactional
    @Override
    public List<PedidoTieneCarne> listAll() {
        List<PedidoTieneCarne> pedidoTieneCarneList = (List<PedidoTieneCarne>) pedidoTieneCarneDao.findAll();
        if(pedidoTieneCarneList.isEmpty()){
            return null;
        }
        return pedidoTieneCarneList;
    }
    @Transactional
    @Override
    public List<PedidoTieneCarne> listByIdPedido(int id) {
        List<PedidoTieneCarne> pedidoTieneCarneList = (List<PedidoTieneCarne>) pedidoTieneCarneDao.findAll();
        List<PedidoTieneCarne> pedidosUsuario = new ArrayList<>();
        if(pedidoTieneCarneList.isEmpty()){
            return null;
        }
        for (PedidoTieneCarne pedido:pedidoTieneCarneList){
            if(pedido.getFkIdPedido()==id){
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
    public PedidoTieneCarne save(PedidoTieneCarneDto pedidoTieneCarneDto) {
        PedidoTieneCarne pedido = new Builders().builderPedidoCarne(pedidoTieneCarneDto);
        return pedidoTieneCarneDao.save(pedido);
    }
}
