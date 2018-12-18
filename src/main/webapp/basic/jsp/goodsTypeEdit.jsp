<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<input id="path" value="${ctx}" type="hidden"/>
<div style="margin-top: 5%;margin-left: 6%;">
    <form id="ff" method="post" autocomplete="off">
        <div>
            <label class="layui-form-label">编号：</label>
            <div class="layui-input-inline">
                <input type="text" id="uuid" name="uuid" style="width: 265px;" readonly class="layui-input"/>
            </div>
        </div><br>
        <div>
            <label class="layui-form-label">名称：</label>
            <div class="layui-input-inline">
                <input type="text" id="name" name="name" style="width: 265px;" class="layui-input"/>
            </div>
        </div><br><br>
        <a href="javascript:void(0)" style="margin-left: 26%" class="layui-btn"autocomplete="off" id="editGoodsType">保存</a>&nbsp;&nbsp;&nbsp;
        <a href="javascript:void(0)" class="layui-btn" id="editClose">取消</a>
    </form>
</div>
<script src="${ctx}/basic/js/goodsTypeEdit.js"></script>
</body>