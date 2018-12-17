layui.use(['table','form','layer','jquery'],function () {
    $ = layui.jquery;
    var table = layui.table;
    initTable(table);
    queryGoodsType(table);
    $(document).on('click','#goodsTypeQuery',function () {
        queryGoodsType(table);
    })
});

function initTable(table){
    var name = $('#name').val();
    if(name!=null && ''!=name){
        var render = table.render({
            elem : '#goodsTypeTab',
            height: 312,
            toolbar : '#toolbarTop',
            id : 'goodsType',
            url: '', //数据接口
            page: true, //开启分页
            cols: [[ //表头
                {type:'checkbox', fixed: 'left',width:'4%'},
                {field:'uuid', width:'23%', title: 'ID',align:'center'},
                {field:'name', width:'23%', title: '类型名称',align:'center'},
                {field:'操作', width:'50%', title: '操作',align:'center',toolbar: '#crud'}
            ]],
        });
    }

}

function queryGoodsType(table) {
    table.reload("goodsType", { //此处是上文提到的 初始化标识id
        where: {
            //key: { //该写法上文已经提到
            url: '/erp/goodsType/queryGoodsTypePager'
            //}
        }
    });
    var render = table.render({});
    console.log(render);
}