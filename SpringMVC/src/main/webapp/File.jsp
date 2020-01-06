<%--
  Created by IntelliJ IDEA.
  User: Mrchen
  Date: 2019/4/21
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${ctx}/file/upload" method="post" enctype="multipart/form-data">
        文件<input type="file" name="file"><br>
        文件<input type="file" name="file"><br>
        文件<input type="file" name="file"><br>
        文件<input type="file" name="file"><br>
        文件<input type="file" name="file"><br>
        文件<input type="file" name="file"><br>
        文件<input type="file" name="file"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
