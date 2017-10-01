/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.resources;

import co.konrad.hotel_konrlor.dto.ReservaDTO;
import co.konrad.hotel_konrlor.entities.ReservaEntity;
import co.konrad.hotel_konrlor.logic.ReservaLogic;
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
 * @author brend
 */
@Path("/reservas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ReservaResource {
    
   @EJB
    private ReservaLogic reservaLogic;
    
    /**
     * Metodo GET
     * @return ReservaDTO
     */
    @GET
    public List<ReservaDTO> getReservasList(){
        List<ReservaEntity> proveedores = reservaLogic.getReservas();
        return ReservaDTO.toReservaList(proveedores);
    }
   
    /**
     * Metodo GET para obtener un solo objeto
     * @param id_reserva
     * @return  List
     */
    @GET
    @Path("{id: \\d+}")
    public ReservaDTO getReserva(@PathParam("id") Long id_reserva){
        ReservaEntity reserva = reservaLogic.getReserva(id_reserva);
        if(reserva == null){
            throw new RuntimeException("La reserva no existe");
        }
        return new ReservaDTO(reserva);
    }
    
    /**
     * Metodo POST creacion de reserva
     * @param reserva
     * @return ReservaDTO
     */
    @POST
    public ReservaDTO createReserva(ReservaDTO reserva){
        return new ReservaDTO(reservaLogic.createReserva(reserva.toEntity()));
    }
    
    /**
     * Metodo PUT actualizacion reserva
     * @param id_reserva
     * @param reserva
     * @return ReservaDTO
     */
    @PUT
    @Path("{reservaId: \\d+}")
    public ReservaDTO updateReserva(@PathParam("reservaId") Long id_reserva, ReservaDTO reserva){
        ReservaEntity reservaEntity = reservaLogic.getReserva(id_reserva);
        if(reservaEntity == null){
            throw new RuntimeException("La reserva no existe");
        }
        return new ReservaDTO(reservaLogic.updateReserva(id_reserva, reserva.toEntity()));
    }
    
    @DELETE
    @Path("{reservaId: \\d+}")
    public void deleteProveedor(@PathParam("reservaId") Long id_reserva){
        ReservaEntity reservaEntity = reservaLogic.getReserva(id_reserva);
        if(reservaEntity == null){
            throw new RuntimeException("La reserva no existe");
        }
        reservaLogic.deleteReserva(id_reserva);
    }       
}
