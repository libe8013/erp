<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@include file="/common/ctx.jsp"%>

<%@include file="/common/base.jsp"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<!-- 项目开发阶段不需要缓存处理，但在实际项目上线使用后是需要缓存的，所以到时候注释掉下面代码即可 -->
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<link rel="stylesheet" href="${ctx}/base/js/layui/css/layui.css">
<link rel="stylesheet" href="${ctx}/common/base.css">
<script src="${ctx}/base/js/common/jquery.min.js"></script>
<script src="${ctx}/base/js/layui/layui.js"></script>
<input type="hidden" id="path" value="${ctx}"/>