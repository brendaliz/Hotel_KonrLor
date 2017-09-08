/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;


import co.konrad.hotel_konrlor.entities.HotelEntity;
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
public class HotelPersistence {
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager em;
    public HotelEntity find(Long id_Hotel){
        return em.find(HotelEntity.class, id_Hotel);
    }
    
    public List<HotelEntity> findAll() {
        Query q = em.createQuery("select h from HotelEntity h");
        return q.getResultList();
    }
    
    public HotelEntity create(HotelEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public HotelEntity update(HotelEntity entity) {
        return em.merge(entity);
    }
    public void delete(Long id_Hotel) {
        HotelEntity entity = em.find(HotelEntity.class, id_Hotel);
        em.remove(entity);
    }    
}
