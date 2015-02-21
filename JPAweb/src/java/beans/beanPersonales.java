/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controladores.Mpersonales;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelos.Personales;

/**
 *
 * @author alphyon
 */
@ManagedBean
@RequestScoped
public class beanPersonales {

    /**
     * Creates a new instance of beanPersonales
     */
    public beanPersonales() {
//        Mpersonales mperso = new Mpersonales();
//        List<Personales> listaPersonales = mperso.consultaFullPersonales();
//        Iterator it = listaPersonales.iterator();
//        while (it.hasNext()) {
//            Personales perso = (Personales) it.next();
//            
//            
//        }
    }
    private int codigo;
    private String nombre;
    private String apellido;
    private Date fnacimiento;
    private Short estado;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public void limpiarDatos() {
        this.apellido = "";
        this.nombre = "";

        FacesMessage msg = new FacesMessage("Limpiando Datos...");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void consultarDatos() {
        Mpersonales mper = new Mpersonales();
        Personales per = mper.consultaPersonales(codigo);
        String advertencia = "";

        if (per != null) {
            this.apellido = per.getApellidos();
            this.nombre = per.getNombre();
            this.codigo = per.getId();
            this.fnacimiento = per.getFnacimiento();
            this.estado = per.getEstado();

            advertencia = "Consulatando Datos";
        } else {
            advertencia = "Datos no encontrados...";
        }

        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void guardarPersonales() {
        Mpersonales mper = new Mpersonales();

        String advertencia = "";

        if (this.apellido == null || this.apellido.equals("")) {
            advertencia += "Apellidos Necesarios...<br />";
        }

        if (this.nombre == null || this.nombre.equals("")) {
            advertencia += "Nombres Necesarios...<br />";
        }
        
        if(advertencia.equals("")){
            Personales per = new Personales();
            per.setApellidos(apellido);
            per.setNombre(nombre);
            per.setEstado(estado);
            per.setFnacimiento(fnacimiento);
            
            if(mper.guardarPersonales(per)== 1){
                advertencia = "Datos Almacenados";
            }else{
                advertencia = "Error al almacenar";
            }
        }
        
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    

}
