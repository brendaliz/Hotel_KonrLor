/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.HabitacionEntity;
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
public class HabitacionPersistence {
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager em;
    public HabitacionEntity find(Long id_Habitacion){
        return em.find(HabitacionEntity.class, id_Habitacion);
    }
    
    public List<HabitacionEntity> findAll() {
        Query q = em.createQuery("select h from HabitacionEntity h");
        return q.getResultList();
    }
    
    public HabitacionEntity create(HabitacionEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public HabitacionEntity update(HabitacionEntity entity) {
        return em.merge(entity);
    }
    public void delete(Long id_Habitacion) {
        HabitacionEntity entity = em.find(HabitacionEntity.class, id_Habitacion);
        em.remove(entity);
    }    
}
