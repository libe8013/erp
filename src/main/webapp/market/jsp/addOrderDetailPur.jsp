<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2018/12/20
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head.jsp"%>

    <%--<style type="text/css">
        /*您可以将下列样式写入自己的样式表中*/
        /*layui 元素样式改写*/
        .layui-btn-sm{line-height: normal; font-size: 12.5px;}
        .layui-table-view .layui-table-body{min-height: 256px;}
        .layui-table-cell .layui-input.layui-unselect{height: 30px; line-height: 30px;}

        /*设置 layui 表格中单元格内容溢出可见样式*/
        .table-overlay .layui-table-view,
        .table-overlay .layui-table-box,
        .table-overlay .layui-table-body{overflow: visible;}
        .table-overlay .layui-table-cell{height: auto; overflow: visible;}

        /*文本对齐方式*/
        .text-center{text-align: center;}
    </style>--%>
    <script src="${ctx}/market/js/orderDetailPurchase.js"></script>
</head>
<body>
<input type="hidden" id="path" value="${ctx}"/>
<div>
<form class="layui-form" method="post" autocomplete="off">
        <div class="layui-inline" style="padding-left: 10px;padding-top: 10px;">
            <label class="layui-form-label">供应商：</label>
            <div class="layui-input-inline">
                <select name="supplieruuid" lay-verify="supplieruuid" id="supplieruuid" lay-search="">
                    <option value="0">请选择供应商</option>
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
    <button type="button" class="layui-btn layui-btn-sm layui-btn-normal" id="addRow" data-type="addRow"><i class="layui-icon"><font size="2">增加</font></i></button>
</script>
</body>
</html>
