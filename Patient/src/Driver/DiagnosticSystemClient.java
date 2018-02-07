package Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import Driver.DiagnosticSystemManager;
import com.mindtree.entity.Patient;
import com.mindtree.entity.Test;
import com.mindtree.exceptions.InvalidDateException;
import com.mindtree.exceptions.InvalidEmailIdException;
import com.mindtree.exceptions.InvalidPhoneNumberException;
import com.mindtree.exceptions.InvalidTestNameException;

import Database.ConnectionFactory;

public class DiagnosticSystemClient {

	Patient p = new Patient();
	Test t = new Test();
	ArrayList<Test> testArr = new ArrayList<Test>();
	ConnectionFactory con = new ConnectionFactory();

	Connection conn = (Connection) con.getConnection();

	DiagnosticSystemManager dsm = new DiagnosticSystemManager();

	private void testsDetails()
			throws InvalidEmailIdException, InvalidTestNameException, SQLException, InvalidPhoneNumberException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter tests details\n " + "1. Fetch patient-deatails by email\n"
				+ " 2. Fetch patient-details by phone\n " + "Enter Your choice");

		int fetchChoice = sc.nextInt();

		String choose;

		int pid = -1, tid = -1;

		try {

			if (fetchChoice == 1) {

				System.out.print("Enter Email: ");

				choose = sc.next();

				pid = dsm.checkEmailId(choose, conn);

				if (pid == -1)

					throw new InvalidEmailIdException("Invalid id");

			} else if (fetchChoice == 2) {
				System.out.println("Enter Phone Number");

				choose = sc.next();

				pid = dsm.checkPhoneNumber(choose, conn);

				if (pid == -1) {
					throw new InvalidPhoneNumberException("Invalid Phone Number");
				}
			}
			int more;
			do {
				System.out.println("Enter Test");

				String tests = sc.next();

				tid = dsm.checkTestName(tests, conn);

				if (tid == -1)

					throw new InvalidTestNameException("Invalid Name");

				dsm.insertDetails(pid, tid, conn);

				System.out.println("Want to add More tests: [1/0]");

				more = sc.nextInt();

			} while (more == 1);
		} catch (InvalidEmailIdException | InvalidPhoneNumberException | InvalidTestNameException e) {
			System.out.println(e.toString());
		}
	}

	private void generateReport() throws InvalidEmailIdException, InvalidTestNameException, SQLException,
			InvalidPhoneNumberException, InvalidDateException {

		ArrayList<String> arr = new ArrayList<>();

		ArrayList<String> ar = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter tests details\n " + "1. Fetch patient-deatails by email\n"
				+ " 2. Fetch patient-details by phone\n " + "Enter Your choice");

		int fetchChoice = sc.nextInt();

		String choose;

		int pid = -1, tid = -1;
		try {
			if (fetchChoice == 1) {

				System.out.print("Enter Email: ");

				choose = sc.next();

				p = dsm.getName(choose, conn);

				pid = dsm.checkEmailId(choose, conn);

				if (pid == -1)

					throw new InvalidEmailIdException("Invalid id");
			}

			else if (fetchChoice == 2) {

				System.out.println("Enter Phone Number");

				choose = sc.next();

				pid = dsm.checkPhoneNumber(choose, conn);

				p = dsm.getPhone(choose, conn);

				if (pid == -1)

					throw new InvalidPhoneNumberException("Invalid Phone Number");
			}

			System.out.println("Enter Test Date [DD-MM-YYYY]");

			String testDate = sc.next();

			testArr = dsm.checkTestDate(testDate, conn, pid);

			if (!p.equals(null)) {
				System.out.println("Report");
				System.out.println("Name" + "\t" + p.getName());
				System.out.println("Email" + "\t" + p.getEmail());
				System.out.println("Phone" + "\t" + p.getPhone());
				System.out.println("Date" + "\t" + testDate);
				System.out.println("Test Details:");
				System.out.println("\t \t \tTest\tCost");
				System.out.println("");
			}
			int sum = 0;
			for (Test t : testArr) {
				if (t.equals(null)) {
					System.out.println("NO Record for this Date");

				} else {

					sum += t.getCost();
					System.out.println("\t \t \t" + t.getTestName() + "\t" + t.getCost());

				}

			}

			System.out.println("\t \t \tTotal:\t" + sum);
			System.exit(0);

		} catch (InvalidEmailIdException | InvalidPhoneNumberException | InvalidDateException | ParseException e) {
			System.out.println(e.toString());
		}

	}

	public static void main(String[] args) throws InvalidEmailIdException, SQLException, InvalidTestNameException,
			InvalidPhoneNumberException, InvalidDateException {

		System.out.println("Please choose from the following optins ");

		Scanner sc = new Scanner(System.in);
		int choice;
		DiagnosticSystemClient client = new DiagnosticSystemClient();
		do {
			System.out.println(" 1. Add Diagnostic Test\n 2. Generate Report\n 3. Exit ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				client.testsDetails();
				break;
			case 2:
				client.generateReport();
				break;

			case 3:
				System.out.println("Exiting the program!!");
				System.exit(0);
			}

		} while (choice != 3);

	}

}
