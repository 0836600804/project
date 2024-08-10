package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.ChitietPhieuNhaphangPK;
import BHX_MODEL.Database.model.MatHang;
import BHX_MODEL.Database.model.PhieuNhaphang;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(ChitietPhieuNhaphang.class)
public class ChitietPhieuNhaphang_ { 

    public static volatile SingularAttribute<ChitietPhieuNhaphang, BigDecimal> tongtien;
    public static volatile SingularAttribute<ChitietPhieuNhaphang, MatHang> matHang;
    public static volatile SingularAttribute<ChitietPhieuNhaphang, BigDecimal> giaNhap;
    public static volatile SingularAttribute<ChitietPhieuNhaphang, Date> nsx;
    public static volatile SingularAttribute<ChitietPhieuNhaphang, Date> hsd;
    public static volatile SingularAttribute<ChitietPhieuNhaphang, ChitietPhieuNhaphangPK> chitietPhieuNhaphangPK;
    public static volatile SingularAttribute<ChitietPhieuNhaphang, BigDecimal> soluong;
    public static volatile SingularAttribute<ChitietPhieuNhaphang, PhieuNhaphang> phieuNhaphang;

}