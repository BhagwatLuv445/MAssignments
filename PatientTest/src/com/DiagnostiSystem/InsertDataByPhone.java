package com.DiagnostiSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DiagnostiSystem.Database.ConnectionFactory;
import com.DiagnostiSystem.Database.PatientDao;
import com.DiagnostiSystem.Database.PatientTestDao;
import com.DiagnostiSystem.Database.TestDao;

/**
 * Servlet implementation class PatientDaoServlet
 */
@WebServlet("/PatientDaoServlet")
public class InsertDataByPhone extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static PatientDao pao = new PatientDao();
    static TestDao tdo = new TestDao();
    static PatientTestDao ptdo = new PatientTestDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDataByPhone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		ConnectionFactory cf = new ConnectionFactory();
		
		Connection conn = cf.getConnection();
		
		System.out.println("hello");
		
		response.setContentType("text/html");
	    
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("phone");
		
		String[] arr= request.getParameterValues("testname");
		
		try {
		
			int pid = pao.fetchPatientDetailsByPhone(email, conn);
			
			if(pid!=-1){
			
				for(int i=0; i<arr.length;i++){
				
					int tid = tdo.fetchTestDetails(arr[i], conn);
					//out.println(tid);
					ptdo.insertDetails(pid, tid, conn);
					//out.println(pid);
				}
				
			}
			
			else{
			
				out.println("Invalid Email_id");
			
			}
			
			System.out.println(pid);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//out.println(email);
		
		String htmlRespone = "<html>";
		htmlRespone += "<h2>Your Email is: " + email + "</h2>";
		htmlRespone += "</html>";
		 
		out.println(htmlRespone);

	}

}
