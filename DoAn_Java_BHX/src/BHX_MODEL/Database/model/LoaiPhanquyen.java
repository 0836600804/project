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
@Table(name = "LOAI_PHANQUYEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoaiPhanquyen.findAll", query = "SELECT l FROM LoaiPhanquyen l"),
    @NamedQuery(name = "LoaiPhanquyen.findByMaLoaiPq", query = "SELECT l FROM LoaiPhanquyen l WHERE l.maLoaiPq = :maLoaiPq"),
    @NamedQuery(name = "LoaiPhanquyen.findByNamePhanquyen", query = "SELECT l FROM LoaiPhanquyen l WHERE l.namePhanquyen = :namePhanquyen")})
public class LoaiPhanquyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MA_LOAI_PQ")
    private String maLoaiPq;
    @Column(name = "NAME_PHANQUYEN")
    private String namePhanquyen;
    @OneToMany(mappedBy = "maLoaiPq")
    private Collection<UsersLogin> usersLoginCollection;

    public LoaiPhanquyen() {
    }

    public LoaiPhanquyen(String maLoaiPq) {
        this.maLoaiPq = maLoaiPq;
    }

    public String getMaLoaiPq() {
        return maLoaiPq;
    }

    public void setMaLoaiPq(String maLoaiPq) {
        this.maLoaiPq = maLoaiPq;
    }

    public String getNamePhanquyen() {
        return namePhanquyen;
    }

    public void setNamePhanquyen(String namePhanquyen) {
        this.namePhanquyen = namePhanquyen;
    }

    @XmlTransient
    public Collection<UsersLogin> getUsersLoginCollection() {
        return usersLoginCollection;
    }

    public void setUsersLoginCollection(Collection<UsersLogin> usersLoginCollection) {
        this.usersLoginCollection = usersLoginCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLoaiPq != null ? maLoaiPq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoaiPhanquyen)) {
            return false;
        }
        LoaiPhanquyen other = (LoaiPhanquyen) object;
        if ((this.maLoaiPq == null && other.maLoaiPq != null) || (this.maLoaiPq != null && !this.maLoaiPq.equals(other.maLoaiPq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BHX_MODEL.Database.model.LoaiPhanquyen[ maLoaiPq=" + maLoaiPq + " ]";
    }
    
}
