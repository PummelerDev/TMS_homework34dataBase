package servlets;

import base.Guitar;
import base.MyConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

@WebServlet("/read")
public class ReadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyConnection myConnection = new MyConnection();
        List<Guitar> guitars;
        try {
            guitars = myConnection.read();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(guitars);

        StringBuilder guitarsPrint = new StringBuilder();
        for (Guitar guitar :
                guitars) {
            guitarsPrint.append(guitar.print());
        }
        req.setAttribute("guitars", guitars);
        req.setAttribute("guitarsPrint", guitarsPrint);
        getServletContext().getRequestDispatcher("/read.jsp").forward(req, resp);
    }
}
