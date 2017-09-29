/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.resources;

import co.konrad.hotel_konrlor.dto.PagoCreditoDTO;
import co.konrad.hotel_konrlor.entities.PagoCreditoEntity;
import co.konrad.hotel_konrlor.logic.PagoCreditoLogic;
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
@Path("/pagosCredito")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PagoCreditoResource {
    @EJB
    private PagoCreditoLogic pagoCreditoLogic;
    
    /**
     * Metodo GET
     * @return PagoCreditoDTO
     */
    @GET
    public List<PagoCreditoDTO> getPagosCreditoList(){
        List<PagoCreditoEntity> pagosCredito = pagoCreditoLogic.getPagosCredito();
        return PagoCreditoDTO.toPagoCreditoList(pagosCredito);
    }
    //investigar expresiones regulares en java
    /**
     * Metodo GET para obtener un solo objeto
     * @param id
     * @return  List
     */
    @GET
    @Path("{id: \\d+}")
    public PagoCreditoDTO getPagoCredito(@PathParam("id") Long id_num_tarjeta){
        PagoCreditoEntity pagoCredito = pagoCreditoLogic.getPagoCredito(id_num_tarjeta);
        if(pagoCredito == null){
            throw new RuntimeException("El pago con tarjeta de credito no existe");
        }
        return new PagoCreditoDTO(pagoCredito);
    }
    
    /**
     * Metodo POST creacion de pagoCredito
     * @param pagoCredito
     * @return PagoCreditoDTO
     */
    @POST
    public PagoCreditoDTO createPagoCredito(PagoCreditoDTO pagoCredito){
        return new PagoCreditoDTO(pagoCreditoLogic.createPagoCredito(pagoCredito.toEntity()));
    }
    
    /**
     * Metodo PUT actualizacion pagoCredito
     * @param id
     * @param pagoCredito
     * @return PagoCreditoDTO
     */
    @PUT
    @Path("{pagoCreditoId: \\d+}")
    public PagoCreditoDTO updatePagoCredito(@PathParam("pagoCreditoId") Long id_num_tarjeta, PagoCreditoDTO pagoCredito){
        PagoCreditoEntity pagoCreditoEntity = pagoCreditoLogic.getPagoCredito(id_num_tarjeta);
        if(pagoCreditoEntity == null){
            throw new RuntimeException("El pago con tarjeta de credito no existe");
        }
        return new PagoCreditoDTO(pagoCreditoLogic.updatePagoCredito(id_num_tarjeta, pagoCredito.toEntity()));
    }
    
    @DELETE
    @Path("{pagoCreditoId: \\d+}")
    public void deletePagoCredito(@PathParam("pagoCreditoId") Long id_num_tarjeta){
        PagoCreditoEntity pagoCreditoEntity = pagoCreditoLogic.getPagoCredito(id_num_tarjeta);
        if(pagoCreditoEntity == null){
            throw new RuntimeException("El pago con tarjeta de credito no existe");
        }
        pagoCreditoLogic.deletePagoCredito(id_num_tarjeta);
    }
}
