/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.logic;

import co.konrad.hotel_konrlor.entities.PagoCreditoEntity;
import co.konrad.hotel_konrlor.persistences.PagoCreditoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Stateless
public class PagoCreditoLogic {
    @Inject
    private PagoCreditoPersistence pagoCreditoPersistence;
    
    /*Metodo para encontrar todos los */
    
    public List<PagoCreditoEntity> getPagosCredito(){
        List<PagoCreditoEntity>pagosCredito = pagoCreditoPersistence.findAll();
        return pagosCredito;
    }
    /*Obtener un objeto de la tabla 
        @Param id
        @return pagoCredito*/
    public PagoCreditoEntity getPagoCredito(Long id){
        PagoCreditoEntity pagoCredito = pagoCreditoPersistence.find(id);
        if(pagoCredito == null){
            throw new IllegalArgumentException("El pago en credito solicitado no existe");
        }
        return pagoCredito;
    }
    
    public PagoCreditoEntity createPagoCredito(PagoCreditoEntity pagoCredito){
        pagoCreditoPersistence.create(pagoCredito);
        return pagoCredito;
    }
    
    /* ACTUALIZACION OBJETO PAGO_CREDITO*/
    
    public PagoCreditoEntity updatePagoCredito(Long id, PagoCreditoEntity pagoCredito){
        PagoCreditoEntity pagoCreditoEntity = pagoCreditoPersistence.update(pagoCredito);
        return pagoCreditoEntity;
    }
    /*
    Eliminar un objeto pagoCredito
    @param id
    */
    public void deletePagoCredito (Long id){
        pagoCreditoPersistence.delete(id);
    }
}
