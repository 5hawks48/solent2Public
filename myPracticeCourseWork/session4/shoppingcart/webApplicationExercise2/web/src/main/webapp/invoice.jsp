<%-- 
    Document   : invoice
    Created on : 20 Oct 2021, 14:37:00
    Author     : 5hawks48
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="org.solent.com504.oodd.cart.model.service.ShoppingService" %>
<%@ page import="org.solent.com504.oodd.cart.model.service.ShoppingCart" %>
<%@ page import="org.solent.com504.oodd.cart.model.dto.ShoppingItem" %>
<%@ page import="org.solent.com504.oodd.cart.model.dto.Invoice" %>
<%@ page import="org.solent.com504.oodd.cart.web.WebObjectFactory"%>
<%

    String message="";

    ShoppingService shoppingService = WebObjectFactory.getShoppingService();

    ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
    if (shoppingCart == null) {
        shoppingCart = WebObjectFactory.getNewShoppingCart();
        session.setAttribute("shoppingCart", shoppingCart);
    }

    String action = (String) request.getParameter("action");  
    Invoice invoice = new Invoice();
    
    if ("purchase".equals(action)) {
        message = "Your invoice: ";
        invoice.setCart(shoppingCart);
    } else {
        message = "Error: " + action;
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
        <p><%=message%><p>
        <p><%=invoice.invoiceMessage()%></p>
    </body>
</html>
