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
 * @author Carlos
 */
@Entity
public class TipoAcomodacionEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;    
    
    @Id
    @Column(name="id_tipo_acomodacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_acomodacion;
    
    @ManyToOne
    @JoinColumn(name = "tipo_Habitacion")
    private HabitacionEntity habitacion;

    public Long getId_tipo_acomodacion() {
        return id_tipo_acomodacion;
    }

    public void setId_tipo_acomodacion(Long id_tipo_acomodacion) {
        this.id_tipo_acomodacion = id_tipo_acomodacion;
    }

    public HabitacionEntity getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(HabitacionEntity habitacion) {
        this.habitacion = habitacion;
    }
        
}
