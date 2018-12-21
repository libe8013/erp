var path;
var index;
var GoodsResult;
var endUUID = '';
layui.use(['jquery','form','layer','table'],function () {
    var $ = layui.$,table=layui.table,form=layui.form;
    path = $('#path').val();
    var tableId = 'orderDetailTable';
    custom_rule();
    GoodsResult = getGoods();

    window.GoodsObj = {
        renderSelectOptions : function (data,settings) {
            // var valueField = settings.valueField || 'value',
            //     textField = settings.textField || 'text',
            //     selectedValue = settings.selectedValue || "";
            var valueField = settings.valueField,
                textField = settings.textField,
                selectedValue = settings.selectedValue;
            var html = [];
            for(var i=0, item; i < data.length; i++){
                item = data[i];
                html.push('<option value="');
                html.push(item[valueField]);
                html.push('"');
                if(selectedValue && item[valueField] == selectedValue){
                    html.push(' selected="selected"');
                }
                html.push('>');
                html.push(item[textField]);
                html.push('</option>');
            }
            return html.join('');
        }
    }

    var orderDetailTable = initTable(tableId);

    initSelect(null,'supplieruuid');
    //定义事件集合
    var active = {
        addRow : function () {//添加行方法
            // var uuid = createUUID();
            var oldData = table.cache[tableId];
            alert("ADDROW");
            console.log(oldData);
            var newData = {uuid:null,name:null,outprice:null,num:null,money:121221};
            oldData.push(newData);
            orderDetailTable.reload({
                data : oldData
            });
        },
        updateRow: function(obj){
            var oldData = table.cache[tableId];
            for(var i=0, row; i < oldData.length; i++){
                row = oldData[i];
                if(row.goods == obj.goods){
                    $.extend(oldData[i], obj);
                    return;
                }
            }
            orderDetailTable.reload({
                data : oldData
            });
        },
        removeEmptyTableCache : function () {
            var oldData = table.cache[tableId];
            for(var i=0, row; i < oldData.length; i++){
                row = oldData[i];
                if(!row || !row.uuid){
                    oldData.splice(i, 1);    //删除一项
                }
                continue;
            }
            orderDetailTable.reload({
                data : oldData
            });
        }
    };

    //激活事件
    var activeByType = function (type, arg) {//第一个参数是定义的事件名
        alert(type+"__"+arg+"_____"+arguments.length);
        console.log(arg);
        if(arguments.length === 2){//判断有几个参数值(为undefined不算一个)
            active[type] ? active[type].call(this, arg) : '';
        }else{
            active[type] ? active[type].call(this) : '';
        }
    };

    //注册按钮事件
    $(document).on('click','#addRow', function () {
        var type = $(this).data('type');//获取当前点击按钮的data-type属性值
        activeByType(type);
    });

    //监听select下拉选中事件
    form.on('select(goods)', function(data){
        var elem = data.elem; //得到select原始DOM对象
        $(elem).prev("a[lay-event='goods']").trigger("click");
        alert("select监听");
        var oldData = table.cache[tableId];
        console.log(oldData);
    });

    //监听工具条
    table.on('tool(orderDetailTab)', function (obj) {
        var data = obj.data, event = obj.event, tr = obj.tr; //获得当前行 tr 的DOM对象;
        switch(event){
            case "goods":
                //console.log(data);
                var select = tr.find("select[name='uuid']");
                if(select){
                    alert(1111);
                    var oldData = table.cache[tableId];
                    console.log(oldData);
                    var selectedVal = select.val();
                    if(!selectedVal){//js中的!是取反,即把真变假
                        layer.tips("请选择一个分类", select.next('.layui-form-select'), { tips: [3, '#FF5722'] }); //吸附提示
                    }
                    console.log(selectedVal);
                    console.log($.extend(obj.data, {'uuid': selectedVal}));
                    console.log("==================");

                    activeByType('updateRow', obj.data);	//更新行记录对象
                }
                break;
            case "del":
                layer.confirm('真的删除该行么？', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    activeByType('removeEmptyTableCache');
                });
                break;
        }
    });
});

