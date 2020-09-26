<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">

	<c:choose>
		<c:when test="${not empty cartLines}">

			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 50%">Product</th>
						<th style="width: 10%">Price</th>
						<th style="width: 8%">Quantity</th>
						<th style="width: 22%" class="text-center">Subtotal</th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td data-th="Product">
							<div class="row">
								<div class="col-sm-2 hidden-xs">
									<img src="http://placehold.it/100x100" alt="..."
										class="img-responsive" />
								</div>
								<div class="col-sm-10">
									<h4 class="nomargin" style="padding-left: 20px">Product 1</h4>
									<p style="padding-left: 20px">Quis aute iure reprehenderit
										in voluptate velit esse cillum dolore eu fugiat nulla
										pariatur. Lorem ipsum dolor sit amet.</p>
								</div>
							</div>
						</td>
						<td data-th="Price">$1.99</td>
						<td data-th="Quantity"><input type="number"
							class="form-control text-center" value="1"></td>
						<td data-th="Subtotal" class="text-center">1.99</td>
						<td class="actions" data-th="">
							<button class="btn btn-info btn-sm">
								<i class="fa fa-sync-alt"></i>
							</button>
							<button class="btn btn-danger btn-sm">
								<i class="fa fa-trash-alt"></i>
							</button>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr class="visible-xs">
						<td class="text-center"><strong>Total 1.99</strong></td>
					</tr>
					<tr>
						<td><a href="#" class="btn btn-warning"><i
								class="fa fa-angle-left"></i> Continue Shopping</a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>Total
								$1.99</strong></td>
						<td><a href="#" class="btn btn-success btn-block">Checkout
								<i class="fa fa-angle-right"></i>
						</a></td>
					</tr>
				</tfoot>
			</table>

		</c:when>
		<c:otherwise>
		
			<div class="jumbotron">
				<div class="text-center">
					<img src="${images}/empty_cart.jpg" class="emptyCartImg" alt="Empty Cart !" />
					<p style="color:black">Your Shopping Cart is empty</p>
				</div>
			</div>
		
		</c:otherwise>
		
	</c:choose>
</div>