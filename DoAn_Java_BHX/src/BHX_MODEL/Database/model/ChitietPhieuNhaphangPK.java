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
public class ChitietPhieuNhaphangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_PHIEUNHAP")
    private String idPhieunhap;
    @Basic(optional = false)
    @Column(name = "MAMH")
    private String mamh;

    public ChitietPhieuNhaphangPK() {
    }

    public ChitietPhieuNhaphangPK(String idPhieunhap, String mamh) {
        this.idPhieunhap = idPhieunhap;
        this.mamh = mamh;
    }

    public String getIdPhieunhap() {
        return idPhieunhap;
    }

    public void setIdPhieunhap(String idPhieunhap) {
        this.idPhieunhap = idPhieunhap;
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPhieunhap != null ? idPhieunhap.hashCode() : 0);
        hash += (mamh != null ? mamh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChitietPhieuNhaphangPK)) {
            return false;
        }
        ChitietPhieuNhaphangPK other = (ChitietPhieuNhaphangPK) object;
        if ((this.idPhieunhap == null && other.idPhieunhap != null) || (this.idPhieunhap != null && !this.idPhieunhap.equals(other.idPhieunhap))) {
            return false;
        }
        if ((this.mamh == null && other.mamh != null) || (this.mamh != null && !this.mamh.equals(other.mamh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BHX_MODEL.Database.model.ChitietPhieuNhaphangPK[ idPhieunhap=" + idPhieunhap + ", mamh=" + mamh + " ]";
    }
    
}
