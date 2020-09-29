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
					<c:forEach items="${cartLines}" var="cartLine">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs">
										<img src="${images}/${cartLine.product.code}.jpg" alt="${cartLine.product.name}" class="img-responsive img-Cart" />
									</div>
									<div class="col-sm-10">
										<h4 class="nomargin" style="padding-left: 20px">${cartLine.product.name}
											<c:if test="${cartline.available == false}">
												<strong>(Not Available)</strong>
											</c:if>
										</h4>
										<p style="padding-left: 20px">${cartLine.product.brand}</p>
										<p style="padding-left: 20px">${cartLine.product.description}</p>
									</div>
								</div>
							</td>
							<td data-th="Price">&euro; ${cartLine.buyingPrice}</td>
							<td data-th="Quantity">
								<input type="number" id="count_${cartLine.id}" min="1" max="${cartLine.product.quantity}" class="form-control text-center" value="${cartLine.productCount}">
							</td>
							<td data-th="Subtotal" class="text-center">&euro; ${cartLine.total}</td>
							<td class="actions" data-th="">
								<button type="button" name="refreshCart" value="${cartLine.id}" class="btn btn-info btn-sm">
									<i class="fa fa-sync-alt"></i>
								</button>
								<button class="btn btn-danger btn-sm">
									<i class="fa fa-trash-alt"></i>
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				
				<tfoot>
					<tr class="visible-xs">
						<td class="text-center"><strong>Total: &euro; ${userModel.cart.grandTotal}</strong></td>
					</tr>
					<tr>
						<td><a href="#" class="btn btn-warning"><i
								class="fa fa-angle-left"></i> Continue Shopping</a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>Total: &euro; ${userModel.cart.grandTotal}</strong></td>
						<td><a href="#" class="btn btn-success btn-block">Checkout
								<i class="fa fa-angle-right"></i>
						</a></td>
					</tr>
				</tfoot>
				
			</table>

		</c:when>
		<c:otherwise>

			<!-- 			<div class="jumbotron"> -->
			<div class="text-center" style="padding-top: 100px">
				<img src="${images}/empty_cart.jpg" class="emptyCartImg"
					alt="Empty Cart !" />
				<h2 style="color: black">Your Shopping Cart is empty</h2>
			</div>
			<!-- 			</div> -->

		</c:otherwise>

	</c:choose>
</div>