/**
 * BankServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sd.soapbank.service;

public interface BankServiceImpl extends java.rmi.Remote {
    public boolean deposit(int ac, double money) throws java.rmi.RemoteException;
    public com.sd.soapbank.beans.Account[] getAllAccounts() throws java.rmi.RemoteException;
    public boolean setBalance(int id, double money) throws java.rmi.RemoteException;
    public boolean withdraw(int ac, double money) throws java.rmi.RemoteException;
    public double getBalance(int id) throws java.rmi.RemoteException;
    public com.sd.soapbank.beans.Account getAccount(int id) throws java.rmi.RemoteException;
    public int createAccount(java.lang.String name, java.lang.String pass) throws java.rmi.RemoteException;
}
