<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
</head>
<body>
<h3>form</h3>
<form action="hello2.controller" method="post">
<!-- <form action="hello.controller" method="get"> -->
    <table>
       <tr>
          <td>Name:</td>
          <td><input type="text" name="userName"/></td>
          <td>${errors.name}</td>
       </tr>
       <tr>
          <td><button type="submit">Send</button></td>
       </tr>
    </table>
</form>
</body>
</html>