package com.mindtree.UI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.mindtree.entity.Patient;
import com.mindtree.entity.Patient_Test;
import com.mindtree.entity.Test;
import com.mindtree.exceptions.InvalidEmailIdException;
import com.mysql.jdbc.Connection;

import database.ConnectionFactory;
import database.DAO;


public class DiagnosticSystemClient {

	public static void main(String[] args) throws Exception {

		ConnectionFactory con = new ConnectionFactory();
		
		Connection conn = (Connection) con.getConnection();
		
		DiagnosticSystemManager dsm = new DiagnosticSystemManager();
		//DAO db = new DAO();
		//db.databseConnection();
		ArrayList<Test> arrayList = new ArrayList<Test>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("XYZ Diagnostic Center");
		System.out.println("---------------------");
		System.out.println(" 1. Add Diagnostic tests \n "
							+ "2. Generate Report \n "
							+ "3. Exit \n Enter Your Choice");
		int choice = sc.nextInt();
		switch(choice){
		case 1:System.out.println("Enter tests details\n "
								+ "1. Fetch patient-deatails by email\n"
								+ " 2. Fetch patient-details by phone\n "
								+ "Enter Your choice");
				int fetchChoice=sc.nextInt();
				int testChoice=0;
				if(fetchChoice==1){
					System.out.print("Enter Email:");
					String email = sc.next();
					try{
						if(!dsm.getPatientByEmail(email, conn))	
							throw new InvalidEmailIdException("Invalid id");
						
						System.out.println("Enter Test");
						String tests = sc.next();					
					}
					catch(InvalidEmailIdException i)
					{
						System.out.println(i.toString());
					}//if(pid!=0){
				/*		do{
							Patient_Test pt = new Patient_Test();
							System.out.println("Enter Test Name");
							String testName =sc.next();
							
							int tid=dsm.getTestIdByTestName(testName);
							pt.setPid(pid);
							pt.setTid(tid);
							DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							Date date = new Date();
							//2016/11/16 12:08:43
							String d=dateFormat.format(date);
							pt.setDate(d);
							arrayList.add(pt);
							//System.out.println(tid);
							System.out.println("Want to add More [1.Yes 2.No]");
							testChoice = sc.nextInt();
						}while(testChoice==1);
						int x=dsm.insertIntoPatient_Test(arrayList);
						if(x==1){
							System.out.println("Tests Details are SuccessFully Stored");
						}
					}*/
				}
				/*if(fetchChoice==2){
					System.out.println("Enter phone");
					String phone = sc.next();
					int pid =dsm.getPatientByPhone(phone);
					if(pid!=0){
						do{
							Patient_Test pt = new Patient_Test();
							System.out.println("Enter Test Name");
							String testName =sc.next();							
							int tid=dsm.getTestIdByTestName(testName);
							pt.setPid(pid);
							pt.setTid(tid);
							DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							Date date = new Date();
							//2016/11/16 12:08:43
							String d=dateFormat.format(date);
							pt.setDate(d);
							arrayList.add(pt);
							//System.out.println(tid);
							System.out.println("Want to add More [1.Yes 2.No]");
							testChoice = sc.nextInt();
						}while(testChoice==1);
						int x=dsm.insertIntoPatient_Test(arrayList);
						if(x==1){
							System.out.println("Tests Details are SuccessFully Stored");
						}
					}
					
	*/			}
		}
		
		
	}


