package servlets;
import app.entities.User;
import db.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("usersAction/reg.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        DBManager dbManager = DBManager.getInstance();
        String login = req.getParameter("login");
        String password = req.getParameter("pass");
        User user = new User(login, password);
        dbManager.insertUser(user);
        req.getRequestDispatcher("/signIn").forward(req, resp);
    }

}
