/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.logic;

import co.konrad.hotel_konrlor.entities.CadenaHoteleraEntity;
import co.konrad.hotel_konrlor.persistences.CadenaHoteleraPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Stateless
public class CadenaHoteleraLogic {
    @Inject
    private CadenaHoteleraPersistence cadenaHoteleraPersistence;
    
    /*Metodo para encontrar todos los */
    
    public List<CadenaHoteleraEntity> getCadenasHoteleras(){
        List<CadenaHoteleraEntity>cadenasHoteleras = cadenaHoteleraPersistence.findAll();
        return cadenasHoteleras;
    }
    /*Obtener un objeto de la tabla 
        @Param id
        @return cadenaHotelera*/
    public CadenaHoteleraEntity getCadenaHotelera(Long id_Cadena_Hotelera){
        CadenaHoteleraEntity cadenaHotelera = cadenaHoteleraPersistence.find(id_Cadena_Hotelera);
        if(cadenaHotelera == null){
            throw new IllegalArgumentException("La cadena hotelera solicitada no existe");
        }
        return cadenaHotelera;
    }
    
    public CadenaHoteleraEntity createCadenaHotelera(CadenaHoteleraEntity cadenaHotelera){
        cadenaHoteleraPersistence.create(cadenaHotelera);
        return cadenaHotelera;
    }
    
    /* ACTUALIZACION OBJETO CADENA_HOTELERA*/
    
    public CadenaHoteleraEntity updateCadenaHotelera(Long id_Cadena_Hotelera, CadenaHoteleraEntity cadenaHotelera){
        CadenaHoteleraEntity cadenaHoteleraEntity = cadenaHoteleraPersistence.update(cadenaHotelera);
        return cadenaHoteleraEntity;
    }
    /*
    Eliminar un objeto cadenaHotelera
    @param id
    */
    public void deleteCadenaHotelera (Long id_Cadena_Hotelera){
        cadenaHoteleraPersistence.delete(id_Cadena_Hotelera);
    }
}
