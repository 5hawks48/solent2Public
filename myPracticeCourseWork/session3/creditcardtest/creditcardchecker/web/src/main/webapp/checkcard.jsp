<%-- 
    Document   : checkcard
    Created on : 28 Jul 2021, 17:13:43
    Author     : cgallen, 5hawks48
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="solent.ac.uk.ood.examples.cardcheck.CardValidationResult" %>
<%@ page import="solent.ac.uk.ood.examples.cardcheck.RegexCardValidator" %>

<%
    String creditcardno = request.getParameter("creditcardno");
    /**
     * String action = request.getParameter("action"); CardValidationResult
     * result = new CardValidationResult();
     *
     * if ("checkCard".equals(action)) { result =
     * RegexCardValidator.isValid(creditcardno); }
     *
     */
    CardValidationResult result = RegexCardValidator.isValid(creditcardno);

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Check Credit Card</h1>

        <!-- comment 
        <form action="./checkcard.jsp" method="post">
            <p>Card Number: <input type="text" name="creditcardno" value=""></p>
            <input type="hidden" name="action" value="checkCard">
            <button type="submit" >Check</button>
            <p>Result: <%=(result.isValid() + " : " + (result.isValid() ? result.getCardType().getIssuerName() : "") + " : " + result.getMessage())%></p>
        </form>
        -->
        <form action="./checkcard.jsp" method="post">
            <p>Card Number: <input type="text" name="creditcardno" value="<%=creditcardno%>"></p>
            <!--
            <input type="hidden" name="action" value="textbox">
            -->
            <button type="submit" name="action" value="button">Check Card</button>
            
        </form>

        <% if (result.isValid()) {%>
        <p>Request: <%=request.getParameter("action")%></p>
        <p>"<%= result.getCardNo()%>" is a valid card number issued by  <%= result.getCardType()%> </p>
        <%
        } else {
        %>
        <p>"<%= result.getCardNo()%>" is an invalid card : <%= result.getError()%> </p>
        <%
            }
        %>
    </body>
</html>
