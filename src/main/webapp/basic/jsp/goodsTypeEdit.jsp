<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<div style="margin-top: 5%;margin-left: 6%;">
    <form id="ff" method="post">
        <div>
            <label class="layui-form-label">编号：</label>
            <div class="layui-input-inline">
                <input type="text" id="uuid" name="uuid" readonly class="layui-input"/>
            </div>
        </div><br>
        <div>
            <label class="layui-form-label">名称：</label>
            <div class="layui-input-inline">
                <input type="text" id="name" name="name" class="layui-input"/>
            </div>
        </div><br><br>
        <button style="margin-left: 26%" class="layui-btn" id="editGoodsType">保存</button>&nbsp;&nbsp;&nbsp;
        <button class="layui-btn" id="editClose">取消</button>
    </form>
</div>