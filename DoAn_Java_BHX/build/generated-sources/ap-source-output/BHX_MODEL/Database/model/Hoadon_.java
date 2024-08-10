package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.ChitietHoadon;
import BHX_MODEL.Database.model.Khachhang;
import BHX_MODEL.Database.model.Nhanvien;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(Hoadon.class)
public class Hoadon_ { 

    public static volatile SingularAttribute<Hoadon, BigDecimal> tongtienHd;
    public static volatile SingularAttribute<Hoadon, Date> ngaylapHd;
    public static volatile SingularAttribute<Hoadon, Integer> tongSoLuong;
    public static volatile SingularAttribute<Hoadon, Khachhang> makh;
    public static volatile SingularAttribute<Hoadon, String> idHoadon;
    public static volatile SingularAttribute<Hoadon, String> tenHinhthucTt;
    public static volatile SingularAttribute<Hoadon, BigDecimal> tienKhachGui;
    public static volatile SingularAttribute<Hoadon, BigDecimal> tongtienGg;
    public static volatile CollectionAttribute<Hoadon, ChitietHoadon> chitietHoadonCollection;
    public static volatile SingularAttribute<Hoadon, Nhanvien> manv;

}