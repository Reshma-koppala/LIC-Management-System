package com.pace.project.service;

import java.sql.SQLException;
import java.util.ArrayList;


import com.pace.project.bean.Lic;
import com.pace.project.dao.LicDao;

public class LicServiceProvider {
	ArrayList<Lic> licList = new ArrayList<Lic>();
	LicDao licDAO = new LicDao();

	// Reading lic holders data service
	public ArrayList<Lic> getLicService() throws ClassNotFoundException, SQLException {
		licList = licDAO.getLic();
		return licList;
	}

	// Showing lic holders data service
	public void showLicService(ArrayList<Lic> licList) throws ClassNotFoundException, SQLException {

		System.out.println("In service layer ");
		licList = licDAO.getLic();
		licDAO.showLicList(licList);
	}

	// Inserting Lic holders details data service
	public void insertLicService(Lic lic) throws ClassNotFoundException, SQLException {
		licDAO.insertLicHolderDetails(lic);
	}

	// deleting lic holder data service
	public void deleteLicService(int registration_number) throws ClassNotFoundException, SQLException {
		boolean isLicHolderDeleted = licDAO.deletePerson(registration_number);
		if (isLicHolderDeleted == true) {
			System.out.println("Lic holder with registration_number " + registration_number + " was deleted");
		} else {
			System.out.println("Lic holder with registration_number " + registration_number + " was Unavailable");
		}
	}
	// updating lic data service
	public void updateLicService(int registration_number) throws ClassNotFoundException, SQLException {
		boolean isLicDataUpdated = licDAO.updateLicHolderDetails(registration_number);
		
		if (isLicDataUpdated == true) {
			System.out.println("Lic holder with registration_number " + registration_number + " was updated!");
		} else {
			System.out.println("Lic holder with registration_number " + registration_number + " was not updated!");
		}

	}

}
