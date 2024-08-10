package BHX_MODEL.Database.model;

import BHX_MODEL.Database.model.LoaiPhanquyen;
import BHX_MODEL.Database.model.Nhanvien;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-05-13T06:54:12")
@StaticMetamodel(UsersLogin.class)
public class UsersLogin_ { 

    public static volatile SingularAttribute<UsersLogin, String> password;
    public static volatile SingularAttribute<UsersLogin, LoaiPhanquyen> maLoaiPq;
    public static volatile SingularAttribute<UsersLogin, Integer> isLoginFirst;
    public static volatile SingularAttribute<UsersLogin, Integer> id;
    public static volatile SingularAttribute<UsersLogin, Nhanvien> manv;

}