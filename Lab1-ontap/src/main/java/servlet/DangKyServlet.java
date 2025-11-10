package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;


@WebServlet("/dang-ky")
public class DangKyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/view/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
        boolean married = (req.getParameter("married") != null);
        String country = req.getParameter("country");
        String notes = req.getParameter("notes");
        String[] hobbies = req.getParameterValues("hobbies");

        System.out.println(">>username: " + username);
        System.out.println(">>password: " + password);
        System.out.println(">>gender: " + gender);
        System.out.println(">>married: " + married);
        System.out.println(">>country: " + country);
        System.out.println(">>notes: " + notes);
        System.out.println(">>hobbies: " + Arrays.toString(hobbies));

        req.getRequestDispatcher("/view/result.jsp").forward(req, resp);
    }
}
