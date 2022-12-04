	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">E-Commerce Cart</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="./ProductServlet">Home</a></li>
				<c:if test="${user!=null}">
					<li class="nav-item"><a class="nav-link" href="./CartDisplayServlet">Cart
							<span class="badge badge-danger">${cart_list.size()}</span>
					</a></li>

					<li class="nav-item"><a class="nav-link" href="./OrdersDisplayServlet">Orders</a></li>

					<li class="nav-item"><a class="nav-link" href="./LogoutServlet">Logout</a></li>

					<li class="nav-item">${user.getFname()}</li>

				</c:if>
				<c:if test="${user==null}">
				<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>