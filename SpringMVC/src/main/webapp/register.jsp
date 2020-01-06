<%--
  Created by IntelliJ IDEA.
  User: Mrchen
  Date: 2019/4/21
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${ctx}/static/plugins/jquery/jquery.js"></script>
    <title>Title</title>
</head>

<body>
    <form  action="${ctx}/reg/check" method="post">
        <input type="text" name="name"><span id="msg"></span> <br>
        <input type="password" name="password">
        <input type="submit" value="提交">
    </form>

</body>
<script>
    $(function () {
        $('input[name=name]').blur(function () {
            alert("1")
            var name=$('input[name=name]').val();
            var obj={
                name:name,
            }
            $.ajax({
                url:'${ctx}/reg/check',
                type:'post',
                contentType:'application/json',
                data:JSON.stringify(obj),
                success:function(data){
                    if(data.code==2000){
                        $('#msg').html('用户名可以使用')
                    }
                    else{
                        $('#msg').html('用户名已被注册')
                    }
                }
            })
        })
    })
</script>
</html>
