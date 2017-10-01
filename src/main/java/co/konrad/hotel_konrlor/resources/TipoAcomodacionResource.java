/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.resources;
import co.konrad.hotel_konrlor.dto.TipoAcomodacionDTO;
import co.konrad.hotel_konrlor.entities.TipoAcomodacionEntity;
import co.konrad.hotel_konrlor.logic.TipoAcomodacionLogic;
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
@Path("/TipoAcomodaciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TipoAcomodacionResource {
    
    @EJB
    private TipoAcomodacionLogic tipoAcomodacionLogic;
    
    /**
     * Metodo GET
     * @return TipoAcomodacionDTO
     */
    @GET
    public List<TipoAcomodacionDTO> getTipoAcomodacionesList(){
        List<TipoAcomodacionEntity> tipoAcomodaciones = tipoAcomodacionLogic.getTiposDeAcomodacion();
        return TipoAcomodacionDTO.toTipoAcomodacionList(tipoAcomodaciones);
    }
   
    /**
     * Metodo GET para obtener un solo objeto
     * @param id_tipo_acomodacion
     * @return  List
     */
    @GET
    @Path("{id: \\d+}")
    public TipoAcomodacionDTO getTipoAcomodacion(@PathParam("id") Long id_tipo_acomodacion){
        TipoAcomodacionEntity TipoAcomodacion = tipoAcomodacionLogic.getTipoAcomodacion(id_tipo_acomodacion);
        if(TipoAcomodacion == null){
            throw new RuntimeException("El Tipo de Acomodacion no existe");
        }
        return new TipoAcomodacionDTO(TipoAcomodacion);
    }
    
    /**
     * Metodo POST creacion de reserva
     * @param TipoAcomodacion
     * @return TipoAcomodacionDTO
     */
    @POST
    public TipoAcomodacionDTO createTipoAcomodacion(TipoAcomodacionDTO TipoAcomodacion){
        return new TipoAcomodacionDTO(tipoAcomodacionLogic.createTipoAcomodacion(TipoAcomodacion.toEntity()));
    }
    
    /**
     * Metodo PUT actualizacion reserva
     * @param id_tipo_acomodacion
     * @param TipoAcomodacion
     * @return TipoAcomodacionDTO
     */
    @PUT
    @Path("{reservaId: \\d+}")
    public TipoAcomodacionDTO updateTipoAcomodacion(@PathParam("reservaId") Long id_tipo_acomodacion, TipoAcomodacionDTO TipoAcomodacion){
        TipoAcomodacionEntity TipoAcomodacionEntity = tipoAcomodacionLogic.getTipoAcomodacion(id_tipo_acomodacion);
        if(TipoAcomodacionEntity == null){
            throw new RuntimeException("El Tipo de Acomodacion no existe");
        }
        return new TipoAcomodacionDTO(tipoAcomodacionLogic.updateTipoAcomodacion(id_tipo_acomodacion, TipoAcomodacion.toEntity()));
    }
    
    @DELETE
    @Path("{reservaId: \\d+}")
    public void deleteTipoAcomodacion(@PathParam("reservaId") Long id_tipo_acomodacion){
        TipoAcomodacionEntity TipoAcomodacionEntity = tipoAcomodacionLogic.getTipoAcomodacion(id_tipo_acomodacion);
        if(TipoAcomodacionEntity == null){
            throw new RuntimeException("El Tipo de Acomodacion no existe");
        }
        tipoAcomodacionLogic.deleteTipoAcomodacion(id_tipo_acomodacion);
    }       
}
