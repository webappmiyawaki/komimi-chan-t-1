package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
	private static String driverName="org.postgresql.Driver";
	private static String url="jdbc:postgresql://localhost:5432/komimi_chan_t_1";

	private static String user="postgres";
	private static String password="test";

	public Connection getConnection(){
		Connection con=null;
		try{
			Class.forName(driverName);
			con=(Connection)DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
    /**
     *     Statement用
     *     try-with-resource文使うからあまり使わない？
     */
    public static void close(Statement stat, Connection conn, ResultSet rs) {
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     *     PreparedStatement用
     */
    public static void close(PreparedStatement pstm, Connection conn, ResultSet rs) {
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
