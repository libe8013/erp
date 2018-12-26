var path;
layui.use(['table','layer','jquery','form','laydate'],function () {
    layui.form.render();
    $ = layui.jquery;
    path = $('#path').val();
    var table = layui.table;
    intiTable(table);

    $(document).on('click','#queryInvrecord',function () {
        queryRegister();
    });

    table.on('tool(InverecordEdit)',function (obj) {
        var data = obj.data;
        layer.confirm('确定执行修改操作嘛?', function(index){
            editRole(data.UUID,index);
        });
    })

});

//时间控件
function initdata() {
    layui.laydate.render({
        elem: '#createtime'
    });
    layui.laydate.render({
        elem: '#djend'
    });
    layui.laydate.render({
        elem: '#shbeg'
    });
    layui.laydate.render({
        elem: '#shend'
    });
}

function intiTable(table) {
    table.render({
        elem:'#InverecordTab',
        height:450,
        id:'InverecordTab',
        toolbar : '#toolbarTop',
        url : '',
        page:true,
        cols:[[
            {type:'checkbox',fixed:'left',width:'4%'},
            {field:'sname', width:'10%', title: '仓库',align:'center'},
            {field:'gname', width:'10%', title: '商品',align:'center'},
            {field:'stNum', width:'10%', title: '数量',align:'center'},
            {field:'type', width:'10%', title: '类型',align:'center'},
            {field:'createtime', width:'10%', title: '登录日期',align:'center'},
            {field:'checktime', width:'10%', title: '审核日期',align:'center'},
            {field:'ename', width:'10%', title: '登记人',align:'center'},
            {field:'ename', width:'10%', title: '审核人',align:'center'},
            {field:'state', width:'10%', title: '状态',align:'center'},
            {field:'操作', width:'10%', title: '操作',align:'center',toolbar:'#crud'}
        ]],
    })
}



//遍历表格数据
function queryRegister() {
    // 登记时间
    var djbeg = $('#createtime').val();
    var djend = $('#djend').val();
    // 审核时间
    var shbeg = $('#shbeg').val();
    var shend = $('#shend').val();
    //类型
    var type =  $('input[name="type"]:checked ').val()//获取选中的值
    if(type==1){
        type="盘盈";
    }else if(type==2){
        type="盘亏";
    }


    var url=path+'/stock/queryInvWtypePager?1=1';
    if(null!=type && ''!=type && 0!=type){
        url+='&type='+type;
    }
    layui.table.reload("InverecordTab",{
        url:url
    });
}



function editRole(uuid,index) {
    $.ajax({
        url: path+'/stock/updAudit',
        data:{uuid:uuid,state:'已审核'},//前端的id，接收的参数
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (message) {//   这里面的data是后天穿过来的返回值
            layui.layer.msg(message.message);
            layer.close(index);
            queryRegister();
        },
    });
}



