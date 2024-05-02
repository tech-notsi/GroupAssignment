<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
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
        <h1>Welcome to Admin Dashboard!</h1>
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

    <section>
        <h2>Manage Products</h2>
        <ul>
            <li><a href="addProduct.jsp">Add New Product</a></li>
            <li><a href="editProduct.jsp">Edit Existing Product</a></li>
            <li><a href="deleteProduct.jsp">Delete Product</a></li>
        </ul>
    </section>

    <section>
        <h2>Recent Orders</h2>
        <ul>
            <c:forEach var="order" items="${recentOrders}">
                <li>Order ID: ${order.orderId} | Date: ${order.orderDate} | Total: $${order.totalAmount}</li>
            </c:forEach>
        </ul>
    </section>

    <footer>
        <!-- Footer content -->
    </footer>
</body>
</html>
