/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.TipoAcomodacionEntity;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Carlos
 */
@Stateful
public class TipoAcomodacionPersistence {
    
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager emTipoAcomodacion;
    
    public TipoAcomodacionEntity find(Long id_tipo_acomodacion){
        return emTipoAcomodacion.find(TipoAcomodacionEntity.class, id_tipo_acomodacion);
    }
    
    public List<TipoAcomodacionEntity> findAll() {
        Query q = emTipoAcomodacion.createQuery("select c from TipoAcomodacionEntity c");
        return q.getResultList();
    }
    
    public TipoAcomodacionEntity create(TipoAcomodacionEntity tipoAcomodacion) {
        emTipoAcomodacion.persist(tipoAcomodacion);
        return tipoAcomodacion;
    }
    
    public TipoAcomodacionEntity update(TipoAcomodacionEntity tipoAcomodacion) {
        return emTipoAcomodacion.merge(tipoAcomodacion);
    }
    public void delete(Long id_tipo_acomodacion) {
        TipoAcomodacionEntity tipoEliminar = emTipoAcomodacion.find(TipoAcomodacionEntity.class, id_tipo_acomodacion);
        emTipoAcomodacion.remove(tipoEliminar);
    }    
}
