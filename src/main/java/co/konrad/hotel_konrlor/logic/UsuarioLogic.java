/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.logic;

import co.konrad.hotel_konrlor.entities.UsuarioEntity;
import co.konrad.hotel_konrlor.persistences.UsuarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Stateless
public class UsuarioLogic {
    @Inject
    private UsuarioPersistence usuarioPersistence;
    
    /*Metodo para encontrar todos los */
    
    public List<UsuarioEntity> getUsuarios(){
        List<UsuarioEntity>usuarios = usuarioPersistence.findAll();
        return usuarios;
    }
    /*Obtener un objeto de la tabla 
        @Param id
        @return usuario*/
    public UsuarioEntity getUsuario(Long id_usuario){
        UsuarioEntity usuario = usuarioPersistence.find(id_usuario);
        if(usuario == null){
            throw new IllegalArgumentException("El usuario solicitado no existe");
        }
        return usuario;
    }
    
    public UsuarioEntity createUsuario(UsuarioEntity usuario){
        usuarioPersistence.create(usuario);
        return usuario;
    }
    
    /* ACTUALIZACION OBJETO USUARIO*/
    
    public UsuarioEntity updateUsuario(Long id_usuario, UsuarioEntity usuario){
        UsuarioEntity usuarioEntity = usuarioPersistence.update(usuario);
        return usuarioEntity;
    }
    /*
    Eliminar un objeto usuario
    @param id
    */
    public void deleteUsuario (Long id_usuario){
        usuarioPersistence.delete(id_usuario);
    }
}
