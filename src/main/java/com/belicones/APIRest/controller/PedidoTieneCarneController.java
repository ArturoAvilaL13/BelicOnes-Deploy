package com.belicones.APIRest.controller;

import com.belicones.APIRest.builder.Builders;
import com.belicones.APIRest.model.dto.PedidoTieneCarneDto;
import com.belicones.APIRest.model.entity.Pedido;
import com.belicones.APIRest.model.entity.PedidoTieneCarne;
import com.belicones.APIRest.payload.MessageResponse;
import com.belicones.APIRest.service.pedidoTieneCarne.PedidoTieneCarneImplementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PedidoTieneCarneController {
    @Autowired
    private PedidoTieneCarneImplementsService pedidoService;

    @GetMapping("pedidosCarnes")
    public ResponseEntity<?> getAll(){
        List<PedidoTieneCarne> pedidos = pedidoService.listAll();
        if(pedidos == null){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("No hay pedidos de carnes")
                            .object(null)
                            .build()
                    , HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .mensaje("Lista de pedidos")
                        .object(pedidos)
                        .build()
                ,HttpStatus.OK
        );
    }

    @GetMapping("pedidoCarne/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        List<PedidoTieneCarne> pedido = pedidoService.listByIdPedido(id);
        if(pedido==null){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("No hay pedidos de carnes con ese Id")
                            .object(null)
                            .build()
                    ,HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .mensaje("Existen pedidos de carne con ese id")
                        .object(pedido)
                        .build()
                ,HttpStatus.OK
        );
    }

    @PostMapping("pedidoCarne")
    public ResponseEntity<?> savePedidoCarne(@RequestBody List<PedidoTieneCarneDto> pedidoTieneCarneDtos){
        try{
            List<PedidoTieneCarne> pedido = new ArrayList<>();
            for(PedidoTieneCarneDto pedidoDto:pedidoTieneCarneDtos){
                pedido.add(pedidoService.save(pedidoDto)) ;
            }
            return new ResponseEntity<>(MessageResponse.builder()
                    .mensaje("Pedido completo guardado")
                    .object(pedido)
                    .build()
                    , HttpStatus.CREATED);
        }catch (DataAccessException excDt){
            return new ResponseEntity<>(MessageResponse
                    .builder()
                    .mensaje(excDt.getMessage())
                    .object(null)
                    .build()
                    ,HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

}
