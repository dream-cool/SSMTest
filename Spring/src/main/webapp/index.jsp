<%@ page contentType="text/html; charset=utf-8"%>
<html>
<body>
<script src="${ctx}/static/vue.js"></script>
<script src="${ctx}/static/vue-resource.js"></script>
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<h2>Hello World!</h2>
<div id="example-4">

    <div id="app">
        <input type="button" value="刷新" @click="flush">
    </div>

</div>
<a href="/pages/login.jsp">密码登录</a><br>
<a href="/pages/relogin.jsp">验证码登录</a><br>
<a href="/pages/register.jsp">注册</a><br>
<a href="/pages/product.jsp">商品</a><br>
<a href="/pages/usermanager.jsp">用户管理</a><br>
<a href="/pages/test.jsp">test</a><br>
<script>

    var vm=new Vue({
        el:"#app",
        methods:{
            flush(){
                location.reload();
            }
        }
    })

    layui.use(['flow', 'form', 'element', 'laydate'], function(){

        var jQuery = layui.jquery
            ,layer = layui.layer
            ,form = layui.form
            ,element = layui.element
            ,flow = layui.flow;

        form.on("radio(sex)", function (data) {
            var sex = data.value;
            alert(data.value)
        });
        //当你执行这样一个方法时，即对页面中的全部带有lay-src的img元素开启了懒加载（当然你也可以指定相关img）
        flow.lazyimg();
    });

    var isAutoSend = document.getElementsByName('isAuto');


</script>
</body>
</html>
