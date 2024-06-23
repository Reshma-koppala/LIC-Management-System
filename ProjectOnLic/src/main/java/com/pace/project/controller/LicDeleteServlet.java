package com.pace.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.pace.project.bean.Lic;
import com.pace.project.dao.LicDao;

/**
 * Servlet implementation class LicDeleteServlet
 */
@WebServlet("/LicDeleteServlet")
public class LicDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LicDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LicDao licDao=new LicDao();
		Lic lic=new Lic();
		boolean rows=false;
		int registration_number;
		String name;
		long mobile_number;
		String email,date_of_birth,plan;
		int income,no_of_dependencies;
		String country,state,city;
		int pincode;
		
		registration_number=Integer.parseInt(request.getParameter("id"));
		PrintWriter out=response.getWriter();
		out.println("Lic registration_number"+registration_number);
		try {
			rows=licDao.deletePerson(registration_number);
		}catch(Exception e) {
			System.out.println("Could not delete the person data!");
		}
		if(rows==true) {
			System.out.println("person data successfully deleted");
		}else {
			System.out.println("person data could not delete");
		}
		RequestDispatcher dis=request.getRequestDispatcher("deleteSuccess.html");
		dis.forward(request, response);
	}

	

}
