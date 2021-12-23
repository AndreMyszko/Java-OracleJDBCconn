import java.sql.*;
public class JDBCTest {
	public static void main(String[] args) {
		try {			
			System.out.println("Connecting to the database...");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Senha123");
			System.out.println("Conncetion established.");
			Statement st = conn.createStatement();
			ResultSet rs1 = st.executeQuery("select * from C##DEV.tb_teste");
			System.out.println("\n>>TB_TESTE:");
			while(rs1.next()) {
				System.out.println(rs1.getInt("TEST_ID")+" --> "+rs1.getString("TEST_NAME"));
			}
			ResultSet rs2 = st.executeQuery("select * from C##DEV.tb_user");
			System.out.println("\n>>TB_USER:");
			while(rs2.next()) {
				System.out.println(rs2.getInt("USER_ID")+" "+rs2.getString("USER_FIRSTNAME")+" "+rs2.getString("USER_LASTNAME") +" "+rs2.getString("USER_EMAIL") +" "+rs2.getString("USER_PHONE"));
			}
			conn.close();
			System.out.println("\nConnection closed.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
