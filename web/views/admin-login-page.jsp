<%-- 
    Document   : login-page
    Author     : Jamie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body
        <div class="login">
            <h1>Admin Login</h1>
            <h2>Login Here</h2>
            <form action="Login" method="post">
                <li>Username<li>
                <li><input type="text" name="username" placeholder="Enter Username"><br><li>
                <li>Password<li> 
                <li><input type="password" name="password"placeholder="Enter Password"><br><li>
                <li><input type="submit" value="Login"><li>
            </form>
        </div>
    </body>
</html>
