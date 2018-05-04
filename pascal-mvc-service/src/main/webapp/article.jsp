<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Article</title>
    </head>

    <body>

        <div itemscope itemtype="http://schema.org/Article">
            <h1> Title: <span itemprop="title"> ${requestScope.article.title} </span> </h1>
            <h3> Date: <span itemprop="date"> ${requestScope.article.date} </span> </h3>

            <div itemprop="author" itemscope itemtype="http://schema.org/Article">
                <h3> Author name: <span itemprop="name"> ${requestScope.article.author.name} </span> </h3>
                <h3> Author surname: <span itemprop="surname"> ${requestScope.article.author.surname} </span> </h3>
                <h3> Country: <span itemprop="country"> ${requestScope.article.author.country} </span> </h3>
            </div>

            <div itemprop="author" itemscope itemtype="http://schema.org/Resource">
                <h3> Resource name: <span itemprop="name"> ${requestScope.article.resource.name} </span> </h3>
                <h3> url: <span itemprop="url"> ${requestScope.article.resource.url} </span> </h3>
            </div>

            <form action="<c:url value="/controller/updateArticle"/>" method="post">
                <input type="hidden" name="title" value="${requestScope.article.title}">

                <h3> Body: </h3>
                <textarea type="text" name="body" rows="25" cols="230" itemprop="body"> ${requestScope.article.body} </textarea> <br> <br>

                <input type="submit" value="update">
            </form>
        </div>

        <br>

        <div itemscope itemtype="http://schema.org/Thing">
            <form action="<c:url value="/controller/removeArticle"/>" method="post">
                <input type="hidden" value="${requestScope.article.title}" name="title">
                <input itemprop="name" type="submit" value="remove">
            </form>
        </div>

        <br>

        <div itemscope itemtype="http://schema.org/Thing">
            <form action="<c:url value="/controller/indexForward"/>" method="get">
                <input itemprop="name" type="submit" value="back to index">
            </form>
        </div>

    </body>
</html>