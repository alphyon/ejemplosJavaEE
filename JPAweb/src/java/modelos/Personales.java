/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alphyon
 */
@Entity
@Table(name = "personales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personales.findAll", query = "SELECT p FROM Personales p"),
    @NamedQuery(name = "Personales.findById", query = "SELECT p FROM Personales p WHERE p.id = :id"),
    @NamedQuery(name = "Personales.findByNombre", query = "SELECT p FROM Personales p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Personales.findByApellidos", query = "SELECT p FROM Personales p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Personales.findByFnacimiento", query = "SELECT p FROM Personales p WHERE p.fnacimiento = :fnacimiento"),
    @NamedQuery(name = "Personales.findByEstado", query = "SELECT p FROM Personales p WHERE p.estado = :estado")})
public class Personales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "fnacimiento")
    @Temporal(TemporalType.DATE)
    private Date fnacimiento;
    @Column(name = "estado")
    private Short estado;

    public Personales() {
    }

    public Personales(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personales)) {
            return false;
        }
        Personales other = (Personales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Personales[ id=" + id + " ]";
    }
    
}
