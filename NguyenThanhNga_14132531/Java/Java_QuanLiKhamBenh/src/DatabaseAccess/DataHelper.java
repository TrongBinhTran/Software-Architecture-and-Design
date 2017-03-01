package DatabaseAccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import KhamBenh.BangKhamBenh;

public class DataHelper {
	public static boolean insertData(BangKhamBenh bangKhamBenh){
		String sql = "insert into khambenh values(?,?,?,?)";
		int date = bangKhamBenh.getNgayKham().getDayOfMonth();
		int month = bangKhamBenh.getNgayKham().getMonthValue();
		int year = bangKhamBenh.getNgayKham().getYear();
		@SuppressWarnings("deprecation")
		java.sql.Date myDate = new java.sql.Date(year-1900, month-1,date);
		
		//check unique 
		Connection  connection = SQLServerConnection.getInstance();
		String sql2 ="select msbn from khambenh where msbn = ? and msbacsy = ? and ngaykham = ?";
		PreparedStatement preSt2;
		try {
			preSt2 = connection.prepareStatement(sql2);
			preSt2.setString(1, bangKhamBenh.getMsbn());
			preSt2.setString(2, bangKhamBenh.getMsbacsy());
			preSt2.setDate(3, myDate);
			ResultSet res = preSt2.executeQuery();
			if(res.next()){
				//update ghiChu
				if(DataHelper.updateGhiChu(bangKhamBenh)){
					System.out.println("Have update ghichu In table khambenh");
					return true;
				}else{
					return false;
				}
			}else{
				//insert new 
				try {
					PreparedStatement preSt = connection.prepareStatement(sql);
					preSt.setString(1, bangKhamBenh.getMsbn());
					preSt.setString(2, bangKhamBenh.getMsbacsy());
					preSt.setDate(3, myDate);
					preSt.setString(4, bangKhamBenh.getGhiChu());
					int count = preSt.executeUpdate();
					if(count>0){
						System.out.println("Have insert new data to table khambenh");
						return true;
					}else{
						System.out.println("Can not insert new data to table khambenh");
						return false;
					}
					//preSt.setti
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Can not insert in to Database: "+e.getMessage());
					return false;
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Row 68: Can not query form table khambenh: "+e1.getMessage());
		}
		return false;
	}
	private static boolean updateGhiChu(BangKhamBenh bangKhamBenh){
		Connection connection = SQLServerConnection.getInstance();
		String lastNote = "";
		//get last note
		String sqlSelect = "select ghichu from khambenh where  msbn = ? and msbacsy = ? and ngaykham = ?";
		int date = bangKhamBenh.getNgayKham().getDayOfMonth();
		int month = bangKhamBenh.getNgayKham().getMonthValue();
		int year = bangKhamBenh.getNgayKham().getYear();
		
		@SuppressWarnings("deprecation")
		java.sql.Date myDate = new Date(year-1900, month-1, date);
		
		try {
			PreparedStatement prSt1 = connection.prepareStatement(sqlSelect);
			prSt1.setString(1, bangKhamBenh.getMsbn());
			prSt1.setString(2, bangKhamBenh.getMsbacsy());
			prSt1.setDate(3,myDate);
			ResultSet res = prSt1.executeQuery();
			if(res.next()){
				lastNote+=res.getString("ghichu");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Can not select ghi chu from khambenh: "+e.getMessage());
			return false;
		}
		String sql ="update khambenh set ghichu = ? where msbn = ? and msbacsy = ? and ngaykham = ?";
		try {
			PreparedStatement prSt2 = connection.prepareStatement(sql);
			prSt2.setString(1, lastNote+"\n"+bangKhamBenh.getGhiChu());
			prSt2.setString(2, bangKhamBenh.getMsbn());
			prSt2.setString(3, bangKhamBenh.getMsbacsy());
			prSt2.setDate(4,myDate);
			int count = prSt2.executeUpdate();
			if(count>0)
				return true;
			else{
				System.out.println("Can not update ghichu: 0 row changed ");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Can not create sql statement for update ghichu in table khambenh: "+e.getMessage());
			return false;
		}
	}
}
