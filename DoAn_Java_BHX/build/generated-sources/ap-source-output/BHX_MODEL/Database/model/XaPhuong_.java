package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.QuanHuyen;
import BHX_MODEL.Database.model.QuequanNhanvien;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(XaPhuong.class)
public class XaPhuong_ { 

    public static volatile SingularAttribute<XaPhuong, QuanHuyen> maquanHuyen;
    public static volatile SingularAttribute<XaPhuong, String> cap;
    public static volatile SingularAttribute<XaPhuong, String> maxaPhuong;
    public static volatile CollectionAttribute<XaPhuong, QuequanNhanvien> quequanNhanvienCollection;
    public static volatile SingularAttribute<XaPhuong, String> tenxaPhuong;

}