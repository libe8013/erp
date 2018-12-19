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
    <script src="${ctx}/basic/js/supplier.js"></script>
</head>
<body>
<input type="hidden" id="path" value="${ctx}"/>
<div>
    <div class="layui-inline">
        <label class="layui-form-label">名称：</label>
        <div class="layui-input-inline">
                <input type="text" id="name" placeholder="请输入要查询的名称" class="layui-input"/>
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">地址：</label>
        <div class="layui-input-inline">
            <input type="text" id="address" placeholder="请输入要查询的地址" class="layui-input"/>
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">联系人：</label>
        <div class="layui-input-inline">
            <input type="text" id="contact" placeholder="请输入要查询的联系人" class="layui-input"/>
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">电话：</label>
        <div class="layui-input-inline">
            <input type="text" id="tele" placeholder="请输入要查询的电话" class="layui-input"/>
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">Email：</label>
        <div class="layui-input-inline">
            <input type="text" id="email" placeholder="请输入要查询的Email" class="layui-input"/>
        </div>
        &nbsp;<a href="javascript:void(0);" class="layui-btn" id="supplierQuery">查询</a>

    </div>

</div>

<div>
    <table class="layui-table" id="supplierTable" lay-filter="supplierTab">
    </table>
</div>
<script type="text/html" id="toolbarTop">
    <a class="layui-btn layui-btn-sm" href="javascript:add();" id="add"><i class="layui-icon"><font size="2">增加</font></i></a>
</script>
<script type="text/html" id="crud">
    <a class="layui-btn layui-btn-sm" lay-event="edit"><i class="layui-icon"></i></a>
    <a class="layui-btn layui-btn-normal layui-btn-sm" id="delButton" lay-event="del"><i class="layui-icon"></i></a>
</script>
<script type="text/html" id="addDiv">
    <form id="ff">
    <div>
        <div class="layui-inline" style="padding:20px;">
            <label class="layui-form-label">名称：</label>
            <div class="layui-input-inline">
                <input type="text" id="name1" placeholder="请输入要添加的名称" class="layui-input"/>
            </div>
        </div>
        <div class="layui-inline" style="padding:20px;">
            <label class="layui-form-label">地址：</label>
            <div class="layui-input-inline">
                <input type="text" id="address1" placeholder="请输入要添加的地址" class="layui-input"/>
            </div>
        </div>
        <div class="layui-inline" style="padding:20px;">
            <label class="layui-form-label">联系人：</label>
            <div class="layui-input-inline">
                <input type="text" id="contact1" placeholder="请输入要添加的联系人" class="layui-input"/>
            </div>
        </div>
        <div class="layui-inline" style="padding:20px;">
            <label class="layui-form-label">电话：</label>
            <div class="layui-input-inline">
                <input type="text" id="tele1" placeholder="请输入要添加的电话" class="layui-input"/>
            </div>
        </div>
        <div class="layui-inline" style="padding:20px;">
            <label class="layui-form-label">Email：</label>
            <div class="layui-input-inline">
                <input type="text" id="email1" placeholder="请输入要添加的Email" class="layui-input"/>
            </div>
        </div>
        <a style="margin-left: 43%;" href="javascript:void(0);" class="layui-btn" id="addButton">保存</a>


    </div>
    </form>
</script>
<script type="text/html" id="editDiv">
    <form id="ff1">
        <div>
            <div class="layui-inline" style="padding:20px;">
                <label class="layui-form-label">编号：</label>
                <div class="layui-input-inline">
                    <input type="text" id="uuid" style="width: 264px;" name="uuid" readonly class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline" style="padding:20px;">
                <label class="layui-form-label">名称：</label>
                <div class="layui-input-inline">
                    <input type="text" id="name2" placeholder="请输入要修改的名称" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline" style="padding:20px;">
                <label class="layui-form-label">地址：</label>
                <div class="layui-input-inline">
                    <input type="text" id="address2" placeholder="请输入要修改的地址" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline" style="padding:20px;">
                <label class="layui-form-label">联系人：</label>
                <div class="layui-input-inline">
                    <input type="text" id="contact2" placeholder="请输入要修改的联系人" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline" style="padding:20px;">
                <label class="layui-form-label">电话：</label>
                <div class="layui-input-inline">
                    <input type="text" id="tele2" placeholder="请输入要修改的电话" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline" style="padding:20px;">
                <label class="layui-form-label">Email：</label>
                <div class="layui-input-inline">
                    <input type="text" id="email2" placeholder="请输入要修改的Email" class="layui-input"/>
                </div>
            </div><br>
            <a style="margin-left: 43%;margin-top: 2%;" href="javascript:void(0);" class="layui-btn" id="editButton">保存</a>


        </div>
    </form>
</script>
</body>
</html>
