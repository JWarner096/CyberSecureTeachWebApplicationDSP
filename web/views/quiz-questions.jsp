<%-- 
    Document   : quiz-questions
    Created on : 26-Apr-2021, 14:34:59
    Author     : jamie
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="pojo.QuestionInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Questions</title>
        <link rel="stylesheet" type="text/css" href="../style.css">
    </head>
    <body>
        <h1>Questions & Answers</h1>
                <a href="../Logout">Logout</a>
                    <table>
                <tr>
                    <th>Question</th>
                    <th>Answer </th>
                </tr>
                <%
                    ArrayList<QuestionInfo> questionInfo = (ArrayList<QuestionInfo>) request.getAttribute("data");
                    for (QuestionInfo info : questionInfo) {
                        out.println(String.format("<tr>" + "<td>%s</td>" + "<td>%s</td>"+ "</tr>", info.qQuestion, info.qAnswer));
                    }
                %>
            </table> 
    </body>
</html>
