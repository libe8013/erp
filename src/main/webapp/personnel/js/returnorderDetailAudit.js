var path;
layui.use(['jquery','table','layer'],function () {
    var table = layui.table;

    path = $('#path').val();

    var uuid = $('#uuid').val();

    var data = getOrderDetail(uuid);

    initTable(data);



    $('#OrdersAudit').click(function () {
        layer.confirm('确定执行审核操作嘛?', function (index) {
            var uuid = $('#uuid').val();
            var creater = $('#createrUUID').val();
            Audit(uuid, creater);
        });
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

function Audit(uuid,creater){
    $.ajax({
        url : path+'/returnedorders/Audit',
        data : {uuid:uuid,state:'已审核',creater:creater},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            parent.layer.msg(data.message);
            parent.queryOrders();
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
        }
    });
}

function initTable(data){
    layui.table.render({
        elem : '#orderDetailTable',
        id : 'orderDetailTable',
        height: 370,
        toolbar : '#Audit',
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
}