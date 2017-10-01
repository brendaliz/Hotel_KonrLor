/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.logic;

import co.konrad.hotel_konrlor.entities.ProveedorPromocionHotelEntity;
import co.konrad.hotel_konrlor.persistences.ProveedorPromocionHotelPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Stateless
public class ProveedorPromocionHotelLogic {
    @Inject
    private ProveedorPromocionHotelPersistence proveedorPromocionHotelPersistence;
    
        /*Metodo para encontrar todos los */
    
    public List<ProveedorPromocionHotelEntity> getPromociones(){
        List<ProveedorPromocionHotelEntity>promociones = proveedorPromocionHotelPersistence.findAll();
        return promociones;
    }
    /*Obtener un objeto de la tabla 
        @Param id
        @return promocion*/
    public ProveedorPromocionHotelEntity getPromocion(Long id_p_Promocion_hotel){
        ProveedorPromocionHotelEntity proveedorPromocionHotelEntity = proveedorPromocionHotelPersistence.find(id_p_Promocion_hotel);
        if(proveedorPromocionHotelEntity == null){
            throw new IllegalArgumentException("La promocion solicitada no existe");
        }
        return proveedorPromocionHotelEntity;
    }
    
    public ProveedorPromocionHotelEntity createPromocion (ProveedorPromocionHotelEntity proveedor){
        proveedorPromocionHotelPersistence.create(proveedor);
        return proveedor;
    }
    
    /* ACTUALIZACION OBJETO PROOVEDOR_PROMOCION_HOTEL*/
    
    public ProveedorPromocionHotelEntity updatePromocion(Long id_p_Promocion_hotel, ProveedorPromocionHotelEntity promocion){
        ProveedorPromocionHotelEntity proveedorPromocionHotelEntity = proveedorPromocionHotelPersistence.update(promocion);
        return proveedorPromocionHotelEntity;
    }
    /*
    Eliminar un objeto proveedorPromocionHotel (promocion)
    @param id
    */
    public void deletePromocion (Long id_p_Promocion_hotel){
        proveedorPromocionHotelPersistence.delete(id_p_Promocion_hotel);
    }    
}
