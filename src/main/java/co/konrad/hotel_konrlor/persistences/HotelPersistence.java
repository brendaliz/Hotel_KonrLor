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
<<<<<<< HEAD
    protected EntityManager emHotel;
=======
    protected EntityManager em;
>>>>>>> 2666d0ace00d7f0888d6f4ee49deb7ea9f3135d5
    
    public HotelEntity find(Long id_Hotel){
        return emHotel.find(HotelEntity.class, id_Hotel);
    }
    
    public List<HotelEntity> findAll() {
        Query q = emHotel.createQuery("select h from HotelEntity h");
        return q.getResultList();
    }
    
    public HotelEntity create(HotelEntity hotel) {
        emHotel.persist(hotel);
        return hotel;
    }
    
    public HotelEntity update(HotelEntity hotel) {
        return emHotel.merge(hotel);
    }
    public void delete(Long id_Hotel) {
        HotelEntity hotelEliminar = emHotel.find(HotelEntity.class, id_Hotel);
        emHotel.remove(hotelEliminar);
    }    
}
