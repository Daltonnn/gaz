package Model;

import Model.UzytkownikModel;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-04T14:41:17")
@StaticMetamodel(TypModel.class)
public class TypModel_ { 

    public static volatile SingularAttribute<TypModel, Integer> idTyp;
    public static volatile CollectionAttribute<TypModel, UzytkownikModel> uzytkownikModelCollection;
    public static volatile SingularAttribute<TypModel, String> nazwa;

}