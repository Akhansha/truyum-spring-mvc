<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="style/styles.css">
    <script src="scripts/code.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body >
    <header class="header">
        <h1 class="heading-truYum">truYum</h1>
        <img src='<c:url value="/resources/images/fork-knife.png" />' />
        <a href="menu-item-list-customer.html" class="menu-button">Menu</a>
        <a href="cart.html" class="cart-button">Cart</a>
    </header>
    <div class="body">
        <h1 class="body-text-heading">Products</h1>
        <div id="menu-item-customer-result">
        	<table>
        		<tr>
        			<th>Name</th>
        			<th>Free Delivery</th>
        			<th>Price</th>
        			<th>Category</th>
        			<th>Action</th>
        		</tr>
        		<c:forEach var="item" items="${menuItemListCustomer}">
        			<tr>
        				<td>${item.name}</td>
        				<td>${item.freeDelivery}</td>
        				<td>${item.price}</td>
        				<td>${item.category}</td>
        				<td><a href="/add-to-cart?menuItemId=${item.id}">Add to Cart</a></td>
        			</tr>
        		
        		</c:forEach>
        	</table>
        </div>
    </div>
    <footer class="footer"><label class="copyright">Copyright © 2020</label></footer>
</body>
</html>