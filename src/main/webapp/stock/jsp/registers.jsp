<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/18/018
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>盘亏盘盈</title>
    <%@include file="/common/head.jsp"%>
    <script src="${ctx}/stock/js/registers.js"></script>
</head>
<body>
<input type="hidden" id="path" value="${ctx}"/>

<div>
    <div class="layui-inline">
        <label class="layui-form-label">登记日期：</label>
        <div class="layui-input-inline">
            <input type="text"  id="djbeg" name="djbeg" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="text"  id="djend" name="djend" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">审核日期：</label>
            <div class="layui-input-inline">
                <input type="text"  id="shbeg" name="shbeg" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-input-inline">
                <input type="text"  id="shend" name="shend" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
    </div>
<form class="layui-form" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">类型：</label>
        <div class="layui-input-block">
            <input type="radio" name="type" checked="checked"  value="0" title="全部">
            <input type="radio" name="type"  value="1" title="盘盈">
            <input type="radio" name="type"  value="2" title="盘亏">
        </div>
    </div>
</form>
        <button class="layui-btn" id="queryInvrecord">查询</button>
</div>
    <div>
        <table class="layui-table" id="InverecordTab">
        </table>
    </div>
<script type="text/html" id="crud">
    <a class="layui-btn layui-btn-sm" lay-event="edit"><i class="layui-icon"></i></a>
</script>
</body>
</html>
