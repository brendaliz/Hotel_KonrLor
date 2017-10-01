/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.resources;

import co.konrad.hotel_konrlor.dto.ProveedorDTO;
import co.konrad.hotel_konrlor.entities.ProveedorEntity;
import co.konrad.hotel_konrlor.logic.ProveedorLogic;
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
@Path("/proveedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProveedorResource {
    @EJB
    private ProveedorLogic proveedorLogic;
    
    /**
     * Metodo GET
     * @return ProveedorDTO
     */
    @GET
    public List<ProveedorDTO> getProveedoresList(){
        List<ProveedorEntity> proveedores = proveedorLogic.getProveedores();
        return ProveedorDTO.toProveedorList(proveedores);
    }
    //investigar expresiones regulares en java
    /**
     * Metodo GET para obtener un solo objeto
     * @param id_proveedor
     * @return  List
     */
    @GET
    @Path("{id: \\d+}")
    public ProveedorDTO getProveedor (@PathParam("id") Long id_proveedor){
        ProveedorEntity proveedor = proveedorLogic.getProveedor(id_proveedor);
        if(proveedor == null){
            throw new RuntimeException("El proveedor no existe");
        }
        return new ProveedorDTO(proveedor);
    }
    
    /**
     * Metodo POST creacion de proveedor
     * @param proveedor
     * @return ProveedorDTO
     */
    @POST
    public ProveedorDTO createProveedor(ProveedorDTO proveedor){
        return new ProveedorDTO(proveedorLogic.createProveedor(proveedor.toEntity()));
    }
    
    /**
     * Metodo PUT actualizacion proveedor
     * @param id_proveedor
     * @param proveedor
     * @return ProveedorDTO
     */
    @PUT
    @Path("{proveedorId: \\d+}")
    public ProveedorDTO updateProveedor(@PathParam("proveedorId") Long id_proveedor, ProveedorDTO proveedor){
        ProveedorEntity proveedorEntity = proveedorLogic.getProveedor(id_proveedor);
        if(proveedorEntity == null){
            throw new RuntimeException("El proveedor no existe");
        }
        return new ProveedorDTO(proveedorLogic.updateProveedor(id_proveedor, proveedor.toEntity()));
    }
    
    @DELETE
    @Path("{proveedorId: \\d+}")
    public void deleteProveedor(@PathParam("proveedorId") Long id_proveedor){
        ProveedorEntity proveedorEntity = proveedorLogic.getProveedor(id_proveedor);
        if(proveedorEntity == null){
            throw new RuntimeException("El proveedor no existe");
        }
        proveedorLogic.deleteProveedor(id_proveedor);
    }       
}
