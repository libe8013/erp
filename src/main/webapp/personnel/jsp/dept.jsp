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
    <script src="/erp/personnel/js/dept.js"></script>
</head>

<body>
<input type="hidden" id="path" value="${ctx}"/>

<div>

    <div class="layui-inline">
        <label class="layui-form-label">名称：</label>
        <div class="layui-input-inline">
            <input type="text" id="name" name="name" placeholder="请输入您要查询的内容" class="layui-input"/>
        </div>
    </div>

    <div class="layui-inline">
        <label class="layui-form-label">电话：</label>
        <div class="layui-input-inline">
            <input type="text" id="tele" name="tele" placeholder="请输入您要查询的内容" class="layui-input"/>
        </div>
    </div>

        <button style="margin-left:4%"  class="layui-btn" id="deptQuery">查询</button>
</div>



    <div>
    <table class="layui-table" id="deptTable" lay-filter="deptTab"></table>
    </div>

    <script type="text/html" id="toolbarTop">
    <a class="layui-btn layui-btn-sm" href="javascript:add();" id="add"><i class="layui-icon"><font size="2">增加</font></i></a>
    </script>

    <script type="text/html" id="crud">
    <a class="layui-btn layui-btn-sm" lay-event="edit"><i class="layui-icon"></i></a>
    <a class="layui-btn layui-btn-normal layui-btn-sm" id="delButton" lay-event="del"><i class="layui-icon"></i></a>
    </script>

    <script type="text/html" id="addDiv">
    <form class="layui-form" id="ff" autocomplete="off">
        <div>
            <div class="layui-inline" style="padding:10px;margin-left:20px">
                <label class="layui-form-label">名称：</label>
                <div class="layui-input-inline">
                    <input type="text" id="name1" lay-verify="name" name="name" placeholder="请输入名称" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline" style="padding:10px; margin-left:20px" >
                <label class="layui-form-label">电话：</label>
                <div class="layui-input-inline">
                    <input type="text" id="tele1" name="tele" lay-verify="phone"  placeholder="请输入电话" class="layui-input"/>
                </div>
            </div>

            </div>
            <br>
            <button style="margin-left: 43%;" href="javascript:void(0);" lay-submit class="layui-btn"  id="addForm" lay-verify="addForm">保存</button>
        </div>
    </form>
</script>
</body>
</html>
