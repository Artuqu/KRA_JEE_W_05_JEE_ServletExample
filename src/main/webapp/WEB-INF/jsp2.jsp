<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>jsp2.jsp</title>
</head>
<body>
    <c:if test="${not empty start && not empty end}">
        <c:forEach begin="${start}" end="${end}" var="i">
            <div>${i}</div>
        </c:forEach>
    </c:if>
</body>
</html>
