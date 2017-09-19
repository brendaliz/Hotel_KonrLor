/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.ReservaEntity;
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
public class ReservaPersistence {
    
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager emReserva;
    
    public ReservaEntity find(Long id_reserva){
        return emReserva.find(ReservaEntity.class, id_reserva);
    }
    
    public List<ReservaEntity> findAll() {
        Query q = emReserva.createQuery("select r from ReservaEntity r");
        return q.getResultList();
    }
    
    public ReservaEntity create(ReservaEntity reserva) {
        emReserva.persist(reserva);
        return reserva;
    }
    
    public ReservaEntity update(ReservaEntity reserva) {
        return emReserva.merge(reserva);
    }
    public void delete(Long id_Reserva) {
        ReservaEntity reservaEliminar = emReserva.find(ReservaEntity.class, id_Reserva);
        emReserva.remove(reservaEliminar);
    }    
}