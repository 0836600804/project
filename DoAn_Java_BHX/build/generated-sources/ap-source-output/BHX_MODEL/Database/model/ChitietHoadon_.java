package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.ChitietHoadonPK;
import BHX_MODEL.Database.model.Hoadon;
import BHX_MODEL.Database.model.MatHang;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(ChitietHoadon.class)
public class ChitietHoadon_ { 

    public static volatile SingularAttribute<ChitietHoadon, MatHang> matHang;
    public static volatile SingularAttribute<ChitietHoadon, ChitietHoadonPK> chitietHoadonPK;
    public static volatile SingularAttribute<ChitietHoadon, Hoadon> hoadon;
    public static volatile SingularAttribute<ChitietHoadon, BigDecimal> thanhTienGg;
    public static volatile SingularAttribute<ChitietHoadon, BigDecimal> thanhTien;
    public static volatile SingularAttribute<ChitietHoadon, BigDecimal> soluong;

}