var path;
layui.use(['table','layer','jquery','form'],function () {
    layui.form.render();
    $ = layui.jquery;
    path = $('#path').val();
    var table = layui.table;
    intiTable(table);

    $(document).on('click','#queryInvrecord',function () {
        queryRegister();
    });
});

/*laydate.render({
    elem: '#test'
    ,format: '' //可任意组合
});*/


//初始化表格
function intiTable(table) {
    table.render({
        elem:'#InverecordTab',
        height:312,
        id:'InverecordTab',
        page:true,
        toolbar : '#toolbarTop',
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
            {field:'state', width:'10%', title: '状态',align:'center',},
            {field:'操作', width:'10%', title: '操作',align:'center',toolbar:'#crud'}
        ]],
    });
}

//遍历表格数据
function queryRegister() {
    // 登记时间
    // 审核时间
    //类型
    var type =  $('input[name="type"]:checked ').val()//获取选中的值
    if(type==1){
        type="盘盈";
    }else if(type==2){
        type="盘亏";
    }

    var url=path+'/stock/queryInventoryPager?1=1';
    if(null!=type && ''!=type && 0!=type){
        url+='&type='+type;
    }
    layui.table.reload("InverecordTab",{
        url:url
    });
}

//点击添加按钮弹出页面
function add() {
    var addDiv = $('#addDiv').html();
    //弹出一个页面
    layer.open({
        type:1,
        area: ['440px', '400px'],
        shadeClose: true, //点击遮罩关闭
        content: addDiv,
        title : '盘盈盘亏登记'
    });
}

/*
function addRegist() {
    var result = [];
    $.ajax({
        url:'',
        data:{},
        dataType:'json',
        type:'post',
        async:false,
        success : function (data) {
            result = data.data;
        }
    });
}*/
