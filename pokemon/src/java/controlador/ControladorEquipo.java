/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Entidades.Entrenador;
import Entidades.Equipo;
import Entidades.EquipoPK;
import Entidades.Pokemon;
import daos.EquipoFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alphyon
 */
@ManagedBean
@RequestScoped
public class ControladorEquipo implements Serializable{
   private Equipo equipo;
   private Pokemon pokemon;
   private Entrenador entrenador;
   
  
   
   @EJB
   EquipoFacade ejbFacadeEquipo;

    public ControladorEquipo() {
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public EquipoFacade getEjbFacadeEquipo() {
        return ejbFacadeEquipo;
    }

    public void setEjbFacadeEquipo(EquipoFacade ejbFacadeEquipo) {
        this.ejbFacadeEquipo = ejbFacadeEquipo;
    }   

   public Pokemon pokeActua(){
        if(pokemon == null){
            pokemon = new Pokemon();
        }
        return pokemon;
   }
   
    public Entrenador entreActua(){
        if(entrenador == null){
           entrenador = new Entrenador();
        }
        return entrenador;
   }
     public Equipo equiActua(){
        if(equipo == null){
           equipo = new Equipo();
           equipo.setEquipoPK(new EquipoPK());
        }
        return equipo;
   }
     
     
    
    /////////////////////////////////////////////////////////////////////////////
    public String prepararListado(){
   
    
     return "vista";
    }
    
    public String prepararCrear(){
        equipo = new Equipo();
        return "crear";
    }
    
    
    
   
    public String crear(){
        try {
           equipo.getEquipoPK().setEntrenadorId(entreActua().getId());
           equipo.getEquipoPK().setPokemonId(pokeActua().getId());
            getEjbFacadeEquipo().create(equipo);
            JsfUtil.agregarMensajeExito("Entrenador Creado :]");
            return prepararCrear();
        } catch (Exception e) {
            JsfUtil.agregarMensageDeError(e,"Error al Crear Entrenador :["+e.getMessage());
            return null;
        }
    }

   
    
   

    
    
   

    
    
}
