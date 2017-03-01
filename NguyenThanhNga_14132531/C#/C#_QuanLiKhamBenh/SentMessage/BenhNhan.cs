using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SentMessage
{
    [Serializable]
   public class benhNhan
    {
        public string msbn { set; get; }
        public string hoTen { set; get; }
        public string soCMND { set; get; }
        public string diaChi { set; get; }
        public benhNhan() : this("", "", "", "") { }
        public benhNhan(string maso, string hoten,string cmnd, string diachi)
        {
            this.msbn = maso;
            this.hoTen = hoten;
            this.soCMND = cmnd;
            this.diaChi = diachi;
        }
    }
}
