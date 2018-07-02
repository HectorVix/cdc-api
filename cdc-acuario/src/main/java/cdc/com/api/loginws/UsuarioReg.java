/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.loginws;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Héctor Vix
 */
public class UsuarioReg {
    
    String nombre;
    String apellido;
    Date fechaNacimiento;    
    String email;
    String emailConfirmar;
    String contrasena;

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
        
        System.out.println("fechaServ:"+fechaNacimiento);
        // this.fechaNacimiento= ft.parse(fechaNacimiento);
       // this.fechaNacimiento = fechaNacimiento;
    }

    
    public String getNombre() {
        
        return nombre;
    }

    public void setNombre(String nombre) {
        System.out.println("nombre vv");
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailConfirmar() {
        return emailConfirmar;
    }

    public void setEmailConfirmar(String emailConfirmar) {
        this.emailConfirmar = emailConfirmar;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

   

  

  
    @Override
	public String toString() {
		return "Usuario [correo=" + nombre + ", password=" + apellido + "]";
	}
    
}
