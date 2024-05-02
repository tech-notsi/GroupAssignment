<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Management</title>
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
        <h1>Customer Management</h1>
        <nav>
            <a href="adminDashboard.jsp">Dashboard</a> |
            <a href="viewCustomers.jsp">View Customers</a> |
            <a href="logout">Logout</a>
        </nav>
    </header>

    <main>
        <section>
            <h2>View Customers</h2>
            <!-- Include table to display list of customers -->
            <jsp:include page="viewCustomers.jsp" />
        </section>
    </main>

    <footer>
        <p>© 2024 Online Shopping</p>
    </footer>
</body>
</html>
