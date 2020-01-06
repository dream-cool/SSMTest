<%@ page contentType="text/html; charset=utf-8"%>
<html>
<body>
<script src="${ctx}/static/vue.js"></script>
<script src="${ctx}/static/vue-resource.js"></script>
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<h2>Hello World!</h2>
<div id="example-4">
    <input type="radio" id="one"  name="isAuto" value="fsse" v-model="picked" @click="test" checked>
    <label for="one">One</label>
    <br>
    <input type="radio" id="two"  name="isAuto" value="Two" v-model="picked" @click="test">
    <label for="two">Two</label>
    <br>
    <span>Picked: {{ pickedaa }}</span>

    <form class="layui-form">
        <input type="radio" name="sex" checked="checked" value="1"  lay-filter="erweima">男
        <input type="radio" name="sex" value="2"  lay-filter="erweima">女
    </form>


    <div id="app">
        <input type="button" value="1111111111111" @click="flush">
        <img class="layui-src" src="/static/images/pw34866.jpg" />
    </div>

</div>
<a href="/pages/login.jsp">登录</a>
<a href="/pages/register.jsp">登录</a>
<a href="/pages/product.jsp">商品</a>
<a href="/pages/test.jsp">商品</a>
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
