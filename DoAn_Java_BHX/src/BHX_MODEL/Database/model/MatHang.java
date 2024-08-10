/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_MODEL.Database.model;

import static BHX_UI.BanHang.frm_Main_BanHang.formatterCurrencyVND;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author VanPhu
 */
@Entity
@Table(name = "MAT_HANG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MatHang.findAll", query = "SELECT m FROM MatHang m"),
    @NamedQuery(name = "MatHang.findByMamh", query = "SELECT m FROM MatHang m WHERE m.mamh = :mamh"),
    @NamedQuery(name = "MatHang.findByTenmh", query = "SELECT m FROM MatHang m WHERE m.tenmh = :tenmh"),
    @NamedQuery(name = "MatHang.findByPicture", query = "SELECT m FROM MatHang m WHERE m.picture = :picture"),
    @NamedQuery(name = "MatHang.findByDonvitinh", query = "SELECT m FROM MatHang m WHERE m.donvitinh = :donvitinh"),
    @NamedQuery(name = "MatHang.findBySoGam", query = "SELECT m FROM MatHang m WHERE m.soGam = :soGam"),
    @NamedQuery(name = "MatHang.findByIsProductKilogram", query = "SELECT m FROM MatHang m WHERE m.isProductKilogram = :isProductKilogram"),
    @NamedQuery(name = "MatHang.findByMotaSanpham", query = "SELECT m FROM MatHang m WHERE m.motaSanpham = :motaSanpham"),
    @NamedQuery(name = "MatHang.findByGiaBan", query = "SELECT m FROM MatHang m WHERE m.giaBan = :giaBan"),
    @NamedQuery(name = "MatHang.findBySoLuongTonHientai", query = "SELECT m FROM MatHang m WHERE m.soLuongTonHientai = :soLuongTonHientai")})
public class MatHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MAMH")
    private String mamh;
    @Column(name = "TENMH")
    private String tenmh;
    @Column(name = "PICTURE")
    private String picture;
    @Column(name = "DONVITINH")
    private String donvitinh;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SO_GAM")
    private BigDecimal soGam;
    @Column(name = "IsProductKilogram")
    private String isProductKilogram;
    @Column(name = "MOTA_SANPHAM")
    private String motaSanpham;
    @Column(name = "GIA_BAN")
    private BigDecimal giaBan;
    @Column(name = "SO_LUONG_TON_HIENTAI")
    private BigDecimal soLuongTonHientai;
    @OneToMany(mappedBy = "mamh")
    private Collection<GiamGia> giamGiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matHang")
    private Collection<ChitietHoadon> chitietHoadonCollection;
    @JoinColumn(name = "MA_BRAND", referencedColumnName = "MA_BRAND")
    @ManyToOne
    private Brand maBrand;
    @JoinColumn(name = "MALOAI", referencedColumnName = "MALOAI")
    @ManyToOne
    private LoaiMathang maloai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matHang")
    private Collection<ChitietPhieuNhaphang> chitietPhieuNhaphangCollection;

    public MatHang() {
    }

    public MatHang(String mamh) {
        this.mamh = mamh;
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public String getTenmh() {
        return tenmh;
    }

    public void setTenmh(String tenmh) {
        this.tenmh = tenmh;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }

    public BigDecimal getSoGam() {
        return soGam;
    }

    public void setSoGam(BigDecimal soGam) {
        this.soGam = soGam;
    }

    public String getIsProductKilogram() {
        return isProductKilogram;
    }

    public void setIsProductKilogram(String isProductKilogram) {
        this.isProductKilogram = isProductKilogram;
    }

    public String getMotaSanpham() {
        return motaSanpham;
    }

    public void setMotaSanpham(String motaSanpham) {
        this.motaSanpham = motaSanpham;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public BigDecimal getSoLuongTonHientai() {
        return soLuongTonHientai;
    }

    public void setSoLuongTonHientai(BigDecimal soLuongTonHientai) {
        this.soLuongTonHientai = soLuongTonHientai;
    }

    @XmlTransient
    public Collection<GiamGia> getGiamGiaCollection() {
        return giamGiaCollection;
    }

    public void setGiamGiaCollection(Collection<GiamGia> giamGiaCollection) {
        this.giamGiaCollection = giamGiaCollection;
    }

    @XmlTransient
    public Collection<ChitietHoadon> getChitietHoadonCollection() {
        return chitietHoadonCollection;
    }

    public void setChitietHoadonCollection(Collection<ChitietHoadon> chitietHoadonCollection) {
        this.chitietHoadonCollection = chitietHoadonCollection;
    }

    public Brand getMaBrand() {
        return maBrand;
    }

    public void setMaBrand(Brand maBrand) {
        this.maBrand = maBrand;
    }

    public LoaiMathang getMaloai() {
        return maloai;
    }

    public void setMaloai(LoaiMathang maloai) {
        this.maloai = maloai;
    }

    public Object[] toRowTableTimKiem(int index) {
        return new Object[]{index, this.mamh, this.tenmh, this.picture, this.donvitinh, formatterCurrencyVND(this.giaBan.setScale(5, RoundingMode.HALF_UP))};
    }

    @XmlTransient
    public Collection<ChitietPhieuNhaphang> getChitietPhieuNhaphangCollection() {
        return chitietPhieuNhaphangCollection;
    }

    public void setChitietPhieuNhaphangCollection(Collection<ChitietPhieuNhaphang> chitietPhieuNhaphangCollection) {
        this.chitietPhieuNhaphangCollection = chitietPhieuNhaphangCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mamh != null ? mamh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatHang)) {
            return false;
        }
        MatHang other = (MatHang) object;
        if ((this.mamh == null && other.mamh != null) || (this.mamh != null && !this.mamh.equals(other.mamh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BHX_MODEL.Database.model.MatHang[ mamh=" + mamh + " ]";
    }

}
