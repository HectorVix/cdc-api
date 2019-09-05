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
public class StatusNacional {

    public String rangon;
    public Date fecharn;
    public String nlestim;
    public String nleprot;
    public String nabund;

    public StatusNacional(String rangon, Date fecharn, String nlestim, String nleprot, String nabund) {
        this.rangon = rangon;
        this.fecharn = fecharn;
        this.nlestim = nlestim;
        this.nleprot = nleprot;
        this.nabund = nabund;
    }

}
