package co.konrad.hotel_konrlor.dto;


import co.konrad.hotel_konrlor.entities.HabitacionEntity;
import co.konrad.hotel_konrlor.entities.TipoAcomodacionEntity;
import java.util.ArrayList;
import java.util.List;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brend
 */
public class TipoAcomodacionDTO {
    
    private Long id_tipo_acomodacion;
    private HabitacionEntity habitacion;
    
    public TipoAcomodacionDTO() {
    }
     
     public TipoAcomodacionDTO(TipoAcomodacionEntity proveedorEntity) {
        this.id_tipo_acomodacion = proveedorEntity.getId_tipo_acomodacion();
        this.habitacion = proveedorEntity.getHabitacion();
        
    }
    
    public TipoAcomodacionEntity toEntity(){
        TipoAcomodacionEntity tipoAcomodacion = new TipoAcomodacionEntity();
        tipoAcomodacion.setId_tipo_acomodacion(this.id_tipo_acomodacion);
        tipoAcomodacion.setHabitacion(this.habitacion);
        
        return tipoAcomodacion;
    }
    
    public static List<TipoAcomodacionDTO> toTipoAcomodacionList(List<TipoAcomodacionEntity> tipoAcomodacionList){
        List<TipoAcomodacionDTO> listaTipoAcomodacion = new ArrayList<>();
        for (int i = 0; i < tipoAcomodacionList.size(); i++){
            listaTipoAcomodacion.add(new TipoAcomodacionDTO(tipoAcomodacionList.get(i)));
        }
        return listaTipoAcomodacion;
    }

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
