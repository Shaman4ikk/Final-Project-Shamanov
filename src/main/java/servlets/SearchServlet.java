package servlets;

import app.entities.Book;
import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    searchBooks(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        searchBooks(req, resp);
    }
    private void searchBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = DBManager.getInstance();
        String search = req.getParameter("search");
        List<Book> bookList = dbManager.searchBooks(search);;
        req.setAttribute("bookList", bookList);
        req.getRequestDispatcher("actionPages/searchPage.jsp").forward(req,resp);
    }
}
