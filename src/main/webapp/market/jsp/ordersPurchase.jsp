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
    <%--<script src="basic/js/goodsType.js"></script>--%>
    <script src="${ctx}/market/js/order.js"></script>
</head>
<body>
<input type="hidden" id="path" value="${ctx}"/>
<div>
    <table class="layui-table" id="ordersTable" lay-filter="ordersTab">
    </table>
</div>
<script type="text/html" id="toolbarTop">
    <a class="layui-btn layui-btn-sm" href="javascript:add();" id="add"><i class="layui-icon"><font size="2">采购申请</font></i></a>
</script>
<script type="text/html" id="crud">
    <a class="layui-btn layui-btn-sm" lay-event="edit"><i class="layui-icon"></i></a>
    <a class="layui-btn layui-btn-normal layui-btn-sm" id="delButton" lay-event="del"><i class="layui-icon"></i></a>
</script>
<script type="text/html" id="addDiv">
    <form class="layui-form" id="addFF" method="post" autocomplete="off">
        <div>
            <div class="layui-inline" style="padding-left: 20px;padding-top: 15px;">
                <label class="layui-form-label">供应商：</label>
                <div class="layui-input-inline">
                    <select name="supplieruuid" lay-verify="supplieruuid" id="supplieruuid" lay-search="">
                        <option value="0">请选择供应商</option>
                    </select>
                </div>
            </div>
            <div>
                <table class="layui-table" id="orderDetailTable" lay-filter="orderDetailTab">
                </table>
            </div>
            <button style="margin-left: 43%;margin-top: 5%;" lay-filter="addPurchase" lay-submit class="layui-btn" id="addButton">保存</button>
        </div>
    </form>
</script>
<script type="text/html" id="editDiv">
    <form class="layui-form" id="editFF" lay-filter="editForm" method="post" autocomplete="off">
        <div>
            <div class="layui-inline" style="padding-top: 18px;padding-left: 20px;">
                <label class="layui-form-label">编号：</label>
                <div class="layui-input-inline">
                    <input type="text" name="uuid" style="width: 265px;" readonly class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline" style="padding-top: 18px;padding-left: 20px;">
                <label class="layui-form-label">名称：</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" lay-verify="storeName" placeholder="请输入要添加的名称" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline" style="padding-top: 18px;padding-left: 20px;">
                <label class="layui-form-label">地址：</label>
                <div class="layui-input-inline">
                    <input type="text" name="address" placeholder="请输入要添加的地址" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline" style="padding-top: 18px;padding-left: 20px;">
                <label class="layui-form-label">库管员：</label>
                <div class="layui-input-inline">
                    <select name="empuuid"  id="empuuidEdit" lay-verify="empuuid" lay-search="">
                        <option value="0">请选择库管员</option>
                    </select>
                </div>
            </div>
            <button style="margin-left: 43%;margin-top: 5%;" lay-filter="editStore" lay-submit class="layui-btn" id="editButton">保存</button>


        </div>
    </form>
</script>
</body>
</html>
