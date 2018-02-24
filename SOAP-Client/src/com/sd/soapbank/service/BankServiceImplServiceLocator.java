/**
 * BankServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sd.soapbank.service;

public class BankServiceImplServiceLocator extends org.apache.axis.client.Service implements com.sd.soapbank.service.BankServiceImplService {

    public BankServiceImplServiceLocator() {
    }


    public BankServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BankServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BankServiceImpl
    private java.lang.String BankServiceImpl_address = "http://localhost:8080/BANK_SOAP/services/BankServiceImpl";

    public java.lang.String getBankServiceImplAddress() {
        return BankServiceImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BankServiceImplWSDDServiceName = "BankServiceImpl";

    public java.lang.String getBankServiceImplWSDDServiceName() {
        return BankServiceImplWSDDServiceName;
    }

    public void setBankServiceImplWSDDServiceName(java.lang.String name) {
        BankServiceImplWSDDServiceName = name;
    }

    public com.sd.soapbank.service.BankServiceImpl getBankServiceImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BankServiceImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBankServiceImpl(endpoint);
    }

    public com.sd.soapbank.service.BankServiceImpl getBankServiceImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sd.soapbank.service.BankServiceImplSoapBindingStub _stub = new com.sd.soapbank.service.BankServiceImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getBankServiceImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBankServiceImplEndpointAddress(java.lang.String address) {
        BankServiceImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sd.soapbank.service.BankServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sd.soapbank.service.BankServiceImplSoapBindingStub _stub = new com.sd.soapbank.service.BankServiceImplSoapBindingStub(new java.net.URL(BankServiceImpl_address), this);
                _stub.setPortName(getBankServiceImplWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BankServiceImpl".equals(inputPortName)) {
            return getBankServiceImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.soapbank.sd.com", "BankServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.soapbank.sd.com", "BankServiceImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BankServiceImpl".equals(portName)) {
            setBankServiceImplEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
