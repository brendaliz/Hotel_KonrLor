/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.PagoDebitoEntity;
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
public class PagoDebitoPersistence {
    
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager em;
    
    public PagoDebitoEntity find(Long id_num_tarjeta){
        return em.find(PagoDebitoEntity.class, id_num_tarjeta);
    }
    
    public List<PagoDebitoEntity> findAll() {
        Query q = em.createQuery("select p from PagoDebitoEntity p");
        return q.getResultList();
    }
    
    public PagoDebitoEntity create(PagoDebitoEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public PagoDebitoEntity update(PagoDebitoEntity entity) {
        return em.merge(entity);
    }
    public void delete(Long num_Cuenta) {
        PagoDebitoEntity entity = em.find(PagoDebitoEntity.class, num_Cuenta);
        em.remove(entity);
    }    
}

