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
</head>
<body>
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
            <select name="goodstypeuuid2" id="gtypeuuid" lay-verify="" lay-search="">
                <option value="0">请选择您要查询的类型</option>
            </select>
        </div>
        <a href="javascript:void(0);" class="layui-btn" id="goodsQuery">查询</a>
        </form>
    </div>
</div>

<div>
    <table class="layui-table" id="goodsTable" lay-filter="goodsTab">
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
    <form class="layui-form" id="ff" autocomplete="off">
    <div>
        <div class="layui-inline" style="padding:20px;">
            <label class="layui-form-label">商品名称：</label>
            <div class="layui-input-inline">
                <input type="text" id="name1" lay-verify="goodsName" name="name" placeholder="请输入商品名称" class="layui-input"/>
            </div>
        </div>
        <div class="layui-inline" style="padding-left: 40px">
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
        <div class="layui-inline" style="padding-left: 40px">
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
        <div class="layui-inline" style="padding-left: 40px">
            <label class="layui-form-label">销售价格：</label>
            <div class="layui-input-inline">
                <input type="text" id="outprice" lay-verify="outprice" name="outprice"  placeholder="请输入销售价格" class="layui-input"/>
            </div>
        </div>

        <div class="layui-inline" style="padding: 20px;">
                <label class="layui-form-label">商品类型：</label>
                <div class="layui-input-inline">
                    <select name="goodstypeuuid" lay-verify="goodstypeuuid" id="goodstypeuuid1" lay-verify="required" lay-search="">
                        <option value="0">请选择商品类型</option>
                    </select>
                </div>
        </div>
        <div class="layui-inline" style="padding-button: 20px;">
            <label class="layui-form-label">供应商：</label>
            <div class="layui-input-inline">
                <select name="supplieruuid" lay-verify="supplier" id="supplier" lay-verify="required" lay-search="">
                    <option value="0">请选择供应商</option>
                </select>
            </div>
        </div><br>
        <button style="margin-left: 43%" href="javascript:void(0);" lay-submit class="layui-btn"  id="addForm">保存</button>
    </div>
    </form>
</script>
<script type="text/html" id="editDiv">
    <div>
        <form id="ff1" lay-filter="goodsEdit" class="layui-form" method="post" autocomplete="off">
            <div>
                <%--<div class="layui-inline" style="padding-top: 15px;padding-left: 20px;">--%>
                    <%--<label class="layui-form-label">商品编号：</label>--%>
                    <%--<div class="layui-input-inline">--%>
                        <%--<input type="text" id="uuid" name="uuid" readonly style="width: 265px;" class="layui-input"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <div class="layui-inline" style="padding:20px;">
                    <label class="layui-form-label">商品名称：</label>
                    <div class="layui-input-inline">
                        <input type="text" id="name2" lay-verify="goodsName" name="name" placeholder="请输入商品名称" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-inline" style="padding-left: 40px">
                    <label class="layui-form-label">商品产地：</label>
                    <div class="layui-input-inline">
                        <input type="text" id="origin2" name="origin" placeholder="请输入商品产地" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-inline" style="padding:20px;">
                    <label class="layui-form-label">商品厂家：</label>
                    <div class="layui-input-inline">
                        <input type="text" id="PRODUCER2" name="PRODUCER" placeholder="请输入商品厂家" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-inline" style="padding-left: 40px">
                    <label class="layui-form-label">计量单位：</label>
                    <div class="layui-input-inline">
                        <input type="text" id="unit2" name="unit" lay-verify="unit" placeholder="请输入商品单位" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-inline" style="padding:20px;">
                    <label class="layui-form-label">进货价格：</label>
                    <div class="layui-input-inline">
                        <input type="text" id="inprice2" lay-verify="inprice" name="inprice" placeholder="请输入进货价格" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-inline" style="padding-left: 40px">
                    <label class="layui-form-label">销售价格：</label>
                    <div class="layui-input-inline">
                        <input type="text" id="outprice2" lay-verify="outprice" name="outprice"  placeholder="请输入销售价格" class="layui-input"/>
                    </div>
                </div>

                <div class="layui-inline" style="padding:20px;">
                    <label class="layui-form-label">商品类型：</label>
                    <div class="layui-input-inline">
                        <select name="goodstypeuuid" lay-verify="goodstypeuuid" id="goodstypeuuid2" lay-verify="required" lay-search="">
                        </select>
                    </div>
                </div>
                <div class="layui-inline" style="padding-button: 20px;">
                    <label class="layui-form-label">供应商：</label>
                    <div class="layui-input-inline">
                        <select name="supplieruuid" id="supplieruuid" lay-verify="supplier" lay-verify="required" lay-search="">
                            <option value="0">请选择供应商</option>
                        </select>
                    </div>
                </div><br>
                <button lay-filter="edit" style="margin-left: 43%" lay-submit class="layui-btn"  id="editGoods">保存</button>
            </div><br><br>
        </form>
    </div>
</script>
</body>
</html>
