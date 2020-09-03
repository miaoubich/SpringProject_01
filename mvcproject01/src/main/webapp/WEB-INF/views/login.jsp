<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="fonts" value="/resources/webfonts" />

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
<link href="${css}/all.css" rel="stylesheet">
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
		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" role="navigation">
			<div class="container">
				<!-- toggle brand on mobile mode -->
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">eTRGOVINA</a>
				</div>
			</div>
		</nav>

		<div class="content">

			<c:if test="${not empty message}">
				<div class="row">
					<div class="col-xs-12 offset-md-2 col-md-8">
						<div class="alert alert-danger fade in">${message}</div>
					</div>
				</div>
			</c:if>

			<c:if test="${not empty logout}">
				<div class="row">
					<div class="col-xs-12 offset-md-2 col-md-8">
						<div class="alert alert-success">${logout}</div>
					</div>
				</div>
			</c:if>

			<div class="row">

				<div class="offset-md-3 col-md-6">

					<div class="card">

						<div class="card-header">
							<h4>Login</h4>
						</div>

						<div class="card-body">
							<form action="${contextRoot}/login" method="POST" class="form-horizontal" id="loginForm">
								<div class="form-group row">
										<label for="username" class="col-md-4 control-label">
											Email:
										</label>
										<div class="col-md-8">
											<input type="text" name="username" id="username" class="form-control" />
										</div>
								</div>
								<div class="form-group row">
									<label for="password" class="col-md-4 control-label">
										Password:
									</label>
									<div class="col-md-8">
										<input type="password" name="password" id="password" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<div class="offset-md-4 col-md-8">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
										<input type="submit" value="Login" class="btn btn-primary" />
									</div>
								</div>
							</form>

						</div>
						<div class="card-footer">
							<div class="text-right">
								New User - <a href="${contextRoot}/register">Register Here</a>
							</div>
						</div>

					</div>

				</div>

			</div>
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- core jquery v3.4.1-->
		<script src="${js}/jquery.min.js"></script>
		<!-- core jquery  validation-->
		<script src="${js}/jquery.validate.js"></script>
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		<script src="${js}/popper.min.js"></script>
		<!-- <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.js"></script> -->
		<script src="${js}/fa-icons.js"></script>
		<!-- customize javascript -->
		<script src="${js}/myapp.js"></script>

	</div>
</body>
</html>
