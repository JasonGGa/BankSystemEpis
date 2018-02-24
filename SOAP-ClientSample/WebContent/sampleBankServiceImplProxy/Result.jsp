<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleBankServiceImplProxyid" scope="session" class="com.sd.soapbank.service.BankServiceImplProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleBankServiceImplProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleBankServiceImplProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleBankServiceImplProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.sd.soapbank.service.BankServiceImpl getBankServiceImpl10mtemp = sampleBankServiceImplProxyid.getBankServiceImpl();
if(getBankServiceImpl10mtemp == null){
%>
<%=getBankServiceImpl10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String ac_1id=  request.getParameter("ac18");
        int ac_1idTemp  = Integer.parseInt(ac_1id);
        String money_2id=  request.getParameter("money20");
        double money_2idTemp  = Double.parseDouble(money_2id);
        boolean deposit15mtemp = sampleBankServiceImplProxyid.deposit(ac_1idTemp,money_2idTemp);
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deposit15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
break;
case 22:
        gotMethod = true;
        com.sd.soapbank.beans.Account[] getAllAccounts22mtemp = sampleBankServiceImplProxyid.getAllAccounts();
if(getAllAccounts22mtemp == null){
%>
<%=getAllAccounts22mtemp %>
<%
}else{
        String tempreturnp23 = null;
        if(getAllAccounts22mtemp != null){
        java.util.List listreturnp23= java.util.Arrays.asList(getAllAccounts22mtemp);
        tempreturnp23 = listreturnp23.toString();
        }
        %>
        <%=tempreturnp23%>
        <%
}
break;
case 25:
        gotMethod = true;
        String id_3id=  request.getParameter("id28");
        int id_3idTemp  = Integer.parseInt(id_3id);
        String money_4id=  request.getParameter("money30");
        double money_4idTemp  = Double.parseDouble(money_4id);
        boolean setBalance25mtemp = sampleBankServiceImplProxyid.setBalance(id_3idTemp,money_4idTemp);
        String tempResultreturnp26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(setBalance25mtemp));
        %>
        <%= tempResultreturnp26 %>
        <%
break;
case 32:
        gotMethod = true;
        String ac_5id=  request.getParameter("ac35");
        int ac_5idTemp  = Integer.parseInt(ac_5id);
        String money_6id=  request.getParameter("money37");
        double money_6idTemp  = Double.parseDouble(money_6id);
        boolean withdraw32mtemp = sampleBankServiceImplProxyid.withdraw(ac_5idTemp,money_6idTemp);
        String tempResultreturnp33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(withdraw32mtemp));
        %>
        <%= tempResultreturnp33 %>
        <%
break;
case 39:
        gotMethod = true;
        String id_7id=  request.getParameter("id42");
        int id_7idTemp  = Integer.parseInt(id_7id);
        double getBalance39mtemp = sampleBankServiceImplProxyid.getBalance(id_7idTemp);
        String tempResultreturnp40 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getBalance39mtemp));
        %>
        <%= tempResultreturnp40 %>
        <%
break;
case 44:
        gotMethod = true;
        String id_8id=  request.getParameter("id55");
        int id_8idTemp  = Integer.parseInt(id_8id);
        com.sd.soapbank.beans.Account getAccount44mtemp = sampleBankServiceImplProxyid.getAccount(id_8idTemp);
if(getAccount44mtemp == null){
%>
<%=getAccount44mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">name:</TD>
<TD>
<%
if(getAccount44mtemp != null){
java.lang.String typename47 = getAccount44mtemp.getName();
        String tempResultname47 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typename47));
        %>
        <%= tempResultname47 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">pass:</TD>
<TD>
<%
if(getAccount44mtemp != null){
java.lang.String typepass49 = getAccount44mtemp.getPass();
        String tempResultpass49 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepass49));
        %>
        <%= tempResultpass49 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">balance:</TD>
<TD>
<%
if(getAccount44mtemp != null){
java.lang.Double typebalance51 = getAccount44mtemp.getBalance();
        String tempResultbalance51 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typebalance51));
        %>
        <%= tempResultbalance51 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getAccount44mtemp != null){
%>
<%=getAccount44mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 57:
        gotMethod = true;
        String name_9id=  request.getParameter("name60");
            java.lang.String name_9idTemp = null;
        if(!name_9id.equals("")){
         name_9idTemp  = name_9id;
        }
        String pass_10id=  request.getParameter("pass62");
            java.lang.String pass_10idTemp = null;
        if(!pass_10id.equals("")){
         pass_10idTemp  = pass_10id;
        }
        int createAccount57mtemp = sampleBankServiceImplProxyid.createAccount(name_9idTemp,pass_10idTemp);
        String tempResultreturnp58 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(createAccount57mtemp));
        %>
        <%= tempResultreturnp58 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>