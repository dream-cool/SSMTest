<%--
  Created by IntelliJ IDEA.
  User: Mrchen
  Date: 2019/4/23
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div style="margin-left: 40%;margin-top: 10%" >
<form class="layui-form"  action="${ctx}/user/login" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline" >
            <input type="text" name="userName" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            <span id="msg"></span><br>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="passWord" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
        <span id="msg_pwd"></span><br>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo" id="butLog">登录</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button><br>
            <a href="/user/register"  >注册</a>
        </div>
        <span id="msg_log"></span><br>
    </div>
</form>
</div>
</body>
<script src="${ctx}/static/plugins/jquery/jquery.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        alert("1")
        $(function () {
            $('#butLog').click(function () {
                var userName=$('input[name=userName]').val();
                var passWord=$('input[name=passWord]').val();
                var obj={
                    userName:userName,
                    passWord:passWord,
                }.
                $.ajax({
                    url:"${ctx}/user/logincheck",
                    type:"post",
                    contentType:"application/json",
                    data:JSON.stringify(obj),
                    success:function (data){
                        if(data.code==2000){
                            alert("登录成功")
                        }else if(data.code==500){
                            $('#msg_pwd').html('密码不能为空')
                        }else{
                            $('#msg_log').html('用户名或密码错误')
                        }
                    }
                })
            })
        })
    });
</script>
</html>
