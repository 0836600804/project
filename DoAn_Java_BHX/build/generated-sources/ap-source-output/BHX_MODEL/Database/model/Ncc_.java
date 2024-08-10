package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.PhieuNhaphang;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(Ncc.class)
public class Ncc_ { 

    public static volatile SingularAttribute<Ncc, String> diaChi;
    public static volatile SingularAttribute<Ncc, String> thongtinChitiet;
    public static volatile SingularAttribute<Ncc, String> tenncc;
    public static volatile SingularAttribute<Ncc, String> mancc;
    public static volatile SingularAttribute<Ncc, Date> ngayHoptac;
    public static volatile CollectionAttribute<Ncc, PhieuNhaphang> phieuNhaphangCollection;
    public static volatile SingularAttribute<Ncc, String> emailNcc;

}