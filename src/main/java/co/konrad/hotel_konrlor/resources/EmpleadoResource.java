/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.resources;

import co.konrad.hotel_konrlor.dto.EmpleadoDTO;
import co.konrad.hotel_konrlor.entities.EmpleadoEntity;
import co.konrad.hotel_konrlor.logic.EmpleadoLogic;
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
@Path("/empleados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmpleadoResource {
    @EJB
    private EmpleadoLogic empleadoLogic;
    
    /**
     * Metodo GET
     * @return EmpleadoDTO
     */
    @GET
    public List<EmpleadoDTO> getEmpleadosList(){
        List<EmpleadoEntity> empleados = empleadoLogic.getEmpleados();
        return EmpleadoDTO.toEmpleadoList(empleados);
    }
    //investigar expresiones regulares en java
    /**
     * Metodo GET para obtener un solo objeto
     * @param id_empleado 
     * @return  List
     */
    @GET
    @Path("{id: \\d+}")
    public EmpleadoDTO getFestival(@PathParam("id") Long id_empleado){
        EmpleadoEntity empleado = empleadoLogic.getEmpleado(id_empleado);
        if(empleado == null){
            throw new RuntimeException("El empleado no existe");
        }
        return new EmpleadoDTO(empleado);
    }
    
    /**
     * Metodo POST creacion de empleado
     * @param empleado
     * @return EmpleadoDTO
     */
    @POST
    public EmpleadoDTO createEmpleado(EmpleadoDTO empleado){
        return new EmpleadoDTO(empleadoLogic.createEmpleado(empleado.toEntity()));
    }
    
    /**
     * Metodo PUT actualizacion empleado
     * @param id_empleado 
     * @param empleado
     * @return EmpleadoDTO
     */
    @PUT
    @Path("{empleadoId: \\d+}")
    public EmpleadoDTO updateEmpleado(@PathParam("empleadoId") Long id_empleado, EmpleadoDTO empleado){
        EmpleadoEntity empleadoEntity = empleadoLogic.getEmpleado(id_empleado);
        if(empleadoEntity == null){
            throw new RuntimeException("El empleado no existe");
        }
        return new EmpleadoDTO(empleadoLogic.updateEmpleado(id_empleado, empleado.toEntity()));
    }
    
    @DELETE
    @Path("{empleadoId: \\d+}")
    public void deleteEmpleado(@PathParam("empleadoId") Long id_empleado){
        EmpleadoEntity empleadoEntity = empleadoLogic.getEmpleado(id_empleado);
        if(empleadoEntity == null){
            throw new RuntimeException("El empleado no existe");
        }
        empleadoLogic.deleteEmpleado(id_empleado);
    }    
}
