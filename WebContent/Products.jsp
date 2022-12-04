<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<%@include file="/includes/navbar.jsp"%>
<div class="container">
<div class="card card-body " style="height:80% !important">
	<div class="card-header m-3">All Products</div>
	<div class="row">

		<c:forEach var="p" items="${productsList}">

			<div class="col-md-3 my-3">
				<div class="card w-100" >
					<img class="card-img-top" src="product-image/${p.getImage()}"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">${p.getName()}</h5>
						<h6 class="price">Price: $ ${p.getPrice()}</h6>
						<h6 class="category">Category: ${p.getCategory()}</h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark" href="add-to-cart?id=${p.getId()}">Add
								to Cart</a> <a class="btn btn-primary"
								href="OrdersServlet?quantity=1&id=${p.getId()}">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</div>


</body>
</html>