<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <nav>
            <a href="index.jsp">Home</a> |
            <a href="customer/productDisplay.jsp">Products</a> |
            <a href="customer/cart.jsp">Cart</a> |
            <a href="customer/orders.jsp">My Orders</a> |
            <a href="customer/logout.jsp">Logout</a> |
            <a href="customer/customerLogin.jsp">Customer Login</a> |
            <a href="admin/adminLogin.jsp">Admin Login</a>
        </nav>
        <br>
        <h1>Admin Login</h1>
    </header>

    <%-- Display error message if login fails --%>
    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null && !error.isEmpty()) { %>
        <p style="color: red;"><%= error %></p>
    <% } %>

    <form method="post" action="adminLogin">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <button type="submit">Login</button>
    </form>

    <footer>
        <p>© 2024 Online Shopping</p>
    </footer>
</body>
</html>
