/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.dto;

import co.konrad.hotel_konrlor.entities.CadenaHoteleraEntity;
import co.konrad.hotel_konrlor.entities.HotelEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class HotelDTO {

    private long id_hotel;
    
    private String nombre;
    
    private String tipo;
    
    private String categoria;
    
    private int num_Telefono;
    
    private String direccion;
    
    private String ciudad;
    
    private String pais;
    
    private boolean disponibilidad;
    
    private CadenaHoteleraEntity cadenaHotelera;
    
    
    public HotelDTO() {
    }

    public HotelDTO(HotelEntity hotelEntity) {
        this.id_hotel = hotelEntity.getId_hotel();
        this.nombre = hotelEntity.getNombre();
        this.tipo = hotelEntity.getTipo();
        this.categoria = hotelEntity.getCategoria();
        this.num_Telefono = hotelEntity.getNum_Telefono();
        this.direccion = hotelEntity.getDireccion();
        this.ciudad = hotelEntity.getCiudad();
        this.pais = hotelEntity.getPais();
        this.disponibilidad = hotelEntity.getDisponibilidad();
        this.cadenaHotelera = hotelEntity.getCadenaHotelera();
    }
    
    public HotelEntity toEntity(){
        HotelEntity hotel = new HotelEntity();
        hotel.setId_hotel(this.id_hotel);
        hotel.setNombre(this.nombre);
        hotel.setTipo(this.tipo);
        hotel.setCategoria(this.categoria);
        hotel.setNum_Telefono(this.num_Telefono);
        hotel.setDireccion(this.direccion);
        hotel.setCiudad(this.ciudad);
        hotel.setPais(this.pais);
        hotel.setDisponibilidad(this.disponibilidad);
        hotel.setCadenaHotelera(this.cadenaHotelera);
        return hotel;
    }

    public static List<HotelDTO> toHotelList(List<HotelEntity> hotelList){
        List<HotelDTO> listaHoteles = new ArrayList<>();
        for (int i = 0; i < hotelList.size(); i++){
            listaHoteles.add(new HotelDTO(hotelList.get(i)));
        }
        return listaHoteles;
    }
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

    public boolean isDisponibilidad() {
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
