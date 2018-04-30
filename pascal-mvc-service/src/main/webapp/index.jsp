<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
      <title>Index</title>
  </head>

  <body>
    <form action="<c:url value="/controller/addForward"/>" method="get">
      <input type="submit" value="add">
    </form>

    <br>

    <form action="<c:url value="/controller/takeTitleList"/>" method="get">
      <input type="submit" value="refresh">
    </form>

    <br>

    <form action="<c:url value="/controller/takeArticle"/>" method="get">
      <div style="overflow-y: scroll; width: 120px; height: 500px">
        <c:forEach items="${titleList}" var="title">
          <input type="submit" name="title" value="${title}"><br>
        </c:forEach>
      </div>
    </form>
  </body>
</html>