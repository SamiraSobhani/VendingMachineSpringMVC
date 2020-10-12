<%-- 
    Document   : Items
    Created on : Oct 8, 2020, 6:43:31 PM
    Author     : ss121
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="windows-1252" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <style>
            body {
                background-color: #E6E6FA;
            }
            .col-md-4 {border: groove}
            #moneyInput {margin-left: 25%}
        </style>
        <title>Vending Machine</title>
    </head>
    <body>


        <div class="container">
            <div class="row">
                <br/>
                <h1 style="text-align: center">Vending Machine</h1>
                <hr/>

                <div class="col-md-8 text-center">

                    <c:forEach items="${itemList}" var="currentItem" >

                        <div class="col-md-4">
                            <form method="GET" action="selectItem">
                                <button type="submit" class="btn btn-block btn-lg" name="id" value="${currentItem.id}">
                                    <p class="item-number text-left"><c:out value="${currentItem.id}"/></p>
                                    <p class="text-center"><c:out value="${currentItem.name}"/></p>
                                    <p class="text-center"><c:out value="$${currentItem.price}"/></p>
                                    <p class="text-center"><c:out value="Quantity: ${currentItem.quantity}"/></p>
                                </button>
                            </form>
                        </div>
                    </c:forEach>
                </div>


                <div class="col-md-4">
                    <div class="form-group">
                        <br/>
                        <br/>
                        <h2 style="text-align: center">Total $ In</h2>

                        <input type="text" class="message-box" id="moneyInput" style="width:50%" value="${moneyInput}"disabled />

                        <form method="GET" action="addDollar">
                            <button type="submit" class="btn btn-default col-sm-2" id="addDollar" style="width:49%">Add Dollar</button>
                        </form>
                        <form method="GET" action="addQuarter">
                            <button type="submit" class="btn btn-default col-sm-2" id="addQuarter" style="width: 49%">Add Quarter</button>
                        </form>
                        <form method="GET" action="addDime">
                            <button type="submit" class="btn btn-default col-sm-2" id="addDime" style="width:49%">Add Dime</button>
                        </form>
                        <form method="GET" action="addNickel">
                            <button type="submit" class="btn btn-default col-sm-2" id="addNickel" style="width:49%">Add Nickel</button>
                        </form>
                    </div>
                    <hr>

                    <div class="form-group">
                        <h2 style="text-align: center">Messages</h2>                                                                                                        
                        <input type="text" class="form-control" id="Message" value="${selectMessage}" readonly/>
                        <p></p>
                        <div class="form-group">
                            <form class="form-inline">
                                <label for="item" class="col-sm-2 label-control">Item:</label>
                                <div class="col-sm-8">
                                    <input type="text" class="message-box" id="itemId" style="width:70%" value="${itemId}" disabled/>
                                    <p></p>
                                </div>
                            </form>
                        </div>
                        <div class="form-group">
                            <form method="GET" action="makePurchase">
                                <button type="submit"
                                        class="btn btn-primary form-control col-sm-offset-1"
                                        id="makePurchase" style="width:85%" name="id" value="${itemId}">Make Purchase</button>
                            </form>                                       
                        </div>
                    </div>
                    <hr>

                    <div class="form-group">
                        <h2 style="text-align:center" id="change">Change</h2>
                        <div class="form-group">
                            <input type="text" class="form-control"
                                   id="returnChange" style="width:100%" value="${returnAmount}" readonly/>
                        </div>
                        <div class="form-group">
                            <form method="GET" action="returnChange">
                                <button type="submite"
                                        class="btn btn-default" id="returnChange"style="width:100%">Return Change</button>
                            </form>
                        </div>
                    </div>
                </div>


            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
