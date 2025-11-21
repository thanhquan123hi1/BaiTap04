<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #74ABE2, #5563DE);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        color: #fff;
        animation: fadeIn 0.7s ease-in-out;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(-10px); }
        to   { opacity: 1; transform: translateY(0); }
    }

    .container {
        text-align: center;
        background: rgba(255, 255, 255, 0.15);
        padding: 40px 60px;
        border-radius: 20px;
        backdrop-filter: blur(12px);
        box-shadow: 0 8px 30px rgba(0,0,0,0.25);
        width: 420px;
        animation: fadeIn 0.8s ease;
    }

    h1 {
        font-size: 32px;
        margin-bottom: 10px;
        font-weight: bold;
    }

    p {
        font-size: 18px;
        opacity: 0.95;
        margin-top: 5px;
    }

    .welcome {
        font-size: 20px;
        margin-bottom: 15px;
        font-weight: 600;
        opacity: 0.95;
    }

    a.btn {
        display: inline-block;
        margin-top: 25px;
        padding: 12px 30px;
        background: #fff;
        color: #5563DE;
        border-radius: 8px;
        font-weight: bold;
        text-decoration: none;
        font-size: 16px;
        transition: 0.3s ease;
    }

    a.btn:hover {
        background: #e2e2e2;
    }

    .small-links {
        margin-top: 20px;
        font-size: 14px;
        opacity: 0.9;
    }

    .small-links a {
        color: #fff;
        font-weight: bold;
        text-decoration: underline;
        margin: 0 6px;
    }

</style>
</head>

<body>

    <div class="container">

        <h1>🎉 User Home</h1>

        <p class="welcome">Welcome, <b>${username}</b> 👋</p>

        <p>You have successfully logged in as a user.</p>

        <!-- Logout -->
        <a href="${pageContext.request.contextPath}/logout" class="btn">
            Logout
        </a>

        <!-- Optional: links to features (bật nếu bạn muốn) -->
        <!--
        <div class="small-links">
            <a href="${pageContext.request.contextPath}/user/categories">My Categories</a> |
            <a href="${pageContext.request.contextPath}/user/videos">My Videos</a>
        </div>
        -->

    </div>

</body>
</html>
