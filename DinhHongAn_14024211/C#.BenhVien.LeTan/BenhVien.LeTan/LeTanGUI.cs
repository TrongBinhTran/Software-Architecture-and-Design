using Apache.NMS;
using Apache.NMS.ActiveMQ;
using Apache.NMS.ActiveMQ.Commands;
using BenhVien.LeTan.Entity;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Common;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BenhVien.LeTan
{
    public partial class LeTanGUI : Form
    {
        bool daCo = false; //Lưu lại khi Lễ tân check id hoặc cmnd của bệnh nhân
        public LeTanGUI()
        {
            InitializeComponent();
        }

        private void btnLuuThongTin_Click_1(object sender, EventArgs e)
        {
            //Cập nhật hoặc update bệnh nhân. 
            SqlConnection connection = DBUtils.GetDBConnection();
            connection.Open();

            if (daCo == true)
            {
                //string sql = "UPDATE benhnhan SET socmnd=@cmnd, hoten=@hoten, diachi=@diachi WHERE msbn='@msbn'";
                string sql = "UPDATE benhnhan SET socmnd=" + txtcmnd.Text + ", hoten='" + txthoten.Text
                    + "', diachi='" + txtdiachi.Text + "' WHERE msbn='" + txtMaBenhNhan.Text + "'";
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = connection;
                cmd.CommandText = sql;
                //cmd.Parameters.Add("@msbn", SqlDbType.VarChar).Value = txtMaBenhNhan.Text;
                //cmd.Parameters.Add("@cmnd", SqlDbType.VarChar).Value = txtcmnd.Text;
                //cmd.Parameters.Add("@hoten", SqlDbType.VarChar).Value = txthoten.Text;
                //cmd.Parameters.Add("@diachi", SqlDbType.VarChar).Value = txtdiachi.Text;

                int rowCount = cmd.ExecuteNonQuery();
                if (rowCount > 0)
                {
                    MessageBox.Show("Đã cập nhật và gửi cho bác sỹ thành công!" + rowCount, "Thành công");
                }
            }
            else
            {
                //string sql = "INSERT INTO benhnhan (msbn, socmnd, hoten, diachi) "
                //                                 + " VALUES (@msbn, @socmnd, @hoten, @diachi) ";
                string sql = "INSERT INTO benhnhan (msbn, socmnd, hoten, diachi) "
                            + " VALUES ('" + txtMaBenhNhan.Text + "', '" + txtcmnd.Text 
                            + "', '" + txthoten.Text + "', '" + txtdiachi.Text + "') ";
                SqlCommand cmd = connection.CreateCommand();
                cmd.CommandText = sql;
                //cmd.Parameters.Add("@msbn", SqlDbType.VarChar).Value = txtMaBenhNhan.Text;
                //cmd.Parameters.Add("@socmnd", SqlDbType.VarChar).Value = txtcmnd.Text;
                //cmd.Parameters.Add("@hoten", SqlDbType.VarChar).Value = txthoten.Text;
                //cmd.Parameters.Add("@diachi", SqlDbType.VarChar).Value = txtdiachi.Text;
                int rowCount = cmd.ExecuteNonQuery();
                if (rowCount > 0)
                {
                    MessageBox.Show("Đã lưu và gửi cho bác sỹ thành công!" + rowCount, "Thành công");
                }
            }
            connection.Close();
            connection.Dispose();


            //Gửi mã bệnh nhân đến bác sỹ khám bệnh
            IConnectionFactory factory = new ConnectionFactory("tcp://localhost:61616");
            IConnection con = factory.CreateConnection("admin", "admin");
            con.Start();
            ISession session = con.CreateSession(AcknowledgementMode.AutoAcknowledge);
            ActiveMQQueue destination = new ActiveMQQueue("benhvien");
            IMessageProducer producer = session.CreateProducer(destination);
            string idBenhNhan = this.txtMaBenhNhan.Text;
            IMessage msg = new ActiveMQTextMessage(idBenhNhan);
            producer.Send(msg);

            session.Close();
            con.Close();


            //Xóa trắng
            txtMaBenhNhan.Text = "";
            txtcmnd.Text = "";
            txthoten.Text = "";
            txtdiachi.Text = "";
        }


        //Check mã bênh nhân nếu có sẽ tự điền thông tin, không thì hiện thông báo
        private void checkId_Click(object sender, EventArgs e)
        {
            SqlConnection conn = DBUtils.GetDBConnection();
            conn.Open();
            string sql = "Select msbn, socmnd, hoten, diachi from benhnhan where msbn='" + txtMaBenhNhan.Text + "'";

            SqlCommand cmd = new SqlCommand();

            cmd.Connection = conn;
            cmd.CommandText = sql;

            BenhNhan bn = new BenhNhan();

            using (DbDataReader reader = cmd.ExecuteReader())
            {
                if (reader.HasRows)
                {

                    while (reader.Read())
                    {
                        bn.msbn = reader.GetString(0);
                        bn.socmnd = reader.GetString(1);
                        bn.hoten = reader.GetString(2);
                        bn.diachi = reader.GetString(3);
                    }
                }
            }

            conn.Close();
            conn.Dispose();

            if (bn.socmnd == null || bn.hoten == null || bn.diachi == null)
            {
                MessageBox.Show("Không tìm thấy bệnh nhân có mã: " + txtMaBenhNhan.Text, "Không tìm thấy");
                daCo = false;
            }
            else
            {
                txtcmnd.Text = bn.socmnd;
                txthoten.Text = bn.hoten;
                txtdiachi.Text = bn.diachi;
                daCo = true;
            }
        }


        //Check số cmnd nếu có sẽ tự điền thông tin, không thì hiện thông báo
        private void checkCmnd_Click(object sender, EventArgs e)
        {
            SqlConnection conn = DBUtils.GetDBConnection();
            conn.Open();
            string sql = "Select msbn, socmnd, hoten, diachi from benhnhan where socmnd='" + txtcmnd.Text + "'";

            SqlCommand cmd = new SqlCommand();

            cmd.Connection = conn;
            cmd.CommandText = sql;

            BenhNhan bn = new BenhNhan();

            using (DbDataReader reader = cmd.ExecuteReader())
            {
                if (reader.HasRows)
                {

                    while (reader.Read())
                    {
                        bn.msbn = reader.GetString(0);
                        bn.socmnd = reader.GetString(1);
                        bn.hoten = reader.GetString(2);
                        bn.diachi = reader.GetString(3);
                    }
                }
            }

            conn.Close();
            conn.Dispose();

            if (bn.msbn == null || bn.hoten == null || bn.diachi == null)
            {
                MessageBox.Show("Không tìm thấy bệnh nhân có mã: " + txtcmnd.Text, "Không tìm thấy");
                daCo = false;
            }
            else
            {
                txtMaBenhNhan.Text = bn.msbn;
                txthoten.Text = bn.hoten;
                txtdiachi.Text = bn.diachi;
                daCo = true;
            }
        }
    }
}
