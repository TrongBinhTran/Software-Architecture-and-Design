package DatabaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
	private static Connection connection = null;
	private SQLServerConnection() {
		// TODO Auto-generated constructor stub
		String url ="jdbc:sqlserver://localhost:1433;databaseName=QLKhamBenh;user=sa;password=Thanhnga9x,pro";
		try {
			connection = DriverManager.getConnection(url);
			System.out.println("Connected to Database QLKhamBenh!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Can not connect to SQLServer: "+e.getMessage());
		}
	}
	public static Connection getInstance(){
		if(connection==null)
			new SQLServerConnection();
		return connection;
	}
}
