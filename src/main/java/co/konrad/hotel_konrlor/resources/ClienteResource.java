/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.resources;

import co.konrad.hotel_konrlor.dto.ClienteDTO;
import co.konrad.hotel_konrlor.entities.ClienteEntity;
import co.konrad.hotel_konrlor.logic.ClienteLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Carlos
 */
@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @EJB
    private ClienteLogic clienteLogic;
    
    /**
     * Metodo GET
     * @return ClientelDTO
     */
    @GET
    public List<ClienteDTO> getClientesList(){
        List<ClienteEntity> clientes = clienteLogic.getClientes();
        return ClienteDTO.toClienteList(clientes);
    }
    //investigar expresiones regulares en java
    /**
     * Metodo GET para obtener un solo objeto
     * @param id_cliente 
     * @return  List
     */
    @GET
    @Path("{id: \\d+}")
    public ClienteDTO getCliente(@PathParam("id") Long id_cliente){
        ClienteEntity cliente = clienteLogic.getCliente(id_cliente);
        if(cliente == null){
            throw new RuntimeException("El cliente no existe");
        }
        return new ClienteDTO(cliente);
    }
    
    /**
     * Metodo POST creacion de cliente
     * @param cliente
     * @return ClieteDTO
     */
    @POST
    public ClienteDTO createCliente(ClienteDTO cliente){
        return new ClienteDTO(clienteLogic.createCliente(cliente.toEntity()));
    }
    
    /**
     * Metodo PUT actualizacion cliente
     * @param id_cliente 
     * @param cliente
     * @return ClienteDTO
     */
    @PUT
    @Path("{clienteId: \\d+}")
    public ClienteDTO updateCliente(@PathParam("clienteId") Long id_cliente, ClienteDTO cliente){
        ClienteEntity clienteEntity = clienteLogic.getCliente(id_cliente);
        if(clienteEntity == null){
            throw new RuntimeException("El cliente no existe");
        }
        return new ClienteDTO(clienteLogic.updateCliente(id_cliente, cliente.toEntity()));
    }
    
    @DELETE
    @Path("{clienteId: \\d+}")
    public void deleteCliente(@PathParam("cleinteId") Long id_cliente){
        ClienteEntity clienteEntity = clienteLogic.getCliente(id_cliente);
        if(clienteEntity == null){
            throw new RuntimeException("El cliente no existe");
        }
        clienteLogic.deleteCliente(id_cliente);
    }    
}
