layui.use(['table','layer','jquery'],function(){
    $ = layui.jquery;
    var table = layui.table;
    initTable(table);
    $(document).on('click','#queryLog',function () {
        queryStoreTab(table);
    })
});

function initTable(table) {
    table.render({
        elem:'#queryLogTab',
        height:312,
        id:'LogTypeTab',//区分表的id
        page:true,//开始分页
        cols:[[//表头数据
            {type:'checkbox',fixed:'left',width:'4%'},
            {field:'id', width:'15%', title: '编号',align:'center'},
            {field:'empid', width:'15%', title: '用户编号',align:'center'},
            {field:'ip', width:'15%', title: 'ip地址',align:'center'},
            {field:'moduleid', width:'15%', title: '模块编号',align:'center'},
            {field:'createDate', width:'15%', title: '日志时间',align:'center'},
            {field:'content', width:'15%', title: '日志内容',align:'center'},
        ]],
    });
}

function queryStoreTab() {
    var empid = $('#empid').val();
    var ip = $('#ip').val();
    var url='/erp/stock/queryLogPage?1=1';
    if(null!=empid && ''!=empid){
        url+='&empid='+empid;
    }
    if(null!=ip && ''!=ip){
        url+='&ip='+ip;
    }
    layui.table.reload('LogTypeTab',{
        url:url
    });
}