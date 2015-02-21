/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Entidades.Pokemon;
import daos.PokemonFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author alphyon
 */
@ManagedBean
@RequestScoped
public class ControladorPokemon implements Serializable{
    private Pokemon pokemon;
    private List<Pokemon> pokemones;    
    @EJB
    PokemonFacade pokemonf;
    
    private String accion;
    public UploadedFile archivo;
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }
    
    
    
    /**
     * Creates a new instance of ControladorPokemon
     */
    public ControladorPokemon() {
    }
    
    
    public Pokemon PokemondoActual(){
        if(pokemon == null){
            pokemon = new Pokemon();
        }
        return pokemon;
    }
    
    private PokemonFacade getFachada(){
        return pokemonf;
    }  
    
    
    public String prepararListado(){
        pokemones = getFachada().findAll();
        return "lista";
    }
    
    public String prepararVista(int id){
        pokemon =getFachada().find(id);
        return "vista";
    }
    
    public String prepararCrear(){
        pokemon = new Pokemon();
        return "crear";
    }
    
    public String prepararEditar(int id){
        pokemon = getFachada().find(id);
        return "editar";
    }
    public String prepararBorrado(int id){
        pokemon = getFachada().find(id);
        setAccion("borrar");
        return "vista";
    }
    
    public String borrando(int id){
        pokemon = getFachada().find(id);
        borrado();
        return prepararListado();
    }
    public String crear(){
        try {
            getFachada().create(pokemon);
            JsfUtil.agregarMensajeExito("Pokemon Creado :]");
            return prepararCrear();
        } catch (Exception e) {
            JsfUtil.agregarMensageDeError(e,"Error al Crear Pokemon :[");
            return null;
        }
    }
    
    public String editar(){
        try {
            getFachada().edit(pokemon);
            JsfUtil.agregarMensajeExito("Exito al editar");
            return "vista";
        } catch (Exception e) {
            JsfUtil.agregarMensageDeError(e,"Error al Editar Pokemon :[");
            return null;
        }
    }
    
    private void borrado() {
        try {
            getFachada().remove(pokemon);
            JsfUtil.agregarMensajeExito("Exito al borrar");
            
        } catch (Exception e) {
            JsfUtil.agregarMensageDeError(e,"Error al borrar Pokemon :[");
           
        }
    }
    
   

    public List<Pokemon> getDatosPokemon() {
        if(pokemones == null){
            pokemones = getFachada().findAll();
        }        
        return pokemones;
    }
    
    

    
    
}
