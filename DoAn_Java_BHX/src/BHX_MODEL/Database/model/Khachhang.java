/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_MODEL.Database.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "KHACHHANG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Khachhang.findAll", query = "SELECT k FROM Khachhang k"),
    @NamedQuery(name = "Khachhang.findByMakh", query = "SELECT k FROM Khachhang k WHERE k.makh = :makh"),
    @NamedQuery(name = "Khachhang.findByTenkh", query = "SELECT k FROM Khachhang k WHERE k.tenkh = :tenkh"),
    @NamedQuery(name = "Khachhang.findByNgaysinh", query = "SELECT k FROM Khachhang k WHERE k.ngaysinh = :ngaysinh"),
    @NamedQuery(name = "Khachhang.findByGioitinh", query = "SELECT k FROM Khachhang k WHERE k.gioitinh = :gioitinh"),
    @NamedQuery(name = "Khachhang.findByCccd", query = "SELECT k FROM Khachhang k WHERE k.cccd = :cccd"),
    @NamedQuery(name = "Khachhang.findByEmail", query = "SELECT k FROM Khachhang k WHERE k.email = :email"),
    @NamedQuery(name = "Khachhang.findByPhone", query = "SELECT k FROM Khachhang k WHERE k.phone = :phone")})
public class Khachhang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MAKH")
    private String makh;
    @Column(name = "TENKH")
    private String tenkh;
    @Column(name = "NGAYSINH")
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;
    @Column(name = "GIOITINH")
    private String gioitinh;
    @Column(name = "CCCD")
    private String cccd;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private String phone;
    @OneToMany(mappedBy = "makh")
    private Collection<Hoadon> hoadonCollection;

    public Khachhang() {
    }

    public Khachhang(String makh) {
        this.makh = makh;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
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

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        hash += (makh != null ? makh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khachhang)) {
            return false;
        }
        Khachhang other = (Khachhang) object;
        if ((this.makh == null && other.makh != null) || (this.makh != null && !this.makh.equals(other.makh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.tenkh;
    }
    
}
