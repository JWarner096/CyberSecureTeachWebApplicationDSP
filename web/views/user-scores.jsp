<%-- 
    Document   : user-scores
    Created on : 17-Mar-2021, 09:39:56
    Author     : Jamie
--%>

<%@page import="pojo.ScoreInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users Scores</title>
        <link rel="stylesheet" type="text/css" href="../style.css">
    </head>
    <body>
        <h1>Users Scores</h1>
                <a href="../Logout">Logout</a>
                    <table>
                <tr>
                    <th>Score ID</th>
                    <th>Score </th>
                    <th>Username</th>
                </tr>
                <%
                    ArrayList<ScoreInfo> scoreInfo = (ArrayList<ScoreInfo>) request.getAttribute("data");
                    for (ScoreInfo info : scoreInfo) {
                        out.println(String.format("<tr>" + "<td>%s</td>" + "<td>%s</td>"+ "<td>%s</td>" + "</tr>", info.sID, info.sScore, info.sUsername));
                    }
                %>
            </table> 
        </div> 
    </body>
</html>