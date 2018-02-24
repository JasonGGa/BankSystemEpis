/**
 * BankServiceImplService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sd.soapbank.service;

public interface BankServiceImplService extends javax.xml.rpc.Service {
    public java.lang.String getBankServiceImplAddress();

    public com.sd.soapbank.service.BankServiceImpl getBankServiceImpl() throws javax.xml.rpc.ServiceException;

    public com.sd.soapbank.service.BankServiceImpl getBankServiceImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
