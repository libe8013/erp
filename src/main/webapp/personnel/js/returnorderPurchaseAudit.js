var path;
var index;
layui.use(['jquery','form','layer','table'],function () {
    $ = layui.jquery;
    var table = layui.table;
    path = $('#path').val();
    custom_rule();
    var orderTable = initTable();
    $(document).on('click','#goodsQuery',function () {
        queryOrders();
    });

    table.on('tool(ordersTab)',function (obj) {
        var data = obj.data;
        var tr = obj.tr;
        if(obj.event=='queryOrderDetailAudit'){
            querySingleOrderDetail(data,tr);
        }else if(obj.event=='delDetail'){
            del(data);
        }
    })

});

function initTable(){
    var table = layui.table;
    return table.render({
        elem : '#ordersTable',
        id : 'ordersTable',
        height: 600,
        data : [],
        page: true, //开启分页
        cols: [[ //表头
            {type:'checkbox',width:'2%'},
            // {field:'uuid', width:'18%', title: '编号',align:'center'},
            {field:'createtime', width:'10%', title: '登记日期',align:'center'},
            {field:'checktime', width:'10%', title: '审核日期',align:'center'},
            {field:'endtime', width:'10%', title: '出库日期',align:'center'},
            {field:'creater', width:'7%', title: '下单员',align:'center',
                templet : function(row){
                    var result='';
                    $.ajax({
                        url : path+'/emp/querySingleEmp',
                        data : {uuid:row.creater},
                        dataType : 'json',
                        type : 'post',
                        async : false,
                        success : function (data) {
                            result=data.name;
                        }
                    });
                    return result;
                }},
            {field:'checker', width:'7%', title: '审查员',align:'center',
                templet : function(row){
                    var result='';
                    $.ajax({
                        url : path+'/emp/querySingleEmp',
                        data : {uuid:row.checker},
                        dataType : 'json',
                        type : 'post',
                        async : false,
                        success : function (data) {
                            result=data.name;
                        }
                    });
                    return result;
                }},
            {field:'ender', width:'7%', title: '库管员',align:'center',
                templet : function(row){
                    var result='';
                    $.ajax({
                        url : path+'/emp/querySingleEmp',
                        data : {uuid:row.ender},
                        dataType : 'json',
                        type : 'post',
                        async : false,
                        success : function (data) {
                            result=data.name;
                        }
                    });
                    return result;
                }},
            {field:'storeuuid', width:'8%', title: '仓库',align:'center',
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
            {field:'totalmoney', width:'6%', title: '总金额',align:'center',templet:function (obj) {
                    return obj.totalmoney+"$";
             }},
            {field:'state', width:'6%', title: '订单状态',align:'center'},
            {field:'操作', width:'12%', title: '操作',align:'center',templet:function(obj){
                if(obj.state=="未审核"){
                    var del = "<button type='button' class='layui-btn layui-btn-normal layui-btn-sm' lay-event='delDetail'><i class=\"layui-icon\"></i></button>";
                    return '<a class="layui-btn layui-btn-normal layui-btn-sm" id="orderdetailAudit" lay-event="queryOrderDetailAudit">退货订单审核</a>&nbsp;'+del;
                }else {
                    return '';
                }
            }}
        ]],
    });
}

function queryOrders() {
    var url = path+'/returnedorders/queryReturnOrdersPager?1=1&state=未审核&type=采购';

    var createtime = $('#createtime').val();
    if(''!=createtime && null!=createtime){
        url+="&createtime="+createtime;
    }

    layui.table.reload("ordersTable", { //此处是上文提到的 初始化标识id
        url : url,

    });
}

function querySingleOrderDetail(data,tr){
    layer.open({
        type: 2,
        title: '订单详情',
        maxmin: true,
        toolbar : '',
        shadeClose: true, //点击遮罩关闭层
        area : ['1030px' , '600px'],
        content: path+"/personnel/jsp/returnorderDetailAudit.jsp?uuid="+data.uuid,
        success : function (layero,index) {
            var body = layer.getChildFrame('body',index);
            var inputBody = body.find('input');
            var storeuuid = $(''+tr.selector+' td[data-content='+data.storeuuid+']').text();
            var creater = $(''+tr.selector+' td[data-content='+data.creater+']').text();
            var checker = $(''+tr.selector+' td[data-content='+data.checker+']').text();
            var ender = $(''+tr.selector+' td[data-content='+data.ender+']').text();
            data["storename"] = storeuuid;
            data["createrUUID"] = data.creater;
            data["creater"] = creater;
            data["checker"] = checker;
            data["ender"] = ender;
            $.each(data,function (dataKey) {
                for (var i=0;i<inputBody.length;i++){
                    if(inputBody[i].id==dataKey){
                        $(inputBody[i]).val(data[dataKey]);
                    }
                }
            })
        }
    });
}

function custom_rule(){
    //自定义验证规则
    layui.form.verify({
        storeName: function(value){
            if(value.length < 1){
                return '仓库名称不能为空';
            }
        }
        ,supplieruuid: function (value) {
            if(value==0){
                return "请选择供应商";
            }
        }
    });
}

function del(data){
    layer.confirm('确定执行删除操作嘛?', function(index){
        $.ajax({
            url : path+'/returnedorders/delReturnOrders',
            data : {returnOrdersUUID:data.uuid},
            dataType : 'json',
            type : 'post',
            async : false,
            success : function (data) {
                layer.close(index);
                layer.msg(data.message);
                queryOrders();
            },
            error:function(result) {

            }
        });
    });
}