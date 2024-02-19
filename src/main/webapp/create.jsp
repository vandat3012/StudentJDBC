<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 19/02/2024
  Time: 11:38 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new student</title>
</head>
<body>
<form method="post">
  <table border="1px">
    <tr>
      <th>Name</th>
      <td><input type="text" name="name" placeholder="name"></td>
    </tr>
    <tr>
      <th>Email</th>
      <td><input type="text" name="email" placeholder="email"></td>
    </tr>
    <tr>
      <th>Address</th>
      <td><input type="text" name="address" placeholder="address"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="Create"></td>
    </tr>
  </table>
</form>
</body>
</html>
