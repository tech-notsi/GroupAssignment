package customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/customerLogin")
public class CustomerLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve login parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Assuming you have a CustomerDAO to validate customer credentials
        CustomerDAO customerDAO = new CustomerDAO(); // Replace with your actual DAO

        // Validate customer login
        boolean isValidCustomer = customerDAO.validateCustomer(username, password);

        if (isValidCustomer) {
            // Customer login successful
            // Create a session and store customer information
            HttpSession session = request.getSession(true);
            session.setAttribute("customerUsername", username);

            // Redirect to customer dashboard or home page
            response.sendRedirect("customerDashboard.jsp");
        } else {
            // Customer login failed
            // Set error message and forward back to login page
            request.setAttribute("loginError", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    // Assuming you also need doGet to handle GET requests for login page display
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to login.jsp for displaying the login form
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
