package servlets;

import base.MyConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyConnection connection = new MyConnection();
        System.out.println(req.getParameter("id"));

        int[] id = Arrays.stream(req.getParameter("id").replaceAll(",", "").replaceAll("\\s+", " ").split(" ")).mapToInt(Integer::parseInt).toArray();
        try {
            connection.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
    }
}
