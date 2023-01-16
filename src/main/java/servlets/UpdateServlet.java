package servlets;

import base.MyConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyConnection connection =new MyConnection();
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        System.out.println(req.getParameter("brand"));
        String brand = req.getParameter("brand");
        System.out.println(brand);
        String type = req.getParameter("type");

        int strings;
        try {
        strings=Integer.parseInt(req.getParameter("strings"));
        } catch (Exception e){
            strings =0;
        }
        try {
            connection.update(id ,name, brand, type, strings);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
    }
}
