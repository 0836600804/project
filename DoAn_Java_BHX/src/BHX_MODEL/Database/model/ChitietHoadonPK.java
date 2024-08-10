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
public class ChitietHoadonPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_HOADON")
    private String idHoadon;
    @Basic(optional = false)
    @Column(name = "MAMH")
    private String mamh;

    public ChitietHoadonPK() {
    }

    public ChitietHoadonPK(String idHoadon, String mamh) {
        this.idHoadon = idHoadon;
        this.mamh = mamh;
    }

    public String getIdHoadon() {
        return idHoadon;
    }

    public void setIdHoadon(String idHoadon) {
        this.idHoadon = idHoadon;
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
        hash += (idHoadon != null ? idHoadon.hashCode() : 0);
        hash += (mamh != null ? mamh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChitietHoadonPK)) {
            return false;
        }
        ChitietHoadonPK other = (ChitietHoadonPK) object;
        if ((this.idHoadon == null && other.idHoadon != null) || (this.idHoadon != null && !this.idHoadon.equals(other.idHoadon))) {
            return false;
        }
        if ((this.mamh == null && other.mamh != null) || (this.mamh != null && !this.mamh.equals(other.mamh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BHX_MODEL.Database.model.ChitietHoadonPK[ idHoadon=" + idHoadon + ", mamh=" + mamh + " ]";
    }
    
}
