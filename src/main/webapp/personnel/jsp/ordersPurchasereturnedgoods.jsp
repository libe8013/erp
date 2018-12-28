<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head.jsp"%>
    <script src="${ctx}/personnel/js/orderPurchasereturnedgoods.js"></script>
</head>
<body>
<input type="hidden" id="path" value="${ctx}"/>
<div>
    <form class="layui-form" method="post" id="ff" autocomplete="off">
        <div class="layui-inline" style="padding-left: 10px;padding-top: 10px;">
            <label class="layui-form-label">仓库：</label>
            <div class="layui-input-inline">
                <select name="storeuuid" lay-verify="storeuuid" lay-filter="supplier" id="storeuuid" lay-search="">
                    <option value="0">请选择仓库</option>
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
