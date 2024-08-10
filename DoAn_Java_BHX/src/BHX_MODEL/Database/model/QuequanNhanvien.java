/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_MODEL.Database.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VanPhu
 */
@Entity
@Table(name = "QUEQUAN_NHANVIEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuequanNhanvien.findAll", query = "SELECT q FROM QuequanNhanvien q"),
    @NamedQuery(name = "QuequanNhanvien.findByManv", query = "SELECT q FROM QuequanNhanvien q WHERE q.quequanNhanvienPK.manv = :manv"),
    @NamedQuery(name = "QuequanNhanvien.findByMaquanHuyen", query = "SELECT q FROM QuequanNhanvien q WHERE q.quequanNhanvienPK.maquanHuyen = :maquanHuyen"),
    @NamedQuery(name = "QuequanNhanvien.findByMaxaPhuong", query = "SELECT q FROM QuequanNhanvien q WHERE q.quequanNhanvienPK.maxaPhuong = :maxaPhuong"),
    @NamedQuery(name = "QuequanNhanvien.findByMatinhthanh", query = "SELECT q FROM QuequanNhanvien q WHERE q.quequanNhanvienPK.matinhthanh = :matinhthanh"),
    @NamedQuery(name = "QuequanNhanvien.findByTenduong", query = "SELECT q FROM QuequanNhanvien q WHERE q.tenduong = :tenduong")})
public class QuequanNhanvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuequanNhanvienPK quequanNhanvienPK;
    @Column(name = "TENDUONG")
    private String tenduong;
    @JoinColumn(name = "MANV", referencedColumnName = "MANV", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Nhanvien nhanvien;
    @JoinColumn(name = "MAQUAN_HUYEN", referencedColumnName = "MAQUAN_HUYEN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private QuanHuyen quanHuyen;
    @JoinColumn(name = "MATINHTHANH", referencedColumnName = "MATINHTHANH", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tinhthanh tinhthanh;
    @JoinColumn(name = "MAXA_PHUONG", referencedColumnName = "MAXA_PHUONG", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private XaPhuong xaPhuong;

    public QuequanNhanvien() {
    }

    public QuequanNhanvien(QuequanNhanvienPK quequanNhanvienPK) {
        this.quequanNhanvienPK = quequanNhanvienPK;
    }

    public QuequanNhanvien(String manv, String maquanHuyen, String maxaPhuong, String matinhthanh) {
        this.quequanNhanvienPK = new QuequanNhanvienPK(manv, maquanHuyen, maxaPhuong, matinhthanh);
    }

    public QuequanNhanvienPK getQuequanNhanvienPK() {
        return quequanNhanvienPK;
    }

    public void setQuequanNhanvienPK(QuequanNhanvienPK quequanNhanvienPK) {
        this.quequanNhanvienPK = quequanNhanvienPK;
    }

    public String getTenduong() {
        return tenduong;
    }

    public void setTenduong(String tenduong) {
        this.tenduong = tenduong;
    }

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public QuanHuyen getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(QuanHuyen quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public Tinhthanh getTinhthanh() {
        return tinhthanh;
    }

    public void setTinhthanh(Tinhthanh tinhthanh) {
        this.tinhthanh = tinhthanh;
    }

    public XaPhuong getXaPhuong() {
        return xaPhuong;
    }

    public void setXaPhuong(XaPhuong xaPhuong) {
        this.xaPhuong = xaPhuong;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quequanNhanvienPK != null ? quequanNhanvienPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuequanNhanvien)) {
            return false;
        }
        QuequanNhanvien other = (QuequanNhanvien) object;
        if ((this.quequanNhanvienPK == null && other.quequanNhanvienPK != null) || (this.quequanNhanvienPK != null && !this.quequanNhanvienPK.equals(other.quequanNhanvienPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BHX_MODEL.Database.model.QuequanNhanvien[ quequanNhanvienPK=" + quequanNhanvienPK + " ]";
    }
    
}
