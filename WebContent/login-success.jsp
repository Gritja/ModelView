<%@page import="a.Package.anBean"%>

<p>You are successfully logged in!</p>

<%
Cookie chocolateChip[] = request.getCookies();
anBean bonanza=(anBean)request.getAttribute("bean");
out.print("Welcome, " + bonanza.getName() +"<br>");
out.print("Your secret password is " + bonanza.getPassword());

%>

