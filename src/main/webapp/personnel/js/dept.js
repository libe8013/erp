var path;
layui.use(['jquery','form','layer','table'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    initTable();
    deptverify();
    $(document).on('click','#deptQuery',function () {
        querydept();
    });
    $(document).on('submit','#ff',function () {
       addForm();
       return false;
    });
   layui.table.on('tool(deptTab)',function (obj) {
        var data = obj.data;
        if(obj.event=="del"){
            del(data.uuid);
        }else if(obj.event=="edit"){
            edit(data);

        }
    });
});












function initTable(){
    var table = layui.table;
    table.render({
        elem : '#deptTable',
        id : 'deptTable',
        toolbar : '#toolbarTop',
        height: 600,
        data : [],
        page: true, //开启分页
        cols: [[ //表头
            {type:'checkbox',width:'2%'},
            // {field:'uuid', width:'18%', title: '编号',align:'center'},
            {field:'name', width:'18%', title: '名称',align:'center'},
            {field:'tele', width:'18%', title: '电话',align:'center'},

            {field:'操作', width:'15%', title: '操作',align:'center',toolbar:'#crud'}
        ]],
    });
}

function querydept() {
    var name = $('#name').val();
    var tele = $('#tele').val();
    var url = path+'/dept/queryDeptList?1=1';
    if(null!=name && ''!=name){
        url+='&name='+name;
    }
    if(null!=tele && ''!=tele){
        url+='&tele='+tele;
    }
    layui.table.reload("deptTable", { //此处是上文提到的 初始化标识id
        url: url
    });

}

function add(){
    var addDiv = $('#addDiv').html();
    //弹出一个页面层
    layer.open({
        skin : 'layer-ext-Select',
        type: 1,
        area: ['440px', '220px'],
        shadeClose: true, //点击遮罩关闭
        content: addDiv,
        title : '新增部门'
    });
}

function addForm() {
    var result = [];
    $.ajax({
        url: path + '/dept/queryDeptList',
        data: {},
        dataType: 'json',
        type: 'post',
        async: false,
        success: function (data) {
            result = data.data;
        }
    });
    var name = $('#name1').val();
    var tele = $('#tele1').val();


    for (var i = 0; i < result.length; i++) {
        if (result[i].name == name) {
            layer.msg('部门名称重复');
            return;
        }
    }



    $.ajax({
        url: path + '/dept/addDept',
        data: {name: name, tele: tele},
        dataType: 'json',
        type: 'post',
        async: false,
        success: function (data) {
            layer.msg("新增部门成功");
            querydept();
            $('#ff')[0].reset();
        },
    });
    return false;
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

function del(uuid) {

    layer.confirm('确定删除该选项?', function(index){
        $.ajax({
            url : path+'/dept/delDept',
            data : {uuid:uuid},
            dataType : 'json',
            type : 'post',
            async : false,
            success : function (data) {
                layer.close(index);
                layer.msg("删除成功");
                querydept();
            },
            error:function(result) {

            }
        });
    });
}





function edit(obj){

    //弹出一个iframe层
    layer.open({
        type: 2,
        title: '编辑部门信息',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area : ['440px' , '300px'],
        content: path+'/personnel/jsp/deptEdit.jsp',
        success : function (layero,index) {
            var body = layer.getChildFrame('body',index);
            var inputBody = body.find('input');
            $.each(obj, function(j) {
                for (var i=0;i<inputBody.length;i++){
                    if(inputBody[i].id==j){
                        $(inputBody[i]).val(obj[j]);
                    }
                }
            });
        }
    });
}





