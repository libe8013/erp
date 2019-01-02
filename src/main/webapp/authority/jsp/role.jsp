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
<script type="text/html" id="toolbarTop">
    <a class="layui-btn layui-btn-sm" href="javascript:add();" id="add"><i class="layui-icon"><font size="2">增加</font></i></a>
</script>
<script type="text/html" id="crud">
    <a class="layui-btn layui-btn-sm" lay-event="edit"><i class="layui-icon"></i></a>
    <a class="layui-btn layui-btn-normal layui-btn-sm" id="delButton" lay-event="del"><i class="layui-icon"></i></a>
</script>
<%--添加界面--%>
<script type="text/html" id="addDiv">
    <div class="layui-form-item" style="padding:20px;">
        <label class="layui-form-label">角色名称：</label>
        <div class="layui-input-inline">
            <input type="text" id="rname" name="rname" lay-verify="required" placeholder="请输入您要添加的角色名称" class="layui-input"/>
        </div>
        <button class="layui-btn" id="addRole">添加角色</button>
    </div>
</script>
<%--修改界面--%>
<script type="text/html" id="upd">
    <form class="layui-form" lay-filter="editForm" method="post" autocomplete="off">
    <div class="layui-form-item" style="padding:20px;">
        <input type="hidden" class="layui-input" id="id" name="id" />
        <label class="layui-form-label">角色名称：</label>
        <div class="layui-input-inline">
            <input type="text" id="name" name="rolename" lay-verify="required" placeholder="请输入您要修改的角色" class="layui-input"/>
        </div>
        <button class="layui-btn" id="edit">确认修改</button>
    </div>
    </form>
</script>
</body>
</html>
