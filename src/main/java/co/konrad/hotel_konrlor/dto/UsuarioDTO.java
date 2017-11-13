/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.dto;
import co.konrad.hotel_konrlor.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author brend
 */
public class UsuarioDTO {
    
     private Long id_usuario;
     private String nombre;
     private String contraseña;
     private boolean avatar;
     private String correo;
     
     public UsuarioDTO() {
    }

    public UsuarioDTO(UsuarioEntity usuarioEntity) {
        this.id_usuario = usuarioEntity.getId_usuario();
        this.nombre = usuarioEntity.getNombre();
        this.contraseña = usuarioEntity.getContraseña();
        this.avatar = usuarioEntity.isAvatar();
        this.correo = usuarioEntity.getCorreo();

    }

    public UsuarioEntity toEntity() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId_usuario(this.id_usuario);
        usuario.setNombre(this.nombre);
        usuario.setContraseña(this.contraseña);
        usuario.setAvatar(this.avatar);
        usuario.setCorreo(this.correo);

        return usuario;
    }

    public static List<UsuarioDTO> toUsuarioList(List<UsuarioEntity> usuarioList) {
        List<UsuarioDTO> listaUsuarios = new ArrayList<>();
        for (int i = 0; i < usuarioList.size(); i++) {
            listaUsuarios.add(new UsuarioDTO(usuarioList.get(i)));
        }
        return listaUsuarios;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isAvatar() {
        return avatar;
    }

    public void setAvatar(boolean avatar) {
        this.avatar = avatar;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
