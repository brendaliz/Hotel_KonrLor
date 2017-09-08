/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konlor.entities;

import java.io.Serializable;
import java.util.Date;
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
public class HotelEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_hotel")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_hotel;
    
    @Column(name = "nombre_Hotel", nullable =false)
    private String nombre;
    
    @Column(name="tipo")
    private String tipo;
    
    @Column(name="categoria_hotel")
    private String categoria;
    
    @Column(name="num_Telefono_hotel")
    private int num_Telefono;
    
    @Column(name="direccion_hotel")
    private String direccion;
    
    @Column(name="ciudad_hotel")
    private String ciudad;
    
    @Column(name="pais_hotel")
    private String pais;
    
    @Column(name="disponibilidad_hotel")
    private boolean disponibilidad;
    
    @ManyToOne
    @JoinColumn(name = "nit_cadena_Hotelera")
    private CadenaHoteleraEntity cadenaHotelera;

    public long getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(long id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNum_Telefono() {
        return num_Telefono;
    }

    public void setNum_Telefono(int num_Telefono) {
        this.num_Telefono = num_Telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public CadenaHoteleraEntity getCadenaHotelera() {
        return cadenaHotelera;
    }

    public void setCadenaHotelera(CadenaHoteleraEntity cadenaHotelera) {
        this.cadenaHotelera = cadenaHotelera;
    }

    
}
