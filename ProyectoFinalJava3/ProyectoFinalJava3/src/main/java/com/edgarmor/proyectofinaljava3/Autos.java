package com.edgarmor.proyectofinaljava3;
/**
 *
 * @author edgar
 */
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Autos")
public class Autos implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAuto")
    private Integer idAuto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nomAuto")
    private String nomAuto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private float costo;
    @JoinColumn(name = "idAgencia", referencedColumnName = "idAgencia")
    @ManyToOne
    private Agencia idAgencia;
    @JoinColumn(name = "idProv", referencedColumnName = "idProv")
    @ManyToOne
    private Proveedores idProv;

    public Autos() {
    }

    public Autos(Integer idAuto) {
        this.idAuto = idAuto;
    }

    public Autos(Integer idAuto, String nomAuto) {
        this.idAuto = idAuto;
        this.nomAuto = nomAuto;
    }
    
    public Autos(Integer idAuto, String nomAuto, float costo) {
        this.idAuto = idAuto;
        this.nomAuto = nomAuto;
        this.costo = costo;
    }

    public Autos(Integer idAuto, String nomAuto, float costo, Agencia idAgencia, Proveedores idProv) {
        this.idAuto = idAuto;
        this.nomAuto = nomAuto;
        this.costo = costo;
        this.idAgencia = idAgencia;
        this.idProv = idProv;
    }

    public Autos(String nomAuto, float costo, Agencia idAgencia, Proveedores idProv) {
        this.nomAuto = nomAuto;
        this.costo = costo;
        this.idAgencia = idAgencia;
        this.idProv = idProv;
    }
        
    public Integer getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(Integer idAuto) {
        this.idAuto = idAuto;
    }

    public String getNomAuto() {
        return nomAuto;
    }

    public void setNomAuto(String nomAuto) {
        this.nomAuto = nomAuto;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Agencia getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Agencia idAgencia) {
        this.idAgencia = idAgencia;
    }

    public Proveedores getIdProv() {
        return idProv;
    }

    public void setIdProv(Proveedores idProv) {
        this.idProv = idProv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuto != null ? idAuto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autos)) {
            return false;
        }
        Autos other = (Autos) object;
        if ((this.idAuto == null && other.idAuto != null) || (this.idAuto != null && !this.idAuto.equals(other.idAuto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edgarmor.proyectofinaljava3.Autos[ idAuto=" + idAuto + " ]";
    }
    
}
