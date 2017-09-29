/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.logic;

import co.konrad.hotel_konrlor.entities.ClienteEntity;
import co.konrad.hotel_konrlor.persistences.ClientePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Stateless
public class ClienteLogic {
    @Inject
    private ClientePersistence clientePersistence;
    
    /*Metodo para encontrar todos los */
    
    public List<ClienteEntity> getClientes(){
        List<ClienteEntity>clientes = clientePersistence.findAll();
        return clientes;
    }
    /*Obtener un objeto de la tabla 
        @Param id
        @return cliente*/
    public ClienteEntity getCliente(Long id_cliente){
        ClienteEntity cliente = clientePersistence.find(id_cliente);
        if(cliente == null){
            throw new IllegalArgumentException("El cliente solicitado no existe");
        }
        return cliente;
    }
    
    public ClienteEntity createCliente(ClienteEntity cliente){
        clientePersistence.create(cliente);
        return cliente;
    }
    
    /* ACTUALIZACION OBJETO CLIENTE*/
    
    public ClienteEntity updateCliente(Long id_cliente, ClienteEntity cliente){
        ClienteEntity clienteEntity = clientePersistence.update(cliente);
        return clienteEntity;
    }
    /*
    Eliminar un objeto cliente
    @param id
    */
    public void deleteCliente (Long id_cliente){
        clientePersistence.delete(id_cliente);
    }
}
