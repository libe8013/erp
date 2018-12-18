<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2018/12/16
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <%--<script src="basic/js/goodsType.js"></script>--%>
    <script src="/erp/basic/js/goodsType.js"></script>
</head>
<body>
<input type="hidden" id="path" value="${ctx}"/>
<div>
    <label class="layui-form-label">类型名称：</label>
    <div class="layui-input-inline">
            <input type="text" id="name" name="name" placeholder="请输入您要查询的内容" class="layui-input"/>
    </div>
    <button class="layui-btn" id="goodsTypeQuery">查询</button>
</div>
<div>
    <table class="layui-table" id="goodsTypeTab" lay-filter="goodsTypeTab">
    </table>
</div>
<script type="text/html" id="toolbarTop">
    <a class="layui-btn layui-btn-sm" href="javascript:add();" id="add"><i class="layui-icon"><font size="2">增加</font></i></a>
</script>
<script type="text/html" id="crud">
    <a class="layui-btn layui-btn-sm" lay-event="edit"><i class="layui-icon"></i></a>
    <a class="layui-btn layui-btn-normal layui-btn-sm" id="delButton" lay-event="del"><i class="layui-icon"></i></a>
</script>
<script type="text/html" id="addDiv">
    <div class="layui-form-item" style="padding:20px;">
        <label class="layui-form-label">类型名称：</label>
        <form id="ff">
        <div class="layui-input-inline">
            <input type="text" id="gname" name="name" lay-verify="required" placeholder="请输入您要添加的类型名称" class="layui-input"/>
        </div>
        </form>
        <button class="layui-btn" id="addForm">保存</button>
    </div>
</script>
</body>
</html>
