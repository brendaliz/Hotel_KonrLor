/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.dto;

import co.konrad.hotel_konrlor.entities.ClienteEntity;
import co.konrad.hotel_konrlor.entities.EmpleadoEntity;
import co.konrad.hotel_konrlor.entities.HotelEntity;
import co.konrad.hotel_konrlor.entities.PagoEntity;
import co.konrad.hotel_konrlor.entities.ReservaEntity;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brend
 */
public class ReservaDTO {

    private Long id_reserva;
    private Date fechaEntrada;
    private Date fechaSalida;
    private int valor_reserva;
    private HotelEntity hotel;
    //private EmpleadoEntity empleado;
    private ClienteEntity cliente;
    private PagoEntity tipo_pago;

    public ReservaDTO() {
    }

    public ReservaDTO(ReservaEntity reservaEntity) {
        this.id_reserva = reservaEntity.getId_reserva();
        this.fechaEntrada = reservaEntity.getFechaEntrada();
        this.fechaSalida = reservaEntity.getFechaSalida();
        this.valor_reserva = reservaEntity.getValor_reserva();
        this.hotel = reservaEntity.getHotel();
        //this.empleado = reservaEntity.getEmpleado();
        this.cliente = reservaEntity.getCliente();
        this.tipo_pago = reservaEntity.getTipo_pago();

    }

    public ReservaEntity toEntity() {
        ReservaEntity reserva = new ReservaEntity();
        reserva.setId_reserva(this.id_reserva);
        reserva.setFechaEntrada(this.fechaEntrada);
        reserva.setFechaSalida(this.fechaSalida);
        reserva.setValor_reserva(this.valor_reserva);
        reserva.setHotel(this.hotel);
        //reserva.setEmpleado(this.empleado);
        reserva.setCliente(this.cliente);
        reserva.setTipo_pago(this.tipo_pago);

        return reserva;
    }

    public static List<ReservaDTO> toReservaList(List<ReservaEntity> reservaList) {
        List<ReservaDTO> listaReservas = new ArrayList<>();
        for (int i = 0; i < reservaList.size(); i++) {
            listaReservas.add(new ReservaDTO(reservaList.get(i)));
        }
        return listaReservas;
    }

    public Long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Long id_reserva) {
        this.id_reserva = id_reserva;
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

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    /*public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }*/

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public PagoEntity getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(PagoEntity tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

}
