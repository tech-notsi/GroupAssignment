<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
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
        <h1>Shopping Cart</h1>
    </header>

    <main>
        <form action="addToCart" method="post">
            <label for="product">Select Product:</label>
            <select id="product" name="product">
                <option value="1">Shoes</option>
                <option value="2">T-Shirt</option>
                <option value="3">Bags</option>
                <!-- Add more options as needed -->
            </select>
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" min="1" value="1">
            <input type="submit" value="Add to Cart">
        </form>
    </main>

    <footer>
        <p>© 2024 Online Shopping</p>
    </footer>
</body>
</html>
