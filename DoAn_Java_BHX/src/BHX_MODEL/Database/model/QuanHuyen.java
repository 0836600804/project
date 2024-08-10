/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_MODEL.Database.model;

import java.io.Serializable;
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
@Table(name = "QUAN_HUYEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuanHuyen.findAll", query = "SELECT q FROM QuanHuyen q"),
    @NamedQuery(name = "QuanHuyen.findByMaquanHuyen", query = "SELECT q FROM QuanHuyen q WHERE q.maquanHuyen = :maquanHuyen"),
    @NamedQuery(name = "QuanHuyen.findByTenquanHuyen", query = "SELECT q FROM QuanHuyen q WHERE q.tenquanHuyen = :tenquanHuyen"),
    @NamedQuery(name = "QuanHuyen.findByCap", query = "SELECT q FROM QuanHuyen q WHERE q.cap = :cap")})
public class QuanHuyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MAQUAN_HUYEN")
    private String maquanHuyen;
    @Column(name = "TENQUAN_HUYEN")
    private String tenquanHuyen;
    @Column(name = "CAP")
    private String cap;
    @JoinColumn(name = "MATINHTHANH", referencedColumnName = "MATINHTHANH")
    @ManyToOne
    private Tinhthanh matinhthanh;
    @OneToMany(mappedBy = "maquanHuyen")
    private Collection<XaPhuong> xaPhuongCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quanHuyen")
    private Collection<QuequanNhanvien> quequanNhanvienCollection;

    public QuanHuyen() {
    }

    public QuanHuyen(String maquanHuyen) {
        this.maquanHuyen = maquanHuyen;
    }

    public String getMaquanHuyen() {
        return maquanHuyen;
    }

    public void setMaquanHuyen(String maquanHuyen) {
        this.maquanHuyen = maquanHuyen;
    }

    public String getTenquanHuyen() {
        return tenquanHuyen;
    }

    public void setTenquanHuyen(String tenquanHuyen) {
        this.tenquanHuyen = tenquanHuyen;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public Tinhthanh getMatinhthanh() {
        return matinhthanh;
    }

    public void setMatinhthanh(Tinhthanh matinhthanh) {
        this.matinhthanh = matinhthanh;
    }

    @XmlTransient
    public Collection<XaPhuong> getXaPhuongCollection() {
        return xaPhuongCollection;
    }

    public void setXaPhuongCollection(Collection<XaPhuong> xaPhuongCollection) {
        this.xaPhuongCollection = xaPhuongCollection;
    }

    @XmlTransient
    public Collection<QuequanNhanvien> getQuequanNhanvienCollection() {
        return quequanNhanvienCollection;
    }

    public void setQuequanNhanvienCollection(Collection<QuequanNhanvien> quequanNhanvienCollection) {
        this.quequanNhanvienCollection = quequanNhanvienCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maquanHuyen != null ? maquanHuyen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        QuanHuyen other = (QuanHuyen) object;
        return maquanHuyen != null && maquanHuyen.equals(other.maquanHuyen);
    }

    @Override
    public String toString() {
        return this.tenquanHuyen;
    }

}
