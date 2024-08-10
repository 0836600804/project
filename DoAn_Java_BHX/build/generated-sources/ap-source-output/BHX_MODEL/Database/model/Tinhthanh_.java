package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.QuanHuyen;
import BHX_MODEL.Database.model.QuequanNhanvien;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(Tinhthanh.class)
public class Tinhthanh_ { 

    public static volatile SingularAttribute<Tinhthanh, String> cap;
    public static volatile SingularAttribute<Tinhthanh, String> tentinhthanh;
    public static volatile CollectionAttribute<Tinhthanh, QuanHuyen> quanHuyenCollection;
    public static volatile CollectionAttribute<Tinhthanh, QuequanNhanvien> quequanNhanvienCollection;
    public static volatile SingularAttribute<Tinhthanh, String> matinhthanh;

}