using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApplication1.Models;
namespace WebApplication1.Controllers
{
    public class ThuongHieuXeController : Controller
    {
        // GET: ThuongHieuXe
        dbConnectSQLDataContext db = new dbConnectSQLDataContext();
        public ActionResult ThuongHieuXe()
        {
            var list = db.THUONGHIEUXEs.ToList();
            return View(list);
        }
    }
}