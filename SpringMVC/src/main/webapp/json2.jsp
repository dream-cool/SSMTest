<%--
  Created by IntelliJ IDEA.
  User: Mrchen
  Date: 2019/4/21
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${ctx}/static/plugins/jquery/jquery.js"></script>
    <title>Title</title>
</head>
<body>
    <button id="b1" >提交</button>

    <form action="${ctx}/json2/m2" method="post">
        <input type="text" name="name">
        <input type="submit" value="tijiao">
    </form>
<div>

</div>
<script>
    $(function () {
        $('#b1').click(function () {
            var com={
                'id':'1',
                'name':'好'
            };

            var com={
                'id':'name',
                'name':'坏'
            };
            $.ajax({
                url:'${ctx}/json2/m2',
                type:'post',
                contentType:'application/json',
                data:JSON.stringify(com),
                success:function (data){
                }
            })
        })
    })

</script>

</body>
</html>
