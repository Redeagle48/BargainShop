package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {

	Connection connect = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public ConnectDB() {
		connect();
	}
	
	// http://www.vogella.com/tutorials/MySQLJava/article.html

	public void connect() {
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// setup the connection with the DB.
			connect = DriverManager
					.getConnection("jdbc:mysql://" + LocationsDB.DB_Server + "/" + LocationsDB.DB_Name + "?"
							+ "user=" + LocationsDB.DB_User + "&password=" + LocationsDB.DB_Password);

		} catch(SQLException sqle) {} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testConnect() {
		// statements allow to issue SQL queries to the database
		try {
			statement = connect.createStatement();
			// resultSet gets the result of the SQL query
			resultSet = statement
					.executeQuery("select * from ist163287.products");
			writeResultSet(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		// resultSet is initialized before the first data set
		while (resultSet.next()) {
			// it is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g., resultSet.getSTring(2);
			String user = resultSet.getString("id");
			String website = resultSet.getString("name");
			System.out.println("ID: " + user);
			System.out.println("Name: " + website);

		}
	}

}
