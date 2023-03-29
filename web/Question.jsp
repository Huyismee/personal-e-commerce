<%-- 
    Document   : Question
    Created on : Nov 11, 2022, 9:41:16 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form action="question" method="POST">
                <div>Question <input type="text" readonly name="id" value="${id}"> : ${question}</div>
                <div><input type="radio" name="answer" value="A">A. ${a}</div>
                <div><input type="radio" name="answer" value="B">B. ${b}</div>
                <div><input type="radio" name="answer" value="C">C. ${c}</div>
                <div><input type="radio" name="answer" value="D">D. ${d}</div>
                <div><input type="submit" value="Next"></div>
            </form>
        </div>
    </body>
</html>
