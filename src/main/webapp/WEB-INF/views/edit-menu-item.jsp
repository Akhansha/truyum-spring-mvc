<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="style/styles.css">
<script src="scripts/code.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>
	<header class="header">
		<h1 class="heading-truYum">truYum</h1>
		<img src="Images/fork-knife.png" alt="forandKnife" class="forkImg">
		<a href="/show-menu-list-admin" class="menu-button">Menu</a>
	</header>
	<div class="body">
		<h2 class="body-text-heading">Edit Menu Item</h2>
		<form class="form-edit-menu" name="menuItemForm" method="POST" action="edit-menu-item">
			<label for="name">Name</label><br> <input type="text" name="title" id="title" minlength="2" value="${menuItem.name}"
				maxlength="65" size="80" required><br>
			<table>
				<tr class="form-table-edit-menu-row">
					<td class="form-table-edit-menu"><label for="field-price">Price
							(Rs.)</label></td>
					<td class="form-table-edit-menu"><label for="field-active">Active</label></td>
					<td class="form-table-edit-menu"><label
						for="field-datoflaunch">Date of Launch</label></td>
					<td class="form-table-edit-menu"><label for="filed-category">Category</label></td>
				</tr>
				<tr class="form-table-edit-menu-row">
					<td class="form-table-edit-menu"><input type="number"
						value="${menuItem.price}" name="price" id="price" width="10"
						required></td>
					<td class="form-table-edit-menu">
					<input type="radio" name="inStock" id="inStock" width="10" value="Yes" <c:if test="${menuItem.active}">checked</c:if> /> 
						<label>Yes</label>
						<input type="radio" name="inStock" id="inStock" width="10" <c:if test="${not menuItem.active}">checked</c:if>
						value="No"> <label>No</label></td>
					<td class="form-table-edit-menu"><input type="date"
						value="${menuItem.dateOfLaunch}" name="dateOfLaunch"
						id="dateOfLaunch" required width="10"></td>
					<td class="form-table-edit-menu">
					<select name="category" id="category">
							<c:forEach var="x" items="${catogoryList}">
								<option value="${x}">${x}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
			</table>
			<input type="checkbox" value="${menuItem.freeDelivery}"
				name="freeDelivery" id="freeDelivery" <c:if test="${menuItem.freeDelivery}">checked</c:if>> <label>Free
				Delivery</label><br>
			<input type="submit" value="Save">
		</form>
	</div>
	<footer class="footer">
		<label class="copyright">Copyright © 2020</label>
	</footer>
</body>
</html>