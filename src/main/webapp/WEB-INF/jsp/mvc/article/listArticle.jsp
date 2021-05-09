<%@ page import="kr.mjc.dowon.web.dao.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>

<!DOCTYPE html>
<html>
<body>
<nav><a href="./articleForm">게시물 등록</a>
<h3>게시글 목록</h3>
<%
    List<Article> articleList = (List<Article>) request.getAttribute("articleList");
    for (Article article : articleList) {%>
<p><%= article %>
    <% String userNames = article.getName(); %>
    <% int articleId = article.getArticleId(); %>

    <a href="/article/getArticle?num=<%=article.getArticleId()%>"> <%= userNames%>님의 게시글(<%= articleId%>번) 보러 가기 </a>
</p>
<%
    }
%>
</body>
</html>