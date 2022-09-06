<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadFile</title>
</head>
<body>
<form action="upload.controller" method="post" enctype="multipart/form-data">
    Please Select Picture to upload:<br/>
    <input type="file" name="myFiles"/>
    <input type="submit" value="upload"/>
</form>
</body>
</html>