/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.resources;

import co.konrad.hotel_konrlor.dto.CadenaHoteleraDTO;
import co.konrad.hotel_konrlor.entities.CadenaHoteleraEntity;
import co.konrad.hotel_konrlor.logic.CadenaHoteleraLogic;
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
@Path("/cadenasHoteleras")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CadenaHoteleraResource {
    
    @EJB
    private CadenaHoteleraLogic cadenaHoteleraLogic;
    
    /**
     * Metodo GET
     * @return CadenaHoteleraDTO
     */
    @GET
    public List<CadenaHoteleraDTO> getCadenasHotelerasList(){
        List<CadenaHoteleraEntity> cadenasHoteleras = cadenaHoteleraLogic.getCadenasHoteleras();
        return CadenaHoteleraDTO.toCadenaHoteleraList(cadenasHoteleras);
    }
    //investigar expresiones regulares en java
    /**
     * Metodo GET para obtener un solo objeto
     * @param id_Cadena_Hotelera 
     * @return  List
     */
    @GET
    @Path("{id: \\d+}")
    public CadenaHoteleraDTO getCadenaHotelera(@PathParam("id") Long id_Cadena_Hotelera){
        CadenaHoteleraEntity cadenaHotelera = cadenaHoteleraLogic.getCadenaHotelera(id_Cadena_Hotelera);
        if(cadenaHotelera == null){
            throw new RuntimeException("La cadena hotelera no existe");
        }
        return new CadenaHoteleraDTO(cadenaHotelera);
    }
    
    /**
     * Metodo POST creacion de cadenaHotelera
     * @param cadenaHotelera
     * @return CadenaHoteleraDTO
     */
    @POST
    public CadenaHoteleraDTO createCadenaHotelera(CadenaHoteleraDTO cadenaHotelera){
        return new CadenaHoteleraDTO(cadenaHoteleraLogic.createCadenaHotelera(cadenaHotelera.toEntity()));
    }
    
    /**
     * Metodo PUT actualizacion cadenaHotelra
     * @param id_Cadena_Hotelera 
     * @param cadenaHotelera
     * @return CadenaHoteleraDTO
     */
    @PUT
    @Path("{cadenaHoteleraId: \\d+}")
    public CadenaHoteleraDTO updateCadenaHotelera(@PathParam("cadenaHoteleraId") Long id_Cadena_Hotelera, CadenaHoteleraDTO cadenaHotelera){
        CadenaHoteleraEntity cadenaHoteleraEntity = cadenaHoteleraLogic.getCadenaHotelera(id_Cadena_Hotelera);
        if(cadenaHoteleraEntity == null){
            throw new RuntimeException("La cadena hotelera no existe");
        }
        return new CadenaHoteleraDTO(cadenaHoteleraLogic.updateCadenaHotelera(id_Cadena_Hotelera, cadenaHotelera.toEntity()));
    }
    
    @DELETE
    @Path("{cadenaHoteleraId: \\d+}")
    public void deleteCadenaHotelera(@PathParam("cadenaHoteleraId") Long id_Cadena_Hotelera){
        CadenaHoteleraEntity cadenaHoteleraEntity = cadenaHoteleraLogic.getCadenaHotelera(id_Cadena_Hotelera);
        if(cadenaHoteleraEntity == null){
            throw new RuntimeException("La cadena hotelera no existe");
        }
        cadenaHoteleraLogic.deleteCadenaHotelera(id_Cadena_Hotelera);
    }    
}
