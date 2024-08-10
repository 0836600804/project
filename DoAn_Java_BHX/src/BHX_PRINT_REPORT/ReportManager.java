package BHX_PRINT_REPORT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRBand;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignSection;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReportManager {

    private static ReportManager instance;

    private JasperReport reportHD;

    public static ReportManager getInstance() {
        if (instance == null) {
            instance = new ReportManager();
        }
        return instance;
    }

    private ReportManager() {
    }

    public void compileReport() throws JRException {
//        reportHD = JasperCompileManager.compileReport(getClass().getResourceAsStream("/BHX_PRINT_REPORT/report_HoaDon.jrxml"));
        reportHD = JasperCompileManager.compileReport("C:\\Users\\VanPhu\\JaspersoftWorkspace\\MyReports\\Blank_A4_Landscape.jrxml");
    }

    public void printReportHoaDon(ReportHoaDonObj data) throws JRException {
        Map para = new HashMap();
        para.put("ID_HOADON", data.getID_HOADON());
        para.put("NGAYLAP_HD", data.getNGAYLAP_HD());
        para.put("MANV", data.getMANV());
        para.put("MAKH", data.getMAKH());
        para.put("TONGTIEN_HD", data.getTONGTIEN_HD());
        para.put("TONGTIEN_GG", data.getTONGTIEN_GG());
        para.put("TIEN_KHACH_GUI", data.getTIEN_KHACH_GUI());
        para.put("TONG_SO_LUONG", data.getTONG_SO_LUONG());
        para.put("TONGTIEN_TL", data.getTONGTIEN_TL());
        int countItem = (data.getDanhSachCTHD().size() - 1) * 40;
        int defaultPageHeight = 330;

        JasperDesign jasper = JRXmlLoader.load("src\\BHX_PRINT_REPORT\\report_HoaDon.jrxml");
        jasper.setPageHeight(defaultPageHeight + countItem);
        JasperReport report2 = JasperCompileManager.compileReport(jasper);

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getDanhSachCTHD());
        JasperPrint print = JasperFillManager.fillReport(report2, para, dataSource);

        view(print);
    }

    private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }
}
