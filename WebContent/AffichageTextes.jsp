<%@page import="model.Texte"%>
<%@page import="java.util.List"%>
<%@page import="dao.TextDao"%>
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
		List<Texte> textes = TextDao.getInstance().all(); 
		
	%>
	<h1>Listes des Textes</h1>
	<ul>
	<% 	for (Texte texte : textes){ %>
		
		<li>
			<span class='id'><%=texte.getId() %></span>
			<span class='extract'><%=texte.getText().substring(0,Math.min(texte.getText().length(),200)) %></span>
		</li>		


	<% } %></ul>
</body>
</html>