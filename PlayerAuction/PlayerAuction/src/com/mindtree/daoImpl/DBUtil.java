/**
 * DBUtil.java
 * © Mindtree Ltd. All Rights reserved.
 * The trademarks used are properties of their respective owners
 */
package com.mindtree.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.exceptions.DaoException;


/**
 * DBUtil class contains operations for establishing connection and releasing
 * acquired resources of MySQL database
 * 
 * @author Orchard
 */
public final class DBUtil {
    
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/player_db";
    private static final String USER = "root";
    private static final String PWD = "root";

    /**
     * private default constructor to prevent instantiation of utility class
     */
    private DBUtil() {
    }

    static {
    	try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
     
    /**
     * 
     * @return database connection
     */
    public static Connection getConnection() throws DaoException {
        try {
			return (Connection)DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
    }

    /**
     * 
     * @param ps
     *            statement to release
     */
    public static void releaseResource(Statement ps)  {
    }

    /**
     * 
     * @param con
     *            connection to release
     */
    public static void releaseResource(Connection con)  {
    	if(con != null) {
    		try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }

    /**
     * 
     * @param con
     *            connection to release
     */
    public static void releaseResource(ResultSet rs)  {
    }
}
