package servlets;

import app.entities.Book;
import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BooksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        booksOrder(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        booksOrder(req, resp);
    }

    private void booksOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = DBManager.getInstance();
        String sort = req.getParameter("sort");
        List<Book> books;
        if (sort != null) {
            books = dbManager.sortBooks(sort);
        } else {
            books = dbManager.getBooks();
        }
        req.setAttribute("books", books);
        req.getRequestDispatcher("rootPages/usersPage.jsp").forward(req, resp);
    }
}
