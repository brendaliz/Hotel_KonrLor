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
public class ClienteOpinarHotelEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_opinion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_opinion;
    
     
    @Column(name = "comentario_opinion")
    private String comentario;
    
    @Column(name = "valoracion")
    private int valoracion;
    
    @ManyToOne
    @JoinColumn (name = "id_cliente")
    private ClienteEntity cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private HotelEntity hotel;

    public Long getId_opinion() {
        return id_opinion;
    }

    public void setId_opinion(Long id_opinion) {
        this.id_opinion = id_opinion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }
   

   
}
