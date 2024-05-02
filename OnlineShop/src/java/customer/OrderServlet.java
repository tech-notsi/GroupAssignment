package customer;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch cart items and customer details from session
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("customerLoggedIn") == null) {
            // If session is invalid or customer not logged in, redirect to login page
            response.sendRedirect("customerlogin.jsp");
            return;
        }

        List<String> cartItems = (List<String>) session.getAttribute("cartItems");
        String customerName = (String) session.getAttribute("username");

        if (cartItems == null || cartItems.isEmpty()) {
            // If cart is empty, redirect with error message
            response.sendRedirect("cart?error=empty");
            return;
        }

        // Calculate total amount based on items (dummy calculation for demonstration)
        double totalAmount = calculateTotalAmount(cartItems);

        // Simulate payment processing (dummy logic)
        boolean paymentSuccess = processPayment(totalAmount);

        if (paymentSuccess) {
            // Clear cart after successful payment
            cartItems.clear();
            session.setAttribute("cartItems", cartItems);

            // Redirect to order confirmation page
            response.sendRedirect("orderConfirmation.jsp");
        } else {
            // Redirect to error page if payment fails
            response.sendRedirect("orderError.jsp");
        }
    }

    // Method to calculate total amount based on cart items (dummy calculation for demonstration)
    private double calculateTotalAmount(List<String> cartItems) {
        // Simple dummy implementation: $10 per item
        return cartItems.size() * 10.0;
    }

    // Method to simulate payment processing (dummy logic)
    private boolean processPayment(double totalAmount) {
        // Dummy implementation: Assume payment is successful if total amount is > $0
        return totalAmount > 0;
    }
}
