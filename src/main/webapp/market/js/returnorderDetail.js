var path;
layui.use(['jquery','table','layer'],function () {
    var table = layui.table;

    path = $('#path').val();

    var uuid = $('#uuid').val();

    var data = getOrderDetail(uuid);

    table.render({
        elem : '#orderDetailTable',
        id : 'orderDetailTable',
        height: 370,
        data : data,
        page: true, //开启分页
        cols: [[ //表头
            // {type:'checkbox',width:'2%'},
            {field:'goodsuuid', width:'18%', title: '商品编号',align:'center'},
            {field:'goodsname', width:'14%', title: '商品名称',align:'center'},
            {field:'price', width:'12%', title: '价格',align:'center'},
            {field:'num', width:'12%', title: '数量',align:'center'},
            {field:'money', width:'12%', title: '金额',align:'center'},
            {field:'state', width:'12%', title: '状态',align:'center'}
        ]],
    });
});

function getOrderDetail(uuid){
    var result = [];
    $.ajax({
        url : path+'/returnorderdetail/queryReturnOrderDetail',
        data : {ordersuuid:uuid},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            result = data;
        }
    });
    return result;
}