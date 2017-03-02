using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BenhVien.LeTan
{
    class DBUtils
    {
        public static SqlConnection GetDBConnection()
        {
            string datasource = @"SANDMARKPC\SQLEXPRESS";

            string database = "BenhVien";
            string username = "sa";
            string password = "pc120696";

            return DBSQLServerUtils.GetDBConnection(datasource, database, username, password);
        }
    }
}
