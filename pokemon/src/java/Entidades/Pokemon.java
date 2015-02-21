/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alphyon
 */
@Entity
@Table(name = "pokemon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pokemon.findAll", query = "SELECT p FROM Pokemon p"),
    @NamedQuery(name = "Pokemon.findById", query = "SELECT p FROM Pokemon p WHERE p.id = :id"),
    @NamedQuery(name = "Pokemon.findByImge", query = "SELECT p FROM Pokemon p WHERE p.imge = :imge"),
    @NamedQuery(name = "Pokemon.findByNombre", query = "SELECT p FROM Pokemon p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pokemon.findByRegion", query = "SELECT p FROM Pokemon p WHERE p.region = :region"),
    @NamedQuery(name = "Pokemon.findByTipo", query = "SELECT p FROM Pokemon p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Pokemon.findByCapturado", query = "SELECT p FROM Pokemon p WHERE p.capturado = :capturado"),
    @NamedQuery(name = "Pokemon.findByNivel", query = "SELECT p FROM Pokemon p WHERE p.nivel = :nivel")})
public class Pokemon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "imge")
    private String imge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "region")
    private String region;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "capturado")
    @Temporal(TemporalType.DATE)
    private Date capturado;
    @Column(name = "nivel")
    private Integer nivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pokemon")
    private List<Equipo> equipoList;

    public Pokemon() {
    }

    public Pokemon(Integer id) {
        this.id = id;
    }

    public Pokemon(Integer id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImge() {
        return imge;
    }

    public void setImge(String imge) {
        this.imge = imge;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getCapturado() {
        return capturado;
    }

    public void setCapturado(Date capturado) {
        this.capturado = capturado;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    @XmlTransient
    public List<Equipo> getEquipoList() {
        return equipoList;
    }

    public void setEquipoList(List<Equipo> equipoList) {
        this.equipoList = equipoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pokemon)) {
            return false;
        }
        Pokemon other = (Pokemon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
}
