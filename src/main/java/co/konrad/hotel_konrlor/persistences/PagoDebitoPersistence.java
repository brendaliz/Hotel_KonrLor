/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.PagoDebitoEntity;
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
public class PagoDebitoPersistence {
    
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
<<<<<<< HEAD
    protected EntityManager emPagoDebito;
    
    public PagoDebitoEntity find(Long id_num_cuenta){
        return emPagoDebito.find(PagoDebitoEntity.class, id_num_cuenta);
=======
    protected EntityManager em;
    
    public PagoDebitoEntity find(Long id_num_tarjeta){
        return em.find(PagoDebitoEntity.class, id_num_tarjeta);
>>>>>>> 2666d0ace00d7f0888d6f4ee49deb7ea9f3135d5
    }
    
    public List<PagoDebitoEntity> findAll() {
        Query q = emPagoDebito.createQuery("select p from PagoDebitoEntity p");
        return q.getResultList();
    }
    
    public PagoDebitoEntity create(PagoDebitoEntity pagoDebito) {
        emPagoDebito.persist(pagoDebito);
        return pagoDebito;
    }
    
    public PagoDebitoEntity update(PagoDebitoEntity pagoDebito) {
        return emPagoDebito.merge(pagoDebito);
    }
    public void delete(Long id_num_cuenta) {
        PagoDebitoEntity pagoDebitoEliminar = emPagoDebito.find(PagoDebitoEntity.class, id_num_cuenta);
        emPagoDebito.remove(pagoDebitoEliminar);
    }    
}

