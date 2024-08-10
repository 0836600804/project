using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Linq;
using WebApplication1.Models;
namespace WebApplication1.Data
{
    public class MyDbContext : DataContext
    {
        public Table<KHACHHANG> Accounts;

        public MyDbContext(string connection) : base(connection) { }
    }

}