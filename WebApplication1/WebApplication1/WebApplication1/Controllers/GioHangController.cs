using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApplication1.Models;
namespace WebApplication1.Controllers
{
    public class GioHangController : Controller
    {
        // GET: GioHang
        dbConnectSQLDataContext db=new dbConnectSQLDataContext();
        public List<GioHang> layGioHang()
        {
            List<GioHang> lstGioHang = Session["GioHang"] as List<GioHang>;
            if(lstGioHang==null)
            {
                lstGioHang=new List<GioHang> ();
                Session["GioHang"] = lstGioHang;
            }
            return lstGioHang;
        }
        public ActionResult ThemVaoHang(string ma, string strUrl)
        {
            List<GioHang>lstGioHang = layGioHang();
            GioHang xemay = lstGioHang.Find(sp => sp.imaxemay == ma);
            if (xemay == null)
            {
                xemay = new GioHang(ma);
                lstGioHang.Add(xemay);
                return Redirect(strUrl);
            }
            else
            {
                xemay.soluong++;
                return Redirect(strUrl);
            }
        }
        private int TongSoLuong()
        {
            int tong = 0;
            List<GioHang> lstGioHang = Session["GioHang"] as List<GioHang>;
            if (lstGioHang != null)
            {
                tong = lstGioHang.Sum(sp => sp.soluong);
            }
            return tong;
        }
        private double TongThanhTien()
        {
            double tong1 = 0;
            List<GioHang> lstGioHang = Session["GioHang"] as List<GioHang>;
            if (lstGioHang != null)
            {
                tong1 += lstGioHang.Sum(sp => sp.thanhtien);

            }
            return tong1;
        }
        public ActionResult GioHang()
        {
            if (Session["GioHang"] == null)
            {
                return RedirectToAction("Index", "Home");

            }
            List<GioHang> lstGioHang = layGioHang();
            ViewBag.TongSoLuong = TongSoLuong();
            ViewBag.TongThanhTien = TongThanhTien();
            return View(lstGioHang);
        }
        public ActionResult XoaGioHang(string ma)
        {
            List<GioHang> lstGioHang = layGioHang();
            GioHang gh = lstGioHang.Single(d => d.imaxemay == ma);
            if(gh!=null)
            {
                lstGioHang.RemoveAll(s => s.imaxemay == ma);
                return RedirectToAction("GioHang", "GioHang");
            }
            else if(lstGioHang.Count==0)
            {
                return RedirectToAction("Index", "Home");
            }
            return RedirectToAction("GioHang", "GioHang");
        }
        public ActionResult XoaGioHangALL()
        {
            List<GioHang>lstGioHang=layGioHang();
            lstGioHang.Clear();
            return RedirectToAction("GioHang", "GioHang");
        }
        public ActionResult CapNhatGioHang(string ma, FormCollection f)
        {
            List<GioHang>lstgiohang=layGioHang();
            GioHang gh = lstgiohang.Single(d => d.imaxemay == ma);
            if (gh!=null)
            {
                gh.soluong = int.Parse(f["txtSoLuong"].ToString());
            }
            return RedirectToAction("GioHang", "GioHang");
        }
    }
}