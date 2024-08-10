package BHX_PRINT_REPORT;

public class ReportChiTietHoaDonObj {

    private String TENMH;
    private String SOLUONG;
    private String GIA_BAN;
    private String THANH_TIEN_GG;
    private String THANH_TIEN;

    public String getTENMH() {
        return TENMH;
    }

    public void setTENMH(String TENMH) {
        this.TENMH = TENMH;
    }

    public String getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(String SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public String getGIA_BAN() {
        return GIA_BAN;
    }

    public void setGIA_BAN(String GIA_BAN) {
        this.GIA_BAN = GIA_BAN;
    }

    public String getTHANH_TIEN_GG() {
        return THANH_TIEN_GG;
    }

    public void setTHANH_TIEN_GG(String THANH_TIEN_GG) {
        this.THANH_TIEN_GG = THANH_TIEN_GG;
    }

    public String getTHANH_TIEN() {
        return THANH_TIEN;
    }

    public void setTHANH_TIEN(String THANH_TIEN) {
        this.THANH_TIEN = THANH_TIEN;
    }

    public ReportChiTietHoaDonObj() {

    }

    public ReportChiTietHoaDonObj(String TENMH, String SOLUONG, String GIA_BAN, String THANH_TIEN_GG, String THANH_TIEN) {
        this.TENMH = TENMH;
        this.SOLUONG = SOLUONG;
        this.GIA_BAN = GIA_BAN;
        this.THANH_TIEN_GG = THANH_TIEN_GG;
        this.THANH_TIEN = THANH_TIEN;
    }
}
