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
    <script src="${ctx}/market/js/returnorderMarketAudit.js"></script>
</head>
<body>
<div>
    <div class="layui-inline">
        <form class="layui-form" action="">
            <label class="layui-form-label">登记时间：</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="createtime" placeholder="yyyy-MM-dd">
            </div>
            <a href="javascript:void(0);" class="layui-btn" id="goodsQuery">查询</a>
        </form>
    </div>
</div>
<div>
    <table class="layui-table" id="ordersTable" lay-filter="ordersTab">
    </table>
</div>
<script>
    layui.use(['laydate'],function () {
        var laydate = layui.laydate;
        //常规用法
        laydate.render({
            elem: '#createtime'
        });
    })

</script>
<script type="text/html" id="crud">
    <a class="layui-btn layui-btn-normal layui-btn-sm" id="orderdetailAudit" lay-event="queryOrderDetailAudit">订单审核</a>
</script>
</body>
</html>
