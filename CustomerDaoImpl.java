package databaseconnectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

	public Customer findCustomerId(int custIs) {
		Connection conn  = null;
		Customer c=new Customer();
		try {
			conn=getConnection();
			PreparedStatement pst=conn.prepareStatement("select * from customer where custIs=?");
			pst.setInt(1, custIs);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				c.setCustIs(rs.getInt("custIs"));
				c.setCustName(rs.getString("custName"));
				c.serAddress(rs.getString("address"));
				c.setAccountNo(rs.getString("accountNo"));
				c.setBalance(rs.getDouble("balance"));;			}
		}
	}
	catch(private Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	ClassNotFoundException e) {
		System.out.println("Driver Not Found");
	}catch(SQLException e) {
	private String getCustName;
	private String getAddress;) {
		e.printStackTrace();
	} finally {
		try {
			conn.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	return c;
}

@Override
public String set(Customer c) {
	String message="";
	Connection conn=null;
	try {
		
		conn = getConnection();
		PreparedStatement pst =conn.prepareStatement("insert into customer(custIs,custName.address,accountNo,balance)values(?,?,?,?,?)");
		pst.setInt(1, c.getCustId());
		pst.setString(2, c.getCustName);
		pst.setString(3,c.getAddress);
		pst.setInt(4, c.getAccountNo());
		pst.setDouble(5, c.getBalance());
		
		int result = pst.executeUpdate();
		 
		message="Adding row Successful";
		
		
	}
	 catch (ClassNotFoundException e) {
		 System.out.println("Driver Not Found");
		 
	 } catch (SQLException e) {
		 e.printStackTrace();
		 message="Not Successful";
	 }finally {
		 try {
			 conn.close();
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
	 }
	return message;
}

@Override
	
public String delete(int customerId) {
	Customer c= new Customer();
	String msg="";
	Connection conn = null;
	try {
		conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("delete from customer where custIs=?");
		pst.setInt(1, customerId);
		int  result = pst.executeUpdate();
		
		   msg=result+"Rows are deleted";
	}catch(ClassNotFoundException e) {
		System.out.println("driver not found...");
	} catch (SQLException e) {
		e.printStackTrace();
		msg="Not Deleted";
	} finally {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return msg;

    @Override
    public List<Customer> listAll() {
    	Connection conn = null;
    	List<Customer> custList=new ArrayList<Customer>();
    	try {
    		conn=getConnection();
    		PreparedStatement pst=conn.prepareStatement("select  from customer");
    		
    		ResultSet rs =  pst.executeQuery();
    		
    		while(rs.next()) {
    			int id = rs.getInt("custIs");
    			String name = rs.getString("custName");
    			String city = rs.getString("address");
    			int account = rs.getInt("accountNo");
    			double balance =rs.getDouble("balance");
    			custList.add(new Customer(id,name,city,account,balance));
    			
    		}
    	}
    	catch (ClassNotFoundException e) {
    		System.out.println("Driver not found");
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			conn.close();
    		}catch (SQLException e) {
    		    e.printStackTrace();
    		}
    	}
    	 return custList;
    	
    }
    
}
private Customer new Customer() {
	// TODO Auto-generated method stub
	return null;
}

	