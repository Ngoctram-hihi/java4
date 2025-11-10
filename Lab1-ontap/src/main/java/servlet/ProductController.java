package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import Model.Product;

@WebServlet({"/products", "/product-detail", "/cart", "/cart-update", "/cart-remove"})
public class ProductController extends HttpServlet {
    private List<Product> products = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        products.add(new Product("Nokia 2020", "image/nokia.webp", 500.00, 0.10, LocalDate.now(), "Điện thoại Nokia bền bỉ"));
        products.add(new Product("Samsung Xyz", "image/samsung.webp", 700.00, 0.15, LocalDate.now(), "Samsung màn hình lớn"));
        products.add(new Product("iPhone Xy", "image/iphone.webp", 900.00, 0.25, LocalDate.now(), "iPhone cao cấp"));
        products.add(new Product("Sony Ericson", "image/sony.webp", 55.00, 0.00, LocalDate.now(), "Sony giá rẻ"));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Map<String, Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        String uri = req.getRequestURI();

        if (uri.endsWith("/products")) {
            req.setAttribute("products", products);
            req.getRequestDispatcher("/view/product-list.jsp").forward(req, resp);

        } else if (uri.endsWith("/product-detail")) {
            String name = req.getParameter("name");
            Product found = products.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
            req.setAttribute("product", found);
            req.getRequestDispatcher("/view/product-detail.jsp").forward(req, resp);

        } else if (uri.endsWith("/cart")) {
            String name = req.getParameter("name");
            int qty = Integer.parseInt(req.getParameter("qty"));
            Product selected = products.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);

            if (selected != null) {
                boolean exists = false;
                for (Map<String, Object> item : cart) {
                    if (item.get("name").equals(name)) {
                        item.put("qty", (int) item.get("qty") + qty);
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    Map<String, Object> item = new HashMap<>();
                    item.put("name", selected.getName());
                    item.put("image", selected.getImage());
                    item.put("price", selected.getPrice());
                    item.put("qty", qty);
                    cart.add(item);
                }
            }
            session.setAttribute("cart", cart);
            req.setAttribute("cart", cart);
            req.getRequestDispatcher("/view/cart.jsp").forward(req, resp);

        } else if (uri.endsWith("/cart-update")) {
            String name = req.getParameter("name");
            int qty = Integer.parseInt(req.getParameter("qty"));
            for (Map<String, Object> item : cart) {
                if (item.get("name").equals(name)) {
                    item.put("qty", qty);
                    break;
                }
            }
            session.setAttribute("cart", cart);
            req.setAttribute("cart", cart);
            req.getRequestDispatcher("/view/cart.jsp").forward(req, resp);

        } else if (uri.endsWith("/cart-remove")) {
            String name = req.getParameter("name");
            cart.removeIf(item -> item.get("name").equals(name));
            session.setAttribute("cart", cart);
            req.setAttribute("cart", cart);
            req.getRequestDispatcher("/view/cart.jsp").forward(req, resp);
        }
    }
}
