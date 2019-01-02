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
    <script src="${ctx}/purchase/js/orderPurchase.js"></script>
</head>
<body>
<div>
    <div class="layui-inline">
        <form class="layui-form" action="">
            <label class="layui-form-label">订单状态：</label>
            <div class="layui-input-inline">
                <select id="state" lay-verify="" lay-search="">
                    <option value="">全部</option>
                    <option value="未审核">未审核</option>
                    <option value="已审核">已审核</option>
                    <option value="已确定">已确定</option>
                    <option value="未入库">未入库</option>
                    <option value="已入库">已入库</option>
                </select>
            </div>
            <a href="javascript:void(0);" class="layui-btn" id="goodsQuery">查询</a>
        </form>
    </div>
</div>
<div>
    <table class="layui-table" id="ordersTable" lay-filter="ordersTab">
    </table>
</div>
<script type="text/html" id="crud">
    <a class="layui-btn layui-btn-normal layui-btn-sm" id="orderdetail" lay-event="queryOrderDetail">订单详情</a>
</script>
</body>
</html>
