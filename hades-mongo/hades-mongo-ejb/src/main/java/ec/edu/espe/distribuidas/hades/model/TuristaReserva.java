/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.hades.model;

import java.math.BigDecimal;
import java.util.Date;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author user
 */
@Embedded
public class TuristaReserva {
    
    private String tipoIdentificacion;
    private String identificacion;
    private String nombre;
    private Date fechaNacimiento;
    private BigDecimal pesoMaleta;
    @Reference
    private Reserva Reserva;
   
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public BigDecimal getPesoMaleta() {
        return pesoMaleta;
    }

    public void setPesoMaleta(BigDecimal pesoMaleta) {
        this.pesoMaleta = pesoMaleta;
    }

    public Reserva getReserva() {
        return Reserva;
    }

    public void setReserva(Reserva Reserva) {
        this.Reserva = Reserva;
    }
       
}
