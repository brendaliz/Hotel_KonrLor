/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.PagoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author Carlos
 */
@Stateless
public class PagoPersistence {
    
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager emPago;
    
    public PagoEntity find(Long id_pago){
        return emPago.find(PagoEntity.class, id_pago);
    }
    
    public List<PagoEntity> findAll() {
        Query q = emPago.createQuery("select p from PagoEntity p");
        return q.getResultList();
    }
    
    public PagoEntity create(PagoEntity pago) {
        emPago.persist(pago);
        return pago;
    }
    
    public PagoEntity update(PagoEntity pago) {
        return emPago.merge(pago);
    }
    public void delete(Long id_pago) {
        PagoEntity pagoEliminar = emPago.find(PagoEntity.class, id_pago);
        emPago.remove(pagoEliminar);
    }    
}
