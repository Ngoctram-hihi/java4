package servlet;

import java.io.IOException;
import java.nio.file.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/hit-counter")
public class HitCounterServlet extends HttpServlet {
    private int count;
    private final Path path = Paths.get("c:/temp/count.txt");

    @Override
    public void init() throws ServletException {
        try {
            // Đọc số lượt truy cập từ file
            count = Integer.parseInt(Files.readAllLines(path).get(0));
        } catch (IOException | NumberFormatException e) {
            count = 0; // Nếu lỗi, khởi tạo bằng 0
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        count++; // Tăng số lượt truy cập
        req.setAttribute("count", count); // Chia sẻ biến count
        req.getRequestDispatcher("/view/hit-counter.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        try {
            // Ghi số lượt truy cập vào file
            Files.write(path, String.valueOf(count).getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
