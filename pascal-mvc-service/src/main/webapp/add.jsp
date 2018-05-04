<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Add</title>
    </head>

    <body>

        <div itemscope itemtype="http://schema.org/Article">
            <form action="<c:url value="/controller/addArticle"/>" method="post">
                <h1>Title:</h1>
                <input itemprop="title" type="text" name="title" style="width: 200px" required> <br> <br>

                <h3>Body:</h3>
                <textarea itemprop="body" type="text" name="body" rows="35" cols="100"></textarea> <br> <br>

                <div itemscope itemtype="http://schema.org/Thing">
                    <input itemprop="name" type="submit" value="add">
                </div>
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
