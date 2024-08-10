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
@Table(name = "LOAI_MATHANG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoaiMathang.findAll", query = "SELECT l FROM LoaiMathang l"),
    @NamedQuery(name = "LoaiMathang.findByMaloai", query = "SELECT l FROM LoaiMathang l WHERE l.maloai = :maloai"),
    @NamedQuery(name = "LoaiMathang.findByTenloai", query = "SELECT l FROM LoaiMathang l WHERE l.tenloai = :tenloai"),
    @NamedQuery(name = "LoaiMathang.findByPicture", query = "SELECT l FROM LoaiMathang l WHERE l.picture = :picture")})
public class LoaiMathang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MALOAI")
    private String maloai;
    @Column(name = "TENLOAI")
    private String tenloai;
    @Column(name = "PICTURE")
    private String picture;
    @JoinColumn(name = "MANHOM_LOAI", referencedColumnName = "MANHOM_LOAI")
    @ManyToOne
    private NhomLoaiMathang manhomLoai;
    @OneToMany(mappedBy = "maloai")
    private Collection<MatHang> matHangCollection;

    public LoaiMathang() {
    }

    public LoaiMathang(String maloai) {
        this.maloai = maloai;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public NhomLoaiMathang getManhomLoai() {
        return manhomLoai;
    }

    public void setManhomLoai(NhomLoaiMathang manhomLoai) {
        this.manhomLoai = manhomLoai;
    }

    @XmlTransient
    public Collection<MatHang> getMatHangCollection() {
        return matHangCollection;
    }

    public void setMatHangCollection(Collection<MatHang> matHangCollection) {
        this.matHangCollection = matHangCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maloai != null ? maloai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoaiMathang)) {
            return false;
        }
        LoaiMathang other = (LoaiMathang) object;
        if ((this.maloai == null && other.maloai != null) || (this.maloai != null && !this.maloai.equals(other.maloai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.tenloai;
    }

}
