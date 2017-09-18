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
    protected EntityManager emPromocion;
    
    public ProveedorPromocionHotelEntity find(Long id_p_Promocion_hotel){
        return emPromocion.find(ProveedorPromocionHotelEntity.class, id_p_Promocion_hotel);
    }
    
    public List<ProveedorPromocionHotelEntity> findAll() {
        Query q = emPromocion.createQuery("select p from ProveedorPromocionHotelEntity p");
        return q.getResultList();
    }
    
    public ProveedorPromocionHotelEntity create(ProveedorPromocionHotelEntity promocion) {
        emPromocion.persist(promocion);
        return promocion;
    }
    
    public ProveedorPromocionHotelEntity update(ProveedorPromocionHotelEntity promocion) {
        return emPromocion.merge(promocion);
    }
    public void delete(Long id_p_Promocion_hotel) {
        ProveedorPromocionHotelEntity promocionEliminar = emPromocion.find(ProveedorPromocionHotelEntity.class, id_p_Promocion_hotel);
        emPromocion.remove(promocionEliminar);
    }
}
