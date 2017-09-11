/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author brend
 */
@Entity
public class ReservaEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_reserva")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_entrada")
    private Date fechaEntrada;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_salida")
    private Date fechaSalida;
    
    private int valor_reserva;
    
    @ManyToOne
    @JoinColumn (name = "id_hotel")
    private HotelEntity hotel;
    
    @ManyToOne
    @JoinColumn (name = "id_empleado")
    private EmpleadoEntity empleado;
    
    @ManyToOne
    @JoinColumn (name = "id_cliente")
    private ClienteEntity cliente;
    
    @ManyToOne
    @JoinColumn (name = "tipo_pago")
    private PagoEntity tipo_pago;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getValor_reserva() {
        return valor_reserva;
    }

    public void setValor_reserva(int valor_reserva) {
        this.valor_reserva = valor_reserva;
    }

    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }

    public PagoEntity getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(PagoEntity tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
    
    
    
    
    
    
}
