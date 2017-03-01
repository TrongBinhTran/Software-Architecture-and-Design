using System;
using System.Data;
using System.Linq;
using System.Windows.Forms;
using SentMessage;
namespace QuanLiKhamBenh
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {
            panel1.BorderStyle = BorderStyle.Fixed3D;
        }

        private void label1_Click(object sender, EventArgs e)
        {
            
        }

        private void label3_Click(object sender, EventArgs e)
        {
            label3.Text = "Mã Số Bệnh Nhân:";
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        DataClassesDataContext dbContext = new DataClassesDataContext();
        private void button1_Click_1(object sender, EventArgs e)
        {
            //Connect Database and find patient
            string maSo = textBoxMaSoBenhNhan.Text;
            var result = from table in dbContext.benhnhans
                     where table.msbn == maSo
                     select table;
            if (result.Count() > 0)
            {
                //Show info
                var bn = result.FirstOrDefault();
                textBoxCMND.Text = bn.socmnd;
                textBoxHoTen.Text = bn.hoten;
                richTextBoxDiaChi.Text = bn.diachi;
            }
        }
       // DataClassesDataContext dbContext = new DataClassesDataContext();
        private void buttonTimCMND_Click(object sender, EventArgs e)
        {
            //Connect Database and find patient
            string soCMND = textBoxCMND.Text;
            var result = from table in dbContext.benhnhans
                         where table.socmnd == soCMND
                         select table;
            if (result.Count() > 0)
            {
                //Show info
                var bn = result.FirstOrDefault();
                textBoxMaSoBenhNhan.Text = bn.msbn;
                textBoxHoTen.Text = bn.hoten;
                richTextBoxDiaChi.Text = bn.diachi;
            }
        }
        benhnhan benhNhan = new benhnhan();
        private void button1_Click(object sender, EventArgs e)
        {
            string maSoBenhNhan = textBoxMaSoBenhNhan.Text;
            string CMND = textBoxCMND.Text;
            string hoTen = textBoxHoTen.Text;
            string diaChi = richTextBoxDiaChi.Text;
            benhNhan bn = new benhNhan(maSoBenhNhan, hoTen, CMND, diaChi);
            Console.WriteLine(bn.ToString());
            //sent to doctor
            Sender.sentXMLInfo(bn);
            //check and insert into database
            string maSo = textBoxMaSoBenhNhan.Text;
            var result = from table in dbContext.benhnhans
                         where table.msbn == maSo
                         select table;
            if (result.Count() == 0)
            {
                benhNhan.msbn = textBoxMaSoBenhNhan.Text;
                benhNhan.socmnd = textBoxCMND.Text;
                benhNhan.hoten = textBoxHoTen.Text;
                benhNhan.diachi = richTextBoxDiaChi.Text;   
                dbContext.benhnhans.InsertOnSubmit(benhNhan);
                dbContext.SubmitChanges();
            }
            labelMess.Text = "Da Cap Nhat";
            //this code is use to sent my format string
            // string info = maSoBenhNhan + ";" + CMND + ";" + hoTen + ";" + diaChi;
            //Sender.sentString(info);
        }

        private void button1_Click_2(object sender, EventArgs e)
        {
            textBoxMaSoBenhNhan.Text = "";
            textBoxCMND.Text = "";
            textBoxHoTen.Text = "";
            richTextBoxDiaChi.Text = "";
            labelMess.Text = "";
        }
    }
}
