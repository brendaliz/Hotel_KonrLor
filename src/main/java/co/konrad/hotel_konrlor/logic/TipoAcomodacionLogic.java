/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.logic;

import co.konrad.hotel_konrlor.entities.TipoAcomodacionEntity;
import co.konrad.hotel_konrlor.persistences.TipoAcomodacionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Stateless
public class TipoAcomodacionLogic {
    @Inject
    private TipoAcomodacionPersistence tipoAcomodacionPersistence;
    
        /*Metodo para encontrar todos los */
    
    public List<TipoAcomodacionEntity> getTiposDeAcomodacion(){
        List<TipoAcomodacionEntity>tiposDeAcomodacion = tipoAcomodacionPersistence.findAll();
        return tiposDeAcomodacion;
    }
    /*Obtener un objeto de la tabla 
        @Param id
        @return tipoAcomodacion*/
    public TipoAcomodacionEntity getTipoAcomodacion(Long id_tipo_acomodacion){
        TipoAcomodacionEntity tipoAcomodacion = tipoAcomodacionPersistence.find(id_tipo_acomodacion);
        if(tipoAcomodacion == null){
            throw new IllegalArgumentException("El tipo de acomodacion solicitado no existe");
        }
        return tipoAcomodacion;
    }
    
    public TipoAcomodacionEntity createTipoAcomodacion(TipoAcomodacionEntity tipoAcomodacion){
        tipoAcomodacionPersistence.create(tipoAcomodacion);
        return tipoAcomodacion;
    }
    
    /* ACTUALIZACION OBJETO TIPO_ACOMODACION*/
    
    public TipoAcomodacionEntity updateTipoAcomodacion(Long id_tipo_acomodacion, TipoAcomodacionEntity tipoAcomodacion){
        TipoAcomodacionEntity tipoAcomodacionEntity = tipoAcomodacionPersistence.update(tipoAcomodacion);
        return tipoAcomodacionEntity;
    }
    /*
    Eliminar un objeto tipoAcomodacion
    @param id
    */
    public void deleteTipoAcomodacion (Long id_tipo_acomodacion){
        tipoAcomodacionPersistence.delete(id_tipo_acomodacion);
    }    
}
