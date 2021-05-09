package kr.mjc.dowon.web.article;

import kr.mjc.dowon.web.dao.Article;
import kr.mjc.dowon.web.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/article/getArticle")
public class GetArticleServlet extends HttpServlet {

    @Autowired
    private ArticleDao articleDao;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String articleId = request.getParameter("num");
        Article article = articleDao.getArticle(Integer.parseInt(articleId));
        request.setAttribute("ARTICLE", article);
        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/getArticle.jsp").forward(request, response);


    }
}