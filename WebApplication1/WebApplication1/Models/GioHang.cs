using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WebApplication1.Models;
namespace WebApplication1.Models
{
    public class GioHang
    {
        dbConnectSQLDataContext db=new dbConnectSQLDataContext();
        public string imaxemay { get; set; }
        public string itenxemay { get; set; }
        public string ihinhanh { get; set; }
        public double dongia { get; set; }
        public int soluong { get; set; }
        public double thanhtien
        {
            get { return soluong * dongia; }
        }
        public GioHang(string Ma)
        {
            imaxemay= Ma;
            XEMAY xemay = db.XEMAYs.Single(s => s.MAXEMAY == imaxemay);
            itenxemay = xemay.TENXEMAY;
            ihinhanh = xemay.HINHANH;
            dongia = double.Parse(xemay.GIABANXE.ToString());
            soluong = 1;
        }
    }
}