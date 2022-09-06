<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MultiLangResult</title>
</head>
<body>
<p>
  <a href="resultMultiLang.controller?locale=zh-TW">中文</a>
  <a href="resultMultiLang.controller?locale=en-US">英文</a>
</p>
<spring:message code="program.error"/>
</body>
</html>