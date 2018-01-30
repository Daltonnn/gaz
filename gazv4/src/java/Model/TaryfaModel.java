/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "taryfa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaryfaModel.findAll", query = "SELECT t FROM TaryfaModel t")
    , @NamedQuery(name = "TaryfaModel.findByIdTaryfa", query = "SELECT t FROM TaryfaModel t WHERE t.idTaryfa = :idTaryfa")
    , @NamedQuery(name = "TaryfaModel.findByNazwa", query = "SELECT t FROM TaryfaModel t WHERE t.nazwa = :nazwa")
    , @NamedQuery(name = "TaryfaModel.findByCenaJed", query = "SELECT t FROM TaryfaModel t WHERE t.cenaJed = :cenaJed")
    , @NamedQuery(name = "TaryfaModel.findByCenaLicz", query = "SELECT t FROM TaryfaModel t WHERE t.cenaLicz = :cenaLicz")})
public class TaryfaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_taryfa")
    private Integer idTaryfa;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "cena_jed")
    private BigDecimal cenaJed;
    @Basic(optional = false)
    @Column(name = "cena_licz")
    private BigDecimal cenaLicz;
    @OneToMany(mappedBy = "taryfa")
    private Collection<UzytkownikModel> uzytkownikModelCollection;

    public TaryfaModel() {
    }

    public TaryfaModel(Integer idTaryfa) {
        this.idTaryfa = idTaryfa;
    }
    
    public TaryfaModel(String nazwa, BigDecimal cenaJed, BigDecimal cenaLicz) {       
        this.nazwa = nazwa;
        this.cenaJed = cenaJed;
        this.cenaLicz = cenaLicz;
    }

    public TaryfaModel(Integer idTaryfa, String nazwa, BigDecimal cenaJed, BigDecimal cenaLicz) {
        this.idTaryfa = idTaryfa;
        this.nazwa = nazwa;
        this.cenaJed = cenaJed;
        this.cenaLicz = cenaLicz;
    }

    public Integer getIdTaryfa() {
        return idTaryfa;
    }

    public void setIdTaryfa(Integer idTaryfa) {
        this.idTaryfa = idTaryfa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public BigDecimal getCenaJed() {
        return cenaJed;
    }

    public void setCenaJed(BigDecimal cenaJed) {
        this.cenaJed = cenaJed;
    }

    public BigDecimal getCenaLicz() {
        return cenaLicz;
    }

    public void setCenaLicz(BigDecimal cenaLicz) {
        this.cenaLicz = cenaLicz;
    }

    @XmlTransient
    public Collection<UzytkownikModel> getUzytkownikModelCollection() {
        return uzytkownikModelCollection;
    }

    public void setUzytkownikModelCollection(Collection<UzytkownikModel> uzytkownikModelCollection) {
        this.uzytkownikModelCollection = uzytkownikModelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTaryfa != null ? idTaryfa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaryfaModel)) {
            return false;
        }
        TaryfaModel other = (TaryfaModel) object;
        if ((this.idTaryfa == null && other.idTaryfa != null) || (this.idTaryfa != null && !this.idTaryfa.equals(other.idTaryfa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TaryfaModel[ idTaryfa=" + idTaryfa + " ]";
    }
        
}
