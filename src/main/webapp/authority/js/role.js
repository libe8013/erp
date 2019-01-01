var path;
var index;
layui.use(['table','layer','jquery'],function () {
    var table=layui.table;
    path = $('#path').val();
    intiTable(table);

    //弹出添加角色窗口
    /*添加*/
    table.on('tool(UserTable)',function () {
        add();
    })

    $(document).on('click','#addRole',function () {
        addRole();

    });
    /*查询*/
    $(document).on('click','#queryrole',function () {
        queRole(table);
    })

    $(document).on('click','#edit',function () {
        editRole();
    })


    layui.table.on('tool(StoreTypeTab)', function(obj){
        var data = obj.data;
        if(obj.event=="del"){
            delRole(data.id);
        }else if(obj.event=="edit"){
            updRole(data);
        }
    });
});


function intiTable(table) {
    table.render({
        elem:'#roleTab',
        height:450,
        id:'RoleTab',
        toolbar : '#toolbarTop',
        url : '',
        page:true,
        cols:[[
            {type:'checkbox',fixed:'left',width:'4%'},
            {field:'rolename', width:'43%', title: '角色名称',align:'center'},
            {field:'操作', width:'15%', title: '操作',align:'center',toolbar:'#crud',templet:function () {

                }},
        ]],
    })
}

function queRole() {
    var rolename = $('#rolename').val();
    var url=path+'/authorityrole/queryRole?1=1';
    if (null!=rolename && ''!=rolename){
        url+='&rolename='+rolename;
    }
    layui.table.reload('RoleTab',{
        url:url
    });
}

//弹出层
function add(){
    var addDiv = $('#addDiv').html();
    //弹出一个页面层
    index = layer.open({
        type: 1,
        area: ['450px', '150px'],
        shadeClose: true, //点击遮罩关闭
        content: addDiv,
        title : '新增角色名称'
    });
}
//添加角色方法
function addRole() {
    var rname = $('#rname').val();
    $.ajax({
        url: path+'/authorityrole/addRole',
        data:{rolename:rname},
        dataType:'json',
        type:'post',
        asyns:false,
        success:function (data) {
            layer.msg(data.message);
            layer.close(index);
            queRole();
        }
    });
}


function updRole(data) {
    var updrole = $('#upd').html();//根据id获取主体
    index = layer.open({
        type: 1,
        area: ['450px', '150px'],
        shadeClose: true, //点击遮罩关闭
        content: updrole,
        title:'修改角色'
    });
    $('#id').val(data.id);
    layui.form.val('editForm',data);
}

function editRole() {
    var rolename = $('#name').val();
    var id = $('#id').val();
    $.ajax({
        url: path+'/authorityrole/editRole',
        data:{id:id,rolename:rolename},//前端的id，接收的参数
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {//   这里面的data是后天穿过来的返回值
            layer.msg(data.message);
            layer.close(index);
            queRole();
        }
    });
}


/*删除*/
function delRole(id) {
    layer.confirm('确定执行删除操作嘛?', function(index){
        $.ajax({
            url : path+'/authorityrole/delrole',
            data : {id:id},
            dataType : 'json',
            type : 'post',
            async : false,
            success : function (data) {
                layer.close(index);
                layer.msg(data.message);
                queRole();
            },
            error:function(result) {
            }
        });
    });
}