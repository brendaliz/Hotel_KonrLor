/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.dto;

import co.konrad.hotel_konrlor.entities.ClienteEntity;
import co.konrad.hotel_konrlor.entities.PagoEntity;
import co.konrad.hotel_konrlor.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Carlos
 */
public class ClienteDTO {
    private Long id_cliente;
    
    private String nombre;
    
    private String apellido;
    
    private int documento;
    
    private String direccion;
    
    private Date fechaNacimiento;
    
    private String pais;
    
    private String ciudad;
    
    private int telefono;
    
    private int celular;
    
    private PagoEntity tipo_pago;
    
    private UsuarioEntity usuario;

    public ClienteDTO() {
    }
    
    public ClienteDTO(ClienteEntity clienteEntity) {
        this.id_cliente = clienteEntity.getId_cliente();
        this.nombre = clienteEntity.getNombre();
        this.apellido = clienteEntity.getApellido();
        this.documento = clienteEntity.getDocumento();
        this.direccion = clienteEntity.getDireccion();
        this.fechaNacimiento = clienteEntity.getFechaNacimiento();
        this.pais = clienteEntity.getPais();
        this.ciudad = clienteEntity.getCiudad();
        this.telefono = clienteEntity.getTelefono();
        this.celular = clienteEntity.getCelular();
        this.tipo_pago = clienteEntity.getTipo_pago();
        this.usuario = clienteEntity.getUsuario();
    }
    
    public ClienteEntity toEntity(){
        ClienteEntity cliente = new ClienteEntity();
        cliente.setId_cliente(this.id_cliente);
        cliente.setNombre(this.nombre);
        cliente.setApellido(this.apellido);
        cliente.setDocumento(this.documento);
        cliente.setDireccion(this.direccion);
        cliente.setFechaNacimiento(this.fechaNacimiento);
        cliente.setPais(this.pais);
        cliente.setCiudad(this.ciudad);
        cliente.setTelefono(this.telefono);
        cliente.setCelular(this.celular);
        cliente.setTipo_pago(this.tipo_pago);
        cliente.setUsuario(this.usuario);
        return cliente;
    }
    
    public static List<ClienteDTO> toClienteList(List<ClienteEntity> clienteList){
        List<ClienteDTO> listaClientes = new ArrayList<>();
        for (int i = 0; i < clienteList.size(); i++){
            listaClientes.add(new ClienteDTO(clienteList.get(i)));
        }
        return listaClientes;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
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

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public PagoEntity getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(PagoEntity tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    
    
}
