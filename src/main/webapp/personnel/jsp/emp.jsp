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

    <script src="/erp/personnel/js/emp.js"></script>



</head>

<body>
<input type="hidden" id="path" value="${ctx}"/>

<div>

    <div class="layui-inline" style="padding-top: 6px">
        <label class="layui-form-label">登录名：</label>
        <div class="layui-input-inline" style="font-size: 10px">
            <input type="text" id="username" name="username" placeholder="请输入您要查询的内容" class="layui-input"/>
        </div>
    </div>

    <div class="layui-inline" style="padding-top: 6px">
        <label class="layui-form-label">真实姓名：</label>
        <div class="layui-input-inline" style="font-size: 10px">
            <input type="text" id="name" name="name" placeholder="请输入您要查询的内容" class="layui-input"/>
        </div>
    </div>

    <div class="layui-inline" style="padding-top: 6px;" >
        <label class="layui-form-label">电话：</label>
        <div class="layui-input-inline" style="font-size: 10px">
            <input type="text" id="tele" name="tele" placeholder="请输入您要查询的内容" class="layui-input"/>
        </div>
    </div>

    <div class="layui-inline" style="padding-top: 6px">
        <label class="layui-form-label">地&nbsp; &nbsp;&nbsp; &nbsp;址：</label>
        <div class="layui-input-inline"  style="font-size: 10px">
            <input type="text" id="address" name="address" placeholder="请输入您要查询的内容" class="layui-input"/>
        </div>
    </div>


    <div class="layui-inline" style="padding-top: 6px">
        <label class="layui-form-label">email：</label>
        <div class="layui-input-inline" style="font-size: 10px">
            <input type="text" id="email" name="email" placeholder="请输入您要查询的内容" class="layui-input"/>
        </div>
    </div>

    <div class="layui-inline" style="padding-top: 15px ;font-size: 12px" >
        <label class="layui-form-label">出生年月日：</label>
        <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
            <input type="text" class="layui-input" id="birthday" name="birthday" >
        </div>
        截止日期：&nbsp;<div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
            <input type="text" class="layui-input" id="endtime" name="endtime">
        </div>
    </div>

    <div class="layui-inline">
        <form class="layui-form">
            <label class="layui-form-label">部&nbsp; &nbsp;门：</label>
            <div class="layui-input-inline">
                <select name="deptname" id="deptname" lay-verify="depuuid" lay-search="">

                    <option value="0">请选择您要查询的部门</option>
                </select>
            </div>
        </form>
     </div>



    <div class="layui-inline" style="padding-top: 6px">
        <label class="layui-form-label">性别：</label>
        <div class="layui-input-block" style="padding-top: 6px;font-size: 15px">
            <input type="radio" name="gender" value="男" title="男">男
            &nbsp; &nbsp;<input type="radio" name="gender" value="女" title="女" >女
            &nbsp; &nbsp;<input type="radio" name="gender" value="" title="全部" checked>全部
        </div>
    </div>

    <button style="margin-left:4%"  class="layui-btn" id="EmpQuery">查询</button>
</div>



<div>
    <table class="layui-table" id="empTable" lay-filter="empTab"></table>
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




   </div>

        <br>
        <div>
        <button style="margin-left: 43%;" href="javascript:void(0);" lay-submit class="layui-btn"  id="addForm">保存</button>
        </div>
    </form>
</script>
</body>
</html>
