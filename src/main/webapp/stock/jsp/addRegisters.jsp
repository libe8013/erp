<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/20/020
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<input id="path" value="${ctx}" type="hidden"/>

<div>
    <form class="layui-form" action="">
    <div class="layui-inline">
            <label class="layui-form-label">商品：</label>
            <div class="layui-input-inline">
                <select name="gname" id="gname" lay-verify="required" lay-search="">
                    <option value="0">请选择您要查询的员工</option>
                </select>
            </div>
    </div>
    </form>
    <form class="layui-form" method="post">
    <div class="layui-inline">
            <label class="layui-form-label">仓库：</label>
            <div class="layui-input-inline">
                <select name="sname" id="sname" lay-search="">
                    <option value="0">请选择您要查询的仓库</option>
                </select>
            </div>
    </div>
    </form>
    <form class="layui-form" action="">
    <div class="layui-inline">
            <label class="layui-form-label">数量：</label>
            <div class="layui-input-inline">
                <input class="layui-input" id="num" name="num" />
            </div>
    </div>
    </form>
    <form class="layui-form" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">类型：</label>
            <div class="layui-input-block">
                <input type="radio" name="type"  value="1" title="盘盈">
                <input type="radio" name="type"  value="2" title="盘亏">
            </div>
        </div>
    </form>
    <input type="submit" id="save" name="save" class="layui-input" />
</div>
</body>
</html>
