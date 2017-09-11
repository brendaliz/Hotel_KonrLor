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
public class ProveedorPromocionHotelEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private ProveedorEntity proveedor;
    
    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private HotelEntity hotel;

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }
    
}
