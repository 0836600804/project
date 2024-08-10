package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.MatHang;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(Brand.class)
public class Brand_ { 

    public static volatile SingularAttribute<Brand, String> tenBrand;
    public static volatile SingularAttribute<Brand, String> maBrand;
    public static volatile CollectionAttribute<Brand, MatHang> matHangCollection;
    public static volatile SingularAttribute<Brand, String> mota;
    public static volatile SingularAttribute<Brand, String> picture;

}