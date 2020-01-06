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
    <title>注册</title>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div style="margin-left: 30%">
<form class="layui-form" action="${ctx}/user/register" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="text" name="userName" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">*
            <span id="msg" class="layui-form-mid layui-word-aux"></span>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="passWord" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">

        </div>
        <div class="layui-form-mid layui-word-aux">*
            <span id="msg_pwd" class="layui-form-mid layui-word-aux"></span>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-inline">
            <input type="text" name="email"   lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-inline">
            <input type="text" name="tel" required  lay-verify="required" placeholder="请输入电话" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地址</label>
        <div class="layui-input-inline">
            <input type="text" name="address" required  lay-verify="required" placeholder="请输入地址" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">单选框</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="男" title="男">
            <input type="radio" name="sex" value="女" title="女" checked>
        </div>
    </div>
    <div class="layui-form-item" style="margin-left: -5%">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo" id="butLog">注册</button>
            <span id="msg_log"></span>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            <div class="layui-form-mid layui-word-aux">*项必填</div>
        </div>
    </div>
</form>
</div>

</body>
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<script>
    layui.use(['element','form','jquery'],function () {
            var element=layui.element;
            var form=layui.form;
            var $=layui.jquery;
        form.render();
        //监听提交
        // form.on('submit(formDemo)', function(data){
        //     layer.msg(JSON.stringify(data.field));
        //     return false;
        // });
        $(function () {
            //input<name="这里是input标签的name属性">表示某一input文本框对象 通过这个的.val可以获取该文本框里的内容
            $('input[name=userName]').blur(function () {
                //定义一个值为input文本框内容的uname变量
                // var uname=$('input[name=username]').val();
                // var obj={
                //     //将uname变量赋给obj对象的username属性
                //     //这里对象的属性要与等会需要用到的pojo类属性一致
                //     username:uname,
                // }
                var userName=$('input[name=userName]').val();
                var passWord=$('input[name=passWord]').val();
                var obj={
                    userName:userName,
                    passWord:passWord,
                }
                $.ajax({
                    url:"${ctx}/user/registercheck",
                    type:"post",
                    contentType:"application/json",
                    data:JSON.stringify(obj),
                    success:function(data){
                        if(data.code==2000){
                            $('#msg').html('用户名可以使用')
                        }else if(data.code==500){
                            $('#msg').html('用户名不能为空')
                        }
                        else {
                            $('#msg').html('用户名已被注册')
                        }
                    }
                })
            })
        })
    });
</script>
</html>
