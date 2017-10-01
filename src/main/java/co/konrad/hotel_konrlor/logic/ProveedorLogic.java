/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.logic;

import co.konrad.hotel_konrlor.entities.ProveedorEntity;
import co.konrad.hotel_konrlor.persistences.ProveedorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Stateless
public class ProveedorLogic {
    @Inject
    private ProveedorPersistence proveedorPersistence;

        /*Metodo para encontrar todos los */
    
    public List<ProveedorEntity> getProveedores(){
        List<ProveedorEntity>proveedores = proveedorPersistence.findAll();
        return proveedores;
    }
    /*Obtener un objeto de la tabla 
        @Param id
        @return proveedor*/
    public ProveedorEntity getProveedor(Long id_proveedor){
        ProveedorEntity proveedor = proveedorPersistence.find(id_proveedor);
        if(proveedor == null){
            throw new IllegalArgumentException("El proveedor solicitado no existe");
        }
        return proveedor;
    }
    
    public ProveedorEntity createProveedor(ProveedorEntity proveedor){
        proveedorPersistence.create(proveedor);
        return proveedor;
    }
    
    /* ACTUALIZACION OBJETO PROVEEDOR*/
    
    public ProveedorEntity updateProveedor(Long id_pago, ProveedorEntity proveedor){
        ProveedorEntity proveedorEntity = proveedorPersistence.update(proveedor);
        return proveedorEntity;
    }
    /*
    Eliminar un objeto proveedor
    @param id
    */
    public void deleteProveedor (Long id_proveedor){
        proveedorPersistence.delete(id_proveedor);
    }    
}
