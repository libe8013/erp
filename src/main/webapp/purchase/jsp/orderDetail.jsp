<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2018/12/23
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <script src="${ctx}/purchase/js/orderPurchase.js"></script>
</head>
<body>
<form class="layui-form layui-form-pane" action="">
    <div style="padding-left: 3%;">
        <div>
            <div class="layui-inline">
                <label class="layui-form-label">流水号</label>
                <div class="layui-input-inline">
                    <input type="text" id="uuid" readonly lay-verify="required"  autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">供应商</label>
                <div class="layui-input-block">
                    <input type="text" id="supplier" id="date1" readonly autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">状态</label>
                <div class="layui-input-inline">
                    <input type="text" id="number" readonly autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div>
            <div class="layui-inline">
                <label class="layui-form-label">下单人</label>
                <div class="layui-input-inline">
                    <input type="text" name="username" readonly lay-verify="required"  autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">审核人</label>
                <div class="layui-input-block">
                    <input type="text" name="date" readonly autocomplete="off" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">库管员</label>
                <div class="layui-input-inline">
                    <input type="text" name="number" readonly autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div>
            <div class="layui-inline">
                <label class="layui-form-label">下单日期</label>
                <div class="layui-input-inline">
                    <input type="text" readonly name="username" lay-verify="required"  autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">审核日期</label>
                <div class="layui-input-block">
                    <input type="text" readonly name="date" id="" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">确认日期</label>
                <div class="layui-input-inline">
                    <input type="text" readonly name="number" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div>
            <div class="layui-inline">
                <label class="layui-form-label">入库日期</label>
                <div class="layui-input-inline">
                    <input type="text" readonly name="username" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">运单号</label>
                <div class="layui-input-inline">
                    <input type="text" readonly name="username" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
