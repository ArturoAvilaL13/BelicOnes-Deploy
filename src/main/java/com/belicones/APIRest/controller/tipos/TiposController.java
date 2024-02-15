package com.belicones.APIRest.controller.tipos;

import com.belicones.APIRest.builder.Builders;
import com.belicones.APIRest.model.dto.tipos.carne.TipoDeCarneDto;
import com.belicones.APIRest.model.dto.tipos.entrega.TipoEntregaDto;
import com.belicones.APIRest.model.dto.tipos.pago.TipoPagoDto;
import com.belicones.APIRest.model.entity.tipos.carne.TipoDeCarne;
import com.belicones.APIRest.model.entity.tipos.entrega.TipoEntrega;
import com.belicones.APIRest.model.entity.tipos.pago.TipoPago;
import com.belicones.APIRest.payload.MessageResponse;
import com.belicones.APIRest.service.tipos.InterfaceTiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TiposController {
    @Autowired
    private InterfaceTiposService tiposService;
    @GetMapping("tipo/carnes")
    public ResponseEntity<?> showAllTiposDeCarnes(){
        List<TipoDeCarne> getList = tiposService.listAllTiposCarnes();
        if (getList == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("No hay registros")
                            .object(null)
                            .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .mensaje("Lista de tipos de Carnes")
                        .object(getList)
                        .build()
                , HttpStatus.OK);
    }

    @GetMapping("tipo/pagos")
    public ResponseEntity<?> showAllTiposDePagos(){
        List<TipoPago> getList = tiposService.listAllTiposPago();
        if (getList == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("No hay registros")
                            .object(null)
                            .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .mensaje("Lista de tipos de Carnes")
                        .object(getList)
                        .build()
                , HttpStatus.OK);
    }

    @GetMapping("tipo/entregas")
    public ResponseEntity<?> showAllTiposDeEntregas(){
        List<TipoEntrega> getList = tiposService.listAllTiposEntregas();
        if (getList == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("No hay registros")
                            .object(null)
                            .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .mensaje("Lista de tipos de Carnes")
                        .object(getList)
                        .build()
                , HttpStatus.OK);
    }

    @PostMapping("tipo/pago")
    public ResponseEntity<?> savePago(@RequestBody TipoPagoDto tipoPagoDto){
        try{
            TipoPago tipoPago = tiposService.saveTipoPago(tipoPagoDto);
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("Tipo guardado con exito")
                            .object(new Builders().builderTipoPago(tipoPago))
                            .build()
                    ,HttpStatus.CREATED
            );
        }catch(DataAccessException dataAcEx){
            return new ResponseEntity<>(MessageResponse
                    .builder()
                    .mensaje(dataAcEx.getMessage())
                    .object(null)
                    .build()
                    ,HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PostMapping("tipo/corte")
    public ResponseEntity<?> saveCorte(@RequestBody TipoDeCarneDto tipoDeCarneDto){
        try{
            TipoDeCarne tipoDeCarne = tiposService.saveTipoDeCarne(tipoDeCarneDto);
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("Tipo guardado con exito")
                            .object(new Builders().builderTipoDeCarne(tipoDeCarne))
                            .build()
                    ,HttpStatus.CREATED
            );
        }catch(DataAccessException dataAcEx){
            return new ResponseEntity<>(MessageResponse
                    .builder()
                    .mensaje(dataAcEx.getMessage())
                    .object(null)
                    .build()
                    ,HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PostMapping("tipo/entrega")
    public ResponseEntity<?> saveEntrega(@RequestBody TipoEntregaDto tipoEntregaDto){
        try{
            TipoEntrega tipoEntrega = tiposService.saveTipoEntrega(tipoEntregaDto);
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("Tipo guardado con exito")
                            .object(new Builders().builderTipoEntrega(tipoEntrega))
                            .build()
                    ,HttpStatus.CREATED
            );
        }catch(DataAccessException dataAcEx){
            return new ResponseEntity<>(MessageResponse
                    .builder()
                    .mensaje(dataAcEx.getMessage())
                    .object(null)
                    .build()
                    ,HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

}
