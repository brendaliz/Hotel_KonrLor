/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.ClienteOpinarHotelEntity;
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
public class ClienteOpinarHotelPersistence {
    
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager em;
    
    public ClienteOpinarHotelEntity find(Long id_opinion){
        return em.find(ClienteOpinarHotelEntity.class, id_opinion);
    }
    
    public List<ClienteOpinarHotelEntity> findAll() {
        Query q = em.createQuery("select c from ClienteOpinarHotelEntity c");
        return q.getResultList();
    }
    
    public ClienteOpinarHotelEntity create(ClienteOpinarHotelEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public ClienteOpinarHotelEntity update(ClienteOpinarHotelEntity entity) {
        return em.merge(entity);
    }
    public void delete(Long id) {
        ClienteOpinarHotelEntity entity = em.find(ClienteOpinarHotelEntity.class, id);
        em.remove(entity);
    }    
}
