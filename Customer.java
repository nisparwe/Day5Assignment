package databaseconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer {
	public class JdbcExample {

		public void main(String[] args) throws Exception {
			Class.forName("org.mariadb.jdbc.Driver");
			
			Connection conn= DriverManager.getConnection("jdbc:mariadb://localhost:3306/sapientdb","root","Nehab123@");
			if(conn !=null)
				System.out.println("DB Connected...");
			Statement st= conn.createStatement();
			ResultSet rs=st.executeQuery("select * from customer");
			
			while(rs.next()) {
				int id=rs.getInt("custIs");
				String name=rs.getString("custName");
				String city=rs.getString("ADDRESS");
				int accountNo=rs.getInt("accountNo");
				double balance=rs.getDouble("balance");
				System.out.println(id+" "+name+" "+city+" "+accountNo+" "+balance);
			}


		}
	}

	public void setCustIs(int int1) {
		// TODO Auto-generated method stub
		
	}
}
