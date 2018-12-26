<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/24/024
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<input type="hidden" id="path" value="${ctx}" />
<script src="${ctx}/authority/js/roleAuth.js"></script>
<script src="${ctx}/base/js/layui-xtree/layui-xtree.js"></script>

<div class="layui-inline" style="width: 60%;">
    <div>
        <table class="layui-table" id="roleAuth" lay-filter="AuthTab">
        </table>
    </div>
</div>
<%--<div class="layui-inline">
    <div>
        <form class="layui-form">
            <div id="demo" style="width:400px;border:1px solid black;padding: 10px 0 25px 5px;">
            </div>
        </form>
    </div>
</div>--%>
<div style="float: right;" >
<form class="layui-form">
    <div id="demo1" style="width:430px;border:1px solid black;padding: 10px 0 25px 5px;"></div>
</form>
</div>
</body>
</html>
