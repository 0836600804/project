package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.Hoadon;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(Khachhang.class)
public class Khachhang_ { 

    public static volatile SingularAttribute<Khachhang, String> makh;
    public static volatile SingularAttribute<Khachhang, String> gioitinh;
    public static volatile SingularAttribute<Khachhang, String> phone;
    public static volatile CollectionAttribute<Khachhang, Hoadon> hoadonCollection;
    public static volatile SingularAttribute<Khachhang, String> tenkh;
    public static volatile SingularAttribute<Khachhang, Date> ngaysinh;
    public static volatile SingularAttribute<Khachhang, String> email;
    public static volatile SingularAttribute<Khachhang, String> cccd;

}