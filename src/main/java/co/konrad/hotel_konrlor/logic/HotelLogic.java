/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.logic;

import co.konrad.hotel_konrlor.entities.HotelEntity;
import co.konrad.hotel_konrlor.persistences.HotelPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Stateless
public class HotelLogic {
    @Inject
    private HotelPersistence hotelPersistence;
    
    /*Metodo para encontrar todos los */
    
    public List<HotelEntity> getHoteles(){
        List<HotelEntity>hoteles = hotelPersistence.findAll();
        return hoteles;
    }
    /*Obtener un objeto de la tabla 
        @Param id
        @return hotel*/
    public HotelEntity getHotel(Long id){
        HotelEntity hotel = hotelPersistence.find(id);
        if(hotel == null){
            throw new IllegalArgumentException("El hotel solicitado no existe");
        }
        return hotel;
    }
    
    public HotelEntity createHotel(HotelEntity hotel){
        hotelPersistence.create(hotel);
        return hotel;
    }
    
    /* ACTUALIZACION OBJETO HOTEL*/
    
    public HotelEntity updateHotel(Long id, HotelEntity hotel){
        HotelEntity hotelEntity = hotelPersistence.update(hotel);
        return hotelEntity;
    }
    /*
    Eliminar un objeto hotel
    @param id
    */
    public void deleteHotel (Long id){
        hotelPersistence.delete(id);
    }
}
