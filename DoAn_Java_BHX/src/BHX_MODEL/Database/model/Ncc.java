/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_MODEL.Database.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author VanPhu
 */
@Entity
@Table(name = "NCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ncc.findAll", query = "SELECT n FROM Ncc n"),
    @NamedQuery(name = "Ncc.findByMancc", query = "SELECT n FROM Ncc n WHERE n.mancc = :mancc"),
    @NamedQuery(name = "Ncc.findByTenncc", query = "SELECT n FROM Ncc n WHERE n.tenncc = :tenncc"),
    @NamedQuery(name = "Ncc.findByThongtinChitiet", query = "SELECT n FROM Ncc n WHERE n.thongtinChitiet = :thongtinChitiet"),
    @NamedQuery(name = "Ncc.findByNgayHoptac", query = "SELECT n FROM Ncc n WHERE n.ngayHoptac = :ngayHoptac"),
    @NamedQuery(name = "Ncc.findByEmailNcc", query = "SELECT n FROM Ncc n WHERE n.emailNcc = :emailNcc"),
    @NamedQuery(name = "Ncc.findByDiaChi", query = "SELECT n FROM Ncc n WHERE n.diaChi = :diaChi")})
public class Ncc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MANCC")
    private String mancc;
    @Column(name = "TENNCC")
    private String tenncc;
    @Column(name = "THONGTIN_CHITIET")
    private String thongtinChitiet;
    @Column(name = "NGAY_HOPTAC")
    @Temporal(TemporalType.DATE)
    private Date ngayHoptac;
    @Column(name = "EMAIL_NCC")
    private String emailNcc;
    @Column(name = "DIA_CHI")
    private String diaChi;
    @OneToMany(mappedBy = "mancc")
    private Collection<PhieuNhaphang> phieuNhaphangCollection;

    public Ncc() {
    }

    public Ncc(String mancc) {
        this.mancc = mancc;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public String getThongtinChitiet() {
        return thongtinChitiet;
    }

    public void setThongtinChitiet(String thongtinChitiet) {
        this.thongtinChitiet = thongtinChitiet;
    }

    public Date getNgayHoptac() {
        return ngayHoptac;
    }

    public void setNgayHoptac(Date ngayHoptac) {
        this.ngayHoptac = ngayHoptac;
    }

    public String getEmailNcc() {
        return emailNcc;
    }

    public void setEmailNcc(String emailNcc) {
        this.emailNcc = emailNcc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @XmlTransient
    public Collection<PhieuNhaphang> getPhieuNhaphangCollection() {
        return phieuNhaphangCollection;
    }

    public void setPhieuNhaphangCollection(Collection<PhieuNhaphang> phieuNhaphangCollection) {
        this.phieuNhaphangCollection = phieuNhaphangCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mancc != null ? mancc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ncc)) {
            return false;
        }
        Ncc other = (Ncc) object;
        if ((this.mancc == null && other.mancc != null) || (this.mancc != null && !this.mancc.equals(other.mancc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BHX_MODEL.Database.model.Ncc[ mancc=" + mancc + " ]";
    }
    
}
