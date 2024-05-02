<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Products</title>
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
        <h1>Products</h1>
   
    </header>

    <main>
        <table border="1">
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Add to Cart</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.productName}</td>
                        <td>${product.description}</td>
                        <td>$${product.price}</td>
                        <td>
                            <form action="addToCart" method="post">
                                <input type="hidden" name="productId" value="${product.productId}">
                                <input type="number" name="quantity" value="1" min="1" required>
                                <input type="submit" value="Add to Cart">
                            </form>
                        </td>
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
