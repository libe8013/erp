<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/18/018
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>盘亏盘盈</title>
    <%@include file="/common/head.jsp"%>
    <script src="${ctx}/stock/js/registers.js"></script>
</head>
<body>
<input type="hidden" id="path" value="${ctx}"/>

<div>
    <div class="layui-inline">
        <label class="layui-form-label">登记日期：</label>
        <div class="layui-input-inline">
            <input type="text"  id="createtime" name="djbeg" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="text"  id="djend" name="djend" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">审核日期：</label>
            <div class="layui-input-inline">
                <input type="text"  id="shbeg" name="shbeg" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-input-inline">
                <input type="text"  id="shend" name="shend" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
    </div><br>
    <div class="layui-inline" style="padding-top: 10px;">
        <form class="layui-form" method="post">
            <div class="layui-form-item">
                <label class="layui-form-label">类型：</label>
                <div class="layui-input-block">
                    <input type="radio" name="type" checked="checked"  value="0" title="全部">
                    <input type="radio" name="type"  value="1" title="盘盈">
                    <input type="radio" name="type"  value="2" title="盘亏">
                </div>
            </div>
        </form>
    </div>
    <button class="layui-btn" id="queryInvrecord">查询</button>

</div>

    <div>
        <table class="layui-table" id="InverecordTab">
        </table>
    </div>
<script type="text/html" id="toolbarTop">
    <a class="layui-btn layui-btn-sm" href="javascript:add();" id="add"><i class="layui-icon"><font size="2">增加</font></i></a>
</script>
<%--添加界面--%>
<script type="text/html" id="addDiv">
    <div class="layui-form-item" style="padding:13px;">
        <form class="layui-form" method="post">
            <div class="layui-inline">
                <label class="layui-form-label">商品：</label>
                <div class="layui-input-inline">
                    <select name="goodsuuid" id="goodsuuid" lay-verify="goodsuuid" lay-filter="goodsuuid" lay-search="">
                        <option value="0">请选择您要查询的商品</option>
                    </select>
                </div>
            </div>

            <div class="layui-inline" style="margin-top: 6px;">
                <label class="layui-form-label">仓库：</label>
                <div class="layui-input-inline">
                    <select name="storeuuid" name="storeuuid" lay-verify="num" id="storeuuid" lay-verify="required" lay-search="">
                        <option value="0">请选择您要查询的仓库</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline" style="margin-top: 6px;">
                <label class="layui-form-label">数量：</label>
                <div class="layui-input-inline">
                    <input type="text" id="num" name="num" lay-verify="num" placeholder="请输入数量" class="layui-input"/>
                </div>
            </div>
            <div class="layui-form-item" style="margin-top: 6px;">
                <label class="layui-form-label">类型：</label>
                <div class="layui-input-block">
                    <input type="radio" name="type" checked="checked" value="0" title="盘盈">
                    <input type="radio" name="type"  value="1" title="盘亏">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">备注：</label>
                <div class="layui-input-inline">
                    <input type="text" id="remark" name="remark" placeholder="请输入备注" class="layui-input"/>
                </div>
            </div><br>
            <a style="margin-left: 42%;margin-top: 10px;" lay-submit lay-filter="addForm" class="layui-btn layui-btn-sm">保存</a>
        </form>
    </div>
</script>
</body>
</html>
