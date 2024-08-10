/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_MODEL.Database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VanPhu
 */
@Entity
@Table(name = "CHITIET_PHIEU_NHAPHANG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChitietPhieuNhaphang.findAll", query = "SELECT c FROM ChitietPhieuNhaphang c"),
    @NamedQuery(name = "ChitietPhieuNhaphang.findByIdPhieunhap", query = "SELECT c FROM ChitietPhieuNhaphang c WHERE c.chitietPhieuNhaphangPK.idPhieunhap = :idPhieunhap"),
    @NamedQuery(name = "ChitietPhieuNhaphang.findByMamh", query = "SELECT c FROM ChitietPhieuNhaphang c WHERE c.chitietPhieuNhaphangPK.mamh = :mamh"),
    @NamedQuery(name = "ChitietPhieuNhaphang.findBySoluong", query = "SELECT c FROM ChitietPhieuNhaphang c WHERE c.soluong = :soluong"),
    @NamedQuery(name = "ChitietPhieuNhaphang.findByGiaNhap", query = "SELECT c FROM ChitietPhieuNhaphang c WHERE c.giaNhap = :giaNhap"),
    @NamedQuery(name = "ChitietPhieuNhaphang.findByHsd", query = "SELECT c FROM ChitietPhieuNhaphang c WHERE c.hsd = :hsd"),
    @NamedQuery(name = "ChitietPhieuNhaphang.findByNsx", query = "SELECT c FROM ChitietPhieuNhaphang c WHERE c.nsx = :nsx"),
    @NamedQuery(name = "ChitietPhieuNhaphang.findByTongtien", query = "SELECT c FROM ChitietPhieuNhaphang c WHERE c.tongtien = :tongtien")})
public class ChitietPhieuNhaphang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChitietPhieuNhaphangPK chitietPhieuNhaphangPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SOLUONG")
    private BigDecimal soluong;
    @Column(name = "GIA_NHAP")
    private BigDecimal giaNhap;
    @Column(name = "HSD")
    @Temporal(TemporalType.DATE)
    private Date hsd;
    @Column(name = "NSX")
    @Temporal(TemporalType.DATE)
    private Date nsx;
    @Column(name = "TONGTIEN")
    private BigDecimal tongtien;
    @JoinColumn(name = "MAMH", referencedColumnName = "MAMH", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MatHang matHang;
    @JoinColumn(name = "ID_PHIEUNHAP", referencedColumnName = "ID_PHIEUNHAP", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PhieuNhaphang phieuNhaphang;

    public ChitietPhieuNhaphang() {
    }

    public ChitietPhieuNhaphang(ChitietPhieuNhaphangPK chitietPhieuNhaphangPK) {
        this.chitietPhieuNhaphangPK = chitietPhieuNhaphangPK;
    }

    public ChitietPhieuNhaphang(String idPhieunhap, String mamh) {
        this.chitietPhieuNhaphangPK = new ChitietPhieuNhaphangPK(idPhieunhap, mamh);
    }

    public ChitietPhieuNhaphangPK getChitietPhieuNhaphangPK() {
        return chitietPhieuNhaphangPK;
    }

    public void setChitietPhieuNhaphangPK(ChitietPhieuNhaphangPK chitietPhieuNhaphangPK) {
        this.chitietPhieuNhaphangPK = chitietPhieuNhaphangPK;
    }

    public BigDecimal getSoluong() {
        return soluong;
    }

    public void setSoluong(BigDecimal soluong) {
        this.soluong = soluong;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Date getHsd() {
        return hsd;
    }

    public void setHsd(Date hsd) {
        this.hsd = hsd;
    }

    public Date getNsx() {
        return nsx;
    }

    public void setNsx(Date nsx) {
        this.nsx = nsx;
    }

    public BigDecimal getTongtien() {
        return tongtien;
    }

    public void setTongtien(BigDecimal tongtien) {
        this.tongtien = tongtien;
    }

    public MatHang getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }

    public PhieuNhaphang getPhieuNhaphang() {
        return phieuNhaphang;
    }

    public void setPhieuNhaphang(PhieuNhaphang phieuNhaphang) {
        this.phieuNhaphang = phieuNhaphang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chitietPhieuNhaphangPK != null ? chitietPhieuNhaphangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChitietPhieuNhaphang)) {
            return false;
        }
        ChitietPhieuNhaphang other = (ChitietPhieuNhaphang) object;
        if ((this.chitietPhieuNhaphangPK == null && other.chitietPhieuNhaphangPK != null) || (this.chitietPhieuNhaphangPK != null && !this.chitietPhieuNhaphangPK.equals(other.chitietPhieuNhaphangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BHX_MODEL.Database.model.ChitietPhieuNhaphang[ chitietPhieuNhaphangPK=" + chitietPhieuNhaphangPK + " ]";
    }
    
}
