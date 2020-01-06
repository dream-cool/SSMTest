<%--
  Created by IntelliJ IDEA.
  User: Mrchen
  Date: 2019/4/23
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"   %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
    <script src="${ctx}/static/vue.js"></script>
    <script src="${ctx}/static/vue-resource.js"></script>
    <script src="${ctx}/static/plugins/jquery/jquery.js"></script>
</head>
<body class="layui-layout-body">
<div style="margin-left: 40%;margin-top: 10%" >
<div class="layui-form"  >
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline" >
            <input type="text" name="userName" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            <span id="msg"></span><br>
        </div>
        <input class="layui-btn" type="button" value="发送验证码" name="send" id="send" >
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">验证码</label>
        <div class="layui-input-inline">
            <input type="text" name="passWord"  placeholder="请输入验证码" autocomplete="off" class="layui-input">
        </div>
        <span id="msg_pwd"></span><br>
    </div>
    <div class="layui-form-item" >
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo" id="butLog">登录</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button><br>
            <a href="/user/register"  >注册</a>
        </div>
        <span id="msg_log"></span><br>
    </div >
    <div  id="sc">
        <img  class="layui-src" id="image" :src="sr">
    </div>
</div>
</div>
</body>
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<script>

    var  vm=new Vue({
        el:"#sc",
        data:{
            c:0,
            sr:'',
        },
        methods:{
            timedCount(){
                if(this.c>0){
                    this.c=this.c-1;
                    setTimeout("vm.timedCount()",1000);
                    $("#send").val('发送成功，有效时间,还剩'+this.c+'秒');
                }else{
                    $('#msg_pwd').html('验证码已失效，请重新发送');
                    $("#send").removeAttr("disabled");
                    $("#send").val('发送验证码');
                }
            }
        }
    })

    layui.use(['flow', 'form', 'element', 'laydate'], function(){
        var element = layui.element;
        var $=layui.jquery
            ,flow = layui.flow;
        flow.lazyimg();
        $(function () {
            $('#butLog').click(function () {
                var userName=$('input[name=userName]').val();
                var passWord=$('input[name=passWord]').val();
                var obj={
                    userName:userName,
                    passWord:passWord,
                }
                $.ajax({
                    url:"${ctx}/login/check",
                    type:"post",
                    contentType:"application/json",
                    data:JSON.stringify(obj),
                    success:function (data){
                        if(data.code==100){
                            alert("登录成功")
                        }else if(data.code==400){
                            alert("您已输错3次，原验证码已失效，请重新请求")
                        }else if(data.code==200){
                            alert('验证码输入错误')
                        }else if(data.code==404){
                            alert('验证码已失效或您还没有请求发送验证码')
                        }
                    }
                })
            })
            $('#send').click(function () {
                var userName=$('input[name=userName]').val();
                var obj={
                    userName:userName,
                }
                $.ajax({
                    url:"${ctx}/login/send",
                    type:"post",
                    contentType:"application/json",
                    data:JSON.stringify(obj),
                    success:function (data){
                        if(data.code==500){
                            vm.c=60
                            $('#msg_pwd').html('');
                            $("#send").attr("disabled", "disabled")
                            vm.sr=data.src
                            vm.timedCount()
                        }
                        if(data.check==200){
                            alert("你已连续请求三次")
                        }
                        alert(vm.sr)
                    }
                })
            })
        })
    });
</script>
</html>
