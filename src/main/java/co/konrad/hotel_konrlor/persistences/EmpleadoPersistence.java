/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.persistences;

import co.konrad.hotel_konrlor.entities.EmpleadoEntity;
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
public class EmpleadoPersistence {
    
    @PersistenceContext(unitName = "Hotel_KonLonrPU")
    protected EntityManager emEmpleado;
    
    public EmpleadoEntity find(Long id_empleado){
        return emEmpleado.find(EmpleadoEntity.class, id_empleado);
    }
    
    public List<EmpleadoEntity> findAll() {
        Query q = emEmpleado.createQuery("select u from EmpleadoEntity u");
        return q.getResultList();
    }
    
    public EmpleadoEntity create(EmpleadoEntity empleado) {
        emEmpleado.persist(empleado);
        return empleado;
    }
    
    public EmpleadoEntity update(EmpleadoEntity empleado) {
        return emEmpleado.merge(empleado);
    }
    public void delete(Long id_empleado) {
        EmpleadoEntity empleadoEliminar = emEmpleado.find(EmpleadoEntity.class, id_empleado);
        emEmpleado.remove(empleadoEliminar);
    }
}
