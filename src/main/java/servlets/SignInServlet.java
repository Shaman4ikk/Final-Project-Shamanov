package servlets;
import app.entities.User;
import db.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        DBManager dbManager = DBManager.getInstance();
        String login = req.getParameter("login");
        String password = req.getParameter("pass");
        User user = new User(login, password);
        user = dbManager.getUser(user);
        if (user.getLogin() == null && user.getPassword() == null) {
            resp.sendRedirect("/index.jsp");
        }
        else {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            switch (user.getRoot()) {
                case "admin":
                    resp.sendRedirect("/admin");
                    break;
                case "librarian":
                    resp.sendRedirect("/OrderUserBook");
                    break;
                case "user":
                    resp.sendRedirect("/bookList");
                    break;
            }
        }
    }
}
