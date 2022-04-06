<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

    <head>
        <spring:url value="/resources/css/main.css" var="mainCss" />
        <link href="${mainCss}" rel="stylesheet" />
        <title>View Posts</title>
    </head>
    <body>
    <h1> This is  view  list posts </h1>
        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Content</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${posts}" var="post">
                    <tr>
                        <td>${post.title}</td>
                        <td>${post.content}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>