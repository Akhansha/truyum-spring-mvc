<%@ include file="common/taglibs-and-head.jspf"%>
<div class="container-my">
	<%@ include file="common/header-with-cart.jspf"%>
	<div class="body">
		<h2 class="body-text-heading">Cart</h2>
		<div id="cart-result">
			<div class="show-cart-table">
				<table class="table">
					<tr>
						<th>Name</th>
						<th>Free Delivery</th>
						<th>Price</th>
						<th></th>
					</tr>
					<c:forEach var="menuItem" items="${cartItems}">
						<tr>
							<td>${menuItem.name}</td>
							<td><c:choose>
									<c:when test="${menuItem.freeDelivery}">
									Yes
								</c:when>
									<c:otherwise>
									No
								</c:otherwise>
								</c:choose></td>
							<td>${menuItem.price}</td>
							<td><a href="/remove-cart?menuItemId=${menuItem.id}&userId=${userId}">Delete</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td class="cart-footer-row">Total</td>
						<td class="cart-footer-row">${total}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<%@ include file="common/footer.jspf"%>
</div>
<%@ include file="common/end-tags.jspf"%>