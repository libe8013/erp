<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2019/01/02
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head.jsp"%>
</head>
<body>
<form class="layui-form" action="">
    <input type="hidden" id="uuid" name="uuid"/>
    <div style="padding-top: 20px;">
    <div class="layui-inline">
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="text" id="email" readonly name="email" lay-verify="email" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-inline">
        <div class="layui-form-item">
            <label class="layui-form-label">输入框</label>
            <div class="layui-input-inline">
                <input type="text" id="title" name="title" lay-verify="title" value="库存预警" placeholder="请输入标题" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">文本域</label>
        <div class="layui-input-block">
            <textarea name="context" id="context" placeholder="请输入内容" lay-verify="content" class="layui-textarea">有商品库存小于待发货数量,请及时补货</textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="button" class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="button" id="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
    </div>

</form>
<script>
    var path;
    var index;
    layui.use(['jquery','form','layer','table'],function () {
        $ = layui.jquery;
        path = $('#path').val();
        var form = layui.form;
        var layer = layui.layer;
        custom_rule();
        $('#reset').click(function () {
            $('#context').val('');
            $('#title').val('');
        });
        form.on('submit(formDemo)',function (data) {
            var data = data.field;
            $.ajax({
                url : path+'/email/sendEmail',
                data : data,
                dataType : 'json',
                type : 'post',
                async : false,
                success : function (obj) {
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index);
                    parent.layer.msg(obj.message, { icon: 1 }); //提示
                    // parent.queryGoodsType();
                }
            });
            return false;
        });
    });

    function custom_rule(){
        //自定义验证规则
        layui.form.verify({
            title: function(value){
                if(value.length < 1){
                    return '请输入标题';
                }
            }
            ,content: function (value) {
                if(value.length < 1){
                    return '内容不能为空';
                }
            }
        });
    }


</script>
</body>
</html>
