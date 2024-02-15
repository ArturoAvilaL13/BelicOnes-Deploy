package com.belicones.APIRest.service.usuario;

import com.belicones.APIRest.model.dto.UsuarioDto;
import com.belicones.APIRest.model.entity.Usuario;

import java.util.List;

public interface InterfaceUsuarioService {
    List<Usuario> listAll();
    Usuario save(UsuarioDto usuarioDto);
    Usuario findById(int id);
    void delete(Usuario usuario);
    boolean existsById(Integer id);

}