function initTable(tableId){
    return layui.table.render({
        elem : '#orderDetailTable',
        id : tableId,
        toolbar : '#toolbarTop',
        height: 524,
        data : [],
        page: true, //开启分页
        cols: [[ //表头
            {type:'checkbox',width:'4%'},
            {field:'uuid', width:'25%', title: '商品编号',align:'center',templet:function(obj){
                    alert("goodsGOODS");
                    console.log(obj);
                    var options = GoodsObj.renderSelectOptions(GoodsResult, {valueField: "uuid", textField: "name", selectedValue: obj.uuid});
                    return '<a lay-event="goods"></a><select name="uuid" id="goods'+obj.LAY_INDEX+'" lay-filter="goods"><option value=""></option>' + options + '</select>';
                }},
            {field:'name', width:'20%', title: '商品名称',align:'center'
                // templet:function (obj) {
                // alert("goodsGOODS");
                // console.log(obj);
                //     var options = GoodsObj.renderSelectOptions(GoodsResult, {valueField: "uuid", textField: "name", selectedValue: obj.uuid});
                //     return '<a lay-event="goods"></a><select name="uuid" id="goods'+obj.LAY_INDEX+'" lay-filter="goods"><option value=""></option>' + options + '</select>';
                // }
             },
            {field:'outprice', width:'12%', title: '价格',align:'center', edit: 'text'},
            {field:'num', width:'12%', title: '数量',align:'center', edit: 'text'},
            {field:'money', width:'12%', title: '金额',align:'center', edit: 'text'},
            {field:'操作', width:'15%', title: '操作',align:'center',templet:function (row) {
                    return '<a class="layui-btn layui-btn-sm layui-btn-normal" lay-event="del" lay-id="'+row.uuid+'"><i class="layui-icon"></i></a>';
             }}
        ]],
    });
}

function queryStore() {
    var name = $('#name').val();
    var address = $('#address').val();
    var empuuid = $('#empuuid option:selected').val();
    var url = path+'/store/queryStoreLikePager?1=1';

    if(null!=name && ''!=name){
        url+='&name='+name;
    }
    if(null!=address && ''!=address){
        url+='&address='+address;
    }
    if(null!=empuuid && ''!=empuuid && 0!=empuuid){
        url+='&empuuid='+empuuid;
    }

    layui.table.reload("storeTable", { //此处是上文提到的 初始化标识id
        url: url
    });
}

function initSelect(id,htmlid){
    var form = layui.form;
    $.get(path + '/supplier/querySupplierLikePager', {type:'0'}, function (data) {
        var goodsType = "";
        if (data.data != null) {
            $.each(data.data, function (index, item) {
                if (item.uuid){
                    if(id!=null && id!=0 && item.uuid==id){
                        goodsType += "<option class='generate' selected='selected' value='" + item.uuid + "'>" + item.name + "</option>";
                    }else{
                        goodsType += "<option class='generate' value='" + item.uuid + "'>" + item.name + "</option>";
                    }
                }else{
                    goodsType += "<option value='" + item.uuid + "'>" + item.name + "</option>";
                }
            });
            $("select[id='"+htmlid+"']").append(goodsType);
            //反选
            // $("select[name='???']").val($("#???").val());
            //append后必须从新渲染
            form.render('select');
        }
    });
}

function custom_rule(){
    //自定义验证规则
    layui.form.verify({
        supplieruuid: function (value) {
            if(value==0){
                return "请选择供应商";
            }
        }
    });
}

var createUUID = (function (uuidRegEx, uuidReplacer) {
    return function () {
        return "xxxxxxxxxxxx4xxxyxxxxxxxxxxxxxxx".replace(uuidRegEx, uuidReplacer).toUpperCase();
    };
})(/[xy]/g, function (c) {
    var r = Math.random() * 16 | 0,
        v = c == "x" ? r : (r & 3 | 8);
    return v.toString(16);
});

function getGoods(){
    var result = [];
    $.ajax({
        url : path+'/goods/queryGoodsLikePager',
        data : {},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            result = data.data;
        },
        error:function(result) {

        }
    });
    return result;
}

function editSelect(index){
    alert(index);
}