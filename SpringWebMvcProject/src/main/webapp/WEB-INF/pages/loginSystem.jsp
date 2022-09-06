<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<h3>LoginSystem</h3>
<form action="checklogin.controller" method="post">
    <table>
        <tr>
           <td>UserName:</td>
           <td><input type="text" name="userName"/></td>
           <td>${errors.name}</td>
        </tr>
        <tr>
           <td>Password:</td>
           <td><input type="password" name="userPwd"/></td>
           <td>${errors.pwd}</td>
        </tr>
        <tr>
           <td><button type="submit">Login</button></td>
           <td>${errors.msg}</td>
        </tr>
    </table>
</form>
</body>
</html>