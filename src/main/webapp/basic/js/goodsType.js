layui.use(['table','form'],function () {
    initTable();
    queryGoodsType();
});

function initTable(){
    var table = layui.table;
    table.render({
        elem : '#goodsTypeTab',
        height: 312,
        url: '/erp/goodsType/queryGoodsTypePager', //数据接口
        page: false, //开启分页
        cols: [[ //表头
            {type:'checkbox'},
            {field:'uuid', width:280, title: 'ID',align:'center'},
            {field:'name', width:240, title: '类型名称',align:'center'},
            {field:'操作', width:1000, title: '操作',align:'center'}
    ]],
    });
}

function queryGoodsType() {
    var table = $('#goodsTypeTab');
    console.log(table.option);
}