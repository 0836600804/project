using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApplication1.Models;
namespace WebApplication1.Controllers
{
    public class XeMayController : Controller
    {
        dbConnectSQLDataContext db =new dbConnectSQLDataContext();
        // GET: XeMay
        public ActionResult XeMay()
        {
            return View(db.XEMAYs.OrderBy(s=>s.TENXEMAY).ToList());
        }
        public ActionResult timXeMay(string txt_Search)
        {
            var list = db.XEMAYs.Where(s => s.TENXEMAY.Contains(txt_Search)).ToList();

            int sl = list.Count;
            ViewBag.SL = sl;
            return View(list);
        }   
        public ActionResult XeMayTheoLoai(string MaLoai)
        {
            var listXe =db.XEMAYs.Where(t=>t.MALOAIXE == MaLoai).ToList();
            if(listXe.Count==0)
            {
                ViewBag.TB = "Không tìm thấy loại xe cần tìm";
            }    
            return View(listXe);
        }
        public ActionResult XeMayTheoHang(string MaHang) 
        {
            var listHang = db.XEMAYs.Where(s => s.MATHUONGHIEU == MaHang).ToList();
            if(listHang.Count==0)
            {
                ViewBag.TB = "Không tìm thấy hãng xe cần tìm.";
            }
            return View(listHang);
        }
        public ActionResult XemThongTinXe(string MaXe)
        {
            XEMAY listxemmay = db.XEMAYs.Single(s => s.MAXEMAY == MaXe);
            if (listxemmay == null)
            { 
                return HttpNotFound(); 
            }    
              
            return View(listxemmay);
        }
        

    }
}