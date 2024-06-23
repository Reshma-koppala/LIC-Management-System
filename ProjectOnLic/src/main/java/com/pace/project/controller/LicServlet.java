package com.pace.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pace.project.bean.Lic;
import com.pace.project.service.LicServiceProvider;
import com.pace.project.bean.Lic;
import com.pace.project.service.LicServiceProvider;

/**
 * Servlet implementation class LicServlet
 */
@WebServlet("/LicServlet")
public class LicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Lic lic=new Lic();
		ArrayList<Lic>licList=new ArrayList<Lic>();
		
		LicServiceProvider licServiceProvider=new LicServiceProvider();
		try {
			licList=licServiceProvider.getLicService();
			HttpSession session=request.getSession();
			session.setAttribute("liclist", licList);
			RequestDispatcher dis=request.getRequestDispatcher("showLicHoldersDetails.jsp");
			dis.forward(request, response);
		}catch(ClassNotFoundException|SQLException e){
			System.out.println(e.getMessage());
			System.out.println("Lic holder data could not found");
		}
	
	}

}
