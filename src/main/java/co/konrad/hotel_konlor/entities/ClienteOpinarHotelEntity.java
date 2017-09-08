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

public class ClienteOpinarHotelEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @JoinColumn
    @Column(name = "id_opinion")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "numero_documento_cliente")            
    private ClienteEntity cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private HotelEntity Hotel;
    
    @Column(name = "comentario_opinion")
    private String comentario;
    
    @Column(name = "valoracion")
    private int valoracion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public HotelEntity getHotel() {
        return Hotel;
    }

    public void setHotel(HotelEntity Hotel) {
        this.Hotel = Hotel;
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
    
    
}
