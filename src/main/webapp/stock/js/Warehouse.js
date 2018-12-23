layui.use(['table','layer','jquery'],function(){
   $ = layui.jquery;
   var table = layui.table;
   initTable(table);
   $(document).on('click','#queryStoreLikePage',function () {
       queryStoreTab(table);
   })
});

function initTable(table) {
    table.render({
        elem:'#queryStoreTypeTab',
        height:312,
        id:'StoreTypeTab',//区分表的id
        page:true,//开始分页
        cols:[[//表头数据
            {type:'checkbox',fixed:'left',width:'4%'},
            {field:'sname', width:'33%', title: '仓库名称',align:'center'},
            {field:'gname', width:'33%', title: '商品',align:'center'},
            {field:'num', width:'33%', title: '数量',align:'center'},
        ]],
    });
}

function queryStoreTab() {
    var gname = $('#gname').val();
    var sname = $('#sname').val();
    var url='/erp/stock/queryStoreLikePage?1=1';
    if(null!=gname && ''!=gname){
        url+='&gname='+gname;
    }
    if(null!=sname && ''!=sname){
        url+='&sname='+sname;
    }
    layui.table.reload('StoreTypeTab',{
        url:url
    });
}