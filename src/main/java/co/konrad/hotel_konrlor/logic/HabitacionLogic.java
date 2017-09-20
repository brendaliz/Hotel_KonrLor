/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.logic;

import co.konrad.hotel_konrlor.entities.HabitacionEntity;
import co.konrad.hotel_konrlor.persistences.HabitacionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Stateless
public class HabitacionLogic {
    @Inject
    private HabitacionPersistence habitacionPersistence;
    
    /*Metodo para encontrar todos los */
    
    public List<HabitacionEntity> getHabitaciones(){
        List<HabitacionEntity>habitaciones = habitacionPersistence.findAll();
        return habitaciones;
    }
    /*Obtener un objeto de la tabla 
        @Param id
        @return habitacion*/
    public HabitacionEntity getHabitacion(Long id){
        HabitacionEntity habitacion = habitacionPersistence.find(id);
        if(habitacion == null){
            throw new IllegalArgumentException("La habitacion solicitada no existe");
        }
        return habitacion;
    }
    
    public HabitacionEntity createHabitaicon(HabitacionEntity habitacion){
        habitacionPersistence.create(habitacion);
        return habitacion;
    }
    
    /* ACTUALIZACION OBJETO HABITACION*/
    
    public HabitacionEntity updateHabitacion(Long id, HabitacionEntity habitacion){
        HabitacionEntity habitacionEntity = habitacionPersistence.update(habitacion);
        return habitacionEntity;
    }
    /*
    Eliminar un objeto habitacion
    @param id
    */
    public void deleteHabitacion (Long id){
        habitacionPersistence.delete(id);
    }
}
