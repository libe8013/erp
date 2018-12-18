<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/18 0018
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <%@include file="/common/head.jsp"%>

    <script src="${ctx}/market/js/order.js"></script>

</head>
<body>
<input type="hidden" id="path" value="${ctx}"/>
    <div class="layui-inline">
        <form class="layui-form" action="">
            <label class="layui-form-label">客户：</label>
            <div class="layui-input-inline">
                <select name="empname" id="empname" lay-search="">
                    <option value="0">请选择您要查询的客户</option>
                </select>
            </div>
            <button class="layui-btn" id="queryOrder">查询</button>
        </form>
    </div>


<div>
    <table class="layui-table" id="orderTable" lay-filter="orderTable"></table>
</div>
<script type="text/html" id="toolbarTop">
    <a class="layui-btn layui-btn-sm" href="javascript:add();" id="add"><i class="layui-icon"><font size="2">增加</font></i></a>
</script>

</body>
</html>
