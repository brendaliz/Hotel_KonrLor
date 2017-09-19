/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.dto;

import co.konrad.hotel_konrlor.entities.PagoCreditoEntity;
import co.konrad.hotel_konrlor.entities.PagoEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class PagoCreditoDTO {

    private Long id_num_tarjeta;
    
    private String nombre_franquicia;
    
    private Date fechaVencimiento;
    
    private PagoEntity tipo_pago;
    
    private int cod_clave;
    
    public PagoCreditoDTO() {
    }

    public PagoCreditoDTO(PagoCreditoEntity pagoCreditoEntity) {
        this.id_num_tarjeta = pagoCreditoEntity.getId_num_tarjeta();
        this.nombre_franquicia = pagoCreditoEntity.getNombre_franquicia();
        this.fechaVencimiento = pagoCreditoEntity.getFechaVencimiento();
        this.tipo_pago = pagoCreditoEntity.getTipo_pago();
        this.cod_clave = pagoCreditoEntity.getCod_clave();
    }
    
    public PagoCreditoEntity toEntity(){
        PagoCreditoEntity pagoCredito = new PagoCreditoEntity();
        pagoCredito.setId_num_tarjeta(this.id_num_tarjeta);
        pagoCredito.setNombre_franquicia(this.nombre_franquicia);
        pagoCredito.setFechaVencimiento(this.fechaVencimiento);
        pagoCredito.setTipo_pago(this.tipo_pago);
        pagoCredito.setCod_clave(this.cod_clave);
        return pagoCredito;
    }
    
    public static List<PagoCreditoDTO> toPagoCreditoList(List<PagoCreditoEntity> pagoCreditoList){
        List<PagoCreditoDTO> listaPagosCredito = new ArrayList<>();
        for (int i = 0; i < pagoCreditoList.size(); i++){
            listaPagosCredito.add(new PagoCreditoDTO(pagoCreditoList.get(i)));
        }
        return listaPagosCredito;
    }

    public Long getId_num_tarjeta() {
        return id_num_tarjeta;
    }

    public void setId_num_tarjeta(Long id_num_tarjeta) {
        this.id_num_tarjeta = id_num_tarjeta;
    }

    public String getNombre_franquicia() {
        return nombre_franquicia;
    }

    public void setNombre_franquicia(String nombre_franquicia) {
        this.nombre_franquicia = nombre_franquicia;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public PagoEntity getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(PagoEntity tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public int getCod_clave() {
        return cod_clave;
    }

    public void setCod_clave(int cod_clave) {
        this.cod_clave = cod_clave;
    }
    
    
}
