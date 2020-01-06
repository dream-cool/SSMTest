<%--
  Created by IntelliJ IDEA.
  User: Mrchen
  Date: 2019/4/25
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>非模块化方式使用layui</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body>

<!-- 你的HTML代码 -->

<script src="${ctx}/static/plugins/jquery/jquery.js"></script>
<script>
    //由于模块都一次性加载，因此不用执行 layui.use() 来加载对应模块，直接使用即可：
    alert("3")
    layui.use(['layer', 'form'], function(){
        var layer = layui.layer
            ,form = layui.form;
        layer.msg('Hello World');
    });
</script>
</body>
</html>