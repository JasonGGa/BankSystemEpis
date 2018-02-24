package com.sd.soapbank.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sd.soapbank.beans.Account;

public class BankServiceImpl implements BankService {
	
	public BankServiceImpl() {
		//createTable();
	}
	
	private Connection connect() {
        String url = "jdbc:sqlite:test.db";
        Connection con = null;
        try {
        	Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return con;
    }
	
	private boolean createTable() {
		
		String sql = "CREATE TABLE IF NOT EXISTS account (\n"
				+ "	id integer PRIMARY KEY,\n"
				+ "	name text NOT NULL,\n"
				+ " pass text NOT NULL, \n"
				+ "	balance real\n"
				+ ");";

		try {
			Connection conn = this.connect();
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("Database successfully created");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	@Override
	public Account[] getAllAccounts() {
		
		String sql = "SELECT id, pass, name, balance FROM account";
		
		Account[] list = new Account[100];
		int index = 0;

		try (Connection conn = this.connect();
				Statement stmt  = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){

			while (rs.next()) {
				list[index++] = new Account(rs.getInt("id"), rs.getString("name"), rs.getString("pass"), rs.getDouble("balance"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	@Override
	public Account getAccount(int id) {
		
		String sql = "SELECT id, name, pass, balance FROM account WHERE id = ?";
		Account ac = null;
		
		try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            ac = new Account(rs.getInt("id"), rs.getString("name"), rs.getString("pass"), rs.getDouble("balance"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return ac;
	}
	
	@Override
	public int createAccount(String name, String pass) {
		
		String sql = "INSERT INTO account(name, pass, balance) VALUES(?,?,?)";
		int id = -1;
		 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, pass);
            pstmt.setDouble(3, 0);
            id = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return id;
	}

	@Override
	public boolean setBalance(int id, double money) {
		
		String sql = "UPDATE account SET balance = ? WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	
            pstmt.setDouble(1, money);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return true;
	}

	@Override
	public double getBalance(int id) {
		
		String sql = "SELECT balance FROM account WHERE id = ?";
		double balance = 0;
		
		try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            balance = rs.getDouble("balance");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return balance;
	}
	
	public static void main(String[] args) {
		BankServiceImpl bs = new BankServiceImpl();
		bs.getAllAccounts();
	}

	@Override
	public boolean deposit(int ac, double money) {
		double bal = getBalance(ac);
		setBalance(ac, bal+money); 
		return true;
	}

	@Override
	public boolean withdraw(int ac, double money) {
		double bal = getBalance(ac);
		if (bal >= money) {
			setBalance(ac, bal- money);
			return true;
		}
		return false;
	}
}
