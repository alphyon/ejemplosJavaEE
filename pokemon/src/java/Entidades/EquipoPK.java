/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author alphyon
 */
@Embeddable
public class EquipoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "pokemon_id")
    private int pokemonId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entrenador_id")
    private int entrenadorId;

    public EquipoPK() {
    }

    public EquipoPK(int pokemonId, int entrenadorId) {
        this.pokemonId = pokemonId;
        this.entrenadorId = entrenadorId;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public int getEntrenadorId() {
        return entrenadorId;
    }

    public void setEntrenadorId(int entrenadorId) {
        this.entrenadorId = entrenadorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pokemonId;
        hash += (int) entrenadorId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoPK)) {
            return false;
        }
        EquipoPK other = (EquipoPK) object;
        if (this.pokemonId != other.pokemonId) {
            return false;
        }
        if (this.entrenadorId != other.entrenadorId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.EquipoPK[ pokemonId=" + pokemonId + ", entrenadorId=" + entrenadorId + " ]";
    }
    
}
