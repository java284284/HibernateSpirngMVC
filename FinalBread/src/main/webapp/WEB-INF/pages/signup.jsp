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
	href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	<div>${message}</div>
	<div class="container text-center ">
		<main class="form-signin m-5">
			<div style="color: red">${message }</div>

			<!-- 表單開始 -->
			<form action="${pageContext.request.contextPath}/signaction.controller"
				method="post">
				<h1 class="h3 mb-3 fw-normal">電話號碼註冊</h1>
				<div class="form-floating">
					<input type="text" class="form-control" id="phone" name="phone"
						onblur="ckPhone()" onfocus="defaultPhoneOut()" required> <label
						for="phone">電話</label><span style="color: red" id="phoneout"></span>
				</div>
				<div class="form-floating">
					<input type="text" class="form-control" id="name" name="name"
						required> <label for="name">會員名稱</label>
				</div>
				<div class="form-floating">
					<input type="date" class="form-control" id="birthday"
						name="birthday" required> <label for="birthday">生日</label>
				</div>
				<div class="form-floating">
					<input type="text" class="form-control" id="pid" name="pid"
						maxlength="10" onblur="ckId()" onfocus="defaultIdOut()" required>
					<label for="pid">身分證號碼</label><span style="color: red" id="idout"></span>
				</div>
				<div class="form-floating">
					<input type="text" class="form-control" id="pwd" name="pwd"
						required> <label for="pwd">密碼</label>
				</div>




				<div class=" mb-2">
					<button class="w-25 btn btn-lg btn-primary">註冊</button>
				</div>

			</form>
			<!-- 表單結束 -->
			<div>

				<a href="${pageContext.request.contextPath}/bread.com"
					style="text-decoration: none; color: black"><button
						class="w-25 btn btn-lg btn-outline-dark" id="cancel">取消</button></a>

			</div>
		</main>

		<jsp:include page="footer.jsp" />

	</div>

</body>
<script type="text/javascript">
	function defaultPhoneOut() {
		document.getElementById("phoneout").innerHTML = "";
	}
	function ckPhone() {
		let phone = document.getElementById("phone").value;
		if (phone != "" && phone.search(/^09\d{8}$/) == -1) {
			document.getElementById("phoneout").innerHTML = "輸入格式錯誤";
		}
	}
	function defaultIdOut() {
		document.getElementById("idout").innerHTML = "";
	}
	function ckId() {
		let id = document.getElementById("pid").value;
		if (id != "" && id.search(/^[A-Z,a-z]{1}[1-2,8-9]{1}\d{8}$/) == -1) {
			document.getElementById("idout").innerHTML = "輸入格式錯誤";
		}

	}
</script>
</html>