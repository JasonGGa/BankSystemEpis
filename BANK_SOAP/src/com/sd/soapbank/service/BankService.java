package com.sd.soapbank.service;

import com.sd.soapbank.beans.Account;

public interface BankService {
	
	public Account[] getAllAccounts();
	public Account getAccount(int id);
	public int createAccount(String name, String pass);
	public boolean setBalance(int ac, double money);
	public double getBalance(int ac);
	public boolean deposit(int ac, double money);
	public boolean withdraw(int ac, double money);

}
