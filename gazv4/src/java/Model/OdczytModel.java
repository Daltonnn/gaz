/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "odczyt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdczytModel.findAll", query = "SELECT o FROM OdczytModel o")
    , @NamedQuery(name = "OdczytModel.findByIdOdczyt", query = "SELECT o FROM OdczytModel o WHERE o.idOdczyt = :idOdczyt")
    , @NamedQuery(name = "OdczytModel.findByDataOd", query = "SELECT o FROM OdczytModel o WHERE o.dataOd = :dataOd")
    , @NamedQuery(name = "OdczytModel.findByDataDo", query = "SELECT o FROM OdczytModel o WHERE o.dataDo = :dataDo")
    , @NamedQuery(name = "OdczytModel.findByWartosc", query = "SELECT o FROM OdczytModel o WHERE o.wartosc = :wartosc")})
public class OdczytModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_odczyt")
    private Integer idOdczyt;
    @Basic(optional = false)
    @Column(name = "data_od")
    @Temporal(TemporalType.DATE)
    private Date dataOd;
    @Basic(optional = false)
    @Column(name = "data_do")
    @Temporal(TemporalType.DATE)
    private Date dataDo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "wartosc")
    private BigDecimal wartosc;
    @OneToMany(mappedBy = "idOdczyt")
    private Collection<LaczModel> laczModelCollection;

    public OdczytModel() {
    }

    public OdczytModel(Integer idOdczyt) {
        this.idOdczyt = idOdczyt;
    }

    public OdczytModel(Integer idOdczyt, Date dataOd, Date dataDo, BigDecimal wartosc) {
        this.idOdczyt = idOdczyt;
        this.dataOd = dataOd;
        this.dataDo = dataDo;
        this.wartosc = wartosc;
    }

    public Integer getIdOdczyt() {
        return idOdczyt;
    }

    public void setIdOdczyt(Integer idOdczyt) {
        this.idOdczyt = idOdczyt;
    }

    public Date getDataOd() {
        return dataOd;
    }

    public void setDataOd(Date dataOd) {
        this.dataOd = dataOd;
    }

    public Date getDataDo() {
        return dataDo;
    }

    public void setDataDo(Date dataDo) {
        this.dataDo = dataDo;
    }

    public BigDecimal getWartosc() {
        return wartosc;
    }

    public void setWartosc(BigDecimal wartosc) {
        this.wartosc = wartosc;
    }

    @XmlTransient
    public Collection<LaczModel> getLaczModelCollection() {
        return laczModelCollection;
    }

    public void setLaczModelCollection(Collection<LaczModel> laczModelCollection) {
        this.laczModelCollection = laczModelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOdczyt != null ? idOdczyt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdczytModel)) {
            return false;
        }
        OdczytModel other = (OdczytModel) object;
        if ((this.idOdczyt == null && other.idOdczyt != null) || (this.idOdczyt != null && !this.idOdczyt.equals(other.idOdczyt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.OdczytModel[ idOdczyt=" + idOdczyt + " ]";
    }
    
}
