<%--
  Created by IntelliJ IDEA.
  User: Mrchen
  Date: 2019/4/19
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
     %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <form action="${cxt}/ann/rb" method="post"  >
     <input type="text" name="id">
     <input type="text" name="name">
     <input type="text" name="content">
     <input type="text" name="time">
     <input type="submit" value="提交">
     <input type="text" name="value">
 </form>


</body>
</html>
