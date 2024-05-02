<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product Management</title>
    <link rel="stylesheet" href="/styles.css">
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
        <h1>Product Management</h1>
        <nav>
            <a href="adminDashboard.jsp">Dashboard</a> |
            <a href="addProduct.jsp">Add New Product</a> |
            <a href="editProduct.jsp">Edit Existing Product</a> |
            <a href="deleteProduct.jsp">Delete Product</a> |
            <a href="logout">Logout</a>
        </nav>
    </header>

    <main>
        <section>
            <h2>Add New Product</h2>
            <!-- Include form for adding new product -->
            <jsp:include page="addProduct.jsp" />
        </section>

        <section>
            <h2>Edit Existing Product</h2>
            <!-- Include form for editing existing product -->
            <jsp:include page="editProduct.jsp" />
        </section>

        <section>
            <h2>Delete Product</h2>
            <!-- Include form for deleting product -->
            <jsp:include page="deleteProduct.jsp" />
        </section>
    </main>

    <footer>
        <p>© 2024 Online Shopping</p>
    </footer>
</body>
</html>
