/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.logic;

import co.konrad.hotel_konrlor.entities.ReservaEntity;
import co.konrad.hotel_konrlor.persistences.ReservaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Stateless
public class ReservaLogic {
    @Inject
    private ReservaPersistence reservaPersistence;
    
    /*Metodo para encontrar todos los */
    
    public List<ReservaEntity> getReservas(){
        List<ReservaEntity>reservas = reservaPersistence.findAll();
        return reservas;
    }
    /*Obtener un objeto de la tabla 
        @Param id
        @return resrva*/
    public ReservaEntity getReserva(Long id_reserva){
        ReservaEntity reserva = reservaPersistence.find(id_reserva);
        if(reserva == null){
            throw new IllegalArgumentException("La reserva solicitada no existe");
        }
        return reserva;
    }
    
    public ReservaEntity createReserva(ReservaEntity reserva){
        reservaPersistence.create(reserva);
        return reserva;
    }
    
    /* ACTUALIZACION OBJETO RESERVA*/
    
    public ReservaEntity updateReserva(Long id_reserva, ReservaEntity reserva){
        ReservaEntity reservaEntity = reservaPersistence.update(reserva);
        return reservaEntity;
    }
    /*
    Eliminar un objeto reserva
    @param id
    */
    public void deleteReserva (Long id_reserva){
        reservaPersistence.delete(id_reserva);
    }
}
