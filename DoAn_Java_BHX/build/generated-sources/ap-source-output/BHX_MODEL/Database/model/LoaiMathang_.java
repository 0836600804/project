package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.MatHang;
import BHX_MODEL.Database.model.NhomLoaiMathang;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(LoaiMathang.class)
public class LoaiMathang_ { 

    public static volatile SingularAttribute<LoaiMathang, String> tenloai;
    public static volatile SingularAttribute<LoaiMathang, String> maloai;
    public static volatile CollectionAttribute<LoaiMathang, MatHang> matHangCollection;
    public static volatile SingularAttribute<LoaiMathang, NhomLoaiMathang> manhomLoai;
    public static volatile SingularAttribute<LoaiMathang, String> picture;

}