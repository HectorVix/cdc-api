/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.loginws;

/**
 *
 * @author Héctor Vix
 */
public class UsuarioReg {
    String correo;
    String password;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
   

  
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
	public String toString() {
		return "Usuario [correo=" + correo + ", password=" + password + "]";
	}
    
}
