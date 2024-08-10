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
@Table(name = "TINHTHANH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tinhthanh.findAll", query = "SELECT t FROM Tinhthanh t"),
    @NamedQuery(name = "Tinhthanh.findByMatinhthanh", query = "SELECT t FROM Tinhthanh t WHERE t.matinhthanh = :matinhthanh"),
    @NamedQuery(name = "Tinhthanh.findByTentinhthanh", query = "SELECT t FROM Tinhthanh t WHERE t.tentinhthanh = :tentinhthanh"),
    @NamedQuery(name = "Tinhthanh.findByCap", query = "SELECT t FROM Tinhthanh t WHERE t.cap = :cap")})
public class Tinhthanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MATINHTHANH")
    private String matinhthanh;
    @Column(name = "TENTINHTHANH")
    private String tentinhthanh;
    @Column(name = "CAP")
    private String cap;
    @OneToMany(mappedBy = "matinhthanh")
    private Collection<QuanHuyen> quanHuyenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tinhthanh")
    private Collection<QuequanNhanvien> quequanNhanvienCollection;

    public Tinhthanh() {
    }

    public Tinhthanh(String matinhthanh) {
        this.matinhthanh = matinhthanh;
    }

    public String getMatinhthanh() {
        return matinhthanh;
    }

    public void setMatinhthanh(String matinhthanh) {
        this.matinhthanh = matinhthanh;
    }

    public String getTentinhthanh() {
        return tentinhthanh;
    }

    public void setTentinhthanh(String tentinhthanh) {
        this.tentinhthanh = tentinhthanh;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    @XmlTransient
    public Collection<QuanHuyen> getQuanHuyenCollection() {
        return quanHuyenCollection;
    }

    public void setQuanHuyenCollection(Collection<QuanHuyen> quanHuyenCollection) {
        this.quanHuyenCollection = quanHuyenCollection;
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
        hash += (matinhthanh != null ? matinhthanh.hashCode() : 0);
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
        Tinhthanh other = (Tinhthanh) object;
        return matinhthanh != null && matinhthanh.equals(other.matinhthanh);
    }

    @Override
    public String toString() {
        return this.tentinhthanh;
    }

}
