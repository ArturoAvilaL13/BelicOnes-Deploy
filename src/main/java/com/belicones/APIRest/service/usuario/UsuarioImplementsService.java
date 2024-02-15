package com.belicones.APIRest.service.usuario;

import com.belicones.APIRest.builder.Builders;
import com.belicones.APIRest.model.dao.UsuarioDao;
import com.belicones.APIRest.model.dto.UsuarioDto;
import com.belicones.APIRest.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioImplementsService implements InterfaceUsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;
    @Override
    public List<Usuario> listAll() {
        List<Usuario> usuarios = (List<Usuario>) usuarioDao.findAll();
        if(usuarios.isEmpty()){
            return null;
        }
        return usuarios;
    }
    @Transactional
    @Override
    public Usuario save(UsuarioDto usuarioDto) {
        Usuario usuario = new Builders().builderUsuario(usuarioDto);
        return usuarioDao.save(usuario);
    }
    @Transactional
    @Override
    public Usuario findById(int id) {
        return usuarioDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public boolean existsById(Integer id) {
        return usuarioDao.existsById(id);
    }
}
