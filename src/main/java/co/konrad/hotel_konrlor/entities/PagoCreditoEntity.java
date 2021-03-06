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
public class PagoCreditoEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="num_tarjeta")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_num_tarjeta;
    
    @Column(name = "nombre_franquicia", nullable = false)
    private String nombre_franquicia;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;
    
    @ManyToOne
    @JoinColumn (name = "tipo_pago")
    private PagoEntity tipo_pago;
    
    @Column(name = "cod_clave")
    private int cod_clave;

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
