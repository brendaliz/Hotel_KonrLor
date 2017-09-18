/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author brend
 */
@Entity
public class EmpleadoEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_empleado")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_empleado;
    
    @Column(name = "nombre_empleado", nullable = false)
    private String nombre;
     
    @Column(name = "apellido_empleado", nullable = false)
    private String apellido;
    
    
    @ManyToOne
    @JoinColumn (name = "id_usuario")
    private UsuarioEntity usuario;
    
    @ManyToOne
    @JoinColumn (name = "id_cadena_hotelera")
    private CadenaHoteleraEntity cadena_hotelera;

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public CadenaHoteleraEntity getCadena_hotelera() {
        return cadena_hotelera;
    }

    public void setCadena_hotelera(CadenaHoteleraEntity cadena_hotelera) {
        this.cadena_hotelera = cadena_hotelera;
    }

    
    
    
    
}
