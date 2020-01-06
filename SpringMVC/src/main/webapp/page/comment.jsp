<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mrchen
  Date: 2019/4/18
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java"  %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="${ctx}/static/vue.js"></script>
    <script src="${ctx}/static/vue-resource.js"></script>
    <script src="${ctx}/static/plugins/jquery/jquery.js"></script>

</head>

<body>
 <div id="content">

     <ul>
         <li v-for="comment in comments">
             {{comment.id}}
             {{comment.name}}
             {{comment.content}}
             {{comment.time}}
         </li>
     </ul>




     <button id="test" @click="getinfo">test</button>

     <c:forEach items="${comments}" var="com">
         ${com.id}
         ${com.name}
         ${com.content}
         <c:out value="100"></c:out>
         <c:out value="${com.id}"></c:out>
     </c:forEach>

 </div>

 <script>

     var v1 =new Vue({
         el:'#content',
         data:{
             msg:"hello",
             comments:[ ],
         },
         created(){
             this.getinfo()
         },
         methods:{
             getinfo(){
                this.$http.get('${ctx}/comment/addcomment').then(function (result) {
                    this.comments=result.data
                })
             },
         },
     })

 </script>
</body>
</html>
