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
    <script src="${ctx}/personnel/js/returnorderDetailStorage.js"></script>
</head>
<body>
<form class="layui-form layui-form-pane" action="">
    <input class="layui-input" type="hidden" name="storeuuid" id="storeuuid" readonly/>

    <div style="padding-left: 3%;">
        <div>
            <div class="layui-inline">
                <label class="layui-form-label">流水号</label>
                <div class="layui-input-inline" style="width: 260px;">
                    <input type="text" id="uuid" value="${param.get("uuid")}" readonly lay-verify="required"  autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">仓库</label>
                <div class="layui-input-block">
                    <input type="text" id="storename" readonly autocomplete="off" class="layui-input">
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
                <label class="layui-form-label">总金额</label>
                <div class="layui-input-inline">
                    <input type="text" readonly id="totalmoney" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div>
            <div class="layui-inline">
                <label class="layui-form-label">出库日期</label>
                <div class="layui-input-inline" style="width: 260px;">
                    <input type="text" readonly id="endtime" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>

        </div>
    </div>
</form>
<div>
    <table class="layui-table" id="orderDetailTable" lay-filter="orderDetailAuditFilter">
    </table>
</div>
<script type="text/html" id="Affirm">
    <button class="layui-btn layui-btn-normal layui-btn-sm" id="OrdersAffirm" lay-event="OrderDetailAffirm">订单入库</button>
</script>
<script type="text/html" id="storageDiv">
    <form class="layui-form layui-form-pane"lay-filter="goodsStorage" id="goodsStorage" style="padding-left: 2%;">
        <input class="layui-input" name="storeuuid" type="hidden"/>
        <input type="hidden" name="ordersuuid"/>
    <input type="hidden" name="uuid"/>
    <div style="padding-top: 10px;">
        <div class="layui-inline">
            <label class="layui-form-label">商品Id</label>
            <div class="layui-input-block">
                <input type="text" readonly id="goodsuuid" name="goodsuuid" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">商品名称</label>
            <div class="layui-input-inline">
                <input type="text" readonly id="goodsname" name="goodsname" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline" style="margin-top: 10px;">
            <label class="layui-form-label">数量</label>
            <div class="layui-input-inline">
                <input type="text" readonly id="num" name="num" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline" style="margin-top: 10px;">
                <label class="layui-form-label">仓库：</label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="storename" readonly/>
                    <%--<select name="storeuuid" id="store" disabled="disabled" lay-verify="storeuuid" lay-search="">--%>
                        <%--<option value="0">请选择仓库</option>--%>
                    <%--</select>--%>
                </div>
        </div>
        <div class="layui-inline" style="margin-top: 15px;margin-left: 40%;">
            <a class="layui-btn" lay-submit lay-filter="Storage" id="delStorage">出库</a>
        </div>
    </div>
    </form>
</script>
</body>
</html>
