package servlets;

import app.entities.Book;
import app.entities.Order;
import app.entities.User;
import db.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetOrderUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        booksOrder(req, resp);
        getUsers(req, resp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("rootPages/librPage.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        booksOrder(req, resp);
        getUsers(req, resp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("rootPages/librPage.jsp");
        requestDispatcher.forward(req, resp);
    }
    private void booksOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = DBManager.getInstance();
        List<Order> orderList = dbManager.getOrders();
        req.setAttribute("ordBook", orderList);

    }
    public void getUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = DBManager.getInstance();
        List<User> users = dbManager.getUsers();
        req.setAttribute("users", users);
    }
}
