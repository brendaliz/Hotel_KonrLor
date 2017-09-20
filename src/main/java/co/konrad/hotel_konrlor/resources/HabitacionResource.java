/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.resources;

import co.konrad.hotel_konrlor.dto.HabitacionDTO;
import co.konrad.hotel_konrlor.entities.HabitacionEntity;
import co.konrad.hotel_konrlor.logic.HabitacionLogic;
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
@Path("/habitaciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HabitacionResource {
    @EJB
    private HabitacionLogic habitacionLogic;
    
    /**
     * Metodo GET
     * @return HabitacionDTO
     */
    @GET
    public List<HabitacionDTO> getHabitacionesList(){
        List<HabitacionEntity> habitaciones = habitacionLogic.getHabitaciones();
        return HabitacionDTO.toHabitacionList(habitaciones);
    }
    //investigar expresiones regulares en java
    /**
     * Metodo GET para obtener un solo objeto
     * @param id
     * @return  List
     */
    @GET
    @Path("{id: \\d+}")
    public HabitacionDTO getHabitacion(@PathParam("id") Long id){
        HabitacionEntity habitacion = habitacionLogic.getHabitacion(id);
        if(habitacion == null){
            throw new RuntimeException("La habitacion no existe");
        }
        return new HabitacionDTO(habitacion);
    }
    
    /**
     * Metodo POST creacion de habitacion
     * @param habitacion
     * @return HabitacionDTO
     */
    @POST
    public HabitacionDTO createHabitacion(HabitacionDTO habitacion){
        return new HabitacionDTO(habitacionLogic.createHabitaicon(habitacion.toEntity()));
    }
    
    /**
     * Metodo PUT actualizacion habitacion
     * @param id
     * @param habitacion
     * @return HabitacionDTO
     */
    @PUT
    @Path("{habitacionId: \\d+}")
    public HabitacionDTO updateHabitacion(@PathParam("habitacionId") Long id, HabitacionDTO habitacion){
        HabitacionEntity habitacionEntity = habitacionLogic.getHabitacion(id);
        if(habitacionEntity == null){
            throw new RuntimeException("La habitacion no existe");
        }
        return new HabitacionDTO(habitacionLogic.updateHabitacion(id, habitacion.toEntity()));
    }
    
    @DELETE
    @Path("{habitacionId: \\d+}")
    public void deleteHabitacion(@PathParam("habitacionId") Long id){
        HabitacionEntity habitacionEntity = habitacionLogic.getHabitacion(id);
        if(habitacionEntity == null){
            throw new RuntimeException("La habitacion no existe");
        }
        habitacionLogic.deleteHabitacion(id);
    }
}
