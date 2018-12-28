<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2018/12/20
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head.jsp"%>
    <script src="${ctx}/market/js/orderDetailMarket.js"></script>
</head>
<body>
<input type="hidden" id="path" value="${ctx}"/>
<div>
<form class="layui-form" method="post" id="ff" autocomplete="off">
        <div class="layui-inline" style="padding-left: 10px;padding-top: 10px;">
            <label class="layui-form-label">客户：</label>
            <div class="layui-input-inline">
                <select name="supplieruuid" lay-verify="supplieruuid" lay-filter="supplier"  id="supplieruuid" lay-search="">
                    <option value="0">请选择客户</option>
                </select>
            </div>
        </div>
</form>

</div>

<div style="margin-bottom: 10px;" class="table-overlay">
    <table class="layui-table" id="orderDetailTable" lay-filter="orderDetailTab">
    </table>
</div>

<script type="text/html" id="toolbarTop">
    <button type="button" class="layui-btn layui-btn-sm" id="addRow" data-type="addRow"><i class="layui-icon"><font size="2">增加</font></i></button>
    <button type="button" class="layui-btn layui-btn-sm" id="saveOrders" data-type="saveOrders"><i class="layui-icon"><font size="2">提交</font></i></button>
</script>
</body>
</html>
