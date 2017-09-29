/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.dto;

import co.konrad.hotel_konrlor.entities.HotelEntity;
import co.konrad.hotel_konrlor.entities.ProveedorEntity;
import co.konrad.hotel_konrlor.entities.ProveedorPromocionHotelEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author brend
 */
public class ProveedorPromocionHotelDTO {
    
      private Long id_p_Promocion_hotel;
      private ProveedorEntity proveedor;
      private HotelEntity id_hotel;
    
     public ProveedorPromocionHotelDTO() {
    }
     
     public ProveedorPromocionHotelDTO(ProveedorPromocionHotelEntity proveedorEntity) {
        this.id_p_Promocion_hotel = proveedorEntity.getId_p_Promocion_hotel();
        this.id_hotel = proveedorEntity.getId_hotel();
        this.proveedor = proveedorEntity.getProveedor();
        
    }
    
    public ProveedorPromocionHotelEntity toEntity(){
        ProveedorPromocionHotelEntity proveedorPromocion = new ProveedorPromocionHotelEntity();
        proveedorPromocion.setId_p_Promocion_hotel(this.id_p_Promocion_hotel);
        proveedorPromocion.setId_hotel(this.id_hotel);
        proveedorPromocion.setProveedor(this.proveedor);
        
        return proveedorPromocion;
    }
    
    public static List<ProveedorPromocionHotelDTO> toProveedorPromocionList(List<ProveedorPromocionHotelEntity> proveedorPromocionList){
        List<ProveedorPromocionHotelDTO> listaProveedoresPromocion = new ArrayList<>();
        for (int i = 0; i < proveedorPromocionList.size(); i++){
            listaProveedoresPromocion.add(new ProveedorPromocionHotelDTO(proveedorPromocionList.get(i)));
        }
        return listaProveedoresPromocion;
    }

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
