package com.ResturantSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Methods
{
	Scanner sc = new Scanner(System.in);
	public static final String driverName = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/resturant_system";
	public static final String userName = "root";
	public static final String passWord = "Ranjan@0187";
	
	void searchResturant() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, passWord);

			ps = con.prepareStatement("select *from resturant where name=?");
			System.out.println("Enter name of Resturant: ");
			String searchname = sc.next();
			ps.setString(1, searchname);
			rs = ps.executeQuery();

			if (rs.next()) 
			{
				System.out.println("Name: " + rs.getString("name") + "\t");
				System.out.println("Opening_time: " + rs.getString("opening_time") + "\t");
				System.out.println("Closing_time: " + rs.getString("close_time") + "\t");
				System.out.println("Phone_no: " + rs.getLong("phone_no") + "\t");
				System.out.println("Adress: " + rs.getString("address") + "\t");
				System.out.println("Status: " + rs.getInt("status") + "\t");
				System.out.println("Resturant Search Succesfully");
				System.out.println("-----------------------------------------------------------------------------------");
			} 
			else 
			{

				System.out.println("Resturant is not found");
				System.out.println("-----------------------------------------------------------------------------------");
			}

		} catch (Exception e) {

			System.out.println("Error......");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	void displayDetailsOfResturant() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, passWord);
			ps = con.prepareStatement("select *from resturant");
			rs = ps.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getString("name") + "\t");
				System.out.println(rs.getString("opening_time") + "\t");
				System.out.println(rs.getString("close_time") + "\t");
				System.out.println(rs.getString("phone_no") + "\t");
				System.out.println(rs.getString("address") + "\t");
				System.out.println(rs.getString("status") + "\t\n");
				System.out.println("-----------------------------------------------------------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	void addResturant() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		try {

			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, passWord);

			String query = "insert into resturant(name, opening_time, close_time, phone_no, address, Status) values(?,?,?,?,?,?);";
			ps = con.prepareStatement(query);

			RMS rp = new RMS();
			
			System.out.println("Enter a name");
			String name = sc.next();

			System.out.println("Enter a opening_time");
			int opening_time = sc.nextInt();

			System.out.println("Enter a close_time");
			int close_time = sc.nextInt();

			System.out.println("Enter a phone_no");
			long phone_no = sc.nextLong();

			System.out.println("Enter a address");
			String address = sc.next();

			System.out.println("Enter a status");
			int status = sc.nextInt();
			
			rp.setName(name);
			rp.setOpenTime(opening_time);
			rp.setCloseTime(close_time);
			rp.setPhoneNumber(phone_no);
			rp.setAddress(address);
			rp.setStatus(status);
			
			ps.setString(1, rp.getName());
			ps.setInt(2, rp.getOpenTime());
			ps.setInt(3, rp.getCloseTime());
			ps.setLong(4, rp.getPhoneNumber());
			ps.setString(5, rp.getAddress());
			ps.setInt(6, rp.getStatus());

			ps.executeUpdate();

			System.out.println("Resturant Added Succesfully");
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("After Addition of data  Records are");
			displayDetailsOfResturant();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {

				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	void updateDetailsOfResturant() {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, passWord);

			System.out.println("---------------------Enter a choice for update:-------------------- \n");
			System.out.println("1. If you want to update a whole values of Resturant ");
			System.out.println("2. If you want to update values which you want ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				String query = "update resturant set name=?, opening_time= ?,close_time= ?, phone_no= ? , address= ? , Status=? where name = ?;";
				ps = con.prepareStatement(query);

				System.out.println("Enter a name of resturant which you want to update");
				String name1 = sc.next();

				System.out.println("Enter the value for name to update");
				String name = sc.next();

				System.out.println("Enter the value for opening_time to update");
				String opening_time = sc.next();

				System.out.println("Enter the value for closing_time to update");
				String close_time = sc.next();

				System.out.println("Enter the value for phone_no to update");
				long phone_no = sc.nextLong();

				System.out.println("Enter the value for adress to update");
				String address = sc.next();

				System.out.println("Enter the value for Status to update");
				int status = sc.nextInt();

				ps.setString(7, name1);
				ps.setString(1, name);
				ps.setString(2, opening_time);
				ps.setString(3, close_time);
				ps.setLong(4, phone_no);
				ps.setString(5, address);
				ps.setInt(6, status);

				ps.executeUpdate();
				System.out.println("Resturant Updated Succesfully");
				System.out.println("-----------------------------------------------------------------------------------");
				System.out.println("------------------------------------------------------------------------------------");

				break;

			case 2:
				System.out.println("Enter a choice for update value you want from following..... ");
				System.out.println("1. For update Name ");
				System.out.println("2. For update Opening Time ");
				System.out.println("3. For update Closing Time ");
				System.out.println("4. For update Phone No. ");
				System.out.println("5. For update Adress ");
				System.out.println("7. For update Status value");

				int choice1 = sc.nextInt();

				switch (choice1) {
				case 1:
					String query1 = "update resturant set  name= ? where name = ?;";
					ps = con.prepareStatement(query1);

					System.out.println("Enter a name of restaurant which you want to update");
					String name2 = sc.next();
					System.out.println("Enter the value which you want to update");
					String nameu = sc.next();

					ps.setString(2, name2);
					ps.setString(1, nameu);

					ps.executeUpdate();
					System.out.println("Resturant Name Updated Succesfully");
					System.out.println("-----------------------------------------------------------------------------------");
					break;

				case 2:
					String query2 = "update resturant set opening_time = ? where name = ?;";
					ps = con.prepareStatement(query2);

					System.out.println("Enter a name of resturant which you want to update");
					String name3 = sc.next();
					System.out.println("Enter the value which you want to update");
					String opening_time2 = sc.next();

					ps.setString(2, name3);
					ps.setString(1, opening_time2);

					ps.executeUpdate();
					System.out.println("Resturant Opening_time Updated Succesfully");
					System.out.println("-----------------------------------------------------------------------------------");
					break;

				case 3:
					String query3 = "update restaurant set  closing_time= ? where name = ?;";
					ps = con.prepareStatement(query3);

					System.out.println("Enter a name of restaurant which you want to update");
					String name4 = sc.next();
					System.out.println("Enter the value which you want to update");
					String closing_time3 = sc.next();

					ps.setString(2, name4);
					ps.setString(1, closing_time3);

					ps.executeUpdate();
					System.out.println("Resturant Close_time= Updated Succesfully");
					System.out.println("-----------------------------------------------------------------------------------");
					System.out.println("------------------------------------------------------------------------------------");

					break;
				case 4:
					String query4 = "update resturant set  phone_no= ? where name = ?;";
					ps = con.prepareStatement(query4);

					System.out.println("Enter a name of resturant which you want to update");
					String name5 = sc.next();
					System.out.println("Enter the value which you want to update");
					String phone_no3 = sc.next();

					ps.setString(2, name5);
					ps.setString(1, phone_no3);

					ps.executeUpdate();
					System.out.println("Resturant Phone_no Updated Succesfully");
					System.out.println("-----------------------------------------------------------------------------------");
					System.out.println("------------------------------------------------------------------------------------");
					break;
				
				case 5:
					String query5 = "update resturant set  address= ? where name = ?;";
					ps = con.prepareStatement(query5);

					System.out.println("Enter a name of resturant which you want to update");
					String name6 = sc.next();
					System.out.println("Enter the value which you want to update");
					String adress3 = sc.next();

					ps.setString(2, name6);
					ps.setString(1, adress3);

					ps.executeUpdate();
					System.out.println("Restaurant Adress Updated Succesfully");
					System.out.println("-----------------------------------------------------------------------------------");
					System.out.println("------------------------------------------------------------------------------------");
					break;

				case 6:
					String query6 = "update resturant set Status = ? where name = ?;";
					ps = con.prepareStatement(query6);

					System.out.println("Enter a name of resturant which you want to update");
					String name7 = sc.next();
					System.out.println("Enter the value which you want to update");
					int status2 = sc.nextInt();

					ps.setString(2, name7);
					ps.setInt(1, status2);

					ps.executeUpdate();
					System.out.println("Resturant Status Updated Succesfully");
					System.out.println("-----------------------------------------------------------------------------------");
					System.out.println("------------------------------------------------------------------------------------");
					break;

				default:
					System.out.println("Invalid choice");
					break;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {

				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	void deleteDetailsOfResturant() {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, passWord);

			String query = "delete from resturant where name = ?;";
			ps = con.prepareStatement(query);
			System.out.println("Enter a name");
			String name = sc.next();
			ps.setString(1, name);
			ps.executeUpdate();
			System.out.println("Resturant Deleted Succesfully");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("After Deletion Records are");
			displayDetailsOfResturant();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {

				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	void activateDeactivate() {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, passWord);

			System.out.println("Enter a choice");
			System.out.println("1. Activate");
			System.out.println("2. Deactivate");
			int ch = sc.nextInt();
			switch (ch) {

			case 1:
				ps = con.prepareStatement("select * from resturant where Status=1");
				rs = ps.executeQuery();

				System.out.println("-------Activate Resturant Data------ ");
				while (rs.next()) 
				{

					System.out.println("Name : " + rs.getString("name") + "\t");
					System.out.println("Opening_time : " + rs.getString("opening_time") + "\t");
					System.out.println("Closing_time : " + rs.getString("close_time") + "\t");
					System.out.println("Phone_no : " + rs.getLong("phone_no") + "\t");
					System.out.println("Address : " + rs.getString("address") + "\t");
					System.out.println("Status : " + rs.getInt("status") + "\t");
					
        
					System.out.println("-----------------------------------------------------------------------------------");
				}
				break;
				
			case 2:
				ps1 = con.prepareStatement("select * from resturant where Status = 0");
				rs = ps1.executeQuery();

				System.out.println("-------Deactivate Resturant Data------ ");
				while (rs.next()) {

					System.out.println("Name : " + rs.getString("name") + "\t");
					System.out.println("Opening_time : " + rs.getString("opening_time") + "\t");
					System.out.println("Closing_time : " + rs.getString("close_time") + "\t");
					System.out.println("Phone_no :" + rs.getLong("phone_no") + "\t");
					System.out.println("Adress :" + rs.getString("address") + "\t");
					System.out.println("Status :" + rs.getInt("status") + "\t");
					System.out.println("\n");

					System.out.println("------------------------------------------------------------------------------------");
					System.out.println("------------------------------------------------------------------------------------");
				}
                  
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally
		{
			try 
			{
				if (rs == null) 
				{
					ps.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

}