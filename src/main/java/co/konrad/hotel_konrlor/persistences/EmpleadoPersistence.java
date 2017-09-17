/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.EmpleadoEntity;
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
public class EmpleadoPersistence {
    
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager em;
    
    public EmpleadoEntity find(Long id_empleado){
        return em.find(EmpleadoEntity.class, id_empleado);
    }
    
    public List<EmpleadoEntity> findAll() {
        Query q = em.createQuery("select u from EmpleadoEntity u");
        return q.getResultList();
    }
    
    public EmpleadoEntity create(EmpleadoEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public EmpleadoEntity update(EmpleadoEntity entity) {
        return em.merge(entity);
    }
    public void delete(Long cod_Empleado) {
        EmpleadoEntity entity = em.find(EmpleadoEntity.class, cod_Empleado);
        em.remove(entity);
    }
}
