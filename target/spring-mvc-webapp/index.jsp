<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>

<!DOCTYPE html>
<html>

    <head>
        <title>Vending Machine</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <style>
            body {
                background-color: #E6E6FA;
            }
        </style>
        <title>Start Page Vending Machine</title>
    </head>

    <body>
        <br/>
        <h1 style="text-align: center">Vending Machine</h1>
        <br/>
        <hr/>
        <h2 style="text-align: center">

            <a href="${pageContext.request.contextPath}/displayItems">Click here to start a great vending!</a>
        </h2>

        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>

</html>

