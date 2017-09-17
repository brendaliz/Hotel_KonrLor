/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.CadenaHoteleraEntity;
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
public class CadenaHoteleraPersistence {
    
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager em;
    
    public CadenaHoteleraEntity find(Long id_Cadena_Hotelera){
        return em.find(CadenaHoteleraEntity.class, id_Cadena_Hotelera);
    }
    
    public List<CadenaHoteleraEntity> findAll() {
        Query q = em.createQuery("select cu from CadenaHotelera cu");
        return q.getResultList();
    }
    
    public CadenaHoteleraEntity create(CadenaHoteleraEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public CadenaHoteleraEntity update(CadenaHoteleraEntity entity) {
        return em.merge(entity);
    }
    public void delete(Long id_Cadena_Hotelera) {
        CadenaHoteleraEntity entity = em.find(CadenaHoteleraEntity.class, id_Cadena_Hotelera);
        em.remove(entity);
    }
}
