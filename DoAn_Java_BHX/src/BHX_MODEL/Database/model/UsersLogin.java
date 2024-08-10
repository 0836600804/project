/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_MODEL.Database.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VanPhu
 */
@Entity
@Table(name = "USERS_LOGIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersLogin.findAll", query = "SELECT u FROM UsersLogin u"),
    @NamedQuery(name = "UsersLogin.findById", query = "SELECT u FROM UsersLogin u WHERE u.id = :id"),
    @NamedQuery(name = "UsersLogin.findByPassword", query = "SELECT u FROM UsersLogin u WHERE u.password = :password"),
    @NamedQuery(name = "UsersLogin.findByIsLoginFirst", query = "SELECT u FROM UsersLogin u WHERE u.isLoginFirst = :isLoginFirst")})
public class UsersLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "IsLoginFirst")
    private Integer isLoginFirst;
    @JoinColumn(name = "MA_LOAI_PQ", referencedColumnName = "MA_LOAI_PQ")
    @ManyToOne
    private LoaiPhanquyen maLoaiPq;
    @JoinColumn(name = "MANV", referencedColumnName = "MANV")
    @OneToOne(optional = false)
    private Nhanvien manv;

    public UsersLogin() {
    }

    public UsersLogin(Integer id) {
        this.id = id;
    }

    public UsersLogin(Integer id, String password) {
        this.id = id;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsLoginFirst() {
        return isLoginFirst;
    }

    public void setIsLoginFirst(Integer isLoginFirst) {
        this.isLoginFirst = isLoginFirst;
    }

    public LoaiPhanquyen getMaLoaiPq() {
        return maLoaiPq;
    }

    public void setMaLoaiPq(LoaiPhanquyen maLoaiPq) {
        this.maLoaiPq = maLoaiPq;
    }

    public Nhanvien getManv() {
        return manv;
    }

    public void setManv(Nhanvien manv) {
        this.manv = manv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersLogin)) {
            return false;
        }
        UsersLogin other = (UsersLogin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BHX_MODEL.Database.model.UsersLogin[ id=" + id + " ]";
    }
    
}
