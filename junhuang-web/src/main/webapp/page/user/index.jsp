<%--
  Created by IntelliJ IDEA.
  User: pengweiyuan
  Date: 4/4/16
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link type="text/css" rel="stylesheet" href="<% request.getContextPath();%>/resources/main.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    i am userindex

</p>
<spring:message code="hi"></spring:message>

<br>
<a href="<%request.getContextPath(); %>/user/language?language=en" >english</a>
<br>
<a href="<%request.getContextPath(); %>/user/language?language=zh_cn" >english</a>
</body>
</html>
