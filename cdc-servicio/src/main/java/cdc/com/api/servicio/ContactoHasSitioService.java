/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.ContactoHasSitio;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface ContactoHasSitioService {

    public void save(ContactoHasSitio ContactoHasSitio);

    public void update(ContactoHasSitio ContactoHasSitio);

    public void delete(Long id);

    public ContactoHasSitio find(Long id);

    public List<ContactoHasSitio> all();

    public List<ContactoHasSitio> buscarContactoHasSitio(int contactoId, int codsitio);
}
