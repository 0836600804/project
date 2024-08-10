/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_MODEL.Database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VanPhu
 */
@Entity
@Table(name = "GIAM_GIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiamGia.findAll", query = "SELECT g FROM GiamGia g"),
    @NamedQuery(name = "GiamGia.findById", query = "SELECT g FROM GiamGia g WHERE g.id = :id"),
    @NamedQuery(name = "GiamGia.findBySoPhanTram", query = "SELECT g FROM GiamGia g WHERE g.soPhanTram = :soPhanTram"),
    @NamedQuery(name = "GiamGia.findByLan", query = "SELECT g FROM GiamGia g WHERE g.lan = :lan"),
    @NamedQuery(name = "GiamGia.findByNgay", query = "SELECT g FROM GiamGia g WHERE g.ngay = :ngay"),
    @NamedQuery(name = "GiamGia.findByTg", query = "SELECT g FROM GiamGia g WHERE g.tg = :tg")})
public class GiamGia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SO_PHAN_TRAM")
    private BigDecimal soPhanTram;
    @Column(name = "LAN")
    private Integer lan;
    @Column(name = "NGAY")
    @Temporal(TemporalType.DATE)
    private Date ngay;
    @Column(name = "TG")
    @Temporal(TemporalType.TIME)
    private Date tg;
    @JoinColumn(name = "MAMH", referencedColumnName = "MAMH")
    @ManyToOne
    private MatHang mamh;

    public GiamGia() {
    }

    public GiamGia(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getSoPhanTram() {
        return soPhanTram;
    }

    public void setSoPhanTram(BigDecimal soPhanTram) {
        this.soPhanTram = soPhanTram;
    }

    public Integer getLan() {
        return lan;
    }

    public void setLan(Integer lan) {
        this.lan = lan;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Date getTg() {
        return tg;
    }

    public void setTg(Date tg) {
        this.tg = tg;
    }

    public MatHang getMamh() {
        return mamh;
    }

    public void setMamh(MatHang mamh) {
        this.mamh = mamh;
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
        if (!(object instanceof GiamGia)) {
            return false;
        }
        GiamGia other = (GiamGia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BHX_MODEL.Database.model.GiamGia[ id=" + id + " ]";
    }
    
}
