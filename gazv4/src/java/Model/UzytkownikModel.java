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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "uzytkownik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UzytkownikModel.findAll", query = "SELECT u FROM UzytkownikModel u")
    , @NamedQuery(name = "UzytkownikModel.findByIdUzytkownik", query = "SELECT u FROM UzytkownikModel u WHERE u.idUzytkownik = :idUzytkownik")
    , @NamedQuery(name = "UzytkownikModel.findByImie", query = "SELECT u FROM UzytkownikModel u WHERE u.imie = :imie")
    , @NamedQuery(name = "UzytkownikModel.findByNazwisko", query = "SELECT u FROM UzytkownikModel u WHERE u.nazwisko = :nazwisko")
    , @NamedQuery(name = "UzytkownikModel.findByNrMiesz", query = "SELECT u FROM UzytkownikModel u WHERE u.nrMiesz = :nrMiesz")
    , @NamedQuery(name = "UzytkownikModel.findByUlica", query = "SELECT u FROM UzytkownikModel u WHERE u.ulica = :ulica")
    , @NamedQuery(name = "UzytkownikModel.findByMiasto", query = "SELECT u FROM UzytkownikModel u WHERE u.miasto = :miasto")
    , @NamedQuery(name = "UzytkownikModel.findByKodPoczt", query = "SELECT u FROM UzytkownikModel u WHERE u.kodPoczt = :kodPoczt")
    , @NamedQuery(name = "UzytkownikModel.findByEmail", query = "SELECT u FROM UzytkownikModel u WHERE u.email = :email")
    , @NamedQuery(name = "UzytkownikModel.findByHaslo", query = "SELECT u FROM UzytkownikModel u WHERE u.haslo = :haslo")
    , @NamedQuery(name = "UzytkownikModel.findByPotwierdz", query = "SELECT u FROM UzytkownikModel u WHERE u.potwierdz = :potwierdz")})
public class UzytkownikModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_uzytkownik")
    private Integer idUzytkownik;
    @Basic(optional = false)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @Column(name = "nazwisko")
    private String nazwisko;
    @Basic(optional = false)
    @Column(name = "nr_miesz")
    private String nrMiesz;
    @Basic(optional = false)
    @Column(name = "ulica")
    private String ulica;
    @Basic(optional = false)
    @Column(name = "miasto")
    private String miasto;
    @Basic(optional = false)
    @Column(name = "kod_poczt")
    private String kodPoczt;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "haslo")
    private String haslo;
    @Column(name = "potwierdz")
    private Boolean potwierdz;
    @JoinColumn(name = "taryfa", referencedColumnName = "id_taryfa")
    @ManyToOne
    private TaryfaModel taryfa;
    @JoinColumn(name = "typ", referencedColumnName = "id_typ")
    @ManyToOne
    private TypModel typ;
    @OneToMany(mappedBy = "idUzytkownik")
    private Collection<LaczModel> laczModelCollection;

    public UzytkownikModel() {
    }

    public UzytkownikModel(Integer idUzytkownik) {
        this.idUzytkownik = idUzytkownik;
    }

    public UzytkownikModel(Integer idUzytkownik, String imie, String nazwisko, String nrMiesz, String ulica, String miasto, String kodPoczt, String email, String haslo) {
        this.idUzytkownik = idUzytkownik;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrMiesz = nrMiesz;
        this.ulica = ulica;
        this.miasto = miasto;
        this.kodPoczt = kodPoczt;
        this.email = email;
        this.haslo = haslo;
    }
    
    public UzytkownikModel( String imie, String nazwisko, String nrMiesz, String ulica, String miasto, String kodPoczt, String email, String haslo) {        
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrMiesz = nrMiesz;
        this.ulica = ulica;
        this.miasto = miasto;
        this.kodPoczt = kodPoczt;
        this.email = email;
        this.haslo = haslo;
    }

    public Integer getIdUzytkownik() {
        return idUzytkownik;
    }

    public void setIdUzytkownik(Integer idUzytkownik) {
        this.idUzytkownik = idUzytkownik;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNrMiesz() {
        return nrMiesz;
    }

    public void setNrMiesz(String nrMiesz) {
        this.nrMiesz = nrMiesz;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getKodPoczt() {
        return kodPoczt;
    }

    public void setKodPoczt(String kodPoczt) {
        this.kodPoczt = kodPoczt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Boolean getPotwierdz() {
        return potwierdz;
    }

    public void setPotwierdz(Boolean potwierdz) {
        this.potwierdz = potwierdz;
    }

    public TaryfaModel getTaryfa() {
        return taryfa;
    }

    public void setTaryfa(TaryfaModel taryfa) {
        this.taryfa = taryfa;
    }

    public TypModel getTyp() {
        return typ;
    }

    public void setTyp(TypModel typ) {
        this.typ = typ;
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
        hash += (idUzytkownik != null ? idUzytkownik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UzytkownikModel)) {
            return false;
        }
        UzytkownikModel other = (UzytkownikModel) object;
        if ((this.idUzytkownik == null && other.idUzytkownik != null) || (this.idUzytkownik != null && !this.idUzytkownik.equals(other.idUzytkownik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.UzytkownikModel[ idUzytkownik=" + idUzytkownik + " ]";
    }
    
}
