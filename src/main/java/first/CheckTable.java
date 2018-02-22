package first;
import java.sql.*;

public class CheckTable {
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:jtds:sqlserver://192.168.5.204:1433/cxpsadm_hemanshu_48dev1";
    static final String USER = "cxpsadm_hemanshu_48dev1";
    static final String PASS = "c_xps123";

    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:sqlserver://192.168.5.204:1433;databaseName=CXPSADM_HEMANSHU_48DEV1",
                "CXPSADM_HEMANSHU_48DEV1", "c_xps123");
        return con;
    }

    public static boolean tableExistFunc() {
        Connection conn = null;
        boolean exist= false;
        try{
            conn = getConnection();
            exist=(tableExist(conn,"phonebook"));
            conn.close();
            return exist;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public static boolean tableExist(Connection conn, String tableName) throws SQLException {
        boolean tExists = false;
        try (ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null)) {
            while (rs.next()) {
                String tName = rs.getString("TABLE_NAME");
                if (tName != null && tName.equals(tableName)) {
                    tExists = true;
                    break;
                }
            }
        }
        return tExists;
    }

    public static int createTable() throws SQLException {
        Connection conn = null;
        boolean exist= false;
        Statement stmt = null;
        int val=0;
        try{
            conn = getConnection();
            stmt = conn.createStatement();
            String sql = "CREATE TABLE PHONEBOOK " +
                    "(id INTEGER not NULL, " +
                    " NAME VARCHAR(255), " +
                    " PHONENUMBER VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);

            return val;
        }catch (Exception e){
            e.printStackTrace();
            return val;
        }finally {
          conn.close();
        }

    }



    public static void main(String[] args) throws SQLException {

        System.out.println(tableExistFunc());

    }


}
