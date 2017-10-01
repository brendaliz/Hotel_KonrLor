/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.resources;
import co.konrad.hotel_konrlor.dto.UsuarioDTO;
import co.konrad.hotel_konrlor.entities.UsuarioEntity;
import co.konrad.hotel_konrlor.logic.UsuarioLogic;
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
@Path("/Usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UsuarioResource {
    
    @EJB
    private UsuarioLogic usuarioLogic;
    
    /**
     * Metodo GET
     * @return UsuarioDTO
     */
    @GET
    public List<UsuarioDTO> getReservasList(){
        List<UsuarioEntity> usuarios = usuarioLogic.getUsuarios();
        return UsuarioDTO.toUsuarioList(usuarios);
    }
   
    /**
     * Metodo GET para obtener un solo objeto
     * @param id_usuario
     * @return  List
     */
    @GET
    @Path("{id: \\d+}")
    public UsuarioDTO getReserva(@PathParam("id") Long id_usuario){
        UsuarioEntity usuario = usuarioLogic.getUsuario(id_usuario);
        if(usuario == null){
            throw new RuntimeException("El usuario no existe");
        }
        return new UsuarioDTO(usuario);
    }
    
    /**
     * Metodo POST creacion de usuario
     * @param usuario
     * @return UsuarioDTO
     */
    @POST
    public UsuarioDTO createReserva(UsuarioDTO reserva){
        return new UsuarioDTO(usuarioLogic.createUsuario(reserva.toEntity()));
    }
    
    /**
     * Metodo PUT actualizacion usuario
     * @param id_usuario
     * @param usuario
     * @return UsuarioDTO
     */
    @PUT
    @Path("{usuarioId: \\d+}")
    public UsuarioDTO updateReserva(@PathParam("usuarioId") Long id_usuario, UsuarioDTO usuario){
        UsuarioEntity usuarioEntity = usuarioLogic.getUsuario(id_usuario);
        if(usuarioEntity == null){
            throw new RuntimeException("El usuario no existe");
        }
        return new UsuarioDTO(usuarioLogic.updateUsuario(id_usuario, usuario.toEntity()));
    }
    
    @DELETE
    @Path("{usuarioId: \\d+}")
    public void deleteProveedor(@PathParam("usuarioId") Long id_usuario){
        UsuarioEntity usuarioEntity = usuarioLogic.getUsuario(id_usuario);
        if(usuarioEntity == null){
            throw new RuntimeException("El usuario no existe");
        }
        usuarioLogic.deleteUsuario(id_usuario);
    }       
}
