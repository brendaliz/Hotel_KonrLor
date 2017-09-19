/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.ClienteEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Carlos
 */

@Stateless
    public class ClientePersistence {
    
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager emCliente;
    
    public ClienteEntity find(Long id_cliente){
        return emCliente.find(ClienteEntity.class, id_cliente);
    }
    
    public List<ClienteEntity> findAll() {
        Query q = emCliente.createQuery("select c from ClienteEntity c");
        return q.getResultList();
    }
    
    public ClienteEntity create(ClienteEntity cliente) {
        emCliente.persist(cliente);
        return cliente;
    }
    
    public ClienteEntity update(ClienteEntity cliente) {
        return emCliente.merge(cliente);
    }
    public void delete(Long id_cliente) {
        ClienteEntity clienteElminar = emCliente.find(ClienteEntity.class, id_cliente);
        emCliente.remove(clienteElminar);
    }    
}
