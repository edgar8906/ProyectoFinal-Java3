package com.edgarmor.proyectofinaljava3;
/**
 *
 * @author edgar
 */
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Proveedores")
public class Proveedores implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProv")
    private Integer idProv;
    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "nomProv")
    private String nomProv;

    public Proveedores() {
    }

    public Proveedores(Integer idProv) {
        this.idProv = idProv;
    }

    public Proveedores(Integer idProv, String nomProv) {
        this.idProv = idProv;
        this.nomProv = nomProv;
    }

    public Proveedores(String nomProv) {
        this.nomProv = nomProv;
    }

    public Integer getIdProv() {
        return idProv;
    }

    public void setIdProv(Integer idProv) {
        this.idProv = idProv;
    }

    public String getNomProv() {
        return nomProv;
    }

    public void setNomProv(String nomProv) {
        this.nomProv = nomProv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProv != null ? idProv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.idProv == null && other.idProv != null) || (this.idProv != null && !this.idProv.equals(other.idProv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edgarmor.proyectofinaljava3.Proveedores[ idProv=" + idProv + " ]";
    }
    
}
