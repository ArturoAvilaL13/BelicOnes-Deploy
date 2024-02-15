package com.belicones.APIRest.controller;

import com.belicones.APIRest.builder.Builders;
import com.belicones.APIRest.model.dto.UsuarioDto;
import com.belicones.APIRest.model.entity.Usuario;
import com.belicones.APIRest.payload.MessageResponse;
import com.belicones.APIRest.service.usuario.InterfaceUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    @Autowired
    private InterfaceUsuarioService usuarioService;

    @PostMapping("usuario")
    public ResponseEntity<?> create(@RequestBody UsuarioDto usuarioDto){//Metodo para guardar usuarios
        Usuario usuarioCreate;
        try{
            usuarioCreate = usuarioService.save(usuarioDto);
            return new ResponseEntity<>(MessageResponse.builder()
                    .mensaje("Usuario guardado correctamente")
                    .object(new Builders().builderUsuario(usuarioCreate))
                    .build()
                    , HttpStatus.CREATED);
        }catch(DataAccessException excDt){
            return new ResponseEntity<>(MessageResponse.builder()
                    .mensaje(excDt.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("usuarios")//Despliega todos los usuario
    public ResponseEntity<?> showAll() {
        List<Usuario> getList = usuarioService.listAll();
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
                        .mensaje("Lista de usuarios")
                        .object(getList)
                        .build()
                , HttpStatus.OK);
    }

    @GetMapping("usuario/checar/{id:\\d+}")
    public ResponseEntity<?> showById(@PathVariable Integer id){
        Usuario usuario = usuarioService.findById(id);
        if(usuario == null){
            return new ResponseEntity<>(MessageResponse.builder()
                    .mensaje("El usuario que intenta buscar no existe")
                    .object(null)
                    .build()
                    , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .mensaje("El usuario existe")
                        .object(new Builders().builderUsuario(usuario))
                        .build()
                ,HttpStatus.OK);

    }

    @GetMapping("usuario/checar/{par1}/{par2}")
    public ResponseEntity<?> checkUser(@PathVariable("par1") String correo,@PathVariable("par2") String contrasena){
        List<Usuario> usuarioList = usuarioService.listAll();
        Usuario usuario=null;
        for(Usuario usr:usuarioList){
            if(usr.getCorreo().equals(correo) && usr.getContrasena().equals(contrasena)){
                usuario=usr;
                break;
            }
        }
        if(usuario == null){
            return new ResponseEntity<>(MessageResponse.builder()
                    .mensaje("El correo o la contraseña que ingreso no existe")
                    .object(null)
                    .build()
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .mensaje("El usuario existe")
                        .object(new Builders().builderUsuario(usuario))
                        .build()
                ,HttpStatus.OK);
    }

    @GetMapping("usuario/checar/{correo:^[\\w.+\\-]+@{1}[\\w.+\\-]+\\.{1}com}")
    public ResponseEntity<?> showByCorreo(@PathVariable String correo){
        List<Usuario> usuarioList = usuarioService.listAll();
        Usuario usuario=null;
        for(Usuario usr:usuarioList){
            if(usr.getCorreo().equals(correo)){
                usuario = usr;
                break;
            }
        }

        if(usuario == null){
            return new ResponseEntity<>(MessageResponse.builder()
                    .mensaje("El correo que ingreso no existe")
                    .object(null)
                    .build()
                    , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .mensaje("El usuario existe")
                        .object(new Builders().builderUsuario(usuario))
                        .build()
                ,HttpStatus.OK);

    }

    @PutMapping("usuario/{id}")
    public ResponseEntity<?> update(@RequestBody UsuarioDto usuarioDto,@PathVariable Integer id){
        Usuario usuarioUpdate = null;
        try{
            if(usuarioService.existsById(id)){
                usuarioDto.setIdUsuario(id);
                usuarioUpdate = usuarioService.save(usuarioDto);
                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .mensaje("Guardado correctamente")
                                .object(new Builders().builderUsuario(usuarioUpdate))
                                .build()
                                , HttpStatus.CREATED
                );
            }else{
                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .mensaje("El registro que intenta actualizar no existe")
                                .object(null)
                                .build()
                        ,HttpStatus.NOT_FOUND
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

    @DeleteMapping("usuario/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Integer id){
        try{
            Usuario usuarioDelete = usuarioService.findById(id);
            usuarioService.delete(usuarioDelete);
            return  new ResponseEntity<>(usuarioDelete,HttpStatus.NO_CONTENT);
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
