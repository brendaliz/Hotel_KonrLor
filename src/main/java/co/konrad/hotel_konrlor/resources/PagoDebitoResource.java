/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.resources;

import co.konrad.hotel_konrlor.dto.PagoDebitoDTO;
import co.konrad.hotel_konrlor.entities.PagoDebitoEntity;
import co.konrad.hotel_konrlor.logic.PagoDebitoLogic;
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
@Path("/pagosDebito")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PagoDebitoResource {
    @EJB
    private PagoDebitoLogic pagoDebitoLogic;
    
    /**
     * Metodo GET
     * @return PagoDebitoDTO
     */
    @GET
    public List<PagoDebitoDTO> getPagosDebitoList(){
        List<PagoDebitoEntity> pagosDebito = pagoDebitoLogic.getPagosDebito();
        return PagoDebitoDTO.toPagoDebitoList(pagosDebito);
    }
    //investigar expresiones regulares en java
    /**
     * Metodo GET para obtener un solo objeto
     * @param id
     * @return  List
     */
    @GET
    @Path("{id: \\d+}")
    public PagoDebitoDTO getPagoDebito(@PathParam("id") Long id){
        PagoDebitoEntity pagoDebito = pagoDebitoLogic.getPagoDebito(id);
        if(pagoDebito == null){
            throw new RuntimeException("El pago con tarjeta debito no existe");
        }
        return new PagoDebitoDTO(pagoDebito);
    }
    
    /**
     * Metodo POST creacion de pagoDebito
     * @param pagoDebito
     * @return PagoDebitoDTO
     */
    @POST
    public PagoDebitoDTO createPagoDebito(PagoDebitoDTO pagoDebito){
        return new PagoDebitoDTO(pagoDebitoLogic.createPagoDebito(pagoDebito.toEntity()));
    }
    
    /**
     * Metodo PUT actualizacion pagoDebito
     * @param id
     * @param pagoDebito
     * @return PagoDebitoDTO
     */
    @PUT
    @Path("{pagoDebitoId: \\d+}")
    public PagoDebitoDTO updatePagoDebito(@PathParam("pagoDebitoId") Long id, PagoDebitoDTO pagoDebito){
        PagoDebitoEntity pagoDebitoEntity = pagoDebitoLogic.getPagoDebito(id);
        if(pagoDebitoEntity == null){
            throw new RuntimeException("El pago con tarjeta debito no existe");
        }
        return new PagoDebitoDTO(pagoDebitoLogic.updatePagoDebito(id, pagoDebito.toEntity()));
    }
    
    @DELETE
    @Path("{pagoDebitoId: \\d+}")
    public void deletePagoDebito(@PathParam("pagoDebitoId") Long id){
        PagoDebitoEntity pagoDebitoEntity = pagoDebitoLogic.getPagoDebito(id);
        if(pagoDebitoEntity == null){
            throw new RuntimeException("El pago con tarjeta debito no existe");
        }
        pagoDebitoLogic.deletePagoDebito(id);
    }    
}
