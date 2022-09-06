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
<body class="vh-100">
	<div class="container text-center ">
		<main class="form-signin m-5">


			<!-- 表單開始 -->
			<form
				action="${pageContext.request.contextPath}/loginaction.controller"
				method="post">
				<h1 class="h3 mb-3 fw-normal">會員登入</h1>
				<div class="form-floating">
					<input type="text" class="form-control" id="floatingInput"
						placeholder="aaa" name="phone" required> <label
						for="floatingInput">電話號碼</label>
				</div>
				<div class="form-floating">
					<input type="password" class="form-control" id="pwd"
						placeholder="pwd" name="pwd" required> <label for="pwd">密碼</label>
					<i id="checkEye" class="fas fa-eye-slash"></i>
				</div>

				<div class="checkbox my-3">
					<label> <input type="checkbox" name="remeberMe">
						記住我
					</label>
				</div>
				<div style="color: red">${message }</div>
				<div style="margin-bottom: 10px">
					<span style="margin-right: 20px; color: blue">還沒有註冊?</span><a
						href="${pageContext.request.contextPath}/signup.com">註冊</a>
				</div>
				<div class=" mb-2">
					<button class="w-25 btn btn-lg btn-primary">登入</button>
				</div>
				<div>
					<button class="w-25 btn btn-lg btn-outline-dark" id="cancel">取消</button>
				</div>
			</form>
			<!-- 表單結束 -->

		</main>

		<jsp:include page="footer.jsp" />

	</div>
	<div class="text-center m-5">
		快速登入:
		<button class="btn btn-outline-info fastLogin">admin</button>
		<button class="btn btn-outline-info fastLogin2">Tom</button>
	</div>

</body>


<script type="text/javascript">
	//快速登入
	$(".fastLogin").click(function() {
		$("#floatingInput").val("admin");
		$("#pwd").val("987654");
	});
	$(".fastLogin2").click(function() {
		$("#floatingInput").val("0987654321");
		$("#pwd").val("1234");
	});

	//密碼可視切換
	$("#checkEye").click(function() {
		if ($(this).hasClass('fa-eye')) {
			$("#pwd").attr('type', 'password');
		} else {
			$("#pwd").attr('type', 'text');
		}
		$(this).toggleClass('fa-eye').toggleClass('fa-eye-slash');
	});

	//取消按鈕返回上頁
	$("#cancel").click(function(event) {
		event.preventDefault(); //取消預設行為
		window.history.back(); //返回上一頁
	})
</script>

</html>