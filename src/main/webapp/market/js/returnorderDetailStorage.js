var path;
layui.use(['jquery','table','layer'],function () {
    var table = layui.table;

    $ = layui.jquery;

    path = $('#path').val();

    var uuid = $('#uuid').val();

    var data = getReturnOrderDetail(uuid);
    initTable(data);
    custom_rule();

    // table.on('tool(orderDetailAuditFilter)',function (obj) {
    //     var data = obj.data;
    //     store(obj);
    // })

    layui.form.on('submit(Storage)',function (obj) {
        var data = obj.field;
        returnStorage(data)
        parent.queryOrdersStorage();
        return false;
    })

    //监听行单击事件（单击事件为：rowDouble）
    table.on('row(orderDetailAuditFilter)', function(obj){
        var data = obj.data;
        //标注选中样式
        if(data.state!="已入库"){
            store(obj);
        }
    });

});



function getReturnOrderDetail(uuid){
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

function returnStorage(data){

    $.ajax({
        url : path+'/returnedorders/returnMarketStorage',
        data : data,
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            parent.layer.msg(data.message);
            // parent.queryOrders();
            if(data.close){
                var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                parent.layer.close(index);
            }else{
                layer.close(layer.index);
                var uuid = $('#uuid').val();
                var data = getReturnOrderDetail(uuid);
                layui.table.reload('orderDetailTable',{
                    data : data
                });
            }
        }
    });
}

function initTable(data){
    layui.table.render({
        elem : '#orderDetailTable',
        id : 'orderDetailTable',
        height: 370,
        toolbar : '',
        data : data,
        page: true, //开启分页
        cols: [[ //表头
            // {field:'uuid', width:'18%', title: '商品编号',align:'center',width:'2%'},
            {field:'goodsuuid', width:'16%', title: '商品编号',align:'center'},
            {field:'goodsname', width:'12%', title: '商品名称',align:'center'},
            {field:'price', width:'12%', title: '价格',align:'center'},
            {field:'num', width:'12%', title: '数量',align:'center'},
            {field:'money', width:'12%', title: '金额',align:'center'},
            {field:'state', width:'12%', title: '状态',align:'center'},
            {field:'storeuuid', width:'12%', title: '仓库',align:'center',
                templet : function(row){
                    var result='';
                    $.ajax({
                        url : path+'/store/querySingleStore',
                        data : {uuid:row.storeuuid},
                        dataType : 'json',
                        type : 'post',
                        async : false,
                        success : function (data) {
                            result=data.name;
                        }
                    });
                    return result;
                }},
            {field:'button', width:'12%', title: '操作',align:'center',templet:function (row) {
                if(row.state=='未入库'){
                    return '<button class="layui-btn layui-btn-normal layui-btn-sm" id="OrdersAffirm" lay-event="OrderDetailAffirm">订单入库</button>';
                }else{
                    return '';
                }
             }},
        ]],
    });
}

function initSelect(id,htmlid){
    // alert();
    var storename = "";
    $.ajax({
        url : path + '/store/querySingleStore',
        data : {uuid:id},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            storename = data.name;
        }
    });
    return storename;
}

function custom_rule(){
    //自定义验证规则
    layui.form.verify({
        storeuuid: function(value){
            if(value==0 || value==''){
                return '请选择仓库';
            }
        }
    });
}

function store(obj) {
    var data = obj.data;
    // if(obj.event=='OrderDetailAffirm'){
        var storage = $('#storageDiv').html();
        layer.open({
            skin : 'layer-ext-Select',
            type: 1,
            area: ['680px', '220px'],
            shadeClose: true, //点击遮罩关闭
            content: storage
        });
        var storename = initSelect(data.storeuuid,'storeuuid');
        data['storename'] = storename;
        layui.form.val('goodsStorage',data);
    // }
}