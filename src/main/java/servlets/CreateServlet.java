package servlets;

import base.MyConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyConnection connection =new MyConnection();
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String type = req.getParameter("type");
        int strings = Integer.parseInt(req.getParameter("strings"));
        try {
            connection.create(name, brand, type, strings);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
    }
}
