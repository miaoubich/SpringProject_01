<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shopping Place - ${title}</title>

<script>
	window.menu = "${title}";
	window.contextRoot = "${contextRoot}";
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap fontawesome css -->
<link href="${css}/fontawesome.css" rel="stylesheet">
<!-- bootstrap css theme -->
<link href="${css}/bootstrap.cerulean.theme.css" rel="stylesheet">
<!-- Bootstrap table css -->
<%-- <link href="${css}/bootstrap-table.min.css" rel="stylesheet"> --%>
<!-- dataTables for bs4 css -->
<!-- <link rel="stylesheet" type="text/css" -->
<!-- 	href="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.css" /> -->
<link href="${css}/bs4-dataTables.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">
</head>

<body>
	<div class="wrapper">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">

				<!-- nav Brand -->
				<a class="navbar-brand" href="${contextRoot}/home"><b><i>eTRGOVINA</i></b></a>
			</div>
		</nav>


		<div class="content">

			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="jumbotron">
							
							<h2>${errorTitle}</h2>
							<hr/>
							<blockquote style="word-wrap:break-word">
								${errorDescription}
							</blockquote>
						
						</div>
					</div>
				</div>
			</div>

		</div>
		
		<%@include file="./shared/footer.jsp" %>
	</div>
</body>
</html>
