/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author Carlos
 */

@Entity
public class HabitacionEntity implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    @Id
    @Column(name="id_Habitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tipo_Habitacion;
    
    private String galeria;
    
    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private HotelEntity hotel;

    public long getTipo_Habitacion() {
        return tipo_Habitacion;
    }

    public void setTipo_Habitacion(long tipo_Habitacion) {
        this.tipo_Habitacion = tipo_Habitacion;
    }

    public String getGaleria() {
        return galeria;
    }

    public void setGaleria(String galeria) {
        this.galeria = galeria;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }



}