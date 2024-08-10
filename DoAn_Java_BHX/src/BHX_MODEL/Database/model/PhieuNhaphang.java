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
@Table(name = "PHIEU_NHAPHANG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhieuNhaphang.findAll", query = "SELECT p FROM PhieuNhaphang p"),
    @NamedQuery(name = "PhieuNhaphang.findByIdPhieunhap", query = "SELECT p FROM PhieuNhaphang p WHERE p.idPhieunhap = :idPhieunhap"),
    @NamedQuery(name = "PhieuNhaphang.findByNgaylapPhieunhap", query = "SELECT p FROM PhieuNhaphang p WHERE p.ngaylapPhieunhap = :ngaylapPhieunhap"),
    @NamedQuery(name = "PhieuNhaphang.findByTongtienPhieunhap", query = "SELECT p FROM PhieuNhaphang p WHERE p.tongtienPhieunhap = :tongtienPhieunhap"),
    @NamedQuery(name = "PhieuNhaphang.findByGhiChu", query = "SELECT p FROM PhieuNhaphang p WHERE p.ghiChu = :ghiChu")})
public class PhieuNhaphang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PHIEUNHAP")
    private String idPhieunhap;
    @Column(name = "NGAYLAP_PHIEUNHAP")
    @Temporal(TemporalType.DATE)
    private Date ngaylapPhieunhap;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TONGTIEN_PHIEUNHAP")
    private BigDecimal tongtienPhieunhap;
    @Column(name = "GHI_CHU")
    private String ghiChu;
    @JoinColumn(name = "MANCC", referencedColumnName = "MANCC")
    @ManyToOne
    private Ncc mancc;
    @JoinColumn(name = "MANV", referencedColumnName = "MANV")
    @ManyToOne
    private Nhanvien manv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phieuNhaphang")
    private Collection<ChitietPhieuNhaphang> chitietPhieuNhaphangCollection;

    public PhieuNhaphang() {
    }

    public PhieuNhaphang(String idPhieunhap) {
        this.idPhieunhap = idPhieunhap;
    }

    public String getIdPhieunhap() {
        return idPhieunhap;
    }

    public void setIdPhieunhap(String idPhieunhap) {
        this.idPhieunhap = idPhieunhap;
    }

    public Date getNgaylapPhieunhap() {
        return ngaylapPhieunhap;
    }

    public void setNgaylapPhieunhap(Date ngaylapPhieunhap) {
        this.ngaylapPhieunhap = ngaylapPhieunhap;
    }

    public BigDecimal getTongtienPhieunhap() {
        return tongtienPhieunhap;
    }

    public void setTongtienPhieunhap(BigDecimal tongtienPhieunhap) {
        this.tongtienPhieunhap = tongtienPhieunhap;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Ncc getMancc() {
        return mancc;
    }

    public void setMancc(Ncc mancc) {
        this.mancc = mancc;
    }

    public Nhanvien getManv() {
        return manv;
    }

    public void setManv(Nhanvien manv) {
        this.manv = manv;
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
        hash += (idPhieunhap != null ? idPhieunhap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhieuNhaphang)) {
            return false;
        }
        PhieuNhaphang other = (PhieuNhaphang) object;
        if ((this.idPhieunhap == null && other.idPhieunhap != null) || (this.idPhieunhap != null && !this.idPhieunhap.equals(other.idPhieunhap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BHX_MODEL.Database.model.PhieuNhaphang[ idPhieunhap=" + idPhieunhap + " ]";
    }
    
}
