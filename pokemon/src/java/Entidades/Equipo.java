/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alphyon
 */
@Entity
@Table(name = "equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByFechaagregado", query = "SELECT e FROM Equipo e WHERE e.fechaagregado = :fechaagregado"),
    @NamedQuery(name = "Equipo.findByPokemonId", query = "SELECT e FROM Equipo e WHERE e.equipoPK.pokemonId = :pokemonId"),
    @NamedQuery(name = "Equipo.findByEntrenadorId", query = "SELECT e FROM Equipo e WHERE e.equipoPK.entrenadorId = :entrenadorId")})
public class Equipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquipoPK equipoPK;
    @Column(name = "fechaagregado")
    @Temporal(TemporalType.DATE)
    private Date fechaagregado;
    @JoinColumn(name = "pokemon_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pokemon pokemon;
    @JoinColumn(name = "entrenador_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Entrenador entrenador;

    public Equipo() {
    }

    public Equipo(EquipoPK equipoPK) {
        this.equipoPK = equipoPK;
    }

    public Equipo(int pokemonId, int entrenadorId) {
        this.equipoPK = new EquipoPK(pokemonId, entrenadorId);
    }

    public EquipoPK getEquipoPK() {
        return equipoPK;
    }

    public void setEquipoPK(EquipoPK equipoPK) {
        this.equipoPK = equipoPK;
    }

    public Date getFechaagregado() {
        return fechaagregado;
    }

    public void setFechaagregado(Date fechaagregado) {
        this.fechaagregado = fechaagregado;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipoPK != null ? equipoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.equipoPK == null && other.equipoPK != null) || (this.equipoPK != null && !this.equipoPK.equals(other.equipoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Equipo[ equipoPK=" + equipoPK + " ]";
    }
    
}
