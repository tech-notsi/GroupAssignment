<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Logout</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <<header>
             <nav>
            <a href="index.jsp">Home</a> |
            <a href="customer/productDisplay.jsp">Products</a> |
            <a href="customer/cart.jsp">Cart</a> |
            <a href="customer/orders.jsp">My Orders</a> |
            <a href="customer/logout.jsp">Logout</a> |
            <a href="customer/customerLogin.jsp">Customer Login</a> |
            <a href="admin/adminLogin.jsp">Admin Login</a>
        </nav>
    </header>
    <div class="logout-message">
        <h1>Logout Successful</h1>
        <p>You have been successfully logged out.</p>
        <p>Redirecting to login page...</p>
    </div>

    <%
        // Redirect to the login page after logout
        response.setHeader("index.jsp");
    %>

    <footer>
        <p>© 2024 Online Shopping</p>
    </footer>
</body>
</html>
