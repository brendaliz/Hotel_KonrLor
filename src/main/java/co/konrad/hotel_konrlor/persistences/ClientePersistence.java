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
    protected EntityManager em;
    
    public ClienteEntity find(Long id_cliente){
        return em.find(ClienteEntity.class, id_cliente);
    }
    
    public List<ClienteEntity> findAll() {
        Query q = em.createQuery("select c from ClienteEntity c");
        return q.getResultList();
    }
    
    public ClienteEntity create(ClienteEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public ClienteEntity update(ClienteEntity entity) {
        return em.merge(entity);
    }
    public void delete(Long id_usuario) {
        ClienteEntity entity = em.find(ClienteEntity.class, id_usuario);
        em.remove(entity);
    }    
}
