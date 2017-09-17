/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.ProveedorPromocionHotelEntity;
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
public class ProveedorPromocionHotelPersistence {
    
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager em;
    
    public ProveedorPromocionHotelEntity find(Long id_p_Promocion_hotel){
        return em.find(ProveedorPromocionHotelEntity.class, id_p_Promocion_hotel);
    }
    
    public List<ProveedorPromocionHotelEntity> findAll() {
        Query q = em.createQuery("select p from ProveedorPromocionHotelEntity p");
        return q.getResultList();
    }
    
    public ProveedorPromocionHotelEntity create(ProveedorPromocionHotelEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public ProveedorPromocionHotelEntity update(ProveedorPromocionHotelEntity entity) {
        return em.merge(entity);
    }
    public void delete(Long id_proveedor/*,Long id_hotel*/) {
        ProveedorPromocionHotelEntity entity = em.find(ProveedorPromocionHotelEntity.class, id_proveedor/*,id_hotel*/);
        em.remove(entity);
    }
}
