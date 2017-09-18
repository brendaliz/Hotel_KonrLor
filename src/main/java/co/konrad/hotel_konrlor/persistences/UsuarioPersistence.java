/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.UsuarioEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author Carlos
 */
@Stateless
public class UsuarioPersistence {
    
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager emUsuario;
    
    public UsuarioEntity find(Long id_usuario){
        return emUsuario.find(UsuarioEntity.class, id_usuario);
    }
    
    public List<UsuarioEntity> findAll() {
        Query q = emUsuario.createQuery("select u from UsuarioEntity r");
        return q.getResultList();
    }
    
    public UsuarioEntity create(UsuarioEntity usuario) {
        emUsuario.persist(usuario);
        return usuario;
    }
    
    public UsuarioEntity update(UsuarioEntity usuario) {
        return emUsuario.merge(usuario);
    }
    public void delete(Long id_usuario) {
        UsuarioEntity usuarioEliminar = emUsuario.find(UsuarioEntity.class, id_usuario);
        emUsuario.remove(usuarioEliminar);
    }    
}