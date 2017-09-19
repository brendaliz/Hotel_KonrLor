/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.dto;

import co.konrad.hotel_konrlor.entities.HabitacionEntity;
import co.konrad.hotel_konrlor.entities.HotelEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class HabitacionDTO {

    private long id_Habitacion;
    
    private String galeria;
    
    private HotelEntity hotel;
    
    public HabitacionDTO() {
    }

    public HabitacionDTO(HabitacionEntity habitacionEntity) {
        this.id_Habitacion = habitacionEntity.getId_Habitacion();
        this.galeria = habitacionEntity.getGaleria();
        this.hotel = habitacionEntity.getHotel();
    }
    
    public HabitacionEntity toEntity(){
        HabitacionEntity habitacion = new HabitacionEntity();
        habitacion.setId_Habitacion(this.id_Habitacion);
        habitacion.setGaleria(this.galeria);
        habitacion.setHotel(this.hotel);
        return habitacion;
    }
    
    public static List<HabitacionDTO> toHabitacionList(List<HabitacionEntity> habitacionList){
        List<HabitacionDTO> listaHabitaciones = new ArrayList<>();
        for (int i = 0; i < habitacionList.size(); i++){
            listaHabitaciones.add(new HabitacionDTO(habitacionList.get(i)));
        }
        return listaHabitaciones;
    }
    

    public long getId_Habitacion() {
        return id_Habitacion;
    }

    public void setId_Habitacion(long id_Habitacion) {
        this.id_Habitacion = id_Habitacion;
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
