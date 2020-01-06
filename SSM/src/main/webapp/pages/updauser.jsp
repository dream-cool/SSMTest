<%--
  Created by IntelliJ IDEA.
  User: Mrchen
  Date: 2019/4/29
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>注册</title>
    <script src="${ctx}/static/vue.js"></script>
    <script src="${ctx}/static/vue-resource.js"></script>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
</head>
<body class="layui-layout-body"  >

<div>
    <a href="${ctx}/pages/usermanager.jsp"  class="layui-btn layui-btn-sm" >
        <i class="layui-icon-return">&#xe65c;</i>
    </a>
</div>

<div id="content">
<div style="margin-left: 30%">
    <div  class="layui-form" >
        <div class="layui-input-inline">
            <input type="hidden" name="userId" v-model="user.userId" lay-verify="title" >
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="userName" v-model="user.userName" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">*
                <span id="msg" class="layui-form-mid layui-word-aux"></span>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="text" name="passWord" v-model="user.passWord" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">

            </div>
            <div class="layui-form-mid layui-word-aux">*
                <span id="msg_pwd" class="layui-form-mid layui-word-aux"></span>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="email" v-model="user.email" lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">电话</label>
            <div class="layui-input-inline">
                <input type="text" name="tel" v-model="user.tel" required  lay-verify="required" placeholder="请输入电话" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-inline">
                <input type="text" name="address" v-model="user.address"  required  lay-verify="required" placeholder="请输入地址" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男"  lay-filter="sex" v-model="user.sex" >
                <input type="radio" name="sex" value="女" title="女"  lay-filter="sex" v-model="user.sex" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <input type="radio" name="state" value="1" lay-filter="state" v-model="user.state"  title="正常">
                <input type="radio" name="state" value="0" lay-filter="state" v-model="user.state" title="禁用" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">注册时间</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" name="regTime" id="regtime" v-model="user.regTime"  placeholder="yyyy-MM-dd HH:mm:ss">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">最后登录时间</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" name="lastLoginTime" v-model="user.lastLoginTime" id="logintime" placeholder="yyyy-MM-dd HH:mm:ss" >
            </div>
        </div>
        <div class="layui-form-item" style="margin-left: -5%">
            <div class="layui-input-block">
                <button class="layui-btn"   name="but" @click="updateinfo" >修改</button>
                <span id="msg_log"></span>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                <div class="layui-form-mid layui-word-aux">*项必填</div>
            </div>
        </div>
    </div>
</div>
</div>

</body>
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<script>
    layui.use(['element','form','jquery','laydate'],function () {
        var element=layui.element;
        var form=layui.form;
        var laydate = layui.laydate;
        form.on("radio(state)", function (data) {
            vm.user.state=data.value
        });
        form.on("radio(sex)", function (data) {
            vm.user.sex=data.value
        });

        laydate.render({
            elem:'#logintime',
            type: 'datetime'
        });
        laydate.render({
            elem:'#regtime',
            type: 'datetime'
        });


        //监听提交
        // form.on('submit(formDemo)', function(data){
        //     layer.msg(JSON.stringify(data.field));
        //     return false;
        // });
        var $=layui.jquery;


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
                    }
                })
            })
        })
    });
    var  vm=new Vue({
        el:"#content",
        data:{
            user:{
                userId:"${user.userId}",
                userName:"${user.userName}",
                passWord:"${user.passWord}",
                tel:"${user.tel}",
                address:"${user.address}",
                state:"${user.state}",
                sex:"${user.sex}",
                email:"${user.email}",
                lastLoginTime:"",
                regTime:""
            }
        },
        created(){
            this.getTime()
        },
        methods:{
            updateinfo(){
                this.time();
                this.$http.post("${ctx}/user/update",
                    {   userId:this.user.userId,
                        userName:this.user.userName,
                        passWord:this.user.passWord,
                        tel:this.user.tel,
                        address:this.user.address,
                        sex:this.user.sex,
                        state:this.user.state,
                        email:this.user.email,
                        lastLoginTime:this.user.lastLoginTime,
                        regTime:this.user.regTime
                    },
                    {emulateJSON:true}).then(function (result) {
                        console.log(result.data)
                })
            },
            getTime(){
                this.$http.post("${ctx}/user/update",
                    {uId:this.user.userId},
                    {emulateJSON:true}).then(function (result) {
                    this.user.regTime=result.data.regTime
                    this.user.lastLoginTime=result.data.lastLoginTime
                    console.log(result.data)
                })
            },
            time(){
                var $=layui.jquery;
                this.user.lastLoginTime=$('input[name=lastLoginTime]').val();
                this.user.regTime=$('input[name=regTime]').val();
            },
        }
    })
</script>
</html>

