<%--
  Created by IntelliJ IDEA.
  User: Mrchen
  Date: 2019/4/25
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <title>网上购物平台</title><!--设置标题内容-->
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"><!--设置中文格式-->
    <link rel="stylesheet" id="styles" href="${ctx}/css/index.css" type="text/css" media="screen,projection"/>
    <script src="${ctx}/static/plugins/jquery/jquery.js"></script>
    <script src="${ctx}/static/vue.js"></script>
    <script src="${ctx}/static/vue-resource.js"></script>
</head>
<body>
<div id="con">
<div id="container"><!--添加一个容器div标签-->
    <div id="header"><!--添加一个头部div标签-->
        <img src="${ctx}/images/背景图.jfif" width="100%" height="160px"/>
    </div>
    <div id="navigation">
        <ul class="nav_ul">
            <c:set var="username" value="${sessionScope.username}"></c:set>
            <li ><a href="product.jsp" style="color:#FFFFFF;">首页</a></li>
            <li ><a href="ShopCartServlet?type=select" style="color:#FFFFFF;">购物车</a></li>
            <li>
                <c:choose>
                    <c:when test="${!empty username}">
                        <a href="./user/userinfo.jsp" style="color:#FFFFFF;">个人信息中心</a>&nbsp;&nbsp;&nbsp;
                        <a href="LoginServlet?type=logout" style="color:#FFFFFF;">${username}，欢迎你，点此注销</a>
                    </c:when>
                    <c:otherwise>
                        <a href="./user/login.jsp" style="color:#FFFFFF;">登录</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </div>
    <form name="req_form" id="req_form"  >
        <div class="layui-input-inline">
            <input type="hidden" name="pageNum" lay-verify="title" value="1">
        </div>
        <label for="">价格：</label>
        <select name="price" v-model="productDto.price"  @change="productinfo" style="background:#D8BCBC;" >
            <option value=''>不限</option>
            <option value="100" >100以下</option>
            <option value="200" >200以下</option>
            <option value="300" >300以下</option>
            <option value="400" >400以下</option>
            <option value="500" >500以下</option>
            <option value="999" >1000以下</option>
        </select>&nbsp; &nbsp; &nbsp; &nbsp;
        <label for="">颜色：</label>
        <select name="color" v-model="productDto.color" @change="productinfo" style="background:#D8BCBC;" >
            <option value=''>不限</option>
            <option value="黑色" >黑色</option>
            <option value="白色" >白色</option>
            <option value="红色" >红色</option>
            <option value="橙色" >橙色</option>
            <option value="黄色" >黄色</option>
            <option value="绿色" >绿色</option>
            <option value="青色" >青色</option>
            <option value="蓝色" >蓝色</option>
            <option value="紫色" >紫色</option>
        </select>&nbsp; &nbsp; &nbsp; &nbsp;
        <label for="">销量：</label>
        <select name="salecount" v-model="productDto.salecount" @change="productinfo" style="background:#D8BCBC;">
            <option  value=''>不限</option>
            <option value="100" >100以上</option>
            <option value="300" >300以上</option>
            <option value="500" >500以上</option>
            <option value="1000" >1000以上</option>
        </select>&nbsp; &nbsp; &nbsp; &nbsp;
        <label for="">上架时间：</label>
        <select name="saletime" v-model="productDto.saletime" @change="productinfo" style="background:#D8BCBC;">
            <option  value=''>不限</option>
            <option value="20181201" >2018年12月后</option>
            <option value="20180601" >2018年6月后</option>
            <option value="20171201" >2017年12月后</option>
            <option value="20170601" >2017年6月后</option>
            <option value="20160101" >2016年之后</option>
        </select>&nbsp; &nbsp; &nbsp; &nbsp; <br>
        <label for="">尺码：</label>
        <select name="size"  v-model="productDto.size" @change="productinfo" style="background:#D8BCBC;">
            <option  value=''>不限</option>
            <option value="35">35</option>
            <option value="36">36</option>
            <option value="37">37</option>
            <option value="38">38</option>
            <option value="39">39</option>
            <option value="40">40</option>
            <option value="41">41</option>
            <option value="42">42</option>
            <option value="43">43</option>
            <option value="44">44</option>
            <option value="45">45</option>
        </select>&nbsp; &nbsp; &nbsp; &nbsp;
        <label for="">价格排序：</label>
        <select name="priceorder"  v-model="productDto.priceorder" @change="productinfo" style="background:#D8BCBC;" >
            <option value=''>不限</option>
            <option value="asc" >价格由低到高</option>
            <option value="desc" >价格由高到低</option>
        </select>&nbsp; &nbsp; &nbsp; &nbsp;
        <label for="">销量排序：</label>
        <select name="countorder" v-model="productDto.coutnorder" @change="productinfo" style="background:#D8BCBC;">
            <option  value=''>不限</option>
            <option value="desc" >销量由高到低</option>
            <option value="asc" >销量由低到高</option>
        </select>&nbsp; &nbsp; &nbsp; &nbsp;
        <div id="lookuptxt" >
            <input type="text" id="choosetxt" name="context" class="form-control" placeholder="请在此处输入搜索内容!" v-model="productDto.context" />
            <input type="button" id="lookupbtn" @click="productinfo"  value="搜索"/>
        </div>
        <ul id="navul">
            <li onmouseover="display(this)" onmouseout="ndisplay(this)" style="background: #D06364"><a href="${ctx}/product/select?cate=0"  style="color: white" >全部</a>
            <li onmouseover="display(this)" onmouseout="ndisplay(this)" style="background: #D06364"><a  href="${ctx}/product/select?cate=1"  style="color: white" >运动鞋</a>
                <ul>
                    <li class="dh1"><a href="${ctx}/product/select?cate=football" >足球鞋</a></li>
                    <li class="dh2"><a href="${ctx}/product/select?cate=basktball" >篮球鞋</a></li>
                    <li class="dh3"><a href="${ctx}/product/select?cate=sport"  >跑步鞋</a></li>
                    <li class="dh4"><a href="${ctx}/product/select?cate=skateboard " >滑板鞋</a></li>
                    <li class="dh5"><a href="${ctx}/product/select?cate=mountain" >登山鞋</a></li>
                </ul>
            </li>
            <li onmouseover="display(this)" onmouseout="ndisplay(this)" style="background: #D06364"><a href="${ctx}/product/select?cate=2"  style="color: white" >休闲鞋</a>
                <ul id=>
                    <li class="dh1"><a href="${ctx}/product/select?cate=skate" >板鞋</a></li>
                    <li class="dh2"><a href="${ctx}/product/select?cate=increase" >增高鞋</a></li>
                    <li class="dh3"><a href="${ctx}/product/select?cate=sandals" >凉鞋</a></li>
                    <li class="dh4"><a href="${ctx}/product/select?cate=slipper" >拖鞋</a></li>
                </ul>
            </li>
            <li onmouseover="display(this)" onmouseout="ndisplay(this)" style="background: #D06364"><a href="${ctx}/product/select?cate=3"  style="color: white" >潮流鞋</a>
                <ul>
                    <li class="dh1"><a href="${ctx}/product/select?cate=highheel">高跟鞋</a></li>
                    <li class="dh2"><a href="${ctx}/product/select?cate=leather" >皮鞋</a></li>
                    <li class="dh3"><a href="${ctx}/product/select?cate=boots" >靴子</a></li>
                </ul>
            </li>
        </ul>
    </form>
    <br><br><br><br>
   <span v-for="Product in products">
     <a  href="CommentServlet?type=select&productnumber=${Product.productnumber}" > <img :src="'${ctx}/'+Product.img" width="300px" height="210px"/> </a> <br>
     {{Product.productname}}<br>
     {{Product.price}}¥ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                     {{Product.salecount}}&nbsp;&nbsp;&nbsp;<br>
     <a onclick="return excute();" href="#" style="background:blanchedalmond "  >购买</a> &nbsp;&nbsp;&nbsp;
     <a onclick="return excute();"  href="ShopCartServlet?productnumber=${Product.productnumber}&type=insert&count=1" style="background:bisque" >加入购物车</a>&nbsp;&nbsp;
     <a  href="CommentServlet?type=select&productnumber=${Product.productnumber}" >商品详情</a>
   </span>
    </div>
    <div id="pages">
        <tr>
            <td>
                共{{pageTotal}}条记录,第{{pagePageNum}}/{{pagePages}}页
            </td>
            <td colspan="8">
                <a href="javascript:void (0);" page="first" >首页</a>
                <a href="javascript:void (0);" page="prev">上一页</a>
                <a href="javascript:void (0);" page="next">下一页</a>
                <a href="javascript:void (0);" page="last">尾页</a>
                <input type="text" name="Page" size="1" style="display:inline-block" v-model="inputPageNum" >
                <a href="javascript:void (0);" page="GO">跳转</a>
            </td>
        </tr>
    </div>
</div>
<div id="footer">
    <p><a href="" target="_blank" style="color: white;">版权所有：</a>
</div>

<script>
    // layui.use(['element','form','jquery'],function () {
    //     var element=layui.element;
    //     var form=layui.form;
    //     var $=layui.jquery;
    //     alert("4")

    $(function (){
        $('a[page]').click(function () {
            var pageNum=1;
            var Page=vm.inputPageNum;
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
            vm.productDto.pageNum=pageNum;
            vm.pageproduct();
        })
    })
    var  vm =new Vue({
        el:"#con",
        data:{
            productDto:{
                color:'',
                pageNum:'',
                size:'',
                price:'',
                saletime:'',
                salecount:'',
                countorder:'',
                priceorder:'',
                context:'',
            },
            products:[],
            pageTotal:'',
            pagePageNum:'',
            pagePages:'',
            inputPageNum:1,
        },
        created(){
            this.productinfo()
        },
        methods:{
            pageproduct(){
                this.$http.post("${ctx}/product/select",
                    {   color:this.productDto.color,
                        pageNum:this.productDto.pageNum,
                        size:this.productDto.size,
                        price:this.productDto.price,
                        saletime:this.productDto.saletime,
                        salecount:this.productDto.salecount,
                        countorder:this.productDto.countorder,
                        priceorder:this.productDto.priceorder,
                        context:this.productDto.context,
                    },
                    {emulateJSON:true}).then(function (result) {
                        this.products=result.data.list,
                        this.pageTotal=result.data.total,
                        this.pagePageNum=result.data.pageNum,
                        this.pagePages=result.data.pages,
                        this.inputPageNum=result.data.pageNum,
                        console.log(result.data)
                })
            },
            productinfo(){
                this.$http.post("${ctx}/product/select",
                    {   color:this.productDto.color,
                        pageNum:1,
                        size:this.productDto.size,
                        price:this.productDto.price,
                        saletime:this.productDto.saletime,
                        salecount:this.productDto.salecount,
                        countorder:this.productDto.countorder,
                        priceorder:this.productDto.priceorder,
                        context:this.productDto.context,
                    },
                    {emulateJSON:true}).then(function (result) {
                        this.products=result.data.list,
                        this.pageTotal=result.data.total,
                        this.pagePageNum=result.data.pageNum,
                        this.pagePages=result.data.pages,
                        this.inputPageNum=result.data.pageNum,
                        console.log(result.data)
                })
            },
        },
    })

    function display(li)
    {
        var subdis=li.getElementsByTagName("ul")[0];
        subdis.style.display="block";
    }
    function ndisplay(li)
    {
        var subdis=li.getElementsByTagName("ul")[0];
        subdis.style.display="None";
    }
    function submit()
    {
        document.getElementById("req_form").submit();
        return false;
    }
    function settxt(txt){
        req_form.selecttxt.value=txt;
    }
</script>
</body>
</html>

