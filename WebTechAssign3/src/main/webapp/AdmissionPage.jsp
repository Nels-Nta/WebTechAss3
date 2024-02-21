<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2/20/2024
  Time: 12:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2/19/2024
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admission Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-color: white; /* Set white background */
            font-family: Arial, sans-serif; /* Choose a font */
        }

        nav {
            background-color: black; /* Set black background for navigation bar */
            padding: 15px 0; /* Add padding to top and bottom */
        }

        nav ul {
            list-style-type: none; /* Remove default list style */
            margin: 0;
            padding: 0;
            text-align: center; /* Center align the navigation links */
        }

        nav ul li {
            display: inline; /* Display list items horizontally */
            margin: 0 10px; /* Add margin between list items */
        }

        nav ul li a {
            color: white; /* Set text color to white */
            text-decoration: none; /* Remove underline from links */
            font-size: 18px; /* Set font size */
            padding: 10px 20px; /* Add padding to links */
            border-radius: 5px; /* Add border radius for rounded corners */
        }

        nav ul li a:hover {
            background-color: #fce6c5; /* Change background color on hover */
        }

        .container {
            margin: 100px auto;
            width: 400px;
            height: 400px;
            background: #fce6c5; /* Change background color to orange */
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            width: 100%;
            background: #f39c12; /* Change background color to orange */
            color: white;
            border: none;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background: #d35400; /* Darken the background color on hover */
        }
        a {
            color: black;
            padding-top: 10px;

        }
        .container h2{
            text-align: center;
        }
    </style>
</head>
<body>
<nav>
    <ul>
        <li><a href="SignUp.jsp">SignUp</a></li>
        <li><a href="LoginPage.jsp">Login</a></li>
        <li><a href="AdmissionPage.jsp">Admission</a></li>

    </ul>
</nav>

<div class="container">
    <h2>Admission Form</h2>
    <form action="#" method="post" enctype="multipart/form-data">
        <input type="text" name="name" placeholder="Name" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="tel" name="phone" placeholder="Phone Number" required>
        <input type="file" name="passport_picture" accept=".jpg, .png" required>
        <input type="file" name="diploma_certificates" accept=".pdf" required>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
