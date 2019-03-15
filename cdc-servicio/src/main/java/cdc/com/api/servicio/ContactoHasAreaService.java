/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.servicio;

import cdc.com.api.modelo.ContactoHasArea;
import java.util.List;

/**
 *
 * @author Héctor Vix
 */
public interface ContactoHasAreaService {

    public void save(ContactoHasArea ContactoHasArea);

    public void update(ContactoHasArea ContactoHasArea);

    public void delete(Long id);

    public ContactoHasArea find(Long id);

    public List<ContactoHasArea> all();

    public List<ContactoHasArea> buscarContactoHasArea(int contactoId, int codigoam);
}
