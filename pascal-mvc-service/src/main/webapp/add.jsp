<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Add</title>
    </head>

    <body>
        <form action="<c:url value="/controller/addArticle"/>" method="post">
            <h4>Title:</h4>
            <input type="text" name="title" style="width: 200px" required><br><br>

            <h4>Body:</h4>
            <textarea type="text" name="body" rows="35" cols="100"></textarea><br><br>

            <input type="submit" value="add">
        </form>

        <br>

        <form action="<c:url value="/controller/indexForward"/>" method="get">
            <input type="submit" value="back to index">
        </form>
    </body>
</html>
