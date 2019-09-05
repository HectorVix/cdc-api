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
public class StatusSubnacional {

    public String rangos;
    public Date fecharevrs;
    public String lestims;
    public String leprots;
    public String abunds;

    public StatusSubnacional(String rangos, Date fecharevrs, String lestims, String leprots, String abunds) {
        this.rangos = rangos;
        this.fecharevrs = fecharevrs;
        this.lestims = lestims;
        this.leprots = leprots;
        this.abunds = abunds;
    }

}
