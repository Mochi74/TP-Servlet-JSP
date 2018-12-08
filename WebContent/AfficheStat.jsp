<%@page import="model.Distribution"%>
<%@page import="java.util.List"%>
<%@page import="dao.StatDao"%>
<%@page import="dao.RecordDao"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jsp to display Stat</title>
</head>
<body>
	<% 
		 
		 ArrayList<Distribution> textes = StatDao.getInstance().allByBrowser();
		
	%>
	<h1>Distribution par Browser</h1>
	<ul>
	<% 	for (Distribution texte : textes){ %>
		
		<li>
			<span class='id'><%=texte.getValue() %></span>
			<span class='extract'><%=Integer.toString(texte.getVisit()) %></span>
		</li>		


	<% } %>
	
	<% 
		 
		 textes = StatDao.getInstance().allByCountry();
		
	%>
	</ul>
	
		<h1>Distribution par pays</h1>
	<ul>
	<% 	for (Distribution texte : textes){ %>
		
		<li>
			<span class='id'><%=texte.getValue() %></span>
			<span class='extract'><%=Integer.toString(texte.getVisit()) %></span>
		</li>		


	<% } %>
	</ul>
	
	<% 
		 
		 textes = StatDao.getInstance().allByDay();
		
	%>
	
		<h1>Distribution par jour</h1>
	<ul>
	<% 	for (Distribution texte : textes){ %>
		
		<li>
			<span class='id'><%=texte.getValue() %></span>
			<span class='extract'><%=Integer.toString(texte.getVisit()) %></span>
		</li>		


	<% } %></ul>
</body>
</html>