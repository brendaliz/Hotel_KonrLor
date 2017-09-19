/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.PagoCreditoEntity;
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
public class PagoCreditoPersistence {
    
    @PersistenceContext(unitName = "Hotel_KonLonrPU")

    protected EntityManager emPagoCredito;
    
    public PagoCreditoEntity find(Long id_num_tarjeta){
        return emPagoCredito.find(PagoCreditoEntity.class, id_num_tarjeta);
    }
    
    public List<PagoCreditoEntity> findAll() {
        Query q = emPagoCredito.createQuery("select p from PagoCreditoEntity p");
        return q.getResultList();
    }
    
    public PagoCreditoEntity create(PagoCreditoEntity pagoCredito) {
        emPagoCredito.persist(pagoCredito);
        return pagoCredito;
    }
    
    public PagoCreditoEntity update(PagoCreditoEntity pagoCredito) {
        return emPagoCredito.merge(pagoCredito);
    }
    public void delete(Long id_num_tarjeta) {
        PagoCreditoEntity pagoCreditoEliminar = emPagoCredito.find(PagoCreditoEntity.class, id_num_tarjeta);
        emPagoCredito.remove(pagoCreditoEliminar);
    }    
}
