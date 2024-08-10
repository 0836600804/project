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
@Table(name = "BRAND")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brand.findAll", query = "SELECT b FROM Brand b"),
    @NamedQuery(name = "Brand.findByMaBrand", query = "SELECT b FROM Brand b WHERE b.maBrand = :maBrand"),
    @NamedQuery(name = "Brand.findByTenBrand", query = "SELECT b FROM Brand b WHERE b.tenBrand = :tenBrand"),
    @NamedQuery(name = "Brand.findByPicture", query = "SELECT b FROM Brand b WHERE b.picture = :picture"),
    @NamedQuery(name = "Brand.findByMota", query = "SELECT b FROM Brand b WHERE b.mota = :mota")})
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MA_BRAND")
    private String maBrand;
    @Column(name = "TEN_BRAND")
    private String tenBrand;
    @Column(name = "PICTURE")
    private String picture;
    @Column(name = "MOTA")
    private String mota;
    @OneToMany(mappedBy = "maBrand")
    private Collection<MatHang> matHangCollection;

    public Brand() {
    }

    public Brand(String maBrand) {
        this.maBrand = maBrand;
    }

    public String getMaBrand() {
        return maBrand;
    }

    public void setMaBrand(String maBrand) {
        this.maBrand = maBrand;
    }

    public String getTenBrand() {
        return tenBrand;
    }

    public void setTenBrand(String tenBrand) {
        this.tenBrand = tenBrand;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
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
        hash += (maBrand != null ? maBrand.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brand)) {
            return false;
        }
        Brand other = (Brand) object;
        if ((this.maBrand == null && other.maBrand != null) || (this.maBrand != null && !this.maBrand.equals(other.maBrand))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BHX_MODEL.Database.model.Brand[ maBrand=" + maBrand + " ]";
    }
    
}
