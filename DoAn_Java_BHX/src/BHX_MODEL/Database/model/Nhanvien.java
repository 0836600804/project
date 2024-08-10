/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_MODEL.Database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author VanPhu
 */
@Entity
@Table(name = "NHANVIEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhanvien.findAll", query = "SELECT n FROM Nhanvien n"),
    @NamedQuery(name = "Nhanvien.findByManv", query = "SELECT n FROM Nhanvien n WHERE n.manv = :manv"),
    @NamedQuery(name = "Nhanvien.findByTennv", query = "SELECT n FROM Nhanvien n WHERE n.tennv = :tennv"),
    @NamedQuery(name = "Nhanvien.findByNgaysinh", query = "SELECT n FROM Nhanvien n WHERE n.ngaysinh = :ngaysinh"),
    @NamedQuery(name = "Nhanvien.findByGioitinh", query = "SELECT n FROM Nhanvien n WHERE n.gioitinh = :gioitinh"),
    @NamedQuery(name = "Nhanvien.findByTrinhdohocvan", query = "SELECT n FROM Nhanvien n WHERE n.trinhdohocvan = :trinhdohocvan"),
    @NamedQuery(name = "Nhanvien.findByChucvu", query = "SELECT n FROM Nhanvien n WHERE n.chucvu = :chucvu"),
    @NamedQuery(name = "Nhanvien.findByPicture", query = "SELECT n FROM Nhanvien n WHERE n.picture = :picture"),
    @NamedQuery(name = "Nhanvien.findByCccd", query = "SELECT n FROM Nhanvien n WHERE n.cccd = :cccd"),
    @NamedQuery(name = "Nhanvien.findByNgayvaolam", query = "SELECT n FROM Nhanvien n WHERE n.ngayvaolam = :ngayvaolam"),
    @NamedQuery(name = "Nhanvien.findByHesoluong", query = "SELECT n FROM Nhanvien n WHERE n.hesoluong = :hesoluong"),
    @NamedQuery(name = "Nhanvien.findByPhone", query = "SELECT n FROM Nhanvien n WHERE n.phone = :phone")})
public class Nhanvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MANV")
    private String manv;
    @Column(name = "TENNV")
    private String tennv;
    @Column(name = "NGAYSINH")
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;
    @Column(name = "GIOITINH")
    private String gioitinh;
    @Column(name = "TRINHDOHOCVAN")
    private String trinhdohocvan;
    @Column(name = "CHUCVU")
    private String chucvu;
    @Column(name = "PICTURE")
    private String picture;
    @Column(name = "CCCD")
    private String cccd;
    @Column(name = "NGAYVAOLAM")
    @Temporal(TemporalType.DATE)
    private Date ngayvaolam;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "HESOLUONG")
    private BigDecimal hesoluong;
    @Column(name = "PHONE")
    private String phone;
    @OneToMany(mappedBy = "manv")
    private Collection<PhieuNhaphang> phieuNhaphangCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "manv")
    private UsersLogin usersLogin;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "nhanvien")
    private QuequanNhanvien quequanNhanvien;
    @OneToMany(mappedBy = "manv")
    private Collection<Hoadon> hoadonCollection;

    public Nhanvien() {
    }

    public Nhanvien(String manv) {
        this.manv = manv;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getTrinhdohocvan() {
        return trinhdohocvan;
    }

    public void setTrinhdohocvan(String trinhdohocvan) {
        this.trinhdohocvan = trinhdohocvan;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public Date getNgayvaolam() {
        return ngayvaolam;
    }

    public void setNgayvaolam(Date ngayvaolam) {
        this.ngayvaolam = ngayvaolam;
    }

    public BigDecimal getHesoluong() {
        return hesoluong;
    }

    public void setHesoluong(BigDecimal hesoluong) {
        this.hesoluong = hesoluong;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlTransient
    public Collection<PhieuNhaphang> getPhieuNhaphangCollection() {
        return phieuNhaphangCollection;
    }

    public void setPhieuNhaphangCollection(Collection<PhieuNhaphang> phieuNhaphangCollection) {
        this.phieuNhaphangCollection = phieuNhaphangCollection;
    }

    public UsersLogin getUsersLogin() {
        return usersLogin;
    }

    public void setUsersLogin(UsersLogin usersLogin) {
        this.usersLogin = usersLogin;
    }

    public QuequanNhanvien getQuequanNhanvien() {
        return quequanNhanvien;
    }

    public void setQuequanNhanvien(QuequanNhanvien quequanNhanvien) {
        this.quequanNhanvien = quequanNhanvien;
    }

    @XmlTransient
    public Collection<Hoadon> getHoadonCollection() {
        return hoadonCollection;
    }

    public void setHoadonCollection(Collection<Hoadon> hoadonCollection) {
        this.hoadonCollection = hoadonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manv != null ? manv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nhanvien)) {
            return false;
        }
        Nhanvien other = (Nhanvien) object;
        if ((this.manv == null && other.manv != null) || (this.manv != null && !this.manv.equals(other.manv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BHX_MODEL.Database.model.Nhanvien[ manv=" + manv + " ]";
    }
    
}
