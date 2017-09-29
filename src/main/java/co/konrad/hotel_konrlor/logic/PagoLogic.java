/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.logic;

import co.konrad.hotel_konrlor.entities.PagoEntity;
import co.konrad.hotel_konrlor.persistences.PagoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Stateless
public class PagoLogic {
    @Inject
    private PagoPersistence pagoPersistence;
    
        /*Metodo para encontrar todos los */
    
    public List<PagoEntity> getPagos(){
        List<PagoEntity>pagos = pagoPersistence.findAll();
        return pagos;
    }
    /*Obtener un objeto de la tabla 
        @Param id
        @return pago*/
    public PagoEntity getPago(Long id_pago){
        PagoEntity pago = pagoPersistence.find(id_pago);
        if(pago == null){
            throw new IllegalArgumentException("El pago solicitado no existe");
        }
        return pago;
    }
    
    public PagoEntity createPago(PagoEntity pago){
        pagoPersistence.create(pago);
        return pago;
    }
    
    /* ACTUALIZACION OBJETO PAGO*/
    
    public PagoEntity updatePago(Long id_pago, PagoEntity pago){
        PagoEntity pagoEntity = pagoPersistence.update(pago);
        return pagoEntity;
    }
    /*
    Eliminar un objeto pago
    @param id
    */
    public void deletePago (Long id_pago){
        pagoPersistence.delete(id_pago);
    }    
}
