<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First jsp</title>
</head>
<body>
<jsp:include page="/WEB-INF/jspf/header.jspf"/>

    <h3>To jest pierwszy jsp</h3>
    ${param.km}km = ${0.62*param.km}mi

<jsp:include page="/WEB-INF/jspf/footer.jspf"/>
</body>
</html>
