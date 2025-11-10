package servlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/tam-giac", "/dien-tich", "/chu-vi"})
public class TamGiacServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/view/tam-giac.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            double a = Double.parseDouble(req.getParameter("a"));
            double b = Double.parseDouble(req.getParameter("b"));
            double c = Double.parseDouble(req.getParameter("c"));

            if ((a + b > c) && (a + c > b) && (b + c > a)) {
                double chuVi = a + b + c;
                String uri = req.getRequestURI();

                if (uri.endsWith("/dien-tich")) {
                    double p = chuVi / 2;
                    double dienTich = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                    req.setAttribute("message", "Diện tích của tam giác là: " + dienTich);
                } else {
                    req.setAttribute("message", "Chu vi của tam giác là: " + chuVi);
                }
            } else {
                req.setAttribute("message", "Không thỏa mãn các cạnh của một tam giác!");
            }
        } catch (Exception e) {
            req.setAttribute("message", "Vui lòng nhập đúng định dạng số cho các cạnh!");
        }

        req.getRequestDispatcher("/view/tam-giac.jsp").forward(req, resp);}}
    
