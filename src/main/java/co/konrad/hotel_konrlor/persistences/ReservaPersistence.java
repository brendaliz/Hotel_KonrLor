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
<<<<<<< HEAD
    protected EntityManager emReserva;
    
    public ReservaEntity find(Long id_reserva){
        return emReserva.find(ReservaEntity.class, id_reserva);
=======
    protected EntityManager em;
    
    public ReservaEntity find(Long id_reserva){
        return em.find(ReservaEntity.class, id_reserva);
>>>>>>> 2666d0ace00d7f0888d6f4ee49deb7ea9f3135d5
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