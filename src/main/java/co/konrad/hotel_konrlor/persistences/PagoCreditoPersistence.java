/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.PagoCreditoEntity;
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
public class PagoCreditoPersistence {
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager em;
    public PagoCreditoEntity find(Long num_Tarjeta){
        return em.find(PagoCreditoEntity.class, num_Tarjeta);
    }
    
    public List<PagoCreditoEntity> findAll() {
        Query q = em.createQuery("select p from PagoCreditoEntity p");
        return q.getResultList();
    }
    
    public PagoCreditoEntity create(PagoCreditoEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public PagoCreditoEntity update(PagoCreditoEntity entity) {
        return em.merge(entity);
    }
    public void delete(Long num_Tarjeta) {
        PagoCreditoEntity entity = em.find(PagoCreditoEntity.class, num_Tarjeta);
        em.remove(entity);
    }    
}
