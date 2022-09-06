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

<!-- 自定義CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shop.css">

</head>

<body>
	<jsp:include page="navigate.jsp" />
	<div class="py-5 text-center container" style="color: red">${message }</div>
	<main>
		<!-- 輪播圖片 -->
		<section class="py-5 text-center container">
			<div id="carouselExampleIndicators" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="${pageContext.request.contextPath}/img/Switch.jpg"
							class="d-block w-100 ">
					</div>
					<div class="carousel-item">
						<img src="${pageContext.request.contextPath}/img/ps5.jpg"
							class="d-block w-100 ">
					</div>
					<div class="carousel-item">
						<img src="${pageContext.request.contextPath}/img/xbox.jpg"
							class="d-block w-100 ">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</section>
		<!-- 輪播圖片 -->
		<div class="py-5 text-center container">
			<form action="${pageContext.request.contextPath}/searchaction.controller">
				搜尋:<input type="text" name="search" placeholder="想要收搜尋的商品">
				<button>GO</button>
			</form>
		</div>
<!-- 		<div class="py-5 text-center container"> -->
<!-- 			金錢排序(由小到大)<input type="checkbox" id="cbox1" name="cbox1" value="ok" -->
<!-- 				onclick="ch()"> <a href="" id="change"><button>套用</button></a> -->
<!-- 		</div> -->

		<div class="album py-5 bg-light">
			<div class="container">
				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

					<!-- 重複的結構 -->
					<c:forEach items="${allProducts }" var="p">
						<div class="col">
							<div class="card">
								<img style="height: 400px"
									src="${pageContext.request.contextPath}/imgaction.controller?id=${p.id}"
									class="card-img-top">
<!-- 								<img style="height: 400px" -->
<%-- 									src="${pageContext.request.contextPath}/imgaction.controller?name=${p.name}" --%>
<!-- 									class="card-img-top"> -->
								<div class="card-body text-center fs-4">${p.name }</div>
								<div class="card-footer text-end">
									<span class="me-5">$${p.price }</span>
<%-- 									<c:if test="${users.name!='admin' }"> --%>
<%-- 										<button class="btn btn-primary add" productId="${p.id }">加入購物車</button> --%>
<%-- 									</c:if> --%>
									<c:if test="${users.name=='admin' }">

										<a
											href="${pageContext.request.contextPath}/update.com?id=${p.id}&name=${p.name}&price=${p.price}"
											style="text-decoration: none; color: white"><button
												class="btn btn-primary add" productId="${p.id }">
												編輯商品</button></a>


										<a
											href="${pageContext.request.contextPath}/deleteaction.controller?id=${p.id}"
											style="text-decoration: none; color: white"><button
												class="btn  btn-danger ">刪除商品</button></a>


									</c:if>
								</div>
							</div>
						</div>
					</c:forEach>
					<!-- 重複的結構 -->

				</div>
			</div>
		</div>
	</main>

	<jsp:include page="footer.jsp" />

</body>
<script type="text/javascript">
// 	var c = 0
// 	function ch() {
// 		var t = window.location.href

// 		if (c % 2 == 0) {

// 			if (t.includes("do?")) {
// 				t += '&cbox1=ok'
// 			}
// 			if (t.includes("do?") == false) {
// 				t += '?cbox1=ok'
// 			}
// 			document.getElementById("change").setAttribute("href", t);
// 		}
// 		document.getElementById("change").setAttribute("href", t);
// 		c += 1
// 	}
</script>
</html>