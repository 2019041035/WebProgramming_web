<%@ page import="kr.mjc.dowon.web.dao.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>

<!DOCTYPE html>
<html>
<body>
<nav><a href="./articleForm">게시물 등록</a>
    <a href="./selectArticleForm">게시물 조회</a></nav>
<h3>게시글 목록</h3>
<%
    List<Article> articleList = (List<Article>) request.getAttribute("articleList");
    for (Article article : articleList) {%>
<p><%= article %>
</p>
<%
    }
%>
</body>
</html>