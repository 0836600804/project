﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApplication1.Models;
namespace WebApplication1.Controllers
{
    public class LoaiXeController : Controller
    {
        // GET: LoaiXe
        dbConnectSQLDataContext db = new dbConnectSQLDataContext();
        public ActionResult LoaiXe()
        {
            var list = db.LOAIXEs.ToList();
            return View(list);
        }
    }
}