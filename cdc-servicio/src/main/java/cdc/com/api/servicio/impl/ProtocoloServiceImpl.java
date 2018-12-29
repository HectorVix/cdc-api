/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio.impl;

import cdc.com.api.dao.ProtocoloDao;
import cdc.com.api.modelo.Protocolo;
import cdc.com.api.servicio.ProtocoloService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Héctor Vix
 */
@Stateless
public class ProtocoloServiceImpl implements ProtocoloService {

    @Inject
    private ProtocoloDao protocoloDao;

    public int save(Protocolo protocolo) {
        return protocoloDao.save(protocolo);
    }

    public void update(Protocolo protocolo) {
        protocoloDao.update(protocolo);
    }

    public void delete(Long id) {
        protocoloDao.delete(id);
    }

    public Protocolo find(Long id) {
        return protocoloDao.find(id);
    }

    @Override
    public List<Protocolo> all() {
        return protocoloDao.all();
    }

    public List<Protocolo> buscarProtocolo(String codigoe, String nombre, String nomcomun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean findProtocolo(String codigoe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
