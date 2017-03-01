using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;

namespace ConnectSQLServer
{
   public class DBUtils
    {
        private static SqlConnection connection = null;
        private DBUtils()
        {
            string datasource = "DESKTOP-VGE3HDE";
            string database = "QLKhamBenh";
            string username = "sa";
            string password = "Thanhnga9x,pro";
            connection = DBSQLServerUtils.GetDBConnection(datasource, database, username, password);
            connection.Open();
        }
        public static SqlConnection getInstance()
        {
            if (connection == null)
                new DBUtils();
            return connection;
        }
    }
}
