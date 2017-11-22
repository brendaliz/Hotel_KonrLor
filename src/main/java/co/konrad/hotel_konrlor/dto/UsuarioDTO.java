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
     private String nombre_usuario;
     private String password;
     private boolean avatar;
     private String correo;
     
     public UsuarioDTO() {
    }

    public UsuarioDTO(UsuarioEntity usuarioEntity) {
        this.id_usuario = usuarioEntity.getId_usuario();
        this.nombre_usuario = usuarioEntity.getNombre_usuario();
        this.password = usuarioEntity.getPassword();
        this.avatar = usuarioEntity.isAvatar();
        this.correo = usuarioEntity.getCorreo();

    }

    public UsuarioEntity toEntity() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId_usuario(this.id_usuario);
        usuario.setNombre_usuario(this.nombre_usuario);
        usuario.setPassword(this.password);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    
    
}
