<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">

	<div class="row">

		<!-- Display sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- Display the actual products -->
		<div class="col-md-9">

			<!-- Add breacrumb component -->
			<div class="row">
				<div clas="col-lg-12">

					<c:if test="${userClickAllProducts == true}">
						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>
						</ol>
					</c:if>
				</div>

			</div>

			<div class="row">

				<div class="col-sm-12">

					<div class="container-fluid">
						<div class="table-responsive">

							<table id="productListTable" class="table table-striped"
								data-toggle="table" data-pagination="true" data-search="true"
								style="width: 100%">

								<thead>
									<tr>
										<!-- 							<th data-sortable="true">ID</th> -->
										<th></th>
										<th>Name</th>
										<th>Brand</th>
										<th>Unit Price</th>
										<th>Qty. Available</th>
										<th></th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th></th>
										<th>Name</th>
										<th>Brand</th>
										<th>Unit Price</th>
										<th>Qty. Available</th>
										<th></th>
									</tr>
								</tfoot>
							</table>
							
						</div>
					</div>
					
				</div>

			</div>
		</div>

	</div>

</div>