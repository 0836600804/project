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
@Table(name = "XA_PHUONG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XaPhuong.findAll", query = "SELECT x FROM XaPhuong x"),
    @NamedQuery(name = "XaPhuong.findByMaxaPhuong", query = "SELECT x FROM XaPhuong x WHERE x.maxaPhuong = :maxaPhuong"),
    @NamedQuery(name = "XaPhuong.findByTenxaPhuong", query = "SELECT x FROM XaPhuong x WHERE x.tenxaPhuong = :tenxaPhuong"),
    @NamedQuery(name = "XaPhuong.findByCap", query = "SELECT x FROM XaPhuong x WHERE x.cap = :cap")})
public class XaPhuong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MAXA_PHUONG")
    private String maxaPhuong;
    @Column(name = "TENXA_PHUONG")
    private String tenxaPhuong;
    @Column(name = "CAP")
    private String cap;
    @JoinColumn(name = "MAQUAN_HUYEN", referencedColumnName = "MAQUAN_HUYEN")
    @ManyToOne
    private QuanHuyen maquanHuyen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "xaPhuong")
    private Collection<QuequanNhanvien> quequanNhanvienCollection;

    public XaPhuong() {
    }

    public XaPhuong(String maxaPhuong) {
        this.maxaPhuong = maxaPhuong;
    }

    public String getMaxaPhuong() {
        return maxaPhuong;
    }

    public void setMaxaPhuong(String maxaPhuong) {
        this.maxaPhuong = maxaPhuong;
    }

    public String getTenxaPhuong() {
        return tenxaPhuong;
    }

    public void setTenxaPhuong(String tenxaPhuong) {
        this.tenxaPhuong = tenxaPhuong;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public QuanHuyen getMaquanHuyen() {
        return maquanHuyen;
    }

    public void setMaquanHuyen(QuanHuyen maquanHuyen) {
        this.maquanHuyen = maquanHuyen;
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
        hash += (maxaPhuong != null ? maxaPhuong.hashCode() : 0);
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
        XaPhuong other = (XaPhuong) object;
        return maxaPhuong != null && maxaPhuong.equals(other.maxaPhuong);
    }

    @Override
    public String toString() {
        return this.tenxaPhuong;
    }

}
