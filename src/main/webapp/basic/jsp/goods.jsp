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
    <script src="${ctx}/basic/js/goods.js"></script>
    <style>
        .layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
            top: 50%;
            transform: translateY(-50%);
        }
    </style>
</head>
<body>
<input type="hidden" id="path" value="${ctx}"/>
<div>
    <div class="layui-inline">
        <label class="layui-form-label">商品名称：</label>
        <div class="layui-input-inline">
                <input type="text" id="name" name="name" placeholder="请输入您要查询的名称" class="layui-input"/>
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">商品产地：</label>
        <div class="layui-input-inline">
            <input type="text" id="origin" name="origin" placeholder="请输入您要查询的产地" class="layui-input"/>
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">商品厂家：</label>
        <div class="layui-input-inline">
            <input type="text" id="PRODUCER" name="PRODUCER" placeholder="请输入您要查询的厂家" class="layui-input"/>
        </div>
    </div>

    <div class="layui-inline">
        <form class="layui-form" action="">
        <label class="layui-form-label">商品类型：</label>
        <div class="layui-input-inline">
            <select name="goodstypeuuid" id="goodstypeuuid" lay-verify="required" lay-search="">
                <option value="0">请选择您要查询的类型</option>
            </select>
        </div>
        <a href="javascript:void(0);" class="layui-btn" id="goodsQuery">查询</a>
        </form>
    </div>
</div>

<div>
    <table class="layui-table" id="goodsTable" lay-filter="goodsTypeTab">
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
    <div>
        <div class="layui-inline" style="padding:20px;">
            <label class="layui-form-label">商品名称：</label>
            <div class="layui-input-inline">
                <input type="text" id="name1" name="name" placeholder="请输入商品名称" class="layui-input"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">商品产地：</label>
            <div class="layui-input-inline">
                <input type="text" id="origin1" name="origin" placeholder="请输入商品产地" class="layui-input"/>
            </div>
        </div>
        <div class="layui-inline" style="padding:20px;">
            <label class="layui-form-label">商品厂家：</label>
            <div class="layui-input-inline">
                <input type="text" id="PRODUCER1" name="PRODUCER" placeholder="请输入商品厂家" class="layui-input"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">计量单位：</label>
            <div class="layui-input-inline">
                <input type="text" id="unit" name="unit" placeholder="请输入商品单位" class="layui-input"/>
            </div>
        </div>
        <div class="layui-inline" style="padding:20px;">
            <label class="layui-form-label">进货价格：</label>
            <div class="layui-input-inline">
                <input type="text" id="inprice" name="inprice" placeholder="请输入进货价格" class="layui-input"/>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">销售价格：</label>
            <div class="layui-input-inline">
                <input type="text" id="outprice" name="outprice" placeholder="请输入销售价格" class="layui-input"/>
            </div>
        </div>

        <div class="layui-inline" style="padding:20px;">
            <form class="layui-form" action="">
                <label class="layui-form-label">商品类型：</label>
                <div class="layui-input-inline">
                    <select name="goodstypeuuid" id="goodstypeuuid1" lay-verify="required" lay-search="">
                        <option value="0">请选择您要查询的类型</option>
                    </select>
                </div>
            </form>
        </div><br>
        <a style="margin-left: 43%" href="javascript:void(0);" class="layui-btn" id="addForm">保存</a>
    </div>
</script>
</body>
</html>
