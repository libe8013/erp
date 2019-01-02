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
        if(obj.event=='queryOrderDetail'){
            querySingleOrderDetail(data,tr);
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
            {field:'createtime', width:'10%', title: '生成日期',align:'center'},
            {field:'checktime', width:'10%', title: '检查日期',align:'center'},
            {field:'starttime', width:'10%', title: '开始日期',align:'center'},
            {field:'endtime', width:'10%', title: '结束日期',align:'center'},
            {field:'creater', width:'8%', title: '下单员',align:'center',
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
            {field:'checker', width:'8%', title: '审查员',align:'center',
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
            {field:'starter', width:'8%', title: '采购员',align:'center',
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
            {field:'ender', width:'8%', title: '库管员',align:'center',
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
            {field:'操作', width:'6%', title: '操作',align:'center',toolbar:'#crud'}
        ]],
    });
}

function queryOrders() {
    var state = $('#state option:selected').val();
    var url = path+'/returnedorders/queryReturnOrdersPager?1=1&type=销售';

    if(null!=state && ''!=state && 0!=state){
        url+='&state='+state;
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
        content: path+"/market/jsp/returnorderDetail.jsp?uuid="+data.uuid,
        success : function (layero,index) {
            var body = layer.getChildFrame('body',index);
            var inputBody = body.find('input');
            var supplier = $(''+tr.selector+' td[data-field="supplieruuid"]').text();
            var creater = $(''+tr.selector+' td[data-field="creater"]').text();
            var checker = $(''+tr.selector+' td[data-field="checker"]').text();
            var ender = $(''+tr.selector+' td[data-field="ender"]').text();
            data["supplieruuid"] = supplier;
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