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
    <script src="${ctx}/personnel/js/orderDetailreturnedgoods.js"></script>
</head>
<body>
<form class="layui-form layui-form-pane" action="">
    <div style="padding-left: 3%;">
        <div>
            <div class="layui-inline">
                <label class="layui-form-label">流水号</label>
                <div class="layui-input-inline" style="width: 260px;">
                    <input type="text" id="uuid" value="${param.get("uuid")}" readonly lay-verify="required"  autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">供应商</label>
                <div class="layui-input-block">
                    <input type="text" id="supplieruuid" id="date1" readonly autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">状态</label>
                <div class="layui-input-inline">
                    <input type="text" id="state" readonly autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div>
            <div class="layui-inline">
                <label class="layui-form-label">下单人</label>
                <div class="layui-input-inline" style="width: 260px;">
                    <input type="text" id="creater" readonly lay-verify="required"  autocomplete="off" class="layui-input">
                    <input type="hidden" id="createrUUID" readonly lay-verify="required"  autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">审核人</label>
                <div class="layui-input-block">
                    <input type="text" id="checker" readonly autocomplete="off" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">库管员</label>
                <div class="layui-input-inline">
                    <input type="text" id="ender" readonly autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div>
            <div class="layui-inline">
                <label class="layui-form-label">下单日期</label>
                <div class="layui-input-inline" style="width: 260px;">
                    <input type="text" readonly id="createtime" lay-verify="required"  autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">审核日期</label>
                <div class="layui-input-block">
                    <input type="text" readonly id="checktime" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">确认日期</label>
                <div class="layui-input-inline">
                    <input type="text" readonly id="starttime" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div>
            <div class="layui-inline">
                <label class="layui-form-label">入库日期</label>
                <div class="layui-input-inline" style="width: 260px;">
                    <input type="text" readonly id="endtime" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">运单号</label>
                <div class="layui-input-inline">
                    <input type="text" readonly id="waybillsn" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">总金额</label>
                <div class="layui-input-inline">
                    <input type="text" readonly id="totalmoney" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
    </div>
</form>
<div>
    <table class="layui-table" id="orderDetailTable" lay-filter="orderDetailAuditFilter">
    </table>
</div>
<script type="text/html" id="Audit">
    <button class="layui-btn layui-btn-normal layui-btn-sm" id="Ordersreturnorders" lay-event="OrderDetailreturnorders">登记</button>
</script>
</body>
</html>
