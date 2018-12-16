layui.use(['table','form'],function () {
    var table = layui.table;
    initTable(table);
    queryGoodsType(table);
});

function initTable(table){
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

function queryGoodsType(table) {
    var tableObject = table.render({});
    console.log(tableObject.options);
}