package com.belicones.APIRest.controller;

import com.belicones.APIRest.builder.Builders;
import com.belicones.APIRest.model.dto.PedidoDto;
import com.belicones.APIRest.model.entity.Pedido;
import com.belicones.APIRest.payload.MessageResponse;
import com.belicones.APIRest.service.pedido.InterfacePedido;
import com.belicones.APIRest.service.pedido.PedidoImplementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PedidoController {
    @Autowired
    private PedidoImplementsService pedidoService;

    @PostMapping("pedido")
    public ResponseEntity<?> create(@RequestBody PedidoDto pedidoDto){
        Pedido pedido;
        try{
            pedido = pedidoService.save(pedidoDto);
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("Pedido guardado exitosamente")
                            .object(new Builders().builderPedido(pedido))
                            .build()
                    ,HttpStatus.CREATED
            );
        }catch(DataAccessException dataAcEx){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje(dataAcEx.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("pedidos")
    public ResponseEntity<?> listAllPedidos(){
        List<Pedido> pedidos = pedidoService.listAll();
        if(pedidos == null){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("No hay pedidos")
                            .object(null)
                            .build()
                    ,HttpStatus.NOT_FOUND
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

    @GetMapping("pedido/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Pedido pedido = pedidoService.findById(id);
        if(pedido==null){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("No hay ningun pedido con ese id")
                            .object(null)
                            .build()
                    ,HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .mensaje("Existe un pedido con ese id")
                        .object(new Builders().builderPedido(pedido))
                        .build()
                ,HttpStatus.OK
        );
    }

    @GetMapping("pedido/usuario/{id}")
    public ResponseEntity<?> findByIdDeUsuario(@PathVariable Integer id){
        List<Pedido> pedidosUsuario = pedidoService.findByIdUsuario(id);
        if(pedidosUsuario == null){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("El usuario con ese id no tiene ningun pedido")
                            .object(null)
                            .build()
                    ,HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .mensaje("El usuario tiene los siguientes pedidos")
                        .object(pedidosUsuario)
                        .build()
                ,HttpStatus.OK
        );
    }

    @DeleteMapping("pedido/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable Integer id){
        try{
            Pedido pedidoDelete = pedidoService.findById(id);
            pedidoService.delete(pedidoDelete);
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("Pedido eliminado correctamente")
                            .object(null)
                    .build(),HttpStatus.OK);
        }catch (DataAccessException dataAcEx){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("No existen pedidos con ese Id, "+dataAcEx.getMessage())
                            .object(null)
                            .build()
                    ,HttpStatus.OK
            );
        }
    }

}
