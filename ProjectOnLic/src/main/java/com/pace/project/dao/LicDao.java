package com.pace.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import com.pace.project.bean.Lic;
import com.pace.project.helper.DbConnector;

public class LicDao {
	
	private Connection connection = null;
	private PreparedStatement pstatement = null;
	private ResultSet resultSet = null;
	// Lic lic = new Lic();
	ArrayList<Lic> licList = null;
	private static String licQry = "select * from lic";
	
	//Get lic registered data
	
	public ArrayList<Lic> getLic() throws ClassNotFoundException, SQLException {
		// Process to get books from table into bookList : 
		//1. Get the book data from table. 
		//2. Add each book to BookList. 
		//3. Return BookList
		try {
			// open the connection
			connection = DbConnector.createConnection();
			// create pstatement
			pstatement = connection.prepareStatement(licQry);
			// get the result
			resultSet = pstatement.executeQuery();
			Lic lic;
			licList = new ArrayList<Lic>();
			while (resultSet.next()) {
				int registration_number;
				String name;
				long mobile_number;
				String email;
				String date_of_birth;
				String plan;
				int income;
				int no_of_dependencies;
				String country,state,city;
				int pincode;
				// declare the pojo
				lic = new Lic();
				// get the row details
				registration_number=resultSet.getInt(1);
				name = resultSet.getString(2);
				mobile_number=resultSet.getLong(3);
				email=resultSet.getString(4);
				date_of_birth=resultSet.getString(5);
				plan=resultSet.getString(6);
				income=resultSet.getInt(7);
				no_of_dependencies=resultSet.getInt(8);
				country=resultSet.getString(9);
				state=resultSet.getString(10);
				city=resultSet.getString(11);
				pincode=resultSet.getInt(12);
				
				// Add this data to lic bean
				// set the pojo with retrieved values from the row
				lic.setRegistration_number(registration_number);
				lic.setName(name);
				lic.setMobile_number(mobile_number);
				lic.setEmail(email);
				lic.setDate_of_birth(date_of_birth);
				lic.setPlan(plan);
				lic.setIncome(income);
				lic.setNo_of_dependencies(no_of_dependencies);
				lic.setCountry(country);
				lic.setState(state);
				lic.setCity(city);
				lic.setPincode(pincode);
				
				// add the lic to licList
				licList.add(lic);
				lic = null;
			} // end of while loop

		} catch (SQLException sqlex) {

		} finally {
			// close connection
			// now data is in array list object, close the connection
			//DbConnector.closeConnection();
		}

		return licList;
	}
	/******************** Show list of LIC holders 
	 * @throws SQLException ************************************/
	public void showLicList(ArrayList<Lic> licList2) throws SQLException {
		System.out.println("In DAO layer ");
		for (Lic lic: licList2) {
			System.out.println(lic.getRegistration_number());
			System.out.print("\t" +lic.getName());
			System.out.print("\t" +lic.getMobile_number());
			System.out.print("\t" + lic.getEmail());
			System.out.println("\t" + lic.getDate_of_birth());
			System.out.println("\t" + lic.getPlan());
			System.out.println("\t" + lic.getIncome());
			System.out.println("\t" + lic.getNo_of_dependencies());
			System.out.println("\t" + lic.getCountry());
			System.out.println("\t" + lic.getState());
			System.out.println("\t" + lic.getCity());
			System.out.println("\t" + lic.getPincode());
		}
		
	}

	/**************** Inserting Lic data 
	 * @return *********************************/

	public int insertLicHolderDetails(Lic lic) throws ClassNotFoundException, SQLException {
		connection = DbConnector.createConnection();

		String insQry = "insert into lic values(?,?,?,?,?,?,?,?,?,?,?,?)";
		pstatement = connection.prepareStatement(insQry);
		pstatement.setInt(1, lic.getRegistration_number());
		pstatement.setString(2, lic.getName());
		pstatement.setLong(3, lic.getMobile_number());
		pstatement.setString(4, lic.getEmail());
		pstatement.setString(5, lic.getDate_of_birth());
		pstatement.setString(6, lic.getPlan());
		pstatement.setInt(7, lic.getIncome());
		pstatement.setInt(8, lic.getNo_of_dependencies());
		pstatement.setString(9, lic.getCountry());
		pstatement.setString(10, lic.getState());
		pstatement.setString(11, lic.getCity());
		pstatement.setInt(12, lic.getPincode());
		
		int rows = pstatement.executeUpdate();
		System.out.println(rows + " Rows Inserted!");
		//DbConnector.closeConnection();
		return rows;
	}
	/**************** Deleting insurance claimed persons *********************************/

	public boolean deletePerson(int registration_number) throws SQLException, ClassNotFoundException {
		pstatement = null;
		//Scanner scnr = new Scanner(System.in);
		connection = DbConnector.createConnection();
		String delQry = "delete from lic where registration_number=?";
		pstatement = connection.prepareStatement(delQry);
		pstatement.setInt(1, registration_number);
		int rows = pstatement.executeUpdate();
		boolean isDelete = true;
		if (rows != 0) { // if rows is non-zero, it is deleted
			isDelete = true; // status of deletion
		} else {
			isDelete = false; // status of deletion
		}
		//DbConnector.closeConnection();
		return isDelete;
	}
	/******************* Updating Lic holder details **************************/
	public boolean updateLicHolderDetails(int registration_number) throws SQLException, ClassNotFoundException {
		pstatement = null;
		Lic lic=new Lic();
		connection = DbConnector.createConnection();
		String updateQry = 
			"update lic set registration_number=?,name=?,mobile_number=?,email_address=?,date_of_birth=?,plan=?,annual_income=?,no_of_dependencies=?,country=?,state=?,city_name=?,pincode=? where registartion_number=?" ;
		pstatement = null;
		pstatement = connection.prepareStatement(updateQry);
		pstatement.setInt(1, registration_number);
		pstatement.setString(2, lic.getName());
		pstatement.setLong(3, lic.getMobile_number());
		pstatement.setString(4, lic.getEmail());
		pstatement.setString(5, lic.getDate_of_birth());
		pstatement.setString(6, lic.getPlan());
		pstatement.setInt(7, lic.getIncome());
		pstatement.setInt(8, lic.getNo_of_dependencies());
		pstatement.setString(9, lic.getCountry());
		pstatement.setString(10, lic.getState());
		pstatement.setString(11, lic.getCity());
		pstatement.setInt(12, lic.getPincode());
		
		int rows = pstatement.executeUpdate();
		boolean isUpdate = true;
		if (rows != 0) { // if row available, it is deleted
			isUpdate = true; // status of updation
		} else {
			isUpdate = false; // status of updation
		}
		//DbConnector.closeConnection();
		return isUpdate;
	}
	

}
