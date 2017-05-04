<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">

    <title>DEMO</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

</head>
<body>
	<p><c:out value="${user.id}" /></p>
	<p><c:out value="${user.username}" /></p>
	<p><c:out value="${user.age}" /></p>
	<p><c:out value="${user.gender}" /></p>
	<p><c:out value="${user.birthday}" /></p>
</body>
</html>
