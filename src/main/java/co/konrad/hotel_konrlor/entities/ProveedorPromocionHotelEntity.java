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
public class ProveedorPromocionHotelEntity implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_p_Promocion_hotel")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_p_Promocion_hotel;
    
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private ProveedorEntity proveedor;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private HotelEntity id_hotel;

    public Long getId_p_Promocion_hotel() {
        return id_p_Promocion_hotel;
    }

    public void setId_p_Promocion_hotel(Long id_p_Promocion_hotel) {
        this.id_p_Promocion_hotel = id_p_Promocion_hotel;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public HotelEntity getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(HotelEntity id_hotel) {
        this.id_hotel = id_hotel;
    }
    
    

}
