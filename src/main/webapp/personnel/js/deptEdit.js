var path;
layui.use(['form','jquery','layer','table'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    deptverify();
    layui.form.on('submit(edit)',function (obj) {

        deptEdit();
    });

});


function  deptEdit(){

    var table = window.parent.layui.table;
    var result = table.cache.deptTable;

    var uuid = $('#uuid').val();
    var name = $('#name').val();
    var tele=$('#tele').val();



    for (var i = 0; i < result.length; i++) {
        if (result[i].name == name) {
            layer.msg('名称重复');
            return;
        }
    }

    $.ajax({
        url: path + '/dept/editDept',
        data: {uuid: uuid, name: name, tele: tele},
        dataType: 'json',
        type: 'post',
        async: false,
        success: function (data) {
            layer.msg(data.msg);
            window.parent.querydept();
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
        },
        error: function (result) {

        }

    });

}

function deptverify(){

    //自定义验证规则
    layui.form.verify({
        name: function(value){
            if(value.length < 1){
                return '名称不能为空';
            }
        }

        ,phone: function (value) {
            if(value.length < 1){
                return '电话不能为空';
            }
        }
        ,phone: [/^1[3|4|5|7|8]\d{9}$/, '手机必须11位，只能是数字！']
    });
}








