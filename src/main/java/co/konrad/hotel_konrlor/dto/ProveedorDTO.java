/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.dto;

import co.konrad.hotel_konrlor.entities.ProveedorEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author brend
 */
public class ProveedorDTO {
    
    private Long id_proveedor;
    private String nombre;
    
     public ProveedorDTO() {
    }
     
     public ProveedorDTO(ProveedorEntity proveedorEntity) {
        this.id_proveedor = proveedorEntity.getId_proveedor();
        this.nombre = proveedorEntity.getNombre();
        
    }
    
    public ProveedorEntity toEntity(){
        ProveedorEntity proveedor = new ProveedorEntity();
        proveedor.setId_proveedor(this.id_proveedor);
        proveedor.setNombre(this.nombre);
        
        return proveedor;
    }
    
    public static List<ProveedorDTO> toProveedorList(List<ProveedorEntity> proveedorList){
        List<ProveedorDTO> listaProveedores = new ArrayList<>();
        for (int i = 0; i < proveedorList.size(); i++){
            listaProveedores.add(new ProveedorDTO(proveedorList.get(i)));
        }
        return listaProveedores;
    }

    public Long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Long id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
   
}
