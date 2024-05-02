package customer;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addToCart")
public class CartServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implement logic to display the shopping cart
        response.getWriter().println("<h2>Your Shopping Cart</h2>");
        // Add code to fetch and display cart items
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implement logic to add or remove items from the shopping cart
        String action = request.getParameter("action");
        if (action != null && !action.isEmpty()) {
            if (action.equals("add")) {
                // Add item to cart logic
            } else if (action.equals("remove")) {
                // Remove item from cart logic
            }
        }
        // Redirect back to cart page after processing
        response.sendRedirect("cart");
    }
}
