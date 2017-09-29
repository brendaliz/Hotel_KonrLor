/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.logic;

import co.konrad.hotel_konrlor.entities.EmpleadoEntity;
import co.konrad.hotel_konrlor.persistences.EmpleadoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Stateless
public class EmpleadoLogic {
    @Inject
    private EmpleadoPersistence empleadoPersistence;
    
    /*Metodo para encontrar todos los */
    
    public List<EmpleadoEntity> getEmpleados(){
        List<EmpleadoEntity>empleados = empleadoPersistence.findAll();
        return empleados;
    }
    /*Obtener un objeto de la tabla 
        @Param id
        @return empleado*/
    public EmpleadoEntity getEmpleado(Long id_empleado){
        EmpleadoEntity empleado = empleadoPersistence.find(id_empleado);
        if(empleado == null){
            throw new IllegalArgumentException("El empleado solicitado no existe");
        }
        return empleado;
    }
    
    public EmpleadoEntity createEmpleado(EmpleadoEntity empleado){
        empleadoPersistence.create(empleado);
        return empleado;
    }
    
    /* ACTUALIZACION OBJETO EMPLEADO*/
    
    public EmpleadoEntity updateEmpleado(Long id_empleado, EmpleadoEntity empleado){
        EmpleadoEntity empleadoEntity = empleadoPersistence.update(empleado);
        return empleadoEntity;
    }
    /*
    Eliminar un objeto empleado
    @param id
    */
    public void deleteEmpleado (Long id_empleado){
        empleadoPersistence.delete(id_empleado);
    }
}
