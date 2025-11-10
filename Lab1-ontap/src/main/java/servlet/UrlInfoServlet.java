
package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UrlInfoServlet")
public class UrlInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>URL Info</title></head><body>");
        out.println("<h2>Thông tin URL</h2>");
        out.println("<ul>");
        out.println("<li><strong>URL:</strong> " + request.getRequestURL() + "</li>");
        out.println("<li><strong>URI:</strong> " + request.getRequestURI() + "</li>");
        out.println("<li><strong>Query String:</strong> " + request.getQueryString() + "</li>");
        out.println("<li><strong>Servlet Path:</strong> " + request.getServletPath() + "</li>");
        out.println("<li><strong>Context Path:</strong> " + request.getContextPath() + "</li>");
        out.println("<li><strong>Path Info:</strong> " + request.getPathInfo() + "</li>");
        out.println("<li><strong>Method:</strong> " + request.getMethod() + "</li>");
        out.println("</ul>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
