/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.PagoEntity;
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
public class PagoPersistence {
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager em;
    public PagoEntity find(String tipoPago){
        return em.find(PagoEntity.class, tipoPago);
    }
    
    public List<PagoEntity> findAll() {
        Query q = em.createQuery("select p from PagoEntity p");
        return q.getResultList();
    }
    
    public PagoEntity create(PagoEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public PagoEntity update(PagoEntity entity) {
        return em.merge(entity);
    }
    public void delete(String tipoPago) {
        PagoEntity entity = em.find(PagoEntity.class, tipoPago);
        em.remove(entity);
    }    
}
