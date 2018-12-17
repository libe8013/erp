layui.use(['table','form','layer','jquery'],function () {
    $ = layui.jquery;
    var table = layui.table;
    initTable(table);
    $(document).on('click','#goodsTypeQuery',function () {
        queryGoodsType(table);
    })
});

function initTable(table){
        table.render({
            elem : '#goodsTypeTab',
            height: 312,
            toolbar : '#toolbarTop',
            id : 'goodsTypeTable',
            // url: '', //数据接口
            page: true, //开启分页
            cols: [[ //表头
                {type:'checkbox', fixed: 'left',width:'4%'},
                {field:'uuid', width:'23%', title: 'ID',align:'center'},
                {field:'name', width:'23%', title: '类型名称',align:'center'},
                {field:'操作', width:'50%', title: '操作',align:'center',toolbar: '#crud'}
            ]],
        });

}

function queryGoodsType(table) {
    var name = $('#name').val();
    var url = '/erp/goodsType/queryGoodsTypePager';
    if(null!=name && ''!=name){
        url+='?name='+name;
    }
    table.reload("goodsTypeTable", { //此处是上文提到的 初始化标识id
        url: url
    });
}