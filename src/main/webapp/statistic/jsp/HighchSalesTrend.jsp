<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/2 0002
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <script src="/erp/base/js/common/code/highcharts.js"></script>
    <script src="/erp/statistic/js/HighchSalesTrend.js"></script>
</head>
<body>

<div>

    <div class="layui-inline" style="padding-top: 8px ;font-size: 12px" >
        <label class="layui-form-label">年份：</label>
        <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
            <input type="text" class="layui-input" id="endtime" name="endtime" >
        </div>


    </div>

    <button style="margin-left:4%"  class="layui-btn" id="querySalesStat">查询</button>
    <a id="btn_ICR" href="javascript:void(0)" class="layui-btn" data-options="iconCls:'icon-reload'">切换</a>

</div>
<div>
    <div id="container" style="min-width:400px;height:400px;padding-top: 10px"></div>
</div>
</body>
</html>
