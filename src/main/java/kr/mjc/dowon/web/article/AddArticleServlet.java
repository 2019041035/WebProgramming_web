package kr.mjc.dowon.web.article;

import kr.mjc.dowon.web.dao.Article;
import kr.mjc.dowon.web.dao.ArticleDao;
import kr.mjc.dowon.web.dao.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/article/addArticle")
public class AddArticleServlet extends HttpServlet {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");

        Article article = new Article();
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setUserId(user.getUserId());
        article.setName(user.getName());

            articleDao.addArticle(article);
            response.sendRedirect(request.getContextPath() + "/article/listArticle");

        } catch (NullPointerException e) {
            response.sendRedirect(
                    "/model2/user/loginForm");
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/article/articleList?msg=Something Wrong. Try this again.");
        }
    }
}