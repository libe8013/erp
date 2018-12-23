<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/17/017
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>仓库查询</title>
    <%@include file="/common/head.jsp"%>
    <script src="/erp/stock/js/Warehouse.js"></script>

</head>
<body>
    <div>
        <div class="layui-inline">
            <label class="layui-form-label">仓库：</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="text" id="sname" name="sname" placeholder="请输入你想查询的仓库" >
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-input-inline">商品：</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="text" id="gname" name="gname" placeholder="请输入你想查询的仓库" >
            </div>
            <button class="layui-btn" id="queryStoreLikePage">查询</button>

        </div>
    </div>

        <div>
            <table class="layui-table" id="queryStoreTypeTab"lay-filter="StoreTypeTab">
            </table>
        </div>

    </div>

</body>
</html>
