<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/25 0025
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
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

            <div class="layui-inline" style="padding-top: 15px;padding-left: 40px">
                <label class="layui-form-label">登录名：</label>
              <div class="layui-input-inline" style="font-size: 10px">
                <input type="text" id="username" name="username"  lay-verify="username" placeholder="请输入登录名" class="layui-input"/>
              </div>
            </div>

            <div class="layui-inline" style="padding-top: 6px;padding-left: 40px">
                <label class="layui-form-label">真实姓名：</label>
                <div class="layui-input-inline" style="font-size: 10px">
                    <input type="text" id="name" name="name" placeholder="请输入真实姓名" class="layui-input"/>
                </div>
            </div>

            <div class="layui-inline" style="padding-top: 6px;padding-left: 40px">
                <label class="layui-form-label">email：</label>
                <div class="layui-input-inline" style="font-size: 10px">
                    <input type="text" id="email" name="email" lay-verify="email"  placeholder="请输入email" class="layui-input"/>
                </div>
            </div>

            <div class="layui-inline" style="padding-top: 6px;padding-left: 40px" >
                <label class="layui-form-label">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：</label>
                <div class="layui-input-inline" style="font-size: 10px">
                    <input type="text" id="tele" name="tele" lay-verify="phone"  placeholder="请输入电话" class="layui-input"/>
                </div>
            </div>

            <div class="layui-inline" style="padding-top: 6px;padding-left: 40px">
                <label class="layui-form-label">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</label>
                <div class="layui-input-inline"  style="font-size: 10px">
                    <input type="text" id="address" name="address" placeholder="请输入地址" class="layui-input"/>
                </div>
            </div>

            <div class="layui-inline" style="padding-top: 6px;padding-left: 40px">
                <label class="layui-form-label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
                <div class="layui-input-block"  style="font-size: 10px">
                    <input type="radio" name="gender" value="男" title="男" checked>
                    &nbsp; &nbsp;<input type="radio" name="gender" value="女" title="女" >
                </div>
            </div>

           <div class="layui-inline" style="padding-top: 6px ;padding-left: 40px" >
               <label class="layui-form-label" >出生年月：</label>
              <div class="layui-inline" style="font-size: 10px"> <!-- 注意：这一层元素并不是必须的 -->
                <input type="text" class="layui-input" id="birthday" name="birthday" lay-verify="birthday">
              </div>
           </div>

            <div class="layui-inline" style="padding-top: 6px ;padding-left: 40px;font-size: 6px">
               <label class="layui-form-label">部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门：</label>
                <div class="layui-input-inline" >
                    <select name="deptname" id="deptname" lay-verify="depuuid" lay-search="" >

                    </select>
                </div>
            </div>



</div>
        <br>


        <button style="margin-left: 43%" type="button" lay-filter="addForm" lay-submit class="layui-btn"  id="addEmp" lay-verify="addEmp">保存</button>

</form>

</div>
<script src="${ctx}/personnel/js/addemp.js"></script>


</body>
</html>


