

//layui 模块化引用
layui.use(['jquery', 'table', 'layer'], function(){
    var $ = layui.$, table = layui.table, form = layui.form, layer = layui.layer;

    //数据表格实例化
    var tableIns = table.render({
        elem: '#orderTable',
        toolbar : '#toolbarTop',
        data:[],
        page: true,
        id : 'orderTable',
        loading: true,
        even: false, //不开启隔行背景
        cols: [[
            {type:'checkbox',width:'4%'},
            {field:'uuid', width:'10%', title: '编号',align:'center'},
            {field:'createtime', width:'10%', title: '录入日期',align:'center'},
            {filed:'starttime',width:'10%',title:'出库日期',align:'center'},
            {field:'starter', width:'10%', title: '销售员',align:'center'},
            {filed:'ender',width:'10%',title:'库管员',align:'center'},
            {filed:'name',width:'10%',title:'客户',align:'center'},
            {filed:'totalmoney',width:'10%',title:'总金额',align:'center'},
            {filed:'state',width:'10%',title:'订单状态',align:'center'},
            {field:'操作', width:'16%', title: '操作',align:'center',toolbar: '#crud'}
        ]]

    });
    /*查询*/
    $('#queryOrder').on('click', function(){
        alert(1);

        table.reload('orderTable', {
            url: 'orders/queryOrdersPage'
        });
    });

});

/*
var path;
layui.use(['table','form','layer','jquery'],function () {
    $ = layui.jquery;
    var table=layui.table;
   var  path = $('#path').val();
    initTable(table);
    $(document).on('click','#queryOrder',function () {
        queryOrders(table);
    });
})

function initTable(table){
    table.render({
        elem : '#orderTable',
        height: 600,
        toolbar : '#toolbarTop',
        data: [], //数据接口
        page: true, //开启分页
        cols: [[ //表头
            {type:'checkbox',width:'4%'},
            {field:'uuid', width:'10%', title: '编号',align:'center'},
            {field:'createtime', width:'10%', title: '录入日期',align:'center'},
            {filed:'starttime',width:'10%',title:'出库日期',align:'center'},
            {field:'starter', width:'10%', title: '销售员',align:'center'},
            {filed:'ender',width:'10%',title:'库管员',align:'center'},
            {filed:'name',width:'10%',title:'客户',align:'center'},
            {filed:'totalmoney',width:'10%',title:'总金额',align:'center'},
            {filed:'state',width:'10%',title:'订单状态',align:'center'},
            {field:'操作', width:'16%', title: '操作',align:'center',toolbar: '#crud'}
        ]],
    });

}



function queryOrders(table){
  //  var name=$( '#empname option:selected').val();
    var url = path+'/orders/queryOrdersPage?1=1';
  //  if(null!=name && ''!=name){
    //    url+='&name='+name; //给对象属性赋值，引号中的属性必须与实体属性一致
   // }
    table.reload("orderTable", { //此处是上文提到的 初始化标识id
        url: url
    });
}
*/
