package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Ánh xạ nhiều URL đến cùng một Servlet
@WebServlet(urlPatterns = {"/crud/create", "/crud/update", "/crud/delete", "/crud/edit/2024"})
public class CrudServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String path = request.getServletPath() + (request.getPathInfo() != null ? request.getPathInfo() : "");

        out.println("<html><head><title>CRUD Servlet</title></head><body>");
        out.println("<h2>Kết quả xử lý:</h2>");

        switch (path) {
            case "/crud/create":
                out.println("<p>Thực hiện chức năng tạo mới (Create).</p>");
                break;
            case "/crud/update":
                out.println("<p>Thực hiện chức năng cập nhật (Update).</p>");
                break;
            case "/crud/delete":
                out.println("<p>Thực hiện chức năng xóa (Delete).</p>");
                break;
            case "/crud/edit/2024":
                out.println("<p>Thực hiện chức năng chỉnh sửa cho năm 2024 (Edit 2024).</p>");
                break;
            default:
                out.println("<p>Không xác định chức năng.</p>");
        }

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
