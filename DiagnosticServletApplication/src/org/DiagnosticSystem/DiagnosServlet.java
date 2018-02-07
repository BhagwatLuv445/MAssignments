package org.DiagnosticSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DiagnosServlet
 */
@WebServlet(description = "It is a Dignostic System", urlPatterns = { "/DiagnosServletPath" })

public class DiagnosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/*	response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Hello form Get Method.");
		PrintWriter writer = response.getWriter();
		writer.println("<h3>Hi From Servlet</h3>");*/
		System.out.println("done");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String lastname = request.getParameter("lastname");
		//System.out.println(email);
		//out.println(email);
		out.println("Last Name:"+lastname);
	}

}
