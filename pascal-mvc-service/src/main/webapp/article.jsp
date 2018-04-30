<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Article</title>
    </head>

    <body>
        <h3>Title:</h3> ${requestScope.article.title}
        <h3>Date:</h3> ${requestScope.article.date}
        <h3>Author name:</h3> ${requestScope.article.author.name}
        <h3>Author surname:</h3> ${requestScope.article.author.surname}
        <h3>Country:</h3> ${requestScope.article.author.country}
        <h3>Resource name:</h3> ${requestScope.article.resource.name}
        <h3>url:</h3> ${requestScope.article.resource.url}

        <form action="<c:url value="/controller/updateArticle"/>" method="post">
            <input type="hidden" name="title" value="${requestScope.article.title}">

            <h3>Body:</h3>
            <textarea type="text" name="body" rows="25" cols="230">${requestScope.article.body}</textarea><br><br>

            <br>

            <input type="submit" value="update">
        </form>

        <br>

        <form action="<c:url value="/controller/removeArticle"/>" method="post">
            <input type="hidden" value="${requestScope.article.title}" name="title">
            <input type="submit" value="remove">
        </form>

        <br>

        <form action="<c:url value="/controller/indexForward"/>" method="get">
            <input type="submit" value="back to index">
        </form>
    </body>
</html>
