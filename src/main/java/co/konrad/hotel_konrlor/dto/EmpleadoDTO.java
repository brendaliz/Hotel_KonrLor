/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.dto;

import co.konrad.hotel_konrlor.entities.CadenaHoteleraEntity;
import co.konrad.hotel_konrlor.entities.EmpleadoEntity;
import co.konrad.hotel_konrlor.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class EmpleadoDTO {

    private Long id_empleado;
    
    private String nombre;
    
    private String apellido;
    
    private UsuarioEntity usuario;
    
    private CadenaHoteleraEntity cadena_hotelera;
    
    public EmpleadoDTO() {
    }

    public EmpleadoDTO(EmpleadoEntity empleadoEntity) {
        this.id_empleado = empleadoEntity.getId_empleado();
        this.nombre = empleadoEntity.getNombre();
        this.apellido = empleadoEntity.getApellido();
        this.usuario = empleadoEntity.getUsuario();
        this.cadena_hotelera = empleadoEntity.getCadena_hotelera();
    }
    
    public EmpleadoEntity toEntity(){
        EmpleadoEntity empleado = new EmpleadoEntity();
        empleado.setId_empleado(this.id_empleado);
        empleado.setNombre(this.nombre);
        empleado.setApellido(this.apellido);
        empleado.setUsuario(this.usuario);
        empleado.setCadena_hotelera(this.cadena_hotelera);
        return empleado;
    }
    
    public static List<EmpleadoDTO> toEmpleadoList(List<EmpleadoEntity> empleadoList){
        List<EmpleadoDTO> listaEmpleados = new ArrayList<>();
        for (int i = 0; i < empleadoList.size(); i++){
            listaEmpleados.add(new EmpleadoDTO(empleadoList.get(i)));
        }
        return listaEmpleados;
    }

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public CadenaHoteleraEntity getCadena_hotelera() {
        return cadena_hotelera;
    }

    public void setCadena_hotelera(CadenaHoteleraEntity cadena_hotelera) {
        this.cadena_hotelera = cadena_hotelera;
    }
    
    
    
}
