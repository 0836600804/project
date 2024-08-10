package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.QuequanNhanvien;
import BHX_MODEL.Database.model.Tinhthanh;
import BHX_MODEL.Database.model.XaPhuong;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(QuanHuyen.class)
public class QuanHuyen_ { 

    public static volatile SingularAttribute<QuanHuyen, String> maquanHuyen;
    public static volatile SingularAttribute<QuanHuyen, String> tenquanHuyen;
    public static volatile SingularAttribute<QuanHuyen, String> cap;
    public static volatile CollectionAttribute<QuanHuyen, XaPhuong> xaPhuongCollection;
    public static volatile CollectionAttribute<QuanHuyen, QuequanNhanvien> quequanNhanvienCollection;
    public static volatile SingularAttribute<QuanHuyen, Tinhthanh> matinhthanh;

}