<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/18/018
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>仓库变动记录</title>
    <%@include file="/common/head.jsp"%>
    <script src="${ctx}/stock/js/invrecord.js"></script>
</head>
<body>
<input type="hidden" id="path" value="${ctx}"/>



<div>
    <div class="layui-inline">
        <form class="layui-form" action="" method="post">
            <label class="layui-form-label">员工：</label>
            <div class="layui-input-inline">
                <select name="empName" id="empName" lay-verify="required" lay-search="">
                    <option value="0">请选择您要查询的员工</option>
                </select>
            </div>
        </form>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">操作日期：</label>
        <div class="layui-input-inline">
            <input type="text"  id="czbeg" name="czbeg" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="text"  id="czend" name="czend" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-inline">
        <form class="layui-form" action="">
            <label class="layui-form-label">仓库：</label>
            <div class="layui-input-inline">
                <select name="sname" id="sname" lay-verify="required" lay-search="">
                    <option value="0">请选择您要查询的仓库</option>
                </select>
            </div>
        </form>
    </div>

    <div class="layui-inline">
        <form class="layui-form" action="">
            <label class="layui-form-label">商品：</label>
            <div class="layui-input-inline">
                <select name="gname" id="gname" lay-verify="required" lay-search="">
                    <option value="0">请选择您要查询的商品</option>
                </select>
            </div>
        </form>
    </div>

    <div class="layui-inline">
        <form class="layui-form" action="">
            <label class="layui-form-label">类型：</label>
            <div class="layui-input-inline">
                <select name="type" id="type" lay-verify="required" lay-search="">
                    <option value="0">请选择您要查询的类型</option>
                </select>
            </div>
        </form>
    </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button class="layui-btn" id="Query">查询</button>

</div>






    <div>
        <table class="layui-table" id="queryRecord">
        </table>
    </div>

</body>
</html>
