package zebraFrame.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static	{
		try		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException cnf)	{
			System.out.println("Driver could not be loaded: "+ cnf);
		}
	}
	private static final String DRIVER= "com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/stud";
	private static final String USER="root";
	private static final String PWD="Welcome123";
	public static Connection conn;
	public static Statement st;
	public static ResultSet rs;

	public static void getConnection()
	{
		try
		{
			conn=(Connection) DriverManager.getConnection(URL,USER,PWD);
			st=(Statement) conn.createStatement();
		}
		catch(SQLException sqle)
		{
			System.out.println("SQL Exception thrown: "+sqle);
		}
	}
	
	public static void PrintCol() throws SQLException
	{
		String query="Select * from student";
		st=(Statement) conn.prepareStatement(query);
		rs= st.executeQuery(query);
		while(rs.next())
		{
			System.out.println(rs.getString(2));
			System.out.println();
		}
		System.out.println("----------------------------");
	}
	
	public static void PrintRow() throws SQLException
	{
		String query="Select * from student where stud_id="+1+"";
		st=(Statement) conn.prepareStatement(query);
		rs= st.executeQuery(query);
		while(rs.next())
		{
			System.out.println(rs.getString(2)+" "+rs.getString(3));
			System.out.println();
		}
		System.out.println("----------------------------");
	}
	
	public static void booleanPrint() throws SQLException
	{
		String str="ayushi";
		boolean b=false;
		String query="Select * from student where stud_id="+1+"";
		st=(Statement) conn.prepareStatement(query);
		rs= st.executeQuery(query);
		while(rs.next())
		{
			if(str.equalsIgnoreCase(rs.getString(2)))
				b=true;
		}
		System.out.println(b);
		System.out.println("----------------------------");
	}
	
	public static void closeConn()
	{
		try {
			if(conn!=null)
			{
				conn.close();
				conn=null;
			}
		}
		catch (SQLException sqle)
		{
			System.out.println("SQL Exception thrown: "+sqle);
		}
	}
	
	public static void main(String[] args) throws SQLException {
		getConnection();
		PrintCol();
		PrintRow();
		booleanPrint();
	}
}
