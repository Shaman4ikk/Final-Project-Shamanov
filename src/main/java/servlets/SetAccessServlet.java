package servlets;

import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetAccessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/wait":
                    wait(req, resp);
                    break;
                case "/subscription":
                    subscription(req, resp);
                    break;
                case "/readRoom":
                    readRoom(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/OrderUserBook").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

    }
    private void wait(HttpServletRequest req, HttpServletResponse resp)
    {
        int id = Integer.parseInt(req.getParameter("bookId"));
        String access = "В очікуванні";
        DBManager dbManager = DBManager.getInstance();
        dbManager.setAccess(access, id);
    }
    private void subscription(HttpServletRequest req, HttpServletResponse resp)
    {
        int id = Integer.parseInt(req.getParameter("bookId"));
        String access = "Абонемент";
        DBManager dbManager = DBManager.getInstance();
        dbManager.setAccess(access, id);
    }
    private void readRoom(HttpServletRequest req, HttpServletResponse resp)
    {
        int id = Integer.parseInt(req.getParameter("bookId"));
        String access = "Читацький зал";
        DBManager dbManager = DBManager.getInstance();
        dbManager.setAccess(access, id);
    }
}
