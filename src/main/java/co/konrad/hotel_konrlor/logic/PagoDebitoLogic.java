/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.logic;

import co.konrad.hotel_konrlor.entities.PagoDebitoEntity;
import co.konrad.hotel_konrlor.persistences.PagoDebitoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Stateless
public class PagoDebitoLogic {
    @Inject
    private PagoDebitoPersistence pagoDebitoPersistence;
    
        /*Metodo para encontrar todos los */
    
    public List<PagoDebitoEntity> getPagosDebito(){
        List<PagoDebitoEntity>pagosDebito = pagoDebitoPersistence.findAll();
        return pagosDebito;
    }
    /*Obtener un objeto de la tabla 
        @Param id
        @return pagoDebito*/
    public PagoDebitoEntity getPagoDebito(Long id){
        PagoDebitoEntity pagoDebito = pagoDebitoPersistence.find(id);
        if(pagoDebito == null){
            throw new IllegalArgumentException("El pago en debito solicitado no existe");
        }
        return pagoDebito;
    }
    
    public PagoDebitoEntity createPagoDebito(PagoDebitoEntity pagoDebito){
        pagoDebitoPersistence.create(pagoDebito);
        return pagoDebito;
    }
    
    /* ACTUALIZACION OBJETO PAGO_DEBITO*/
    
    public PagoDebitoEntity updatePagoDebito(Long id, PagoDebitoEntity pagoDebito){
        PagoDebitoEntity pagoDebitoEntity = pagoDebitoPersistence.update(pagoDebito);
        return pagoDebitoEntity;
    }
    /*
    Eliminar un objeto pagoDebito
    @param id
    */
    public void deletePagoDebito (Long id){
        pagoDebitoPersistence.delete(id);
    }
}
