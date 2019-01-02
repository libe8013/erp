var path;
layui.use(['form','jquery','layer','laydate','table'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    initDate();
    initSelect();
    empverify();
    layui.form.on('submit(empEdit)',function (obj) {
        empEdit();
    });

});


function empEdit(){

    var table = window.parent.layui.table;
    var result = table.cache.empTable;

    var uuid = $('#uuid').val();
    var username = $('#username').val();
    var name = $('#name').val();
    var email=$('#email').val();
    var tele = $('#tele').val();
    var address=$('#address').val();
    var gender=$('input[name="gender"]:checked').val();
    var birthday = $('#birthday').val();
    var depuuid = $('#deptname option:selected').val();


    for (var i = 0; i < result.length; i++) {
        if (result[i].username == username) {
            layer.msg('登录名重复');
            return;
        }
    }

    $.ajax({
            url: path + '/emp/editEmp',
            data: {uuid: uuid, username:username,name: name, email:email,tele: tele,address:address,gender:gender,birthday:birthday,depuuid:depuuid},
            dataType: 'json',
            type: 'post',
            async: false,
            success: function (data) {
                layer.msg(data.msg);
                window.parent.queryEmp();
                var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                parent.layer.close(index);
            },
            error: function (result) {

            }

        });

}

function empverify(){
    //自定义验证规则
    layui.form.verify({
        username: function(value){
            if(value.length < 1){
                return '登录名不能为空';
            }
        }

        ,email: function (value) {
            if(value.length < 1){
                return 'email不能为空';
            }
        }

        ,phone: function (value) {
            if(value.length < 1){
                return '电话不能为空';
            }
        }

        ,birthday: function (value) {
            if(value.length < 1){
                return '生日不能为空';
            }
        }

        ,depuuid: function (value) {
            if(value.length < 1){
                return '部门不能为空';
            }
        }
        ,email: [/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/, "邮箱格式不正确"]

        ,phone: [/^1[3|4|5|7|8]\d{9}$/, '手机必须11位，只能是数字！']
    });
}




function initDate() {
    var laydate=layui.laydate;
    laydate.render({
        elem:'#birthday'
    });
}

//获取下拉框部门名称

function initSelect(){

    var form = layui.form;

    $.get(path + '/emp/queryDeptList',{}, function (data) {
        var deptname = "";  //定义要查询的内容
        if (data.data != null) {
            $.each(data.data, function (index, item) {
                //  console.log(item);
                if (item.uuid){
                    deptname += "<option  value='" + item.uuid + "'>" + item.name + "</option>";
                }else{
                    deptname += "<option value='" + item.uuid + "'>" + item.name + "</option>";
                }
            });
            $("select[name='deptname']").append(deptname);

            //append后必须从新渲染
            form.render('select');
        }
    });
}

