/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.dto;

import co.konrad.hotel_konrlor.entities.CadenaHoteleraEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class CadenaHoteleraDTO {

    private Long id_cadena_hotelera;
    
    private String nombre_Cadena;
    
    private int numero_Telefono;
    
    private String correo_Electronico;
    
    private String direccion_Atencion_Cliente;

    public CadenaHoteleraDTO() {
    }

    public CadenaHoteleraDTO(CadenaHoteleraEntity cadenaHoteleraEntity) {
        this.id_cadena_hotelera = cadenaHoteleraEntity.getId_cadena_hotelera();
        this.nombre_Cadena = cadenaHoteleraEntity.getNombre_Cadena();
        this.numero_Telefono = cadenaHoteleraEntity.getNumero_Telefono();
        this.correo_Electronico = cadenaHoteleraEntity.getCorreo_Electronico();
        this.direccion_Atencion_Cliente = cadenaHoteleraEntity.getDireccion_Atencion_Cliente();
    }
    
    public CadenaHoteleraEntity toEntity(){
        CadenaHoteleraEntity cadenaHotelera = new CadenaHoteleraEntity();
        cadenaHotelera.setId_cadena_hotelera(this.id_cadena_hotelera);
        cadenaHotelera.setNombre_Cadena(this.nombre_Cadena);
        cadenaHotelera.setNumero_Telefono(this.numero_Telefono);
        cadenaHotelera.setCorreo_Electronico(this.correo_Electronico);
        cadenaHotelera.setDireccion_Atencion_Cliente(this.direccion_Atencion_Cliente);
        return cadenaHotelera;
    }
    
    public static List<CadenaHoteleraDTO> toCadenaHoteleraList(List<CadenaHoteleraEntity> cadenaHoteleraList){
        List<CadenaHoteleraDTO> listaCadenaHotelera = new ArrayList<>();
        for(int i = 0; i < cadenaHoteleraList.size(); i++){
            listaCadenaHotelera.add(new CadenaHoteleraDTO(cadenaHoteleraList.get(i)));
        }
        return listaCadenaHotelera;
    }

    public Long getId_cadena_hotelera() {
        return id_cadena_hotelera;
    }

    public void setId_cadena_hotelera(Long id_cadena_hotelera) {
        this.id_cadena_hotelera = id_cadena_hotelera;
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
