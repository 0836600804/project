package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.Hoadon;
import BHX_MODEL.Database.model.PhieuNhaphang;
import BHX_MODEL.Database.model.QuequanNhanvien;
import BHX_MODEL.Database.model.UsersLogin;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(Nhanvien.class)
public class Nhanvien_ { 

    public static volatile SingularAttribute<Nhanvien, String> gioitinh;
    public static volatile SingularAttribute<Nhanvien, BigDecimal> hesoluong;
    public static volatile SingularAttribute<Nhanvien, Date> ngayvaolam;
    public static volatile SingularAttribute<Nhanvien, Date> ngaysinh;
    public static volatile SingularAttribute<Nhanvien, UsersLogin> usersLogin;
    public static volatile SingularAttribute<Nhanvien, String> picture;
    public static volatile CollectionAttribute<Nhanvien, PhieuNhaphang> phieuNhaphangCollection;
    public static volatile SingularAttribute<Nhanvien, String> manv;
    public static volatile SingularAttribute<Nhanvien, String> cccd;
    public static volatile SingularAttribute<Nhanvien, String> chucvu;
    public static volatile SingularAttribute<Nhanvien, String> phone;
    public static volatile SingularAttribute<Nhanvien, QuequanNhanvien> quequanNhanvien;
    public static volatile SingularAttribute<Nhanvien, String> tennv;
    public static volatile CollectionAttribute<Nhanvien, Hoadon> hoadonCollection;
    public static volatile SingularAttribute<Nhanvien, String> trinhdohocvan;

}