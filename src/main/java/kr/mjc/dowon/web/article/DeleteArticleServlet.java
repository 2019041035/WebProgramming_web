package kr.mjc.dowon.web.article;
import kr.mjc.dowon.web.dao.ArticleDao;
import kr.mjc.dowon.web.dao.User;
import kr.mjc.dowon.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/article/deleteArticle")
public class DeleteArticleServlet extends HttpServlet {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ArticleDao articleDao;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("USER");
        int sessionUserId = user.getUserId();
        int articleArticleUserId = Integer.parseInt(request.getParameter("userId"));
        int articleId = Integer.parseInt(request.getParameter("articleId"));



        try {
            if(sessionUserId == articleArticleUserId){
                articleDao.deleteArticle(articleId, sessionUserId);
                response.sendRedirect(request.getContextPath() + "/article/deleteArticle");
            }else{
                response.sendRedirect(request.getContextPath() +
                        "/mvc/article/listArticle");
            }

        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/article/listArticle");
        }
    }
}
