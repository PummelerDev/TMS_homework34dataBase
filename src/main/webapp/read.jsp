<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Guitars</title>
</head>
<body>
<table>
    <caption>Guitars</caption>
    <th>
        <form action="index.html" target="_self">
            <button>Back</button>
        </form>
    </th>
    <th>
        <form action="/TMS_homework34dataBase/read" target="_self">
            <button>read</button>
        </form>
    </th>
</table>
<ul>
    <jsp:useBean id="guitars" scope="request" type="java.util.List"/>
    <c:forEach var="guitar" items="${guitars}">
        <c:out value="${guitar}"/>
    </c:forEach>
</ul>
<%=request.getAttribute("guitars")%>
</body>
</html>
