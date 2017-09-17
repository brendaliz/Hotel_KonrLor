/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.ReservaEntity;
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
public class ReservaPersistence {
    
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager em;
    
    public ReservaEntity find(Long id_reserva){
        return em.find(ReservaEntity.class, id_reserva);
    }
    
    public List<ReservaEntity> findAll() {
        Query q = em.createQuery("select r from ReservaEntity r");
        return q.getResultList();
    }
    
    public ReservaEntity create(ReservaEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public ReservaEntity update(ReservaEntity entity) {
        return em.merge(entity);
    }
    public void delete(Long id_Reserva) {
        ReservaEntity entity = em.find(ReservaEntity.class, id_Reserva);
        em.remove(entity);
    }    
}