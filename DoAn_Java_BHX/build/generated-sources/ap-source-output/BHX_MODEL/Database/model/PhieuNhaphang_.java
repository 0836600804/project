package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.ChitietPhieuNhaphang;
import BHX_MODEL.Database.model.Ncc;
import BHX_MODEL.Database.model.Nhanvien;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(PhieuNhaphang.class)
public class PhieuNhaphang_ { 

    public static volatile SingularAttribute<PhieuNhaphang, Date> ngaylapPhieunhap;
    public static volatile SingularAttribute<PhieuNhaphang, BigDecimal> tongtienPhieunhap;
    public static volatile SingularAttribute<PhieuNhaphang, String> ghiChu;
    public static volatile SingularAttribute<PhieuNhaphang, Ncc> mancc;
    public static volatile CollectionAttribute<PhieuNhaphang, ChitietPhieuNhaphang> chitietPhieuNhaphangCollection;
    public static volatile SingularAttribute<PhieuNhaphang, String> idPhieunhap;
    public static volatile SingularAttribute<PhieuNhaphang, Nhanvien> manv;

}