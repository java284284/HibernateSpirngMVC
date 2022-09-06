<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>線上商店</title>

<!-- web icon -->
<link rel="icon" href="/BreadShop/assets/favicon.ico">

<!-- bootstrap 5.1.3 CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!-- bootstrap 5.1.3 JS -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<!-- jQuery 3.6.0 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<!-- font awesome 5.10.0 -->
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />

<!-- 自定義CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shopping.css">

<style>
</style>

</head>

<body>

	<jsp:include page="navigate.jsp" />

	<main class="mb-5">
		<div class="container">

			<!-- 購物車圖標 -->
			<div class="py-5 text-center">
				<div class="d-block mx-auto mb-4">
					<i class="fas fa-shopping-cart fa-2x"></i>
				</div>
				<h2>購物車</h2>
			</div>
			<!-- 購物車圖標 -->


			<div class="row g-5">

				<!-- 右側區塊，商品清單 -->
				<div class="col-md-6 col-lg-6 order-md-last">
					<h4 class="d-flex justify-content-between align-items-center mb-3">
						<span class="text-primary">商品清單</span> <span
							class="badge bg-primary rounded-pill">2</span>
					</h4>
					<ul class="list-group mb-3">
						<!-- 重複的結構 -->
						<li class="list-group-item d-flex justify-content-between lh-sm">
							<div>
								<h6 class="my-0 ">
									<a class="deleteProduct" href="#">某個蛋糕</a>
								</h6>
							</div> <span class="text-muted subtotal"
							subtotal="${s.quantity * s.products.price}">2個 × $50 =
								$100</span>
						</li>
						<!-- 重複的結構 -->
						
						<li class="list-group-item d-flex justify-content-between lh-sm">
							<div>
								<h6 class="my-0 ">
									<a class="deleteProduct" href="#">某些餅乾</a>
								</h6>
							</div> <span class="text-muted subtotal"
							subtotal="${s.quantity * s.products.price}"> 3個 × $100 =
								$300</span>
						</li>

						<li class="list-group-item d-flex justify-content-between"><span>總金額
								(TW)</span> <strong id="total">400</strong></li>
					</ul>
				</div>
				<!-- 右側區塊，商品清單 -->

				<!-- 左側區塊，帳單地址 -->
				<div class="col-md-6 col-lg-6">
					<h4 class="mb-3">帳單地址</h4>
					<form class="needs-validation" novalidate>
						<div class="row g-3">
							<div class="col-sm">
								<label for="firstName" class="form-label">姓名</label> <input
									type="text" class="form-control" id="firstName" placeholder=""
									value="" required>
							</div>
							<div class="col-12">
								<label for="email" class="form-label">Email </label> <input
									type="email" class="form-control" id="email"
									placeholder="you@example.com">
							</div>
							<div class="col-12">
								<label for="address" class="form-label">地址</label> <input
									type="text" class="form-control" id="address"
									placeholder="台北市大安區..." required>
							</div>
						</div>

						<hr class="my-4">

						<div class="form-check">
							<input type="checkbox" class="form-check-input" id="save-info">
							<label class="form-check-label" for="save-info">將帳單資訊加入快速結帳</label>
						</div>
						<hr class="my-4">
						<h4 class="mb-3">付款方式</h4>
						<div class="my-3">
							<div class="form-check">
								<input id="credit" name="paymentMethod" type="radio"
									class="form-check-input" checked required> <label
									class="form-check-label" for="credit">信用卡</label>
							</div>
							<div class="form-check">
								<input id="debit" name="paymentMethod" type="radio"
									class="form-check-input" required> <label
									class="form-check-label" for="debit">網路轉帳</label>
							</div>
							<div class="form-check">
								<input id="paypal" name="paymentMethod" type="radio"
									class="form-check-input" required> <label
									class="form-check-label" for="paypal">LinePay</label>
							</div>
						</div>
						<hr class="my-4">
						<button class="w-100 btn btn-primary btn-lg" type="submit">前往付款(未實作)</button>
					</form>
				</div>
				<!-- 左側區塊，帳單地址 -->

			</div>
		</div>
	</main>

	<jsp:include page="footer.jsp" />

</body>

</html>