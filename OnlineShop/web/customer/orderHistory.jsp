<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
     <header>
   <nav>
            <a href="/index.jsp">Home</a> |
            <a href="productDisplay.jsp">Products</a> |
            <a href="cart.jsp">Cart</a> |
            <a href="orders.jsp">My Orders</a> |
            <a href="logout.jsp">Logout</a> |
            <a href="customerLogin.jsp">Customer Login</a> |
            <a href="admin/adminLogin.jsp">Admin Login</a>
        </nav>
        <br>
         <h1>Order History</h1>
   
    </header>
   
   
    <main>
        <table border="1">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Order Date</th>
                    <th>Total Amount</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orderHistory}">
                    <tr>
                        <td>${order.orderId}</td>
                        <td>${order.orderDate}</td>
                        <td>$${order.totalAmount}</td>
                        <td>${order.status}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>

    <footer>
        <p>© 2024 Online Shopping</p>
    </footer>
</body>
</html>
