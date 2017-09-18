/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author brend
 */
@Entity
public class PagoDebitoEntity implements Serializable{
    
     private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="num_cuenta")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_num_cuenta;
    
    @Column(name = "nombre_banco", nullable = false)
    private String nombre_banco;
     
    @ManyToOne
    @JoinColumn (name = "tipo_pago")
    private PagoEntity tipo_pago;

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
