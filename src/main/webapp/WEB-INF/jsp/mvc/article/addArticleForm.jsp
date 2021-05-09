<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h3>게시글 등록</h3>
<form action="addArticle" method="post">
    <p><input type="title" name="title" placeholder="제목" required autofocus/></p>
    <p><input type="content" name="content" placeholder="내용" required/></p>
    <p>
        <button type="submit">저장</button>
    </p>
</form>
</body>
</html>