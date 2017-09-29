/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.resources;

import co.konrad.hotel_konrlor.dto.PagoDTO;
import co.konrad.hotel_konrlor.entities.PagoEntity;
import co.konrad.hotel_konrlor.logic.PagoLogic;
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
@Path("/pagos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PagoResource {
    @EJB
    private PagoLogic pagoLogic;
    
    /**
     * Metodo GET
     * @return PagoDTO
     */
    @GET
    public List<PagoDTO> getPagosList(){
        List<PagoEntity> pagos = pagoLogic.getPagos();
        return PagoDTO.toPagoList(pagos);
    }
    //investigar expresiones regulares en java
    /**
     * Metodo GET para obtener un solo objeto
     * @param id
     * @return  List
     */
    @GET
    @Path("{id: \\d+}")
    public PagoDTO getPago (@PathParam("id") Long id_pago){
        PagoEntity pago = pagoLogic.getPago(id_pago);
        if(pago == null){
            throw new RuntimeException("El pago no existe");
        }
        return new PagoDTO(pago);
    }
    
    /**
     * Metodo POST creacion de pago
     * @param pago
     * @return PagoDTO
     */
    @POST
    public PagoDTO createPago(PagoDTO pago){
        return new PagoDTO(pagoLogic.createPago(pago.toEntity()));
    }
    
    /**
     * Metodo PUT actualizacion pago
     * @param id
     * @param pago
     * @return PagoDTO
     */
    @PUT
    @Path("{pagoId: \\d+}")
    public PagoDTO updatePago(@PathParam("pagoId") Long id_pago, PagoDTO pago){
        PagoEntity pagoEntity = pagoLogic.getPago(id_pago);
        if(pagoEntity == null){
            throw new RuntimeException("El pago no existe");
        }
        return new PagoDTO(pagoLogic.updatePago(id_pago, pago.toEntity()));
    }
    
    @DELETE
    @Path("{pagoId: \\d+}")
    public void deletePago(@PathParam("pagoId") Long id_pago){
        PagoEntity pagoEntity = pagoLogic.getPago(id_pago);
        if(pagoEntity == null){
            throw new RuntimeException("El pago no existe");
        }
        pagoLogic.deletePago(id_pago);
    }    
}