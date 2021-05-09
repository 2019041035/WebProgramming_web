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
import java.util.List;

@WebServlet("/article/listArticle")
public class ListArticleServlet extends HttpServlet {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Article> articleList = articleDao.listArticles(0, 100);
        request.setAttribute("articleList", articleList);

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/listArticle.jsp")
                .forward(request, response);
    }
}
