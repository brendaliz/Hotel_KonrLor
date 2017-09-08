/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konlor.entities;

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
 * @author Carlos
 */
@Entity
public class CadenaHoteleraEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_cadena_hotelera")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Cadena_Hotelera;
    
    @Column(name = "nombre_cadena_hotelera")
    private String nombre_Cadena;
    
    @Column(name = "telefono_cadena_hotelera")
    private int numero_Telefono;
    
    @Column(name = "correo_cadena_hotelera")
    private String correo_Electronico;
    
    @Column(name = "direccion_cadena_hotelera")
    private String direccion_Atencion_Cliente;

    public long getNit_Cadena_Hotelera() {
        return id_Cadena_Hotelera;
    }

    public void setNit_Cadena_Hotelera(long nit_Cadena_Hotelera) {
        this.id_Cadena_Hotelera = nit_Cadena_Hotelera;
    }

    public String getNombre_Cadena() {
        return nombre_Cadena;
    }

    public void setNombre_Cadena(String nombre_Cadena) {
        this.nombre_Cadena = nombre_Cadena;
    }

    public int getNumero_Telefono() {
        return numero_Telefono;
    }

    public void setNumero_Telefono(int numero_Telefono) {
        this.numero_Telefono = numero_Telefono;
    }

    public String getCorreo_Electronico() {
        return correo_Electronico;
    }

    public void setCorreo_Electronico(String correo_Electronico) {
        this.correo_Electronico = correo_Electronico;
    }

    public String getDireccion_Atencion_Cliente() {
        return direccion_Atencion_Cliente;
    }

    public void setDireccion_Atencion_Cliente(String direccion_Atencion_Cliente) {
        this.direccion_Atencion_Cliente = direccion_Atencion_Cliente;
    }    
}