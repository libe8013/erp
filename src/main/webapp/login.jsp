﻿<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/head.jsp"%>

<link rel="stylesheet" type="text/css" href="css/login.css"/>

<script>
//登陆
function login(){	
	var formdata=$('#loginform').serializeJSON();	
	$.ajax({
		url:'',
		dataType:'json',
		type:'post',
		data:formdata,
		success:function(value){
			
			if(value.success){//如果成功
				location.href="index.html";//跳转到主界面 
			}else
			{
				$.messager.alert('提示信息',value.message);
			}			
		}		
	});	
}


</script>

</head>
<body>
<div class='signup_container'>
<div class="w-load"><div class="spin"></div></div>
    <h1 class='signup_title'>蓝云ERP管理系统 旗舰版</h1>
    <div id="userInfo">
    	<span style="float:left; margin-left:40px; height:200px; border:0px solid red"><img src='images/erp.jpg' id='admin'/></span>
        <span style="float:left; margin-left:40px; height:200px; border:0px solid red">
            <div id="signup_forms" class="signup_forms clearfix">
                        <form class="signup_form_form" id="loginform" method="post" >
                                <div class="form_row first_row">
                                    <label for="signup_email">请输入用户名</label>
                                    <input type="text" name="username" placeholder="请输入用户名" id="signup_name" >
                                </div>
                                <div class="form_row">
                                    <label for="signup_password">请输入密码</label>
                                    <input type="password" name="pwd" placeholder="请输入密码" id="signup_password" >
                                </div>
                       </form>
            </div> 
            <div id="foo"></div>
                	<br/>      
        </span>
    </div>
    
    

    <div class="login-btn-set"><div class='rem'>记住我</div> <a href='javascript:login()' class='login-btn'></a></div>
</div>

</body>



</html>