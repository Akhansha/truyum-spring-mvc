<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<body onload="menuListAdminLoaded()">
    <header class="header">
        <h1 class="heading-truYum">truYum</h1>
        <img src="Images/fork-knife.png" alt="forandKnife" class="forkImg">
        <a href="menu-item-list-admin.html" class="menu-button">Menu</a>
    </header>
    <div class="body">
        <h1 class="body-text-heading" id="">Menu Items</h1>
        <div id="menu-Item-List-Result">
        	<table>
        		<tr>
        			<th>Name</th>
        			<th>Price</th>
        			<th>Active</th>
        			<th>Date of launch</th>
        			<th>Category</th>
        			<th>Free Delivery</th>
        			<th></th>
        		</tr>
        		<c:forEach var="item" items="${menuItemListAdmin}">
        			<tr>
        				<td>${item.name}</td>
        				<td>${item.price}</td>
        				<td>${item.active}</td>
        				<td>${item.dateOfLaunch}</td>
        				<td>${item.category}</td>
        				<td>${item.freeDelivery}</td>
        				<td><a href="/show-edit-menu-item?menuItemId=${item.id}">Edit</a></td>
        			</tr>
        		
        		</c:forEach>
        	</table>
        </div>
    </div>
    <footer class="footer"><label class="copyright">Copyright Â© 2020</label></footer>
</body>
</html>