<%-- 
    Document   : jspexample3d-modify
    Created on : 11 Oct 2021, 16:03:00
    Author     : Steven

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.solent.oodd.webexercise1.model.User" %>
<%
    // retrieve the stored users list from the session
    List<User> users = (List<User>) session.getAttribute("usersList");
    if (users == null) {
        users = new ArrayList<User>();
        session.setAttribute("usersList", users);
    }

    String name = request.getParameter("userName");
    String address = request.getParameter("userAddress");
    String index = request.getParameter("index");
    int i = Integer.parseInt(index);
    User user = users.get(i);

    // find what action to perform on the page
    String action = request.getParameter("action");

    if ("modifyUser".equals(action)) {
        user.setAddress(address);
        user.setName(name);
    }


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Example 3d - Modify</title>
    </head>
    <body>
        <h1>JSP Example 3: Modify</h1>

        <h2>Modify user</h2>
        <table>
            <tr>
                <td>        
                    <form action="./jspexample3d-modify.jsp" method="get">
                        User name: <input type="text" name="userName" value="<%= user.getName()%>">
                        User address <input type="text" name="userAddress" value="<%= user.getAddress()%>">
                        <input type="hidden" name="action" value="modifyUser">
                        <input type="hidden" name="index" value="<%=index%>">
                        <button type="submit" >Save changes</button>
                    </form> 
                </td>
            </tr>
        </table>


        <h2>commands</h2>
        <form action="./jspexample3c.jsp" method="get">
            <button type="submit" >Return to user list</button>
        </form> 
        <br>

        <a href="./" >back to index page</a>
    </body>
</html>

