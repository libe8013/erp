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
    <script src="${ctx}/market/js/orderMarketStorage.js"></script>
</head>
<body>
<div>
    <form class="layui-form" action="">
        <label class="layui-form-label">确认时间：</label>
        <div class="layui-input-inline">
            <input type="text" class="layui-input" id="starttime" placeholder="yyyy-MM-dd">
        </div>
        <a href="javascript:void(0);" class="layui-btn" id="goodsQuery">查询</a>
    </form>
</div>
<div>
    <table class="layui-table" id="ordersStorageTable" lay-filter="ordersStorageTab">
    </table>
</div>
<script>
    layui.use(['laydate'],function () {
        var laydate = layui.laydate;
        //常规用法
        laydate.render({
            elem: '#starttime'
        });
    })

</script>
</body>
</html>
