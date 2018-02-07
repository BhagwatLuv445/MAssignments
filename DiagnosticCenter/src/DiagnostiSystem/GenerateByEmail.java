package DiagnostiSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DiagnostiSystem.Database.ConnectionFactory;
import DiagnostiSystem.Database.PatientDao;
import DiagnostiSystem.Database.PatientTestDao;
import DiagnostiSystem.Database.TestDao;
import entity.Patient;
import entity.Test;

/**
 * Servlet implementation class GenerateByEmail
 */
@WebServlet("GenerateByEmail")
public class GenerateByEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static PatientDao pao = new PatientDao();
	static TestDao tdo = new TestDao();
	static PatientTestDao ptdo = new PatientTestDao();
	ArrayList<Test> arr = new ArrayList<>();
	Patient p = new Patient();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GenerateByEmail() {
		super();
		System.out.println("hello");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ConnectionFactory cf = new ConnectionFactory();
		System.out.println("hello");
		Connection conn = cf.getConnection();

		System.out.println("hello");

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String date = request.getParameter("date");
		System.out.println(email);
		System.out.println(date);
		// String[] arr= request.getParameterValues("testname");
		try {

			int pid = pao.fetchPatientDetailsByEmail(email, conn);
			System.out.println(pid);
			if (pid != -1) {
				p = pao.getName(email, conn);
				arr = ptdo.fetchAllDetails(date, conn, pid);
				if (!p.equals(null)) {
					System.out.println("Report");
					System.out.println("Name" + "\t" + p.getName());
					System.out.println("Email" + "\t" + p.getEmail());
					System.out.println("Phone" + "\t" + p.getPhone());
					System.out.println("Date" + "\t" + date);
					System.out.println("Test Details:");
					System.out.println("\t \t \tTest\tCost");
					System.out.println("");
				}
				int sum = 0;
				for (Test t : arr) {
					if (t.equals(null)) {
						System.out.println("NO Record for this Date");

					} else {

						sum += t.getCost();
						System.out.println("\t \t \t" + t.getTestName() + "\t" + t.getCost());

					}

				}

				System.out.println("\t \t \tTotal:\t" + sum);
				System.exit(0);

			}

			else {

				out.println("Invalid Email_id");
			}

			System.out.println(pid);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
