/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.resources;

import co.konrad.hotel_konrlor.dto.ProveedorPromocionHotelDTO;
import co.konrad.hotel_konrlor.entities.ProveedorPromocionHotelEntity;
import co.konrad.hotel_konrlor.logic.ProveedorPromocionHotelLogic;

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
@Path("/proveedoresPromocion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ProveedorPromocionHotelResource {
    @EJB
    private ProveedorPromocionHotelLogic proveedorPromocionHotelLogic;
    
    /**
     * Metodo GET
     * @return ProveedorPromocionHotelDTO
     */
    @GET
    public List<ProveedorPromocionHotelDTO> getProveedoresPromocionList(){
        List<ProveedorPromocionHotelEntity> proveedoresPromocion = proveedorPromocionHotelLogic.getPromociones();
        return ProveedorPromocionHotelDTO.toProveedorPromocionList(proveedoresPromocion);
    }

    /**
     * Metodo GET para obtener un solo objeto
     * @param id_p_Promocion_hotel
     * @return  List
     */
    @GET
    @Path("{id: \\d+}")
    public ProveedorPromocionHotelDTO getProveedorPromocion (@PathParam("id") Long id_p_Promocion_hotel){
        ProveedorPromocionHotelEntity proveedorPromocion = proveedorPromocionHotelLogic.getPromocion(id_p_Promocion_hotel);
        if(proveedorPromocion == null){
            throw new RuntimeException("El proveedor promocion no existe");
        }
        return new ProveedorPromocionHotelDTO(proveedorPromocion);
    }
    
    /**
     * Metodo POST creacion de proveedorPromocion
     * @param proveedorPromocion
     * @return ProveedorPromocionHotelDTO
     */
    @POST
    public ProveedorPromocionHotelDTO createProveedorPromocion(ProveedorPromocionHotelDTO proveedorPromocion){
        return new ProveedorPromocionHotelDTO(proveedorPromocionHotelLogic.createPromocion(proveedorPromocion.toEntity()));
    }
    
    /**
     * Metodo PUT actualizacion proveedorPromocion
     * @param id_p_Promocion_hotel
     * @param proveedorPromocion
     * @return ProveedorPromocionHotelDTO
     */
    @PUT
    @Path("{proveedorPromocionId: \\d+}")
    public ProveedorPromocionHotelDTO updateProveedorPromocion(@PathParam("proveedorPromocionId") Long id_p_Promocion_hotel, ProveedorPromocionHotelDTO proveedorPromocion){
        ProveedorPromocionHotelEntity proveedorPromocionEntity = proveedorPromocionHotelLogic.getPromocion(id_p_Promocion_hotel);
        if(proveedorPromocionEntity == null){
            throw new RuntimeException("El proveedor promocion no existe");
        }
        return new ProveedorPromocionHotelDTO(proveedorPromocionHotelLogic.updatePromocion(id_p_Promocion_hotel, proveedorPromocion.toEntity()));
    }
    
    @DELETE
    @Path("{proveedorPromocionId: \\d+}")
    public void deleteProveedorPromocionEntity(@PathParam("proveedorPromocionId") Long id_p_Promocion_hotel){
        ProveedorPromocionHotelEntity proveedorPromocionEntity = proveedorPromocionHotelLogic.getPromocion(id_p_Promocion_hotel);
        if(proveedorPromocionEntity == null){
            throw new RuntimeException("El proveedor promocion no existe");
        }
        proveedorPromocionHotelLogic.deletePromocion(id_p_Promocion_hotel);
    }    

    
}
