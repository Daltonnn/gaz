package Model;

import Model.LaczModel;
import Model.TaryfaModel;
import Model.TypModel;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-04T13:48:30")
@StaticMetamodel(UzytkownikModel.class)
public class UzytkownikModel_ { 

    public static volatile SingularAttribute<UzytkownikModel, Integer> idUzytkownik;
    public static volatile SingularAttribute<UzytkownikModel, Boolean> potwierdz;
    public static volatile SingularAttribute<UzytkownikModel, String> nrMiesz;
    public static volatile SingularAttribute<UzytkownikModel, TypModel> typ;
    public static volatile SingularAttribute<UzytkownikModel, String> kodPoczt;
    public static volatile SingularAttribute<UzytkownikModel, String> imie;
    public static volatile SingularAttribute<UzytkownikModel, TaryfaModel> taryfa;
    public static volatile SingularAttribute<UzytkownikModel, String> ulica;
    public static volatile SingularAttribute<UzytkownikModel, String> nazwisko;
    public static volatile CollectionAttribute<UzytkownikModel, LaczModel> laczModelCollection;
    public static volatile SingularAttribute<UzytkownikModel, String> haslo;
    public static volatile SingularAttribute<UzytkownikModel, String> miasto;
    public static volatile SingularAttribute<UzytkownikModel, String> email;

}