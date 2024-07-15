

package aduana.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/aduana";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;

  public static DataSource getDataSource() {
    BasicDataSource ds = new BasicDataSource();
    ds.setUrl(URL);
    ds.setUsername(USER);
    ds.setPassword(PASSWORD);
    ds.setInitialSize(100);
    return ds;
  }

  public static Connection getConexion() throws SQLException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

    } catch(ClassNotFoundException cnfe) {
      cnfe.printStackTrace(System.out);
    }
    return getDataSource().getConnection();
  }

  public static void close(ResultSet rs) throws SQLException {
    rs.close();
  }

  public static void close(Statement st) throws SQLException {
    st.close();
  }

  public static void close(Connection cn) throws SQLException {
    cn.close();
  }
}



