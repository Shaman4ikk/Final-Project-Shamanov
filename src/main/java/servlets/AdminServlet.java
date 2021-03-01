package servlets;

import app.entities.Book;
import app.entities.User;
import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/deleteBook":
                    deleteBook(req, resp);
                    doPost(req, resp);
                    break;
                case "/addBook":
                    addBook(req, resp);
                    doPost(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        if ("/addBook".equals(action)) {
            System.out.println(action);
            addBook(req, resp);
        }
        System.out.println("post");
        booksOrder(req, resp);
        req.getRequestDispatcher("rootPages/adminPage.jsp").forward(req, resp);
    }

    private void booksOrder(HttpServletRequest req, HttpServletResponse resp) {
        DBManager dbManager = DBManager.getInstance();
        List<Book> books = dbManager.getBooks();
        req.setAttribute("books", books);
    }


    private void deleteBook(HttpServletRequest req, HttpServletResponse resp) {
        DBManager dbManager = DBManager.getInstance();
        int id = Integer.parseInt(req.getParameter("bookId"));
        dbManager.deleteBook(id);
    }

    private void addBook(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        DBManager dbManager = DBManager.getInstance();
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String num = req.getParameter("num");
        String publisher = req.getParameter("publisher");
        String date = req.getParameter("date");
        dbManager.addBook(name, author, num, publisher, date);
    }
}
