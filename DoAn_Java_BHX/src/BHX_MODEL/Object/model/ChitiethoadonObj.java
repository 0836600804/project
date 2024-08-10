package BHX_MODEL.Object.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class ChitiethoadonObj {

    private String maHD;
    private String maSp;
    private String tenSp;
    private String hinhAnhSp;
    private String dvt;
    private String ID;
    private String isKilogram;
    private BigDecimal giaBanSp;
    private BigDecimal giamGia;
    private BigDecimal soLuong;

    public ChitiethoadonObj() {
    }

    public ChitiethoadonObj(String maHD, String maSp, String tenSp, String hinhAnhSp, String dvt, String ID, BigDecimal giaBanSp, BigDecimal giamGia, BigDecimal soLuong, String isKilogram) {
        this.maHD = maHD;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.hinhAnhSp = hinhAnhSp;
        this.dvt = dvt;
        this.giaBanSp = giaBanSp;
        this.ID = ID;
        this.giamGia = giamGia;
        this.soLuong = soLuong;
        this.isKilogram = isKilogram;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getHinhAnhSp() {
        return hinhAnhSp;
    }

    public void setHinhAnhSp(String hinhAnhSp) {
        this.hinhAnhSp = hinhAnhSp;
    }

    public BigDecimal getGiaBanSp() {
        return giaBanSp;
    }

    public String getIsKilogram() {
        return isKilogram;
    }

    public void setIsKilogram(String isKilogram) {
        this.isKilogram = isKilogram;
    }

    public void setGiaBanSp(BigDecimal giaBanSp) {
        this.giaBanSp = giaBanSp;
    }

    public BigDecimal getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(BigDecimal giamGia) {
        this.giamGia = giamGia;
    }

    public BigDecimal getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(BigDecimal soLuong) {
        this.soLuong = soLuong;
    }

    public static String formatterCurrencyVND(BigDecimal price) {
        Locale locale = new Locale("vi", "VN");
        Currency currency = Currency.getInstance("VND");
        DecimalFormatSymbols df = DecimalFormatSymbols.getInstance(locale);
        df.setCurrency(currency);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        numberFormat.setCurrency(currency);
        return numberFormat.format(price);
    }

    public BigDecimal getTienGiamGia() {
        double doubleValue = ((this.giamGia.doubleValue() * this.giaBanSp.doubleValue()) / 100.0) * this.soLuong.doubleValue();
        BigDecimal bigDecimalValue = new BigDecimal(doubleValue);
        return bigDecimalValue;
    }

    public BigDecimal getThanhTien() {
        double doubleValue = (this.giaBanSp.doubleValue() * this.soLuong.doubleValue()) - getTienGiamGia().doubleValue();
        BigDecimal bigDecimalValue = new BigDecimal(doubleValue);
        return bigDecimalValue;
    }

    public BigDecimal getGiaSauGiam() {
        double doubleValue = ((100.0 - this.giamGia.doubleValue()) / 100.0) * this.giaBanSp.doubleValue();
        BigDecimal bigDecimalValue = new BigDecimal(doubleValue);
        return bigDecimalValue;
    }

    public Object[] toRowTable(int index) {
        if (this.isKilogram.toLowerCase().equals("false")) {
            return new Object[]{index, this.maSp, this.tenSp, this.hinhAnhSp, this.dvt, formatterCurrencyVND(this.giaBanSp.setScale(5, RoundingMode.HALF_UP)), this.giamGia.setScale(2, RoundingMode.HALF_UP) + " %", formatterCurrencyVND(this.getGiaSauGiam().setScale(5, RoundingMode.HALF_UP)), this.soLuong.setScale(0, RoundingMode.HALF_UP), formatterCurrencyVND(this.getThanhTien().setScale(5, RoundingMode.HALF_UP))};
        }
        return new Object[]{index, this.maSp, this.tenSp, this.hinhAnhSp, this.dvt, formatterCurrencyVND(this.giaBanSp.setScale(5, RoundingMode.HALF_UP)), this.giamGia.setScale(2, RoundingMode.HALF_UP) + " %", formatterCurrencyVND(this.getGiaSauGiam().setScale(5, RoundingMode.HALF_UP)), this.soLuong.setScale(3, RoundingMode.HALF_UP), formatterCurrencyVND(this.getThanhTien().setScale(5, RoundingMode.HALF_UP))};
    }
}
