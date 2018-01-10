package Model;

import Model.LaczModel;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-10T21:20:29")
@StaticMetamodel(OdczytModel.class)
public class OdczytModel_ { 

    public static volatile SingularAttribute<OdczytModel, Date> dataDo;
    public static volatile CollectionAttribute<OdczytModel, LaczModel> laczModelCollection;
    public static volatile SingularAttribute<OdczytModel, Integer> idOdczyt;
    public static volatile SingularAttribute<OdczytModel, BigDecimal> wartosc;
    public static volatile SingularAttribute<OdczytModel, Date> dataOd;

}