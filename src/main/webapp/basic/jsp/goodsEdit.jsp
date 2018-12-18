<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<input id="path" value="${ctx}" type="hidden"/>
<div>
    <form id="ff1" class="layui-form" method="post" autocomplete="off">
        <div>
            <div class="layui-inline" style="padding-top: 15px;padding-left: 20px;">
                <label class="layui-form-label">商品编号：</label>
                <div class="layui-input-inline">
                    <input type="text" id="uuid" name="uuid" readonly style="width: 265px;" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline" style="padding:20px;">
                <label class="layui-form-label">商品名称：</label>
                <div class="layui-input-inline">
                    <input type="text" id="name" lay-verify="goodsName" name="name" placeholder="请输入商品名称" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">商品产地：</label>
                <div class="layui-input-inline">
                    <input type="text" id="origin" name="origin" placeholder="请输入商品产地" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline" style="padding:20px;">
                <label class="layui-form-label">商品厂家：</label>
                <div class="layui-input-inline">
                    <input type="text" id="PRODUCER" name="PRODUCER" placeholder="请输入商品厂家" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">计量单位：</label>
                <div class="layui-input-inline">
                    <input type="text" id="unit" name="unit" lay-verify="unit" placeholder="请输入商品单位" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline" style="padding:20px;">
                <label class="layui-form-label">进货价格：</label>
                <div class="layui-input-inline">
                    <input type="text" id="inprice" lay-verify="inprice" name="inprice" placeholder="请输入进货价格" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">销售价格：</label>
                <div class="layui-input-inline">
                    <input type="text" id="outprice" lay-verify="outprice" name="outprice"  placeholder="请输入销售价格" class="layui-input"/>
                </div>
            </div>

            <div class="layui-inline" style="padding:20px;">
                <label class="layui-form-label">商品类型：</label>
                <div class="layui-input-inline">
                    <select name="goodstypeuuid" lay-verify="goodstypeuuid" id="goodstypeuuid1" lay-verify="required" lay-search="">
                        <option value="0">请选择商品类型</option>
                    </select>
                </div>
            </div><br>
            <button style="margin-left: 43%" href="javascript:void(0);" lay-submit class="layui-btn"  id="editGoods">保存</button>
        </div><br><br>
    </form>
</div>
<script src="${ctx}/basic/js/goodsEdit.js"></script>
</body>