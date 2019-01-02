<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2019/01/02
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <script src="${ctx}/stock/js/warning.js"></script>
</head>
<body>
<div>
    <div class="layui-inline">
        <label class="layui-form-label">商品名称：</label>
        <div class="layui-input-inline">
            <input type="text" id="name" name="name" placeholder="请输入您要查询的名称" class="layui-input"/>
        </div>
    </div>
    <a href="javascript:void(0);" class="layui-btn" id="goodsQuery">查询</a>
</div>

<div>
    <table class="layui-table" id="goodsTable" lay-filter="goodsTab">
    </table>
</div>
<script type="text/html" id="warning">
    <%--<a class="layui-btn layui-btn-sm layui-btn-normal" lay-filter="sendMsgText" lay-event="sendMsgText">发送警报邮件</a>--%>
</script>
</body>
</html>
