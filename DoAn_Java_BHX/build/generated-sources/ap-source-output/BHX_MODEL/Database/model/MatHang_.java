package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.Brand;
import BHX_MODEL.Database.model.ChitietHoadon;
import BHX_MODEL.Database.model.ChitietPhieuNhaphang;
import BHX_MODEL.Database.model.GiamGia;
import BHX_MODEL.Database.model.LoaiMathang;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(MatHang.class)
public class MatHang_ { 

    public static volatile SingularAttribute<MatHang, String> donvitinh;
    public static volatile SingularAttribute<MatHang, BigDecimal> giaBan;
    public static volatile CollectionAttribute<MatHang, ChitietPhieuNhaphang> chitietPhieuNhaphangCollection;
    public static volatile SingularAttribute<MatHang, String> tenmh;
    public static volatile SingularAttribute<MatHang, BigDecimal> soLuongTonHientai;
    public static volatile SingularAttribute<MatHang, String> picture;
    public static volatile CollectionAttribute<MatHang, GiamGia> giamGiaCollection;
    public static volatile SingularAttribute<MatHang, String> motaSanpham;
    public static volatile SingularAttribute<MatHang, String> isProductKilogram;
    public static volatile SingularAttribute<MatHang, LoaiMathang> maloai;
    public static volatile SingularAttribute<MatHang, Brand> maBrand;
    public static volatile SingularAttribute<MatHang, String> mamh;
    public static volatile CollectionAttribute<MatHang, ChitietHoadon> chitietHoadonCollection;
    public static volatile SingularAttribute<MatHang, BigDecimal> soGam;

}