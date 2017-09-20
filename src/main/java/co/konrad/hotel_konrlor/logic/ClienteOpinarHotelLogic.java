/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.logic;

import co.konrad.hotel_konrlor.entities.ClienteOpinarHotelEntity;
import co.konrad.hotel_konrlor.persistences.ClienteOpinarHotelPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Stateless
public class ClienteOpinarHotelLogic {
    @Inject
    private ClienteOpinarHotelPersistence clienteOpinarHotelPersistence;
    
    /*Metodo para encontrar todos los */
    
    public List<ClienteOpinarHotelEntity> getClientesOpinarHoteles(){
        List<ClienteOpinarHotelEntity>clientesOpinarHoteles = clienteOpinarHotelPersistence.findAll();
        return clientesOpinarHoteles;
    }
    /*Obtener un objeto de la tabla 
        @Param id
        @return clienteOpinarHotel*/
    public ClienteOpinarHotelEntity getClienteOpinarHotel(Long id){
        ClienteOpinarHotelEntity clienteOpinarHotel = clienteOpinarHotelPersistence.find(id);
        if(clienteOpinarHotel == null){
            throw new IllegalArgumentException("La opinion del hotel solicitado no existe");
        }
        return clienteOpinarHotel;
    }
    
    public ClienteOpinarHotelEntity createFestival(ClienteOpinarHotelEntity clienteOpinarHotel){
        clienteOpinarHotelPersistence.create(clienteOpinarHotel);
        return clienteOpinarHotel;
    }
    
    /* ACTUALIZACION OBJETO CLIENTE_OPINAR_HOTEL*/
    
    public ClienteOpinarHotelEntity updateClienteOpinarHotel(Long id, ClienteOpinarHotelEntity clienteOpinarHotel){
        ClienteOpinarHotelEntity clienteOpinarHotelEntity = clienteOpinarHotelPersistence.update(clienteOpinarHotel);
        return clienteOpinarHotelEntity;
    }
    /*
    Eliminar un objeto clienteOpinarHotel
    @param id
    */
    public void deleteClienteOpinarHotel (Long id){
        clienteOpinarHotelPersistence.delete(id);
    }
    
}
