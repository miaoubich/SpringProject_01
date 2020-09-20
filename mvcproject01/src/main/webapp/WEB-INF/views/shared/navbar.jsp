<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">

		<!-- nav Brand -->
		<a class="navbar-brand" href="${contextRoot}/home"><b><i>eTRGOVINA</i></b></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<!-- nav Items -->
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				
				<security:authorize access="hasAuthority('ADMIN')">
					<li class="nav-item" id="manageProducts">
						<a class="nav-link" href="${contextRoot}/manage/products">
							<i class="fas fa-dolly-flatbed"></i> Management
						</a>
					</li>
				</security:authorize>
				
				<li class="nav-item" id="listProducts">
					<a class="nav-link" href="${contextRoot}/show/all/products">
						<i class="fas fa-boxes"></i> Products
					</a>
				</li>
				<li class="nav-item" id="about">
					<a class="nav-link" href="${contextRoot}/about">
						<i class="fa fa-globe"></i> About us
					</a>
				</li>
				<li class="nav-item" id="contact">
					<a class="nav-link" href="${contextRoot}/contact">
						<i class="fa fa-envelope"></i> Contact
					</a>
				</li>

				<security:authorize access="isAnonymous()">
					<li class="nav-item" id="login">
						<a href="login" class="nav-link">
							<i class="fas fa-sign-in-alt"></i> sign-in
						</a>
					</li>
					<li class="nav-item" id="register">
						<a href="${contextRoot}/register" class="nav-link">
							<i class="fas fa-user-plus"></i> sign-up
						</a>
					</li>
				</security:authorize>
				
				<security:authorize access="isAuthenticated()">
					<!-- Dropdown -->
					<li class="nav-item dropdown">
						<a href="javascript:void(0)" class="nav-link dropdown-toggle" id="dropdownMenu1"
							data-toggle="dropdown"> 
							${userModel.fullname}
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<security:authorize access="hasAuthority('USER')">
								<li>
									<a class="dropdown-item" href="${contextRoot}/cart">
										<i class="fas fa-shopping-basket"></i>
										<span class="badge">${userModel.cart.cartLines}</span>
										- &euro; ${userModel.cart.grandTotal}
									</a>
								</li>
								<li class="divider" role="separator"></li>
							</security:authorize>
							
							<li>
								<a class="dropdown-item" href="${contextRoot}/perform-logout">
									<i class="fas fa-sign-out-alt"></i> sign-out
								</a>
							</li> 
						</ul>
					</li>
				</security:authorize>
				
			</ul>


		</div>

	</div>
</nav>

<script>
	window.userRole = '${userModel.role}';
</script>


