using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;

namespace ConnectSQLServer
{
    public class DBSQLServerUtils
    {
        public static SqlConnection GetDBConnection(string datasource, string database, string username, 
            string password)
        {
            //Data Source=DESKTOP-VGE3HDE;Initial Catalog=QLKhamBenh;User ID=sa;Password=***********
            string connectString = @"Data Source=" + datasource + ";Initial Catalog=" + database
                + ";User ID=" + username + ";Password=" + password;
            SqlConnection connection = new SqlConnection(connectString);
            return connection;
        }
    }
}
