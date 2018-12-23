<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/22/022
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<input type="hidden" id="path" value="${ctx}" />
<script src="${ctx}/authority/js/role.js"></script>
<div>
    <div class="layui-inline">
        <label class="layui-input-inline">角色名称：</label>
        <div class="layui-input-inline">
            <input class="layui-input" type="text" id="rolename" name="rolename" placeholder="请您输入角色名称" >
        </div>
        <button class="layui-btn" id="queryrole">查询</button>

    </div>
</div>

<div>
    <table class="layui-table" id="roleTab" lay-filter="StoreTypeTab">
    </table>
</div>


</body>
</html>
