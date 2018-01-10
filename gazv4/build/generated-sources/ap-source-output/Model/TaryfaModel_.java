package Model;

import Model.UzytkownikModel;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-10T21:20:29")
@StaticMetamodel(TaryfaModel.class)
public class TaryfaModel_ { 

    public static volatile SingularAttribute<TaryfaModel, BigDecimal> cenaLicz;
    public static volatile SingularAttribute<TaryfaModel, Integer> idTaryfa;
    public static volatile CollectionAttribute<TaryfaModel, UzytkownikModel> uzytkownikModelCollection;
    public static volatile SingularAttribute<TaryfaModel, BigDecimal> cenaJed;
    public static volatile SingularAttribute<TaryfaModel, String> nazwa;

}