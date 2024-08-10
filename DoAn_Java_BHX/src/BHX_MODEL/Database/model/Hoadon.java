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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "HOADON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoadon.findAll", query = "SELECT h FROM Hoadon h"),
    @NamedQuery(name = "Hoadon.findByIdHoadon", query = "SELECT h FROM Hoadon h WHERE h.idHoadon = :idHoadon"),
    @NamedQuery(name = "Hoadon.findByTienKhachGui", query = "SELECT h FROM Hoadon h WHERE h.tienKhachGui = :tienKhachGui"),
    @NamedQuery(name = "Hoadon.findByTongtienHd", query = "SELECT h FROM Hoadon h WHERE h.tongtienHd = :tongtienHd"),
    @NamedQuery(name = "Hoadon.findByTongtienGg", query = "SELECT h FROM Hoadon h WHERE h.tongtienGg = :tongtienGg"),
    @NamedQuery(name = "Hoadon.findByNgaylapHd", query = "SELECT h FROM Hoadon h WHERE h.ngaylapHd = :ngaylapHd"),
    @NamedQuery(name = "Hoadon.findByTongSoLuong", query = "SELECT h FROM Hoadon h WHERE h.tongSoLuong = :tongSoLuong"),
    @NamedQuery(name = "Hoadon.findByTenHinhthucTt", query = "SELECT h FROM Hoadon h WHERE h.tenHinhthucTt = :tenHinhthucTt")})
public class Hoadon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_HOADON")
    private String idHoadon;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TIEN_KHACH_GUI")
    private BigDecimal tienKhachGui;
    @Column(name = "TONGTIEN_HD")
    private BigDecimal tongtienHd;
    @Column(name = "TONGTIEN_GG")
    private BigDecimal tongtienGg;
    @Column(name = "NGAYLAP_HD")
    @Temporal(TemporalType.DATE)
    private Date ngaylapHd;
    @Column(name = "TONG_SO_LUONG")
    private Integer tongSoLuong;
    @Column(name = "TEN_HINHTHUC_TT")
    private String tenHinhthucTt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoadon")
    private Collection<ChitietHoadon> chitietHoadonCollection;
    @JoinColumn(name = "MAKH", referencedColumnName = "MAKH")
    @ManyToOne
    private Khachhang makh;
    @JoinColumn(name = "MANV", referencedColumnName = "MANV")
    @ManyToOne
    private Nhanvien manv;

    public Hoadon() {
    }

    public Hoadon(String idHoadon, BigDecimal tienKhachGui, Date ngaylapHd, String tenHinhthucTt, Khachhang makh, Nhanvien manv) {
        this.idHoadon = idHoadon;
        this.tienKhachGui = tienKhachGui;
        this.ngaylapHd = ngaylapHd;
        this.tenHinhthucTt = tenHinhthucTt;
        this.makh = makh;
        this.manv = manv;
    }

    public Hoadon(String idHoadon) {
        this.idHoadon = idHoadon;
    }

    public String getIdHoadon() {
        return idHoadon;
    }

    public void setIdHoadon(String idHoadon) {
        this.idHoadon = idHoadon;
    }

    public BigDecimal getTienKhachGui() {
        return tienKhachGui;
    }

    public void setTienKhachGui(BigDecimal tienKhachGui) {
        this.tienKhachGui = tienKhachGui;
    }

    public BigDecimal getTongtienHd() {
        return tongtienHd;
    }

    public void setTongtienHd(BigDecimal tongtienHd) {
        this.tongtienHd = tongtienHd;
    }

    public BigDecimal getTongtienGg() {
        return tongtienGg;
    }

    public void setTongtienGg(BigDecimal tongtienGg) {
        this.tongtienGg = tongtienGg;
    }

    public Date getNgaylapHd() {
        return ngaylapHd;
    }

    public void setNgaylapHd(Date ngaylapHd) {
        this.ngaylapHd = ngaylapHd;
    }

    public Integer getTongSoLuong() {
        return tongSoLuong;
    }

    public void setTongSoLuong(Integer tongSoLuong) {
        this.tongSoLuong = tongSoLuong;
    }

    public String getTenHinhthucTt() {
        return tenHinhthucTt;
    }

    public void setTenHinhthucTt(String tenHinhthucTt) {
        this.tenHinhthucTt = tenHinhthucTt;
    }

    @XmlTransient
    public Collection<ChitietHoadon> getChitietHoadonCollection() {
        return chitietHoadonCollection;
    }

    public void setChitietHoadonCollection(Collection<ChitietHoadon> chitietHoadonCollection) {
        this.chitietHoadonCollection = chitietHoadonCollection;
    }

    public Khachhang getMakh() {
        return makh;
    }

    public void setMakh(Khachhang makh) {
        this.makh = makh;
    }

    public Nhanvien getManv() {
        return manv;
    }

    public void setManv(Nhanvien manv) {
        this.manv = manv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHoadon != null ? idHoadon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoadon)) {
            return false;
        }
        Hoadon other = (Hoadon) object;
        if ((this.idHoadon == null && other.idHoadon != null) || (this.idHoadon != null && !this.idHoadon.equals(other.idHoadon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BHX_MODEL.Database.model.Hoadon[ idHoadon=" + idHoadon + " ]";
    }

}
