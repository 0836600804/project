package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.MatHang;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(GiamGia.class)
public class GiamGia_ { 

    public static volatile SingularAttribute<GiamGia, Date> ngay;
    public static volatile SingularAttribute<GiamGia, Date> tg;
    public static volatile SingularAttribute<GiamGia, BigDecimal> soPhanTram;
    public static volatile SingularAttribute<GiamGia, Integer> lan;
    public static volatile SingularAttribute<GiamGia, String> id;
    public static volatile SingularAttribute<GiamGia, MatHang> mamh;

}