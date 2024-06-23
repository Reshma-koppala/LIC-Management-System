package com.pace.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.pace.project.bean.Lic;
import com.pace.project.dao.LicDao;

/**
 * Servlet implementation class LicInsertServlet
 */
@WebServlet("/LicInsertServlet")
public class LicInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LicInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LicDao licDao = new LicDao();
		Lic lic = new Lic();
		int rows=0;
		int registration_number;
		String name;
		long mobile_number;
		String email,date_of_birth,plan;
		int income,no_of_dependencies;
		String country,state,city;
		int pincode;
		
		registration_number = Integer.parseInt(request.getParameter("id"));
		name = request.getParameter("name");
		mobile_number = Long.parseLong(request.getParameter("mobile number"));
		email=request.getParameter("email");
		date_of_birth=request.getParameter("dob");
		plan=request.getParameter("plan");
		income=Integer.parseInt(request.getParameter("income"));
		no_of_dependencies=Integer.parseInt(request.getParameter("dependencies"));
		country=request.getParameter("country");
		state=request.getParameter("state");
		city=request.getParameter("city");
		pincode=Integer.parseInt(request.getParameter("pin"));
		
		//make the pojo ready with data
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
		
		//pojo is ready with data
		System.out.println(lic.getName());
		try {
			rows=licDao.insertLicHolderDetails(lic);
		}catch(Exception e) {
			System.err.println("Lic holder data could not inserted!");
		}
		if(rows==1) {
			System.out.println("Lic holder data successfully inserted");
			RequestDispatcher dis=request.getRequestDispatcher("registationSuccess.html");
			dis.forward(request,response);
		}else {
			System.out.println("Lic holder data could not insert");
		}
	}

	}


