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
  private   UsuarioDao usuarioDao;
    

    public void save(Usuario usuario) {
      usuarioDao.save(usuario);
    }

    public void update(Usuario usuario) {
    usuarioDao.update(usuario);
    }

    public void delete(Long id) {
     
    usuarioDao.delete(id);
    }

    public Usuario find(Long id) {
      return usuarioDao.find(id);
    }
    public boolean find_Usuario(String email, String contrasena) {
       return usuarioDao.find_Usuario(email, contrasena);
   }

    public int getUsuario_id() {
        return usuarioDao.getUsuario_id();
    }
      @Override
    public List<Usuario> all() {
        return usuarioDao.all();
    }

   

}
