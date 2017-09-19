/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.ClienteOpinarHotelEntity;
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
public class ClienteOpinarHotelPersistence {
    
    @PersistenceContext(unitName = "Hotel_KonLonrPU")

    protected EntityManager emClienteOpinarHotel;
    
    public ClienteOpinarHotelEntity find(Long id_opinion){
        return emClienteOpinarHotel.find(ClienteOpinarHotelEntity.class, id_opinion);
    }
    
    public List<ClienteOpinarHotelEntity> findAll() {
        Query q = emClienteOpinarHotel.createQuery("select c from ClienteOpinarHotelEntity c");
        return q.getResultList();
    }
    
    public ClienteOpinarHotelEntity create(ClienteOpinarHotelEntity clienteOpinar) {
        emClienteOpinarHotel.persist(clienteOpinar);
        return clienteOpinar;
    }
    
    public ClienteOpinarHotelEntity update(ClienteOpinarHotelEntity clienteOpinar) {
        return emClienteOpinarHotel.merge(clienteOpinar);
    }
    public void delete(Long id_opinion) {
        ClienteOpinarHotelEntity clienteOEliminar = emClienteOpinarHotel.find(ClienteOpinarHotelEntity.class, id_opinion);
        emClienteOpinarHotel.remove(clienteOEliminar);
    }    
}
