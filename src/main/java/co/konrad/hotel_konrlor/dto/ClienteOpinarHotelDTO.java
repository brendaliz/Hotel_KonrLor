/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.dto;

import co.konrad.hotel_konrlor.entities.ClienteEntity;
import co.konrad.hotel_konrlor.entities.ClienteOpinarHotelEntity;
import co.konrad.hotel_konrlor.entities.HotelEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class ClienteOpinarHotelDTO {

    private Long id_opinion;
    
    private String comentario;
    
    private int valoracion;
    
    private ClienteEntity cliente;
    
    private HotelEntity hotel;
    
    public ClienteOpinarHotelDTO() {
    }

    public ClienteOpinarHotelDTO(ClienteOpinarHotelEntity clienteOpinarHotelEntity) {
        this.id_opinion = clienteOpinarHotelEntity.getId_opinion();
        this.comentario = clienteOpinarHotelEntity.getComentario();
        this.valoracion = clienteOpinarHotelEntity.getValoracion();
        this.cliente = clienteOpinarHotelEntity.getCliente();
        this.hotel = clienteOpinarHotelEntity.getHotel();
    }
    
    public ClienteOpinarHotelEntity toEntity(){
        ClienteOpinarHotelEntity clienteOpinarHotelEntity = new ClienteOpinarHotelEntity();
        clienteOpinarHotelEntity.setId_opinion(this.id_opinion);
        clienteOpinarHotelEntity.setComentario(this.comentario);
        clienteOpinarHotelEntity.setValoracion(this.valoracion);
        clienteOpinarHotelEntity.setCliente(this.cliente);
        clienteOpinarHotelEntity.setHotel(this.hotel);
        return clienteOpinarHotelEntity;
    }

    public static List<ClienteOpinarHotelDTO> toClienteOpinarHotelList(List<ClienteOpinarHotelEntity> clienteOpinarHotelList){
        List<ClienteOpinarHotelDTO> listaOpinionesHotel = new ArrayList<>();
        for (int i = 0; i < clienteOpinarHotelList.size(); i++){
            listaOpinionesHotel.add(new ClienteOpinarHotelDTO(clienteOpinarHotelList.get(i)));
        }
        return listaOpinionesHotel;
    }
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
