/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "lacz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LaczModel.findAll", query = "SELECT l FROM LaczModel l")
    , @NamedQuery(name = "LaczModel.findById", query = "SELECT l FROM LaczModel l WHERE l.id = :id")})
public class LaczModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_odczyt", referencedColumnName = "id_odczyt")
    @ManyToOne
    private OdczytModel idOdczyt;
    @JoinColumn(name = "id_uzytkownik", referencedColumnName = "id_uzytkownik")
    @ManyToOne
    private UzytkownikModel idUzytkownik;

    public LaczModel() {
    }

    public LaczModel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OdczytModel getIdOdczyt() {
        return idOdczyt;
    }

    public void setIdOdczyt(OdczytModel idOdczyt) {
        this.idOdczyt = idOdczyt;
    }

    public UzytkownikModel getIdUzytkownik() {
        return idUzytkownik;
    }

    public void setIdUzytkownik(UzytkownikModel idUzytkownik) {
        this.idUzytkownik = idUzytkownik;
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
        if (!(object instanceof LaczModel)) {
            return false;
        }
        LaczModel other = (LaczModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.LaczModel[ id=" + id + " ]";
    }
    
}
