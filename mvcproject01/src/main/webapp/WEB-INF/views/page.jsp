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
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Shopping Place - ${title}</title>

<script>
	window.menu = "${title}";
	window.contextRoot = "${contextRoot}";
</script>

<!-- Bootstrap core CSS -->
<%-- <link rel="stylesheet"
 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
 	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" 
 	crossorigin="anonymous"> --%>
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap fontawesome css -->
<link href="${css}/fontAwesom_5.12.1.css" rel="stylesheet">
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
		<%@include file="./shared/navbar.jsp"%>

		<div class="content">

			<!-- WHen click logo load Page Content -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load only when click about -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load only when click contact -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- Load only when click View Products -->
			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>

			<!-- Load a single product -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>

			<!-- Load a manage product -->
			<c:if test="${userClickManageProducts == true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>

			<!-- Load a cart page -->
			<c:if test="${userClickShowCart == true}">
				<%@include file="cart.jsp"%>
			</c:if>
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
		<!-- bootstrap table plugin-->
		<%-- 		<script src="${js}/bootstrap-table.min.js"></script> --%>
		<!-- dataTable for bs4 -->
		<script src="${js}/bs4-dataTables.js"></script>
		<!-- <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.js"></script> -->
		<script src="${js}/fa-icons.js"></script>
		<!-- Bootbox js -->
		<script src="${js}/bootbox.min.js"></script>
		<!-- customize javascript -->
		<script src="${js}/myapp.js"></script>

	</div>
</body>
</html>
