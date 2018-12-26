var path;
var index;
layui.use(['jquery','form','layer','table'],function () {
    $ = layui.jquery;
    var table = layui.table;
    path = $('#path').val();
    custom_rule();
    var orderTable = initTable();
    $(document).on('click','#goodsQuery',function () {
        queryOrdersStorage();
    });
    table.on('tool(ordersStorageTab)',function (obj) {
        var data = obj.data;
        var tr = obj.tr;
        if(obj.event=='queryordersStorageTab'){
            querySingleOrderDetail(data,tr);
        }
    })

});

function initTable(){
    var table = layui.table;
    return table.render({
        elem : '#ordersStorageTable',
        id : 'ordersStorageTable',
        height: 600,
        data : [],
        page: true, //开启分页
        cols: [[ //表头
            {type:'checkbox',width:'2%'},
            // {field:'uuid', width:'18%', title: '编号',align:'center'},
            {field:'createtime', width:'10%', title: '生成日期',align:'center'},
            {field:'checktime', width:'10%', title: '检查日期',align:'center'},
            {field:'starttime', width:'10%', title: '开始日期',align:'center'},
            {field:'endtime', width:'10%', title: '结束日期',align:'center'},
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
            {field:'starter', width:'7%', title: '采购员',align:'center',
                templet : function(row){
                    var result='';
                    $.ajax({
                        url : path+'/emp/querySingleEmp',
                        data : {uuid:row.starter},
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
            {field:'supplieruuid', width:'8%', title: '供应商',align:'center',
                templet : function(row){
                    var result='';
                    $.ajax({
                        url : path+'/supplier/querySupplierLikePager',
                        data : {uuid:row.supplieruuid},
                        dataType : 'json',
                        type : 'post',
                        async : false,
                        success : function (data) {
                            result=data.data[0].name;
                        }
                    });
                    return result;
                }},
            {field:'totalmoney', width:'6%', title: '总金额',align:'center',templet:function (obj) {
                    return obj.totalmoney+"$";
             }},
            {field:'state', width:'6%', title: '订单状态',align:'center'},
            {field:'操作', width:'11%', title: '操作',align:'center',templet:function(obj){
                if(obj.state=="已确认"){
                    return '<a class="layui-btn layui-btn-normal layui-btn-sm" id="orderdetailAudit" lay-event="queryordersStorageTab">订单审核</a>';
                }else {
                    return '';
                }
            }}
        ]],
    });
}

function queryOrdersStorage() {
    var url = path+'/orders/queryPurchasePager?1=1&state=已确认';

    var starttime = $('#starttime').val();

    if(''!=starttime && null!=starttime){
        url+="&starttime="+starttime;
    }

    layui.table.reload("ordersStorageTable", { //此处是上文提到的 初始化标识id
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
        area : ['1030px' , '660px'],
        content: path+"/purchase/jsp/orderDetailStorage.jsp?uuid="+data.uuid,
        success : function (layero,index) {
            var body = layer.getChildFrame('body',index);
            var inputBody = body.find('input');
            var supplier = $(''+tr.selector+' td[data-field=supplieruuid]').text();
            var creater = $(''+tr.selector+' td[data-field=creater]').text();
            var checker = $(''+tr.selector+' td[data-field=checker]').text();
            var starter = $(''+tr.selector+' td[data-field=starter]').text();
            // var ender = $(''+tr.selector+' td[data-content='+data.ender+']').text();
            data["supplieruuid"] = supplier;
            data["createrUUID"] = data.creater;
            data["creater"] = creater;
            data["checker"] = checker;
            data["starter"] = starter;
            // data["ender"] = ender;
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