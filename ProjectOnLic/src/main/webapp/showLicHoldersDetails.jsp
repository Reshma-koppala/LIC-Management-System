<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList,com.pace.project.bean.Lic" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LIC holders details page</title>
</head>
<body>
	<%
	session.getAttribute("liclist");
	ArrayList<Lic> licList=new ArrayList<Lic>();
	licList=(ArrayList<Lic>)session.getAttribute("liclist");
	%>
	<table border='1'>
	<%
	for(Lic lic:licList){
	%>
	<tr>
	<td align="center"><%=lic.getRegistration_number() %></td>
	<td align="center"><%=lic.getName() %></td>
	<td align="center"><%=lic.getMobile_number() %></td>
	<td align="center"><%=lic.getEmail() %></td>
	<td align="center"><%=lic.getDate_of_birth() %></td>
	<td align="center"><%=lic.getPlan() %></td>
	<td align="center"><%=lic.getIncome() %></td>
	<td align="center"><%=lic.getNo_of_dependencies() %></td>
	<td align="center"><%=lic.getCountry() %></td>
	<td align="center"><%=lic.getState() %></td>
	<td align="center"><%=lic.getCity() %></td>
	<td align="center"><%=lic.getPincode() %></td>
	</tr>
	<%
	}
	%>
	</table>
	<a href="index.html">Home Page!</a>
	

</body>
</html>