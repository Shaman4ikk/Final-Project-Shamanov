package servlets;

import app.entities.User;
import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetLibrAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        if (action.equals("/addLibr"))
        {
            addLibrarian(req, resp);
        }
        if(action.equals("/deleteLibr"))
        {
            deleteLibrarian(req, resp);
        }
        getLibrarian(req, resp);
        req.getRequestDispatcher("actionPages/redLibrarAdmin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private void getLibrarian(HttpServletRequest req, HttpServletResponse resp) {
        DBManager dbManager = DBManager.getInstance();
        List<User> librarians = dbManager.getLibrarian();
        req.setAttribute("librarians", librarians);
    }
    private void addLibrarian(HttpServletRequest req, HttpServletResponse resp)
    {
        DBManager dbManager = DBManager.getInstance();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        dbManager.addLibrarian(login, password);
    }
    private void deleteLibrarian(HttpServletRequest req, HttpServletResponse resp)
    {
        DBManager dbManager = DBManager.getInstance();
        int id = Integer.parseInt(req.getParameter("id"));
        dbManager.deleteLibrarian(id);
    }

}
