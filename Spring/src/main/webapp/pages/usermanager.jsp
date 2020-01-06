<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Mrchen
  Date: 2019/4/28
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<fmt:formatDate value='${regTime}'  pattern='yyyy-MM-dd HH:mm:ss'/>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>注册</title>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
    <script src="${ctx}/static/vue.js"></script>
    <script src="${ctx}/static/vue-resource.js"></script>
</head>
<body class="layui-layout-body">

<div id="content">
<div>

        <table class="layui-table">
            <colgroup>
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>用户名</th>
                <th>用户id</th>
                <th>用户密码</th>
                <th>电话</th>
                <th>地址</th>
                <th>性别</th>
                <th>邮箱</th>
                <th>状态</th>
                <th>注册时间</th>
                <th>最后登录时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody v-for="user in users">
            <tr>
                <td>{{user.userName}}</td>
                <td>{{user.userId}}</td>
                <td>{{user.passWord}}</td>
                <td>{{user.tel}}</td>
                <td>{{user.address}}</td>
                <td>{{user.sex}}</td>
                <td>{{user.email}}</td>
                <td>{{user.state}}</td>
                <td>{{user.regTime}}</td>
                <td>{{user.lastLoginTime}}</td>
                <td>
                    <div class="layui-btn-group">
                        <a href="${ctx}/pages/register.jsp" class="layui-btn layui-btn-sm">
                            <i class="layui-icon">&#xe654;</i>
                        </a>
                        <a :href="'${ctx}/user/upduser?userId='+user.userId"  class="layui-btn layui-btn-sm">
                        <i class="layui-icon">&#xe642;</i>
                        </a>
                        <a :href="'${ctx}/user/delete?userId='+user.userId" class="layui-btn layui-btn-sm">
                            <i class="layui-icon">&#xe640;</i>
                        </a>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
</div>
<div id="pages" >
    <tr>
        <td>
            共{{pageTotal}}条记录,第{{pagePageNum}}/{{pagePages}}页
        </td>
        <td colspan="8">
            <a href="javascript:void (0);" page="first"   class="layui-btn layui-btn-sm" >首页</a>
            <a href="javascript:void (0);" page="prev"   class="layui-btn layui-btn-sm">
                <i class="layui-icon layui-icon-prev"></i>
            </a>
            <a href="javascript:void (0);" page="next"  class="layui-btn layui-btn-sm">
                <i class="layui-icon layui-icon-next"></i>
            </a>
            <a href="javascript:void (0);" page="last"   class="layui-btn layui-btn-sm">尾页
            </a>
            <input type="text" size="1" name="Page" style="display:inline-block"  :value="pagePageNum"  >
            <a href="javascript:void (0);" page="GO"   class="layui-btn layui-btn-sm">跳转</a>
        </td>
    </tr>
</div>
</div>

</body>
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<script>
    layui.use(['element','form','jquery'],function () {
        var element=layui.element;
        var form=layui.form;
        var $=layui.jquery;
            $(function () {
                $('a[page]').click(function () {
                    var pageNum;
                    var Page=$('input[name=Page]').val();
                    var currPage=vm.pagePageNum;
                    var totalPages=vm.pagePages;
                    var v=$(this).attr('page');
                    switch (v) {
                        case "first":
                            pageNum=1;
                            break;
                        case "prev":
                            pageNum=parseInt(currPage)-1;
                            if(pageNum<1)
                                pageNum=1;
                            break;
                        case "next":
                            pageNum=parseInt(currPage)+1;
                            if(pageNum>totalPages)
                                pageNum=totalPages;
                            break;
                        case "last":
                            pageNum=totalPages;
                            break;
                        case "GO":
                            Page=parseInt(Page);
                            if(Page<1){
                                alert("小于最小页数");
                                return;
                            }
                            if(Page>totalPages){
                                alert("超过最大页数");
                                return;
                            }
                            if (Page>=1&&Page<=totalPages)
                                pageNum=Page;
                            else
                                alert("请输入正确的页数");
                            break;
                    }
                    vm.inputPageNum=pageNum;
                    vm.getinfo()
                })
            })
    })
    var  vm=new Vue({
        el:"#content",
        data:{
            users:[],
            pageTotal:0,
            pagePageNum:0,
            pagePages:0,
            inputPageNum:1,

        },
        created(){
            this.getinfo();
        },
        methods:{
            getinfo(){
                this.$http.post("${ctx}/user/userinfo",
                {page:this.inputPageNum},
                {emulateJSON:true}
                ).then(function (result) {
                  this.users=result.data.list;
                  this.pageTotal=result.data.total;
                  this.pagePageNum=result.data.pageNum;
                  this.pagePages=result.data.pages;
                  console.log(result.data.list)
                })
            }
        },
    })
</script>
</html>
