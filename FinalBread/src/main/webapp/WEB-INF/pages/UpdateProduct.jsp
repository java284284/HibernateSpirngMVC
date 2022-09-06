<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編輯商品</title>
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

</head>
<body>

	<jsp:include page="navigate.jsp" />
	<c:if test="${message =='新增成功' }">
		<div style="color: blue">${message }</div>
	</c:if>
	<c:if test="${message =='新增失敗!!!!!' }">
		<div style="color: red">${message }</div>
	</c:if>


	<%-- 	<div style="color: red">${message }</div> --%>

	<div class="m-5">
		<div style="color: red">${message }</div>
		<div>商品編號:${id }</div>
		<form
			action="${pageContext.request.contextPath}/updateaction.controller?id=${id}"
			method="POST" enctype="multipart/form-data">
			<div>
				修改名稱： <input type="text" name="productName" value="${name }"
					required>
			</div>
			<div>
				修改價格： <input type="number" name="productPrice" value="${price }"
					min="1" required>
			</div>
			<div>
				修改圖片： <input type="file" name="productImg"
					onchange="openFile(event)" required>
			</div>
			<div>
				<img id="output" height="200" style="display: none">
			</div>

			<button>編輯</button>
		</form>
	</div>

	<jsp:include page="footer.jsp" />
</body>
<script type="text/javascript">
	function openFile(event) {
		var input = event.target; //取得上傳檔案
		var reader = new FileReader(); //建立FileReader物件

		reader.readAsDataURL(input.files[0]); //以.readAsDataURL將上傳檔案轉換為base64字串

		reader.onload = function() { //FileReader取得上傳檔案後執行以下內容
			var dataURL = reader.result; //設定變數dataURL為上傳圖檔的base64字串
			$('#output').attr('src', dataURL).show(); //將img的src設定為dataURL並顯示
		};
	}
</script>
</html>