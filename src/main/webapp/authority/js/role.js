var path;
var index;
layui.use(['table','layer','jquery'],function () {
    var table=layui.table;
    path = $('#path').val();
    intiTable(table);

    // table.on('tool(UserTable)',function (row) {
    //     var data = row.data;
    //     resetPwd(data);
    // })

    $(document).on('click','#queryrole',function () {
        queRole(table);
    })

});


function intiTable(table) {
    table.render({
        elem:'#roleTab',
        height:312,
        id:'RoleTab',
        url : '',
        page:true,
        cols:[[
            {type:'checkbox',fixed:'left',width:'4%'},
            {field:'rolename', width:'43%', title: '角色名称',align:'center'},
            {field:'', width:'43%', title: '操作',align:'center',templet:function (obj) {
                    return '<a class="layui-btn layui-btn-sm" lay-event="" href="javascript:void(0)">修改角色信息</a>'
                }},
        ]]
    })
}

function queRole(table) {
    var url=path+'/authorityrole/queryRole?1=1';
    table.reload('RoleTab',{
        url:url
    });
}