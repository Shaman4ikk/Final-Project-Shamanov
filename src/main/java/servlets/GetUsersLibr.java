package servlets;

import app.entities.User;
import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetUsersLibr  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getUsers(req, resp);
    }
    public void getUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = DBManager.getInstance();
        List<User> users = dbManager.getUsers();
        System.out.println(users);
        req.setAttribute("users", users);
        req.getRequestDispatcher("actionPages/showUsersLibrarian.jsp").forward(req,resp);
    }

}
