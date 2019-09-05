/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos.representativos;

import java.util.Date;

/**
 *
 * @author Héctor Vix
 */
public class StatusGlobal {

    public String nombreg;
    public String rangog;
    public String resrg;
    public Date fecharg;

    public StatusGlobal(String nombreg, String rangog, String resrg, Date fecharg) {
        this.nombreg = nombreg;
        this.rangog = rangog;
        this.resrg = resrg;
        this.fecharg = fecharg;
    }
}
