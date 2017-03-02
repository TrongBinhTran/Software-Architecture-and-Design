package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import org.apache.log4j.BasicConfigurator;

import data.BenhNhan;
import helper.DatabaseConnection;

public class BacSiGui extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton btnCapNhat;
	private javax.swing.JButton btnGoiKham;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JList<String> jListBenhNhanChoKham;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTextArea jTextDiaChi;
	private javax.swing.JTextArea jTextAreaNoiDungKham;
	private javax.swing.JTextField txtCmnd;
	private javax.swing.JTextField txtHoTen;
	private javax.swing.JTextField txtIdBenhNhan;
	public DefaultListModel<String> listBenhNhan = new DefaultListModel<String>();
	private String msbacsy;

	public BacSiGui(String title, String msbacsy) {
		super(title);
		this.msbacsy = msbacsy;
		initComponents();
	}

	private void initComponents(){

		setResizable(false);
		jScrollPane2 = new javax.swing.JScrollPane();
		jListBenhNhanChoKham = new javax.swing.JList<>();
		btnGoiKham = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		txtIdBenhNhan = new javax.swing.JTextField();
		txtCmnd = new javax.swing.JTextField();
		txtHoTen = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextDiaChi = new javax.swing.JTextArea();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTextAreaNoiDungKham = new javax.swing.JTextArea();
		btnCapNhat = new javax.swing.JButton();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		jListBenhNhanChoKham.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách bệnh nhân chờ khám"));
		jScrollPane2.setViewportView(jListBenhNhanChoKham);
		jListBenhNhanChoKham.setModel(listBenhNhan);

		btnGoiKham.setText("Gọi khám...");

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin bệnh nhân được chọn"));

		jLabel1.setText("Mã số bệnh nhân:");

		jLabel2.setText("Số CMND:");

		jLabel3.setText("Họ tên:");

		jTextDiaChi.setColumns(20);
		jTextDiaChi.setRows(5);
		jScrollPane1.setViewportView(jTextDiaChi);

		jLabel4.setText("Địa chỉ:");

		jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Nội dung khám"));

		jTextAreaNoiDungKham.setColumns(20);
		jTextAreaNoiDungKham.setRows(5);
		jScrollPane3.setViewportView(jTextAreaNoiDungKham);

		txtIdBenhNhan.setEditable(false);
		txtHoTen.setEditable(false);
		txtCmnd.setEditable(false);

		btnCapNhat.setText("Cập nhật thông tin khám bệnh");
		btnGoiKham.addActionListener(this);
		btnCapNhat.addActionListener(this);

		jListBenhNhanChoKham.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(
						jPanel1Layout
								.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(
										jPanel1Layout.createSequentialGroup().addContainerGap()
												.addGroup(
														jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(jLabel3).addComponent(jLabel1)
																.addComponent(jLabel2).addComponent(jLabel4))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(
														jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jScrollPane1).addComponent(txtIdBenhNhan)
																.addComponent(txtCmnd,
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		javax.swing.GroupLayout.DEFAULT_SIZE, 256,
																		Short.MAX_VALUE)
																.addComponent(txtHoTen,
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		javax.swing.GroupLayout.DEFAULT_SIZE, 256,
																		Short.MAX_VALUE))
												.addContainerGap())
								.addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(92, 92, 92)
										.addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 204,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(txtIdBenhNhan,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(txtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(
										jPanel1Layout.createSequentialGroup().addGap(35, 35, 35).addComponent(jLabel4))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnGoiKham, javax.swing.GroupLayout.PREFERRED_SIZE, 209,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(jScrollPane2)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnGoiKham, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		pack();
		setLocationRelativeTo(null);
		
		try {
			nhanBenhNhan();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGoiKham) {
			int bn = jListBenhNhanChoKham.getSelectedIndex();
			if (bn < 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn bênh nhân ngọi khám", "Chưa chọn bệnh nhân!",
						JOptionPane.OK_OPTION);
				return;
			}
			String msbn = listBenhNhan.getElementAt(bn);
			listBenhNhan.removeElementAt(bn);
			DatabaseConnection s = new DatabaseConnection();
			s.getConnection();
			try {
				Statement stm = s.con.createStatement();
				ResultSet rs = stm.executeQuery("SELECT socmnd, hoten, diachi FROM benhnhan WHERE msbn='" + msbn + "'");
				while (rs.next()) {
					BenhNhan benhNhan = new BenhNhan(msbn, rs.getString(1), rs.getString(2), rs.getString(3));
					System.out.println(benhNhan);
					txtHoTen.setText(benhNhan.getHoten());
					txtIdBenhNhan.setText(benhNhan.getMsbn());
					txtCmnd.setText(benhNhan.getSocmnd());
					jTextDiaChi.setText(benhNhan.getDiachi());
				}
				s.getClose(rs, stm);
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		}
		if (e.getSource() == btnCapNhat) {
			DatabaseConnection s = new DatabaseConnection();
			s.getConnection();
			try {
				Statement stm = s.con.createStatement();
				int rs1 = stm.executeUpdate("UPDATE benhnhan SET diachi='" + jTextDiaChi.getText() + "' WHERE msbn='"
						+ txtIdBenhNhan.getText() + "'");
				Statement stm2 = s.con.createStatement();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date date = new Date();
				int rs2 = stm2.executeUpdate("INSERT INTO khambenh VALUES ('" + txtIdBenhNhan.getText()
						+ "', '"+msbacsy+"', '" + dateFormat.format(date) + "', '" + jTextAreaNoiDungKham.getText() + "')");
				if (rs1>0 && rs2>0) {
					JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "Hoàn thành!", JOptionPane.OK_OPTION);
					xoaTrang();
				}
				s.getClose(stm);
				s.getClose(stm2);
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		}
	}
	
	private void xoaTrang(){
		txtCmnd.setText("");
		txtHoTen.setText("");
		txtIdBenhNhan.setText("");
		jTextDiaChi.setText("");
		jTextAreaNoiDungKham.setText("");
	}

	public void nhanBenhNhan() throws Exception{
		BasicConfigurator.configure();
		Properties settings = new Properties();
		settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		Context ctx = new InitialContext(settings);
		Object obj = ctx.lookup("ConnectionFactory");
		ConnectionFactory factory = (ConnectionFactory) obj;
		Destination destination = (Destination) ctx.lookup("dynamicQueues/benhvien");
		Connection con = factory.createConnection("admin", "admin");
		con.start();
		Session session = con.createSession(false, Session.CLIENT_ACKNOWLEDGE);
		MessageConsumer receiver = session.createConsumer(destination);
		System.out.println(this.msbacsy + " doi benh nhan...");
		receiver.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message msg) {
				try {
					if (msg instanceof TextMessage) {
						TextMessage tm = (TextMessage) msg;
						String txt = tm.getText();
						listBenhNhan.addElement(txt);
						System.out.println(msbacsy + " nhan benh nhan: " + txt);
						msg.acknowledge();
					} else if (msg instanceof ObjectMessage) {
						ObjectMessage om = (ObjectMessage) msg;
						System.out.println(om);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
//	public void main(String[] args)  {
//		BacSiGui gui = new BacSiGui("Bác Sỹ 1", "bs1001");
//		gui.setLocationRelativeTo(null);
//		gui.setVisible(true);
//	}
}
