<%--
  Created by IntelliJ IDEA.
  User: Mrchen
  Date: 2019/4/21
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${ctx}/static/plugins/jquery/jquery.js"></script>
    <title>Title</title>
</head>
<body>

    <button id="b1" >User对象</button>
    <button id="b2" >map</button>
    <button id="b3" >数组</button>
    <button id="b4" >list</button>
    <input type="text" name="time" >

<div>

</div>
<script>
    $(function () {
        $('#b1').click(function () {
            $.ajax({
                url:'${ctx}/json/m1',
                type:'post',
                success:function (data) {
                    alert(data.name);
                    alert(data.id);
                }
            })
        })

    $('#b2').click(function () {
        $.ajax({
            url:'${ctx}/json/m2',
            type:'post',
            success:function (data) {
                alert(data.time);
                $('input[name=time]').val(data.time);
            }
        })
    })

    $('#b3').click(function () {
        $.ajax({
            url:'${ctx}/json/m3',
            type:'post',
            success:function (data) {
                for (var i=0;i<data.length;i++){
                    alert(data[i].name)
                    alert(data[i].id)
                }
            }
        })
    })

    $('#b4').click(function () {
        $.ajax({
            url:'${ctx}/json/m4',
            type:'post',
            success:function (data) {
                for (var i=0;i<data.length;i++){
                    alert(data[i].name)
                    alert(data[i].id)
                }}
        })
    })
    })




</script>

</body>
</html>
