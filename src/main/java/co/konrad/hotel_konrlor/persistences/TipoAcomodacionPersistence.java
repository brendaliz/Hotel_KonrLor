/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.TipoAcomodacionEntity;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Carlos
 */
@Stateful
public class TipoAcomodacionPersistence {
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager em;
    public TipoAcomodacionEntity find(Long id){
        return em.find(TipoAcomodacionEntity.class, id);
    }
    
    public List<TipoAcomodacionEntity> findAll() {
        Query q = em.createQuery("select c from TipoAcomodacionEntity c");
        return q.getResultList();
    }
    
    public TipoAcomodacionEntity create(TipoAcomodacionEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public TipoAcomodacionEntity update(TipoAcomodacionEntity entity) {
        return em.merge(entity);
    }
    public void delete(Long id) {
        TipoAcomodacionEntity entity = em.find(TipoAcomodacionEntity.class, id);
        em.remove(entity);
    }    
}
