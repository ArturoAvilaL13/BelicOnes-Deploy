package com.belicones.APIRest.model.dao;

import com.belicones.APIRest.model.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario,Integer> {
}
