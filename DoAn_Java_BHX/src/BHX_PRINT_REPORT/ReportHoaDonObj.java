package BHX_PRINT_REPORT;

import java.util.ArrayList;

public class ReportHoaDonObj {

    private String ID_HOADON;
    private String NGAYLAP_HD;
    private String MANV;
    private String MAKH;
    private String TONGTIEN_HD;
    private String TONGTIEN_GG;
    private String TIEN_KHACH_GUI;
    private String TONG_SO_LUONG;
    private String TONGTIEN_TL;

    public void setTONGTIEN_HD(String TONGTIEN_HD) {
        this.TONGTIEN_HD = TONGTIEN_HD;
    }

    public void setTONGTIEN_GG(String TONGTIEN_GG) {
        this.TONGTIEN_GG = TONGTIEN_GG;
    }

    public void setTIEN_KHACH_GUI(String TIEN_KHACH_GUI) {
        this.TIEN_KHACH_GUI = TIEN_KHACH_GUI;
    }

    public void setTONG_SO_LUONG(String TONG_SO_LUONG) {
        this.TONG_SO_LUONG = TONG_SO_LUONG;
    }

    public void setTONGTIEN_TL(String TONGTIEN_TL) {
        this.TONGTIEN_TL = TONGTIEN_TL;
    }
    private ArrayList<ReportChiTietHoaDonObj> danhSachCTHD;

    public String getTONGTIEN_HD() {
        return TONGTIEN_HD;
    }

    public String getTONGTIEN_GG() {
        return TONGTIEN_GG;
    }

    public String getTIEN_KHACH_GUI() {
        return TIEN_KHACH_GUI;
    }

    public String getTONG_SO_LUONG() {
        return TONG_SO_LUONG;
    }

    public String getTONGTIEN_TL() {
        return TONGTIEN_TL;
    }

    public ArrayList<ReportChiTietHoaDonObj> getDanhSachCTHD() {
        return danhSachCTHD;
    }

    public void setDanhSachCTHD(ArrayList<ReportChiTietHoaDonObj> danhSachCTHD) {
        this.danhSachCTHD = danhSachCTHD;
    }

    public String getID_HOADON() {
        return ID_HOADON;
    }

    public void setID_HOADON(String ID_HOADON) {
        this.ID_HOADON = ID_HOADON;
    }

    public String getNGAYLAP_HD() {
        return NGAYLAP_HD;
    }

    public void setNGAYLAP_HD(String NGAYLAP_HD) {
        this.NGAYLAP_HD = NGAYLAP_HD;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

    public ReportHoaDonObj() {

    }

    public ReportHoaDonObj(String ID_HOADON, String NGAYLAP_HD, String MANV, String MAKH, ArrayList<ReportChiTietHoaDonObj> danhSachCTHD) {
        this.ID_HOADON = ID_HOADON;
        this.NGAYLAP_HD = NGAYLAP_HD;
        this.MANV = MANV;
        this.MAKH = MAKH;
        this.danhSachCTHD = danhSachCTHD;
    }
}
