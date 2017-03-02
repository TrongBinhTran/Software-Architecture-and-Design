namespace BenhVien.LeTan
{
    partial class LeTanGUI
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.btnLuuThongTin = new System.Windows.Forms.Button();
            this.txtdiachi = new System.Windows.Forms.RichTextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.checkCmnd = new System.Windows.Forms.Button();
            this.txthoten = new System.Windows.Forms.TextBox();
            this.txtcmnd = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.checkId = new System.Windows.Forms.Button();
            this.txtMaBenhNhan = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 16.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(215, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(179, 32);
            this.label1.TabIndex = 0;
            this.label1.Text = "NHẬN BỆNH";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.btnLuuThongTin);
            this.groupBox1.Controls.Add(this.txtdiachi);
            this.groupBox1.Controls.Add(this.label5);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.checkCmnd);
            this.groupBox1.Controls.Add(this.txthoten);
            this.groupBox1.Controls.Add(this.txtcmnd);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.checkId);
            this.groupBox1.Controls.Add(this.txtMaBenhNhan);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Location = new System.Drawing.Point(12, 55);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(597, 309);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Thông tin bệnh nhân";
            // 
            // btnLuuThongTin
            // 
            this.btnLuuThongTin.Location = new System.Drawing.Point(225, 250);
            this.btnLuuThongTin.Name = "btnLuuThongTin";
            this.btnLuuThongTin.Size = new System.Drawing.Size(118, 43);
            this.btnLuuThongTin.TabIndex = 10;
            this.btnLuuThongTin.Text = "Lưu thông tin";
            this.btnLuuThongTin.UseVisualStyleBackColor = true;
            this.btnLuuThongTin.Click += new System.EventHandler(this.btnLuuThongTin_Click_1);
            // 
            // txtdiachi
            // 
            this.txtdiachi.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtdiachi.Location = new System.Drawing.Point(151, 119);
            this.txtdiachi.Name = "txtdiachi";
            this.txtdiachi.ScrollBars = System.Windows.Forms.RichTextBoxScrollBars.Vertical;
            this.txtdiachi.Size = new System.Drawing.Size(315, 112);
            this.txtdiachi.TabIndex = 9;
            this.txtdiachi.Text = "";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(19, 119);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(55, 17);
            this.label5.TabIndex = 8;
            this.label5.Text = "Địa chỉ:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(19, 91);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(73, 17);
            this.label4.TabIndex = 7;
            this.label4.Text = "Họ và tên:";
            // 
            // checkCmnd
            // 
            this.checkCmnd.Location = new System.Drawing.Point(484, 60);
            this.checkCmnd.Name = "checkCmnd";
            this.checkCmnd.Size = new System.Drawing.Size(75, 23);
            this.checkCmnd.TabIndex = 6;
            this.checkCmnd.Text = "Check";
            this.checkCmnd.UseVisualStyleBackColor = true;
            this.checkCmnd.Click += new System.EventHandler(this.checkCmnd_Click);
            // 
            // txthoten
            // 
            this.txthoten.Location = new System.Drawing.Point(151, 88);
            this.txthoten.Name = "txthoten";
            this.txthoten.Size = new System.Drawing.Size(315, 22);
            this.txthoten.TabIndex = 5;
            // 
            // txtcmnd
            // 
            this.txtcmnd.Location = new System.Drawing.Point(151, 60);
            this.txtcmnd.Name = "txtcmnd";
            this.txtcmnd.Size = new System.Drawing.Size(315, 22);
            this.txtcmnd.TabIndex = 4;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(19, 63);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(73, 17);
            this.label3.TabIndex = 3;
            this.label3.Text = "Số CMND:";
            // 
            // checkId
            // 
            this.checkId.Location = new System.Drawing.Point(484, 31);
            this.checkId.Name = "checkId";
            this.checkId.Size = new System.Drawing.Size(75, 23);
            this.checkId.TabIndex = 2;
            this.checkId.Text = "Check";
            this.checkId.UseVisualStyleBackColor = true;
            this.checkId.Click += new System.EventHandler(this.checkId_Click);
            // 
            // txtMaBenhNhan
            // 
            this.txtMaBenhNhan.Location = new System.Drawing.Point(151, 31);
            this.txtMaBenhNhan.Name = "txtMaBenhNhan";
            this.txtMaBenhNhan.Size = new System.Drawing.Size(315, 22);
            this.txtMaBenhNhan.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(19, 34);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(126, 17);
            this.label2.TabIndex = 0;
            this.label2.Text = "Mã số bệnh nhân: ";
            // 
            // LeTanGUI
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(620, 373);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.label1);
            this.Name = "LeTanGUI";
            this.Text = "Form1";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button btnLuuThongTin;
        private System.Windows.Forms.RichTextBox txtdiachi;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button checkCmnd;
        private System.Windows.Forms.TextBox txthoten;
        private System.Windows.Forms.TextBox txtcmnd;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button checkId;
        private System.Windows.Forms.TextBox txtMaBenhNhan;
        private System.Windows.Forms.Label label2;
    }
}

