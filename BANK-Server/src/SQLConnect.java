import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class SQLConnect {
	
	private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
	
	public ArrayList<Account> selectAll(){
		ArrayList<Account> list = new ArrayList<Account>();
        String sql = "SELECT id, name, pass, balance FROM account";
        
        try (Connection conn = this.connect();
             java.sql.Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
            	System.out.println(rs.getInt("id"));
            	list.add(new Account(rs.getString("name"), rs.getString("pass"), new BigDecimal(rs.getDouble("balance"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

	public void createNewTable() {
		// SQLite connection string
		//String url = "jdbc:sqlite:test.db";

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS account (\n"
				+ "	id integer PRIMARY KEY,\n"
				+ "	name text NOT NULL,\n"
				+ " pass text NOT NULL, \n"
				+ "	balance real,\n"
				+ " session integer\n"
				+ ");";

		try {
			Connection conn = this.connect();
			java.sql.Statement stmt = conn.createStatement();
			// create a new table
			stmt.execute(sql);
			System.out.println("Database successfully created");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insert(String name, String pass, double balance, long session) {
        String sql = "INSERT INTO account(name, pass, balance, session) VALUES(?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, pass);
            pstmt.setDouble(3, balance);
            pstmt.setLong(4, session);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void update(String name, double balance) {
        String sql = "UPDATE account SET balance = ? , "
                + "WHERE name = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setDouble(1, balance);
            pstmt.setString(2, name);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

	public static void main( String args[] ) {
		/*
		Connection c = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}*/
		SQLConnect con = new SQLConnect();
		//con.createNewTable();
		//con.insert("Jeyson", "123", 2000, 2);
		List<Account> l = con.selectAll();
		System.out.println(l.get(0).toString());
	}
}
