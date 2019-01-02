<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<input id="path" value="${ctx}" type="hidden"/>

<div>
    <form id="ff" class="layui-form" method="post" autocomplete="off">

        <div>
            <div class="layui-inline" style="padding-top: 15px;padding-left: 20px;">
                <label class="layui-form-label">编号：</label>
                <div class="layui-input-inline">
                    <input type="text" id="uuid" name="uuid" readonly style="width: 265px;" class="layui-input"/>
                </div>
            </div>

            <div class="layui-inline" style="padding-top: 15px;padding-left: 20px;">
                <label class="layui-form-label">名称：</label>
                <div class="layui-input-inline">
                    <input type="text" id="name" lay-verify="name" name="name" placeholder="请输入名称" class="layui-input"/>
                </div>
            </div>

            <div class="layui-inline" style="padding-top: 15px;padding-left: 20px;">
                <label class="layui-form-label">电话：</label>
                <div class="layui-input-inline">
                    <input type="text" id="tele" name="tele" lay-verify="phone"  placeholder="请输入电话" class="layui-input"/>
                </div>
            </div>

            <br>
            <br>

            <button style="margin-left: 43%" type="button"  lay-submit class="layui-btn" lay-filter="edit" id="deptEdit" lay-verify="deptEdit">保存</button>
        </div><br>
    </form>
</div>
<script src="${ctx}/personnel/js/deptEdit.js"></script>
</body>