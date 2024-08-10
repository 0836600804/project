/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_MODEL.Database.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "NHOM_LOAI_MATHANG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhomLoaiMathang.findAll", query = "SELECT n FROM NhomLoaiMathang n"),
    @NamedQuery(name = "NhomLoaiMathang.findByManhomLoai", query = "SELECT n FROM NhomLoaiMathang n WHERE n.manhomLoai = :manhomLoai"),
    @NamedQuery(name = "NhomLoaiMathang.findByPicture", query = "SELECT n FROM NhomLoaiMathang n WHERE n.picture = :picture"),
    @NamedQuery(name = "NhomLoaiMathang.findByTennhomLoai", query = "SELECT n FROM NhomLoaiMathang n WHERE n.tennhomLoai = :tennhomLoai")})
public class NhomLoaiMathang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MANHOM_LOAI")
    private String manhomLoai;
    @Column(name = "PICTURE")
    private String picture;
    @Column(name = "TENNHOM_LOAI")
    private String tennhomLoai;
    @OneToMany(mappedBy = "manhomLoai")
    private Collection<LoaiMathang> loaiMathangCollection;

    public NhomLoaiMathang() {
    }

    public NhomLoaiMathang(String manhomLoai) {
        this.manhomLoai = manhomLoai;
    }

    public String getManhomLoai() {
        return manhomLoai;
    }

    public void setManhomLoai(String manhomLoai) {
        this.manhomLoai = manhomLoai;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTennhomLoai() {
        return tennhomLoai;
    }

    public void setTennhomLoai(String tennhomLoai) {
        this.tennhomLoai = tennhomLoai;
    }

    @XmlTransient
    public Collection<LoaiMathang> getLoaiMathangCollection() {
        return loaiMathangCollection;
    }

    public void setLoaiMathangCollection(Collection<LoaiMathang> loaiMathangCollection) {
        this.loaiMathangCollection = loaiMathangCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manhomLoai != null ? manhomLoai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhomLoaiMathang)) {
            return false;
        }
        NhomLoaiMathang other = (NhomLoaiMathang) object;
        if ((this.manhomLoai == null && other.manhomLoai != null) || (this.manhomLoai != null && !this.manhomLoai.equals(other.manhomLoai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.tennhomLoai.toString();
    }

}
