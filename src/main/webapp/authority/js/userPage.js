var path;
var index;
layui.use(['table','layer','jquery'],function () {
    var table=layui.table;
    path = $('#path').val();
    intiTable(table);
    queUser(table);

    //弹出层
    table.on('tool(UserTable)',function (row) {
        var data = row.data;
        resetPwd(data);
    })

    $(document).on('click','#PwdBnt',function () {
        updPWD();
    })

    $(document).on('click','#login',function () {
        Login();
    })
});


//初始化表格
function intiTable(table) {
    table.render({
        elem:'#queryUser',
        height:312,
        id:'recordsTable',
        url : '',
        page:true,
        cols:[[
            {type:'checkbox',fixed:'left',width:'4%'},
            {field:'USERNAME', width:'11%', title: '登录名',align:'center'},
            {field:'NAME', width:'11%', title: '真实姓名',align:'center'},
            {field:'GENDER', width:'11%', title: '性别',align:'center'},
            {field:'EMAIL', width:'11%', title: 'Email',align:'center'},
            {field:'TELE', width:'11%', title: '电话',align:'center'},
            {field:'ADDRESS', width:'11%', title: '地址',align:'center'},
            {field:'BIRTHDAY', width:'11%', title: '出生年月日',align:'center'},
            {field:'dname', width:'11%', title: '部门',align:'center'},
            {field:'', width:'11%', title: '操作',align:'center',templet:function (obj) {
                    return '<a class="layui-btn layui-btn-sm" lay-event="" href="javascript:void(0)">重置密码</a>'
                }},
        ]]
    })
}

/**
 * 查询用户信息
 * @param table
 */
function queUser(table) {
    var url=path+'/authorityemp/queryEmpRole';
    table.reload('recordsTable',{
        url:url
    });
}

//显示修改密码界面
function resetPwd(data){
    var upd = $('#updPwd').html();
    index = layer.open({
        type: 1,
        area: ['450px', '150px'],
        shadeClose: true, //点击遮罩关闭
        content: upd,
        title:'修改密码'
    });
    $('#uuid').val(data.UUID);
}

function updPWD() {
    var pwd = $('#pwd').val();
    var uuid = $('#uuid').val();
    $.ajax({
        url: path+'/emp/updPwd',
        data:{uuid:uuid,pwd:pwd},//前端的id，接收的参数
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {//   这里面的data是后台穿过来的返回值
            layer.msg(data.message);
            layer.close(index);
        }
    });
}


/**
 * 登陆方法
 * @constructor
 */
function Login() {
    var username = $('#signup_name').val();
    var pwd = $('#signup_password').val();
    $.ajax({
        url: path+'/emp/Login',
        data:{username:username,pwd:pwd},//前端的id，接收的参数
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {//   这里面的data是后天穿过来的返回值
            if(data.success){
                location.href="index.jsp"
            }else {
                layer.msg(data.message);
                return;
            }
        }
    });
}