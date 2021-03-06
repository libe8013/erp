var path;
layui.use(['jquery','table','layer'],function () {
    var table = layui.table;

    path = $('#path').val();

    var uuid = $('#uuid').val();

    var data = getOrderDetail(uuid);

    initTable(data);

    custom_rule();

    //监听行单击事件（单击事件为：rowDouble）
    table.on('row(orderDetailAuditFilter)', function(obj){
        var data = obj.data;
        if(data.state!="已出库"){
            var tr = obj.tr;
            var storage = $('#storageDiv').html();
            layer.open({
                skin : 'layer-ext-Select',
                type: 1,
                area: ['680px', '220px'],
                shadeClose: true, //点击遮罩关闭
                content: storage
            });
            initSelect(null,'store',data);

            layui.form.val('goodsStorage',data);
        }

    });

    layui.form.on('submit(Storage)',function (obj) {
        var data = obj.field;
        Storage(data)
        parent.queryOrdersStorage();
        return false;
    })

});



function getOrderDetail(uuid){
    var result = [];
    $.ajax({
        url : path+'/orderDetail/queryOrderDetail',
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

function Storage(data){
    $.ajax({
        url : path+'/orders/Marketstorage',
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
                var data = getOrderDetail(uuid);
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
            // {field:'goodsuuid', width:'18%', title: '商品编号',align:'center'},
            {field:'goodsname', width:'14%', title: '商品名称',align:'center'},
            {field:'price', width:'12%', title: '价格',align:'center'},
            {field:'num', width:'12%', title: '数量',align:'center'},
            {field:'money', width:'12%', title: '金额',align:'center'},
            {field:'state', width:'12%', title: '状态',align:'center'},
            {field:'button', width:'12%', title: '操作',align:'center',templet:function (row) {
                if(row.state=='未出库'){
                    return '<button class="layui-btn layui-btn-normal layui-btn-sm" id="OrdersAffirm" lay-event="OrderDetailAffirm">订单出库</button>';
                }else{
                    return '';
                }
             }},
        ]],
    });
}

function initSelect(id,htmlid,data){
    var form = layui.form;
    // alert();
    $.get(path + '/store/queryStoreGoodsUUID', {goodsuuid:data.goodsuuid,num:data.num}, function (data) {
        var goodsType = "";
        if (data != null && data.length!=0) {
            goodsType+="<option value=\"0\">请选择仓库</option>";
            $.each(data, function (index, item) {
                if (item.uuid){
                    if(id!=null && id!=0 && item.uuid==id){
                        goodsType += "<option class='generate' selected='selected' value='" + item.STOREUUID + "'>" + item.name + "</option>";
                    }else{
                        goodsType += "<option class='generate' value='" + item.STOREUUID + "'>" + item.name + "</option>";
                    }
                }else{
                    goodsType += "<option value='" + item.STOREUUID + "'>" + item.name + "</option>";
                }
            });
            //反选
            // $("select[name='???']").val($("#???").val());
        }else{
            goodsType+="<option value='0'>商品库存不足请联系采购员</option>";
        }
        $("select[id='"+htmlid+"']").append(goodsType);
        //append后必须从新渲染
        form.render('select');
    });
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