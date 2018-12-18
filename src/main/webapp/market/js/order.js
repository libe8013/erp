var path;
layui.use(['jquery','form','layer','table'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    initTable();
    $(document).on('click','#queryOrder',function () {
        queryGoodsType();
    });
});

function initTable(){
    var table = layui.table;
    table.render({
        elem : '#orderTable',
        id : 'orderTable',
        toolbar : '#toolbarTop',
        height: 600,
        data : [],
        page: true, //开启分页
        cols: [[ //表头
            {type:'checkbox',width:'2%'},
            {field:'uuid', width:'18%', title: 'ID',align:'center'},
            {field:'createtime', width:'10%', title: '商品名称',align:'center'},
            {field:'starttime', width:'8%', title: '产地',align:'center'},
            {field:'starter', width:'13%', title: '厂家',align:'center'},
            {field:'ender', width:'8%', title: '计量单位',align:'center'},
            {field:'name', width:'8%', title: '进货价格',align:'center'},
            {field:'totalmoney', width:'8%', title: '销售价格',align:'center'},
            {field:'state', width:'10%', title: '商品类型',align:'center'},
            {field:'操作', width:'15%', title: '操作',align:'center'}
        ]],
    });
}

function queryGoodsType() {
    var url = path+'/orders/queryOrdersPage?1=1';
    layui.table.reload("orderTable", { //此处是上文提到的 初始化标识id
        url: url
    });
}