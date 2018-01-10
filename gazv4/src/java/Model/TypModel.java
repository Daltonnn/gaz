/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "typ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypModel.findAll", query = "SELECT t FROM TypModel t")
    , @NamedQuery(name = "TypModel.findByIdTyp", query = "SELECT t FROM TypModel t WHERE t.idTyp = :idTyp")
    , @NamedQuery(name = "TypModel.findByNazwa", query = "SELECT t FROM TypModel t WHERE t.nazwa = :nazwa")})
public class TypModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_typ")
    private Integer idTyp;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;
    @OneToMany(mappedBy = "typ")
    private Collection<UzytkownikModel> uzytkownikModelCollection;

    public TypModel() {
    }

    public TypModel(Integer idTyp) {
        this.idTyp = idTyp;
    }

    public TypModel(Integer idTyp, String nazwa) {
        this.idTyp = idTyp;
        this.nazwa = nazwa;
    }

    public Integer getIdTyp() {
        return idTyp;
    }

    public void setIdTyp(Integer idTyp) {
        this.idTyp = idTyp;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
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
        hash += (idTyp != null ? idTyp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypModel)) {
            return false;
        }
        TypModel other = (TypModel) object;
        if ((this.idTyp == null && other.idTyp != null) || (this.idTyp != null && !this.idTyp.equals(other.idTyp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TypModel[ idTyp=" + idTyp + " ]";
    }
    
}
