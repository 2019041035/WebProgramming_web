<%@ page import="kr.mjc.dowon.web.dao.Article" %>
<!DOCTYPE html>
<% Article article =  (Article) request.getAttribute("ARTICLE");%>
<html>
<title>Article Info</title>
<body>
<h3><%=article.getTitle()%></h3>
    작성자: <%=article.getName()%> <br>
    내용: <%=article.getContent()%> <br><br>
<button onclick="location='deleteArticle?userId=<%=article.getUserId()%>&articleId=<%=article.getArticleId()%>'">글 삭제하기</button>
</body>
</html>