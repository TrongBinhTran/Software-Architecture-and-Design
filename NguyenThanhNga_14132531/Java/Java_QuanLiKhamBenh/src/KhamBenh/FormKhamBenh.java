package KhamBenh;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DatabaseAccess.DataHelper;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class FormKhamBenh extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMSBN;
	private JTextField textCMND;
	private JTextField textHoTen;
	private DefaultListModel<String> listModel;
	private JButton btnGoiKham;
	private JButton btnCapNhatThongTin;
	private JLabel lbGoiKham;
	private JList<String> listBenhNhan;
	private JLabel lbLuuThongTin;
	private JTextArea textAreaNoiDungKham;
	//a variable use for Receiver
	public static ArrayList<BenhNhan> danhSachBenhNhan = new ArrayList<BenhNhan>();
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormKhamBenh frame = new FormKhamBenh();
//					frame.setVisible(true);
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FormKhamBenh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 586);
		this.setLocation(1000, 150);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 51));
		contentPane.setForeground(new Color(255, 204, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("B\u00C1C S\u0128 KH\u00C1M B\u1EC6NH");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));

		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap(289, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
						.addGap(265))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 770, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
				);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder("Danh sách bệnh nhân chờ khám"));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createTitledBorder("Thông tin bệnh nhân được chọn"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(13, Short.MAX_VALUE))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
						.addContainerGap())
				);

		JLabel lblMSBnh = new JLabel("Mã số bệnh nhân: ");
		lblMSBnh.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textMSBN = new JTextField();
		textMSBN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textMSBN.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Số CMND: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textCMND = new JTextField();
		textCMND.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textCMND.setColumns(10);

		JLabel lblHTn = new JLabel("Họ tên: ");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textHoTen = new JTextField();
		textHoTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textHoTen.setColumns(10);

		JLabel lblaCh = new JLabel("Địa chỉ: ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createTitledBorder("Nội Dung Khám"));

		btnCapNhatThongTin = new JButton("Cập Nhật Thông Tin Khám Bệnh");
		btnCapNhatThongTin.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JScrollPane scrollPane_2 = new JScrollPane();
		
		lbLuuThongTin = new JLabel("");
		lbLuuThongTin.setForeground(Color.RED);
		lbLuuThongTin.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_2.createSequentialGroup()
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_2.createSequentialGroup()
										.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblHTn)
											.addComponent(lblNewLabel_1)
											.addComponent(lblMSBnh)
											.addComponent(lblaCh))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
											.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
											.addComponent(textCMND, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
											.addComponent(textMSBN, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
											.addComponent(textHoTen, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)))
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
								.addContainerGap())
							.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
								.addComponent(btnCapNhatThongTin)
								.addGap(112)))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(lbLuuThongTin)
							.addGap(154))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMSBnh)
						.addComponent(textMSBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textCMND, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHTn)
						.addComponent(textHoTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(46)
							.addComponent(lblaCh))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCapNhatThongTin)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbLuuThongTin)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		JTextArea textDiaChi = new JTextArea();
		textDiaChi.setFont(new Font("Monospaced", Font.BOLD, 18));
		scrollPane_2.setViewportView(textDiaChi);

		textAreaNoiDungKham = new JTextArea();
		textAreaNoiDungKham.setFont(new Font("Monospaced", Font.BOLD, 16));
		scrollPane.setViewportView(textAreaNoiDungKham);
		panel_2.setLayout(gl_panel_2);

		btnGoiKham = new JButton("Gọi Khám");
		btnGoiKham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGoiKham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JScrollPane scrollPane_1 = new JScrollPane();
		
		lbGoiKham = new JLabel("");
		lbGoiKham.setForeground(Color.RED);
		lbGoiKham.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(24)
							.addComponent(btnGoiKham, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lbGoiKham)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnGoiKham, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbGoiKham, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
		);
		listModel = new DefaultListModel<String>();
		listBenhNhan = new JList<String>();
		listBenhNhan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listBenhNhan.setModel(listModel);
		listBenhNhan.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int selectedInex = listBenhNhan.getSelectedIndex();
				if(selectedInex!=-1){
					BenhNhan bn = FormKhamBenh.danhSachBenhNhan.get(selectedInex);
					textMSBN.setText(bn.getMsbn());
					textHoTen.setText(bn.getHoTen());
					textDiaChi.setText(bn.getDiaChi());
					textCMND.setText(bn.getSoCMND());
					lbGoiKham.setText("");
					lbLuuThongTin.setText("");
				}	
			}
		});
		scrollPane_1.setViewportView(listBenhNhan);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		btnGoiKham.addActionListener(this);
		btnCapNhatThongTin.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnGoiKham)){
			//This code is not correct, i will fix it later (Show MSBN to another screen)
			lbGoiKham.setText("Da Goi Benh Nhan Vao Kham");
		}else{
			int removeIndex =-1;
			for(int i=0;i<listModel.size();i++){
				if(listModel.get(i).equals(textMSBN.getText())){
					removeIndex =i;
					break;
				}
			}
			if(removeIndex!=-1){
				listModel.remove(removeIndex);
				FormKhamBenh.danhSachBenhNhan.remove(removeIndex);
				//Update database
				String maSoBenhNhan = textMSBN.getText();
				//Another form will get maSoBacSy when login -- this code is not complete
				String maSoBacSy = "BS0001";
				LocalDateTime ngayKham = LocalDateTime.now();
				String ghiChu = textAreaNoiDungKham.getText();
				BangKhamBenh khamBenh = new BangKhamBenh(maSoBenhNhan, maSoBacSy, ngayKham, ghiChu);
				boolean isUpdate = DataHelper.insertData(khamBenh);
				if(isUpdate){
					lbLuuThongTin.setText("Da Luu Thong Tin");
					lbLuuThongTin.setForeground(Color.GREEN);
				}
				else{
					lbLuuThongTin.setText("Loi! Khong the cap nhat");
					lbLuuThongTin.setForeground(Color.RED);
				}
				lbGoiKham.setText("");
			}
		}
	}
	public void addItemToListModel(String item){
		listModel.addElement(item);
	}
}
