<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Shopping</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>
	<div class="container">
		<div class="d-flex py-3">
			<div align="left" class="h5">Total Price$: ${totalPrice}</div>
			
		</div>

		<div class="card-header m-3">Proceed to Buy</div>
		<div class="row">

			<c:forEach var="p" items="${cart_list}">
				<div class="col-md-4 my-3">
					<div class="card w-100">
						<img class="card-img-top" src="product-image/${p.getImage()}"
							alt="Card image cap">
						<div class="card-body">
							<h1 class="display-6">${p.getName()}</h1>
							<h6 class="price">Price: ${p.getPrice()}</h6>
							<h6 class="category">Category:${p.getCategory()}</h6>
							<div class="mt-3 d-flex justify-content-between">
							<a class=" btn btn-primary" role="button" href="./OrdersServlet?id=${p.getId()}">Buy</a>
										
							<a class="btn btn-danger" href="./IncDecServlet?action=rmv&id=${p.getId()}" role="button">Remove<i
										class="fas fa-Remove-square"></i></a>
						</div>
							<form action="" method="post" class="form-inline">
								<input type="hidden" name="id" value="1" class="form-input">
								<div class="mt-4 d-flex justify-content-between">
									<a class="sm btn btn-incre" href="./IncDecServlet?action=inc&id=${p.getId()}"><i
										class="fas fa-plus-square"></i></a> <input type="text"
										name="quantity" class="form-control" value="${p.getQuantity()}" readonly>
									<a class="sm btn btn-dec" href="./IncDecServlet?action=dec&id=${p.getId()}"><i
										class="fas fa-minus-square"></i></a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</c:forEach>
</body>
</html>