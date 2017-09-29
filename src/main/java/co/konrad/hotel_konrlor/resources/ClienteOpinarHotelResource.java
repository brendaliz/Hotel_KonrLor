/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.resources;

import co.konrad.hotel_konrlor.dto.ClienteOpinarHotelDTO;
import co.konrad.hotel_konrlor.entities.ClienteOpinarHotelEntity;
import co.konrad.hotel_konrlor.logic.ClienteOpinarHotelLogic;
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
@Path("/clientesOpinarHoteles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteOpinarHotelResource {
    @EJB
    private ClienteOpinarHotelLogic clienteOpinarHotelLogic;
    
    /**
     * Metodo GET
     * @return ClienteOpinarHotelDTO
     */
    @GET
    public List<ClienteOpinarHotelDTO> getClientesOpinarHotelesList(){
        List<ClienteOpinarHotelEntity> clientesOpinarHoteles = clienteOpinarHotelLogic.getClientesOpinarHoteles();
        return ClienteOpinarHotelDTO.toClienteOpinarHotelList(clientesOpinarHoteles);
    }
    //investigar expresiones regulares en java
    /**
     * Metodo GET para obtener un solo objeto
     * @param id
     * @return  List
     */
    @GET
    @Path("{id: \\d+}")
    public ClienteOpinarHotelDTO getClienteOpinarHotel(@PathParam("id") Long id_opinion){
        ClienteOpinarHotelEntity clienteOpinarHotel = clienteOpinarHotelLogic.getClienteOpinarHotel(id_opinion);
        if(clienteOpinarHotel == null){
            throw new RuntimeException("La opinion sobre el hotel no existe");
        }
        return new ClienteOpinarHotelDTO(clienteOpinarHotel);
    }
    
    /**
     * Metodo POST creacion de clienteOpinarHotel
     * @param clienteOpinarHotel
     * @return ClienteOpinarHotelDTO
     */
    @POST
    public ClienteOpinarHotelDTO createClienteOpinarHotel(ClienteOpinarHotelDTO clienteOpinarHotel){
        return new ClienteOpinarHotelDTO(clienteOpinarHotelLogic.createClienteOpinarHotel(clienteOpinarHotel.toEntity()));
    }
    
    /**
     * Metodo PUT actualizacion ClienteOpinarHotel
     * @param id
     * @param clienteOpinarHotel
     * @return ClienteOpinarHotelDTO
     */
    @PUT
    @Path("{clienteOpinarHotelId: \\d+}")
    public ClienteOpinarHotelDTO updateClienteOpinarHotel(@PathParam("clienteOpinarHotelId") Long id_opinion, ClienteOpinarHotelDTO clienteOpinarHotel){
        ClienteOpinarHotelEntity clienteOpinarHotelEntity = clienteOpinarHotelLogic.getClienteOpinarHotel(id_opinion);
        if(clienteOpinarHotelEntity == null){
            throw new RuntimeException("La opinon sobre el hotel no existe");
        }
        return new ClienteOpinarHotelDTO(clienteOpinarHotelLogic.updateClienteOpinarHotel(id_opinion, clienteOpinarHotel.toEntity()));
    }
    
    @DELETE
    @Path("{clienteOpinarHotelId: \\d+}")
    public void deleteClienteOpinarHotel(@PathParam("clienteOpinarHotelId") Long id_opinion){
        ClienteOpinarHotelEntity clienteOpinarHotelEntity = clienteOpinarHotelLogic.getClienteOpinarHotel(id_opinion);
        if(clienteOpinarHotelEntity == null){
            throw new RuntimeException("La opinion sobre el hotel no existe");
        }
        clienteOpinarHotelLogic.deleteClienteOpinarHotel(id_opinion);
    }
}
