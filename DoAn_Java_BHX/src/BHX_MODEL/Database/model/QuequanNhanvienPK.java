/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_MODEL.Database.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author VanPhu
 */
@Embeddable
public class QuequanNhanvienPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "MANV")
    private String manv;
    @Basic(optional = false)
    @Column(name = "MAQUAN_HUYEN")
    private String maquanHuyen;
    @Basic(optional = false)
    @Column(name = "MAXA_PHUONG")
    private String maxaPhuong;
    @Basic(optional = false)
    @Column(name = "MATINHTHANH")
    private String matinhthanh;

    public QuequanNhanvienPK() {
    }

    public QuequanNhanvienPK(String manv, String maquanHuyen, String maxaPhuong, String matinhthanh) {
        this.manv = manv;
        this.maquanHuyen = maquanHuyen;
        this.maxaPhuong = maxaPhuong;
        this.matinhthanh = matinhthanh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMaquanHuyen() {
        return maquanHuyen;
    }

    public void setMaquanHuyen(String maquanHuyen) {
        this.maquanHuyen = maquanHuyen;
    }

    public String getMaxaPhuong() {
        return maxaPhuong;
    }

    public void setMaxaPhuong(String maxaPhuong) {
        this.maxaPhuong = maxaPhuong;
    }

    public String getMatinhthanh() {
        return matinhthanh;
    }

    public void setMatinhthanh(String matinhthanh) {
        this.matinhthanh = matinhthanh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manv != null ? manv.hashCode() : 0);
        hash += (maquanHuyen != null ? maquanHuyen.hashCode() : 0);
        hash += (maxaPhuong != null ? maxaPhuong.hashCode() : 0);
        hash += (matinhthanh != null ? matinhthanh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuequanNhanvienPK)) {
            return false;
        }
        QuequanNhanvienPK other = (QuequanNhanvienPK) object;
        if ((this.manv == null && other.manv != null) || (this.manv != null && !this.manv.equals(other.manv))) {
            return false;
        }
        if ((this.maquanHuyen == null && other.maquanHuyen != null) || (this.maquanHuyen != null && !this.maquanHuyen.equals(other.maquanHuyen))) {
            return false;
        }
        if ((this.maxaPhuong == null && other.maxaPhuong != null) || (this.maxaPhuong != null && !this.maxaPhuong.equals(other.maxaPhuong))) {
            return false;
        }
        if ((this.matinhthanh == null && other.matinhthanh != null) || (this.matinhthanh != null && !this.matinhthanh.equals(other.matinhthanh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BHX_MODEL.Database.model.QuequanNhanvienPK[ manv=" + manv + ", maquanHuyen=" + maquanHuyen + ", maxaPhuong=" + maxaPhuong + ", matinhthanh=" + matinhthanh + " ]";
    }
    
}
