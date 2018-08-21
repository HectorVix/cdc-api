/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;
import cdc.com.api.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */

public interface UsuarioService {
    
    public void save(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(Long id);
    public Usuario find(Long id);
    public boolean find_Usuario(String email, String contrasena);
    public int getUsuario_id();
    public List<Usuario> all();
}
