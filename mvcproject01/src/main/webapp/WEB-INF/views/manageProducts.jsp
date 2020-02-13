<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row">

		<div class="offset-md-2 col-md-8">

			<div class="card">

				<div class="card-header bg-primary text-white">Product
					Management</div>

				<div class="card-body">

					<sf:form class="form-horizontal" modelAttribute="product">

						<div class="form-group">
							<div class="row">
								<label class="control-label col-md-4" for="name">Enter
									Product Name: </label>
								<div class="col-md-8">
									<sf:input type="text" path="name" id="name"
										class="form-control" placeholder="Enter Product Name" />
									<em class="help-block">Please enter a product name!</em>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label class="control-label col-md-4" for="brand">Enter
									Brand Name: </label>
								<div class="col-md-8">
									<sf:input type="text" path="brand" id="brand"
										class="form-control" placeholder="Enter Brand Name" />
									<em class="help-block">Please enter a brand name!</em>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<label class="control-label col-md-4" for="description">Product
									description: </label>
								<div class="col-md-8">
									<sf:textarea path="description" id="description" rows="4"
										class="form-control"
										placeholder="Please write some description" />
									<em class="help-block">Please enter a description!</em>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="row">
								<label class="control-label col-md-4" for="unitPrice">Enter
									unit price: </label>
								<div class="col-md-8">
									<sf:input type="number" path="unitPrice" id="unitPrice"
										class="form-control" placeholder="unit price in &euro;" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<label class="control-label col-md-4" for="quantity">Quantity
									available: </label>
								<div class="col-md-8">
									<sf:input type="number" path="quantity" id="quantity"
										class="form-control" placeholder="quantity available" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<label class="control-label col-md-4" for="category">Select
									category: </label>
								<div class="col-md-8">
									<select type="number" name="categoryId" id="categoryId"
										class="form-control">
										<option value="1">Category One</option>
										<option value="2">Category Two</option>
									</select>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="offset-md-4 col-md-8">
								<input type="submit" name="submit" id="submit"
									class="btn btn-primary" value="Submit" />
							</div>
						</div>
					</sf:form>

				</div>

			</div>


		</div>

	</div>

</div>
