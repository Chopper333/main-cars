<%@tag description="Page template" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title><c:out value="${pageTitle}" /></title>

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>


<nav class="light-blue lighten-1" role="navigation">
	<div class="nav-wrapper container">
	
		<a id="logo-container" href="#" class="brand-logo">Cars All Day<i class="medium material-icons">directions_car</i></a>
		<ul class="right hide-on-med-and-down">
		<li><a href="freecarslist.jsp">Free cars</a></li>
		<li><a href="registrationform.jsp">Registration</a></li>
		<li><a href="busycarslist.jsp">Busy cars</a></li>
		<li><a href="requestform.jsp">Request</a></li>
			<li><a href="#"><% java.util.Date date = new
					java.util.Date(); out.print(date.toString()); %></a></li>
		</ul>
		
	</div>
</nav>
<%-- 
<nav class="light-blue lighten-1" role="navigation">
	<div class="nav-wrapper container">
		<ul class="right hide-on-med-and-down">
		<li><a href="index.jsp">Task list</a></li>
			<li><a href="tasks.jsp">Tasks</a></li>
			<li><a href="participants.jsp">Participants</a></li>
			<li><a href="#">Settings</a></li>
			<li><a href='#'><% java.util.Date date = new java.util.Date(); out.print(date.toString()); %>
			</a></li>
			<li><a class="btn-small btn-floating waves-effect waves-light blue" title="Ð²ÑÐ¹ÑÐ¸" href="#"><i class="material-icons">input</i></a></li>
		</ul>
	</div>
	
</nav>
--%>
<div class="section no-pad-bot" id="index-banner">
	<div class="container">
		 <jsp:doBody/> <!-- Page body will be here -->
	</div>
</div>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>
