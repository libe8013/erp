<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日志管理</title>
    <%@include file="/common/head.jsp"%>
    <script src="/erp/log/js/log.js"></script>

</head>
<body>
<div>
    <div class="layui-inline">
        <label class="layui-form-label">用户编号：</label>
        <div class="layui-input-inline">
            <input class="layui-input" type="text" id="empid" name="empid" placeholder="请输入您要查询的编号" >
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-input-inline">用户ip：</label>
        <div class="layui-input-inline">
            <input class="layui-input" type="text" id="ip" name="ip" placeholder="请输入你想查询的ip" >
        </div>
        <button class="layui-btn" id="queryLog">查询</button>

    </div>
</div>

<div>
    <table class="layui-table" id="queryLogTab"lay-filter="LogTypeTab">
    </table>
</div>

</div>

</body>
</html>
