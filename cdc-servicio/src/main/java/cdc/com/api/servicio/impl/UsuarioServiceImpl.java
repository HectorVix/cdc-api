/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;
import cdc.com.api.dao.UsuarioDao;
import cdc.com.api.modelo.Usuario;
import cdc.com.api.servicio.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class UsuarioServiceImpl implements UsuarioService{
    
  @Inject
  private   UsuarioDao usuarioDao1;
    

    public void save(Usuario usuario) {
      usuarioDao1.save(usuario);
    }

    public void update(Usuario usuario) {
    usuarioDao1.update(usuario);
    }

    public void delete(Long id) {
     
    usuarioDao1.delete(id);
    }

    public Usuario find(Long id) {
      return usuarioDao1.find(id);
    }

      @Override
    public List<Usuario> all() {
        return usuarioDao1.all();
    }

}
