package servlets;

import app.entities.User;
import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetUsersAdm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/setBan":
                    setBan(req, resp);
                    break;
                case "/unBan":
                    unBan(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getUsers(req, resp);
        req.getRequestDispatcher("/actionPages/redUsersAdmin.jsp").forward(req, resp);
    }

    private void getUsers(HttpServletRequest req, HttpServletResponse resp) {
        DBManager dbManager = DBManager.getInstance();
        List<User> users = dbManager.getUsers();
        req.setAttribute("users", users);
    }
    private void setBan(HttpServletRequest req, HttpServletResponse resp)
    {
        int id = Integer.parseInt(req.getParameter("id"));
        String condition = "Бан";
        DBManager dbManager = DBManager.getInstance();
        dbManager.setConditionUser(condition, id);
    }
    private void unBan(HttpServletRequest req, HttpServletResponse resp)
    {
        int id = Integer.parseInt(req.getParameter("id"));
        String condition = "Доступ";
        DBManager dbManager = DBManager.getInstance();
        dbManager.setConditionUser(condition, id);
    }
}
