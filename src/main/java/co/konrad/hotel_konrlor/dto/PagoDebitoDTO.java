/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.dto;

import co.konrad.hotel_konrlor.entities.PagoDebitoEntity;
import co.konrad.hotel_konrlor.entities.PagoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class PagoDebitoDTO {
    
    private Long id_num_cuenta;
    
    private String nombre_banco;
    
    private PagoEntity tipo_pago;

    public PagoDebitoDTO() {
    }

    public PagoDebitoDTO(PagoDebitoEntity pagoDebitoEntity) {
        this.id_num_cuenta = pagoDebitoEntity.getId_num_cuenta();
        this.nombre_banco = pagoDebitoEntity.getNombre_banco();
        this.tipo_pago = pagoDebitoEntity.getTipo_pago();
    }
    
    public PagoDebitoEntity toEntity(){
        PagoDebitoEntity pagoDebito = new PagoDebitoEntity();
        pagoDebito.setId_num_cuenta(this.id_num_cuenta);
        pagoDebito.setNombre_banco(this.nombre_banco);
        pagoDebito.setTipo_pago(this.tipo_pago);
        return pagoDebito;
    }

    public static List<PagoDebitoDTO> toPagoDebitoList(List<PagoDebitoEntity> pagoDebitoList){
        List<PagoDebitoDTO> listaPagosDebito = new ArrayList<>();
        for (int i = 0; i < pagoDebitoList.size(); i++){
            listaPagosDebito.add(new PagoDebitoDTO(pagoDebitoList.get(i)));
        }
        return listaPagosDebito;
    }
    public Long getId_num_cuenta() {
        return id_num_cuenta;
    }

    public void setId_num_cuenta(Long id_num_cuenta) {
        this.id_num_cuenta = id_num_cuenta;
    }

    public String getNombre_banco() {
        return nombre_banco;
    }

    public void setNombre_banco(String nombre_banco) {
        this.nombre_banco = nombre_banco;
    }

    public PagoEntity getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(PagoEntity tipo_pago) {
        this.tipo_pago = tipo_pago;
    }
    
    
}
