package servlets;

import app.entities.Book;
import app.entities.User;
import db.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        if(action.equals("/returnBook"))
        {
            returnBook(req, resp);
        }
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = DBManager.getInstance();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<Book> books = dbManager.usersBooks(user);
        req.setAttribute("books", books);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("actionPages/accountPage.jsp");
        requestDispatcher.forward(req, resp);
    }
    private void returnBook(HttpServletRequest req, HttpServletResponse resp)
    {
        DBManager dbManager = DBManager.getInstance();
        int id = Integer.parseInt(req.getParameter("bookId"));
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        dbManager.retBookToUser(user,id);
    }
}
