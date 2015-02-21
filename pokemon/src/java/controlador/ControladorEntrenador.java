/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Entidades.Entrenador;
import daos.EntrenadorFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alphyon
 */
@ManagedBean
@RequestScoped
public class ControladorEntrenador implements Serializable{
    private Entrenador entrenador;
    private List<Entrenador> entrenadores;    
    @EJB
    EntrenadorFacade entrenadorf;    
    private String accion;
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }    
    
  
    public ControladorEntrenador() {
        
    }    
    
    public Entrenador EntrenadordoActual(){
        if(entrenador == null){
            entrenador = new Entrenador();
        }
        return entrenador;
    }
    
    private EntrenadorFacade getFachada(){
        return entrenadorf;
    }  
    
    public int contar(){
        return  getFachada().count();
    }
    
    public String prepararListado(){
        entrenadores = getFachada().findAll();
        return "lista";
    }
    
    public String prepararVista(int id){
        entrenador =getFachada().find(id);
        return "vista";
    }
    
    public String prepararCrear(){
        entrenador = new Entrenador();
        return "crear";
    }
    
    public String prepararEditar(int id){
        entrenador = getFachada().find(id);
        return "editar";
    }
    public String prepararBorrado(int id){
        entrenador = getFachada().find(id);
        setAccion("borrar");
        return "vista";
    }
    
    public List<Entrenador> entrenadoresDatos(){
         entrenadores =getFachada().findAll();
        return entrenadores;
    }
    
    public String borrando(int id){
        entrenador = getFachada().find(id);
        borrado();
        return prepararListado();
    }
    public String crear(){
        try {
            getFachada().create(entrenador);
            JsfUtil.agregarMensajeExito("Entrenador Creado :]");
            return prepararCrear();
        } catch (Exception e) {
            JsfUtil.agregarMensageDeError(e,"Error al Crear Entrenador :[");
            return null;
        }
    }
    
    public String editar(){
        try {
            getFachada().edit(entrenador);
            JsfUtil.agregarMensajeExito("Exito al editar");
            return "vista";
        } catch (Exception e) {
            JsfUtil.agregarMensageDeError(e,"Error al Editar Entrenador :[");
            return null;
        }
    }
    
    private void borrado() {
        try {
            getFachada().remove(entrenador);
            JsfUtil.agregarMensajeExito("Exito al borrar");
            
        } catch (Exception e) {
            JsfUtil.agregarMensageDeError(e,"Error al borrar Entrenador :[");
           
        }
    }   

    public List<Entrenador> getDatosEntrenador() {
        if(entrenadores == null){
            entrenadores = getFachada().findAll();
        }
        
        return entrenadores;
    }
    
    
   

    
    
}
