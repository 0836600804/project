package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.Nhanvien;
import BHX_MODEL.Database.model.QuanHuyen;
import BHX_MODEL.Database.model.QuequanNhanvienPK;
import BHX_MODEL.Database.model.Tinhthanh;
import BHX_MODEL.Database.model.XaPhuong;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(QuequanNhanvien.class)
public class QuequanNhanvien_ { 

    public static volatile SingularAttribute<QuequanNhanvien, String> tenduong;
    public static volatile SingularAttribute<QuequanNhanvien, QuequanNhanvienPK> quequanNhanvienPK;
    public static volatile SingularAttribute<QuequanNhanvien, Nhanvien> nhanvien;
    public static volatile SingularAttribute<QuequanNhanvien, QuanHuyen> quanHuyen;
    public static volatile SingularAttribute<QuequanNhanvien, XaPhuong> xaPhuong;
    public static volatile SingularAttribute<QuequanNhanvien, Tinhthanh> tinhthanh;

}