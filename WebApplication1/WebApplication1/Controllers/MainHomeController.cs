using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data;
using System.Data.SqlClient;
using WebApplication1.Models;
using System.Data.Linq;
using WebApplication1.Data;
using PagedList;


namespace WebApplication1.Controllers
{
    public class MainHomeController : Controller
    {
        // GET: MainHome
        dbConnectSQLDataContext db = new dbConnectSQLDataContext();
        public ActionResult XeMay8xemay()
        {
            var list = db.XEMAYs.Take(8).ToList();
            return View(list);

        }
        public ActionResult IndexMain()
        {
            var data = db.KHACHHANGs.ToList();
            return View();
        }
        public ActionResult XeMayMain(int ? page)
        {
            List<XEMAY> listProDuct = db.XEMAYs.ToList();
            int pageSize = 6;
            int pageNumber = (page ?? 1); // Trang mặc định là 1 nếu không có trang được chỉ định
            IPagedList<XEMAY> pagedProducts = listProDuct.ToPagedList(pageNumber, pageSize);
            return View(pagedProducts);
            
        }
        [HttpGet]
        public ActionResult DangKyTK()
        {
            return View();

        }
        [HttpPost]
        public ActionResult DangKyTK(KHACHHANG formCollection)
        {
            try
            {
                db.KHACHHANGs.InsertOnSubmit(formCollection);
                db.SubmitChanges();
                return RedirectToAction("DangNhapTK", "MainHome");
            }
            catch
            {
                return View();
            }
        }
        
        [HttpGet]
        public ActionResult DangNhapTK()
        {
            return View();
        }
        [HttpPost]
        public ActionResult DangNhapTK(FormCollection f)
        {
            var tendn = f["TenDN"];
            var matkhau = f["MatKhau"];
            KHACHHANG kh = db.KHACHHANGs.SingleOrDefault(c => c.TAIKHOAN == tendn && c.MATKHAU == matkhau);
            if (kh != null)
            {
                ViewBag.TB = "Đăng nhập thành công";
                Session["taikhoan"] = kh;
                return RedirectToAction("Index", "Home");
            }
            else
            {
                ViewBag.TB = "Sai tên đăng nhập hoặc sai mật khấu. Vui lòng nhập lại !";
            }
            return View();
        }
    }
}