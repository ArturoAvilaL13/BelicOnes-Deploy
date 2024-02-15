package com.belicones.APIRest.controller;

import com.belicones.APIRest.builder.Builders;
import com.belicones.APIRest.model.dto.CarneDto;
import com.belicones.APIRest.model.entity.Carne;
import com.belicones.APIRest.payload.MessageResponse;
import com.belicones.APIRest.service.carne.InterfaceCarneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarneController {
    @Autowired
    private InterfaceCarneService carneService;

    @PostMapping("carne")
    public ResponseEntity<?> create(@RequestBody CarneDto carneDto){
        Carne carneCreate;
        try {
            carneCreate = carneService.save(carneDto);
            return new ResponseEntity<>(MessageResponse.builder()
                    .mensaje("Carne guardada correctamente")
                    .object(new Builders().builderCarne(carneCreate))
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

    @GetMapping("carnes")
    public ResponseEntity<?> showAll(){
        List<Carne> getCarnes = carneService.listAll();
        if(getCarnes == null){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("No hay carnes para mostrar")
                            .object(null)
                            .build()
                    ,HttpStatus.OK);
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .mensaje("Lista de carnes")
                        .object(getCarnes)
                        .build()
                ,HttpStatus.OK
        );
    }

    @GetMapping("carne/{id:\\d+}")
    public ResponseEntity<?> showCarneById(@PathVariable Integer id){
        Carne carneById = carneService.findById(id);
        if(carneById == null){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("La carne que busca no existe")
                            .object(null)
                            .build()
                    ,HttpStatus.OK);
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .mensaje("La carne existe")
                        .object(new Builders().builderCarne(carneById))
                        .build()
                ,HttpStatus.OK
        );
    }

    @GetMapping("carne/tipo/{id:\\d+}")
    public ResponseEntity<?> showCarnesByTipo(@PathVariable Integer id){
        List<Carne> carnes = carneService.findByTipo(id);
        if(carnes == null){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("No hay carnes en esa categoria")
                            .object(null)
                            .build()
                    ,HttpStatus.OK);
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .mensaje("Si hay carnes en esa categoria")
                        .object(carnes)
                        .build()
                ,HttpStatus.OK
        );
    }

    @PutMapping("carne/{id:\\d+}")
    public ResponseEntity<?> putCarne(@PathVariable Integer id,@RequestBody CarneDto carneDto){
        Carne carneExists = null;
        try{
            if(carneService.existsById(id)){
                carneDto.setIdCarne(id);
                carneExists = carneService.save(carneDto);
                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .mensaje("Carne actualizada")
                                .object(new Builders().builderCarne(carneExists))
                                .build()
                        ,HttpStatus.CREATED
                );
            }else{
                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .mensaje("La carne que buscas no existe")
                                .object(null)
                                .build()
                        ,HttpStatus.OK
                );
            }
        }catch(DataAccessException dataAcEx){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje(dataAcEx.getMessage())
                            .object(null)
                            .build()
                    ,HttpStatus.METHOD_NOT_ALLOWED
            );
        }
    }

    @DeleteMapping("carne/{id:\\d+}")
    public ResponseEntity<?> delte(@PathVariable Integer id){
        Carne carneDelete = null;
        try {
            if(carneService.existsById(id)){

                carneDelete = carneService.findById(id);
                carneService.delete(carneDelete);
                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .mensaje("Carne eliminada")
                                .object(new Builders().builderCarne(carneDelete))
                                .build()
                        ,HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .mensaje("La carne que intenta eliminar no existe")
                                .object(null)
                                .build()
                        ,HttpStatus.NO_CONTENT);
            }
        }catch (DataAccessException dataAcEx){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje(dataAcEx.getMessage())
                            .object(null)
                            .build()
                    ,HttpStatus.METHOD_NOT_ALLOWED
            );
        }
    }
}
