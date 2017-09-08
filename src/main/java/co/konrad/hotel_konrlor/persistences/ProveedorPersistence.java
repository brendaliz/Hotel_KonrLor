/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.ProveedorEntity;
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
public class ProveedorPersistence {
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager em;
    public ProveedorEntity find(Long id_proveedor){
        return em.find(ProveedorEntity.class, id_proveedor);
    }
    
    public List<ProveedorEntity> findAll() {
        Query q = em.createQuery("select p from ProveedorEntity p");
        return q.getResultList();
    }
    
    public ProveedorEntity create(ProveedorEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public ProveedorEntity update(ProveedorEntity entity) {
        return em.merge(entity);
    }
    public void delete(Long id_proveedor) {
        ProveedorEntity entity = em.find(ProveedorEntity.class, id_proveedor);
        em.remove(entity);
    }    
}