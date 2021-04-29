<%-- 
    Document   : edit-users
    Created on : 17-Mar-2021, 09:40:07
    Author     : jamie
--%>
<%@page import="pojo.UserInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Users</title>
        <link rel="stylesheet" type="text/css" href="../style.css">
    </head>
    <body>
        <h1>Users</h1>
                <a href="../Logout">Logout</a>
                    <table>
                <tr>
                    <th>Username</th>
                    <th>Role</th>
                    <th>Full Name</th>
                </tr>
                <%
                    ArrayList<UserInfo> userInfo = (ArrayList<UserInfo>) request.getAttribute("data");
                    for (UserInfo info : userInfo) {
                        out.println(String.format("<tr>" + "<td>%s</td>" + "<td>%s</td>"+ "<td>%s</td>" + "</tr>", info.uName, info.uRole, info.fName));
                    }
                %>
            </table> 
        </div> 
    </body>
</html>
