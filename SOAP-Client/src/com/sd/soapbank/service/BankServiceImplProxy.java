package com.sd.soapbank.service;

public class BankServiceImplProxy implements com.sd.soapbank.service.BankServiceImpl {
  private String _endpoint = null;
  private com.sd.soapbank.service.BankServiceImpl bankServiceImpl = null;
  
  public BankServiceImplProxy() {
    _initBankServiceImplProxy();
  }
  
  public BankServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initBankServiceImplProxy();
  }
  
  private void _initBankServiceImplProxy() {
    try {
      bankServiceImpl = (new com.sd.soapbank.service.BankServiceImplServiceLocator()).getBankServiceImpl();
      if (bankServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bankServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bankServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bankServiceImpl != null)
      ((javax.xml.rpc.Stub)bankServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sd.soapbank.service.BankServiceImpl getBankServiceImpl() {
    if (bankServiceImpl == null)
      _initBankServiceImplProxy();
    return bankServiceImpl;
  }
  
  public boolean deposit(int ac, double money) throws java.rmi.RemoteException{
    if (bankServiceImpl == null)
      _initBankServiceImplProxy();
    return bankServiceImpl.deposit(ac, money);
  }
  
  public com.sd.soapbank.beans.Account[] getAllAccounts() throws java.rmi.RemoteException{
    if (bankServiceImpl == null)
      _initBankServiceImplProxy();
    return bankServiceImpl.getAllAccounts();
  }
  
  public boolean setBalance(int id, double money) throws java.rmi.RemoteException{
    if (bankServiceImpl == null)
      _initBankServiceImplProxy();
    return bankServiceImpl.setBalance(id, money);
  }
  
  public boolean withdraw(int ac, double money) throws java.rmi.RemoteException{
    if (bankServiceImpl == null)
      _initBankServiceImplProxy();
    return bankServiceImpl.withdraw(ac, money);
  }
  
  public double getBalance(int id) throws java.rmi.RemoteException{
    if (bankServiceImpl == null)
      _initBankServiceImplProxy();
    return bankServiceImpl.getBalance(id);
  }
  
  public com.sd.soapbank.beans.Account getAccount(int id) throws java.rmi.RemoteException{
    if (bankServiceImpl == null)
      _initBankServiceImplProxy();
    return bankServiceImpl.getAccount(id);
  }
  
  public int createAccount(java.lang.String name, java.lang.String pass) throws java.rmi.RemoteException{
    if (bankServiceImpl == null)
      _initBankServiceImplProxy();
    return bankServiceImpl.createAccount(name, pass);
  }
  
  
}