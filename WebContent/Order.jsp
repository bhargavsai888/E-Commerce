<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<%@include file="/includes/navbar.jsp"%>


<div class="container m-5">
	

		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>


				<c:forEach var="ol" items="${orderList}">
					<tr>
					
						<td>${ ol.getDate()}</td>
						<td>${ ol.getName()}</td>
						<td>${ol.getCategory()}</td>
						<td>${ol.getQuantity()}</td>
						<td>${ol.getPrice()}</td>
						
						<td>
						<a href="./IncDecServlet?action=rmv&id=${ol.getOrderId()}" class="btn btn-danger">Cancel</a>
						</td>
					</tr>


				</c:forEach>
			</tbody>
		</table>
</body>
</html>