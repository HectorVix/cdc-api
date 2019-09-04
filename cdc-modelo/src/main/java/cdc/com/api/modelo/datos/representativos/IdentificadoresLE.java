/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.modelo.datos.representativos;

/**
 *
 * @author Héctor Vix
 */
public class IdentificadoresLE {

    public String rangog;
    public String rangon;
    public String nombrecomunn;
    public String nombres;
    public String rangos;

    public IdentificadoresLE(String nombres, String rangos) {
        this.nombres = nombres;
        this.rangos = rangos;
    }

    public IdentificadoresLE(String val, int estado) {
        switch (estado) {
            case 1:
                this.rangog = val;
                break;
            case 2:
                this.rangon = val;
                break;
            case 3:
                this.nombrecomunn = val;
                break;
        }
    }
}
