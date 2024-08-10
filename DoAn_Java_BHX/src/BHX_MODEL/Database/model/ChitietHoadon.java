/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_MODEL.Database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VanPhu
 */
@Entity
@Table(name = "CHITIET_HOADON")
@XmlRootElement
@NamedQueries({
      @NamedQuery(name = "ChitietHoadon.findAll", query = "SELECT c FROM ChitietHoadon c"),
      @NamedQuery(name = "ChitietHoadon.findByIdHoadon", query = "SELECT c FROM ChitietHoadon c WHERE c.chitietHoadonPK.idHoadon = :idHoadon"),
      @NamedQuery(name = "ChitietHoadon.findByMamh", query = "SELECT c FROM ChitietHoadon c WHERE c.chitietHoadonPK.mamh = :mamh"),
      @NamedQuery(name = "ChitietHoadon.findBySoluong", query = "SELECT c FROM ChitietHoadon c WHERE c.soluong = :soluong"),
      @NamedQuery(name = "ChitietHoadon.findByThanhTien", query = "SELECT c FROM ChitietHoadon c WHERE c.thanhTien = :thanhTien"),
      @NamedQuery(name = "ChitietHoadon.findByThanhTienGg", query = "SELECT c FROM ChitietHoadon c WHERE c.thanhTienGg = :thanhTienGg") })
public class ChitietHoadon implements Serializable {

   private static final long serialVersionUID = 1L;
   @EmbeddedId
   protected ChitietHoadonPK chitietHoadonPK;
   // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
   // consider using these annotations to enforce field validation
   @Column(name = "SOLUONG")
   private BigDecimal soluong;
   @Column(name = "THANH_TIEN")
   private BigDecimal thanhTien;
   @Column(name = "THANH_TIEN_GG")
   private BigDecimal thanhTienGg;
   @JoinColumn(name = "ID_HOADON", referencedColumnName = "ID_HOADON", insertable = false, updatable = false)
   @ManyToOne(optional = false)
   private Hoadon hoadon;
   @JoinColumn(name = "MAMH", referencedColumnName = "MAMH", insertable = false, updatable = false)
   @ManyToOne(optional = false)
   private MatHang matHang;

   public ChitietHoadon() {
   }

   public ChitietHoadon(ChitietHoadonPK chitietHoadonPK) {
      this.chitietHoadonPK = chitietHoadonPK;
   }

   public ChitietHoadon(String idHoadon, String mamh) {
      this.chitietHoadonPK = new ChitietHoadonPK(idHoadon, mamh);
   }

   public ChitietHoadonPK getChitietHoadonPK() {
      return chitietHoadonPK;
   }

   public void setChitietHoadonPK(ChitietHoadonPK chitietHoadonPK) {
      this.chitietHoadonPK = chitietHoadonPK;
   }

   public BigDecimal getSoluong() {
      return soluong;
   }

   public void setSoluong(BigDecimal soluong) {
      this.soluong = soluong;
   }

   public BigDecimal getThanhTien() {
      return thanhTien;
   }

   public void setThanhTien(BigDecimal thanhTien) {
      this.thanhTien = thanhTien;
   }

   public BigDecimal getThanhTienGg() {
      return thanhTienGg;
   }

   public void setThanhTienGg(BigDecimal thanhTienGg) {
      this.thanhTienGg = thanhTienGg;
   }

   public Hoadon getHoadon() {
      return hoadon;
   }

   public void setHoadon(Hoadon hoadon) {
      this.hoadon = hoadon;
   }

   public MatHang getMatHang() {
      return matHang;
   }

   public void setMatHang(MatHang matHang) {
      this.matHang = matHang;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (chitietHoadonPK != null ? chitietHoadonPK.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof ChitietHoadon)) {
         return false;
      }
      ChitietHoadon other = (ChitietHoadon) object;
      if ((this.chitietHoadonPK == null && other.chitietHoadonPK != null)
            || (this.chitietHoadonPK != null && !this.chitietHoadonPK.equals(other.chitietHoadonPK))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "BHX_MODEL.Database.model.ChitietHoadon[ chitietHoadonPK=" + chitietHoadonPK + " ]";
   }

}
