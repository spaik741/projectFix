package ru.servlets;

import sun.plugin.javascript.navig.LinkArray;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class ServletMain extends HttpServlet {

    private UserRepository usersRepository;

    @Override
    public void init() throws ServletException {
        this.usersRepository = new UserRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = usersRepository.findAll();
        req.setAttribute("usersFromServer", users);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/main.jsp");
        for (User user: users) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        User user = new User(firstName, lastName);
        usersRepository.save(user);
        doGet(req, resp);
    }
}
