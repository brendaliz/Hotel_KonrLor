/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.dto;

import co.konrad.hotel_konrlor.entities.PagoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class PagoDTO {
    
    private Long id_pago;
    
    private String tipo_pago;

    public PagoDTO() {
    }

    public PagoDTO(PagoEntity pagoEntity) {
        this.id_pago = pagoEntity.getId_pago();
        this.tipo_pago = pagoEntity.getTipo_pago();
    }
    
    public PagoEntity toEntity(){
        PagoEntity pago = new PagoEntity();
        pago.setId_pago(this.id_pago);
        pago.setTipo_pago(this.tipo_pago);
        return pago;
    }

    public static List<PagoDTO> toPagoList(List<PagoEntity> pagoList){
        List<PagoDTO> listaPagos = new ArrayList<>();
        for (int i = 0; i < pagoList.size(); i++){
            listaPagos.add(new PagoDTO(pagoList.get(i)));
        }
        return listaPagos;
    }
    
    public Long getId_pago() {
        return id_pago;
    }

    public void setId_pago(Long id_pago) {
        this.id_pago = id_pago;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }   
    
}
