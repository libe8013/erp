<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/21/021
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户</title>
    <%@include file="/common/head.jsp"%>
    <script src="${ctx}/authority/js/userPage.js" ></script>
</head>
<body>
<input type="hidden" id="path" value="${ctx}" />

<div>
    <table class="layui-table" id="queryUser" lay-filter="UserTable">
    </table>
</div>
<script type="text/html" id="updPwd">
        <div class="layui-form-item" style="padding:20px;">
            <input type="hidden" class="layui-input" id="uuid" name="uuid" />
            <label class="layui-form-label">新密码：</label>
                <div class="layui-input-inline">
                    <input type="text" id="pwd" name="pwd" lay-verify="required" placeholder="请输入您要修改的新密码" class="layui-input"/>
                </div>
            <button class="layui-btn" id="PwdBnt">修改密码</button>
        </div>
</script>
</body>
</html>
