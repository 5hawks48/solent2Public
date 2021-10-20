<%-- 
    Document   : newjsp
    Created on : 3 Aug 2021, 13:11:36
    Author     : cgallen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="org.solent.com504.oodd.cart.model.service.ShoppingService" %>
<%@ page import="org.solent.com504.oodd.cart.model.service.ShoppingCart" %>
<%@ page import="org.solent.com504.oodd.cart.model.dto.ShoppingItem" %>
<%@ page import="org.solent.com504.oodd.cart.web.WebObjectFactory"%>
<%

    String message = "";

    ShoppingService shoppingService = WebObjectFactory.getShoppingService();

    ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
    if (shoppingCart == null) {
        shoppingCart = WebObjectFactory.getNewShoppingCart();
        session.setAttribute("shoppingCart", shoppingCart);
    }

    String action = (String) request.getParameter("action");
    String itemName = (String) request.getParameter("itemName");
    String itemUuid = (String) request.getParameter("itemUUID");

    if ("addItemToCart".equals(action)) {
        ShoppingItem shoppingItem = shoppingService.getNewItemByName(itemName);
        if (shoppingItem == null) {
            message = "Error adding " + itemName + " to cart";
        } else {
            message = "Adding " + itemName + " to cart. Price = " + shoppingItem.getPrice();
            shoppingCart.addItemToCart(shoppingItem);
        }
    } else if ("removeItemFromCart".equals(action)) {
        message = "Removed " + itemName;
        shoppingCart.removeItemFromCart(itemUuid);
    } else if (("purchase").equals(action)) {
        message = "Trying to purchase...";
        shoppingService.purchaseItems(shoppingCart);
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

            <!-- The .table class adds basic styling (light padding and only horizontal dividers) to a table: -->     
        <H1>Available Items</H1>
        <table class="table">

            <tr>
                <th>Item Name</th>
                <th>Price</th>
                <th></th>
            </tr>

            <% for (ShoppingItem item : shoppingService.getAvailableItems()) {%>
            <tr>
                <td><%=item.getName()%></td>
                <td><%=item.getPrice()%></td>
                <td></td>
                <td>
                    <!-- post avoids url encoded parameters -->
                    <form action="./home.jsp" method="get">
                        <input type="hidden" name="itemName" value="<%=item.getName()%>">
                        <input type="hidden" name="action" value="addItemToCart">
                        <button type="submit" >Add Item</button>
                    </form> 
                </td>
            </tr>
            <% }%>

        </table>

        <H1>Shopping cart</H1>
        <table class="table">

            <tr>
                <th>Item Name</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>

            <% for (ShoppingItem item : shoppingCart.getShoppingCartItems()) {%>
            <tr>
                <td><%=item.getName()%></td>
                <td><%=item.getPrice()%></td>
                <td><%=item.getQuantity()%></td>
                <td>
                    <!-- post avoids url encoded parameters -->
                    <form action="./home.jsp" method="get">
                        <input type="hidden" name="itemUUID" value="<%=item.getUuid()%>">
                        <input type="hidden" name="itemName" value="<%=item.getName()%>">
                        <input type="hidden" name="action" value="removeItemFromCart">
                        <button type="submit" >Remove Item</button>
                    </form> 
                </td>
            </tr>
            <% }%>

        </table>

        <p>Total cost: <%=shoppingCart.getTotal()%></p>

        <form action="./invoice.jsp" method="get">    
            <!--<input type="hidden" name="shoppingCart" value="<%=shoppingCart%>">-->
            <input type="hidden" name="action" value="purchase">
            <button type="submit" >Purchase Items</button>
        </form>



    </body>
</html>
