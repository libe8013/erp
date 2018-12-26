var path;
var index;
var GoodsResult;
var supplierUUID;
layui.use(['jquery','form','layer','table'],function () {
    var $ = layui.$,table=layui.table,form=layui.form;
    path = $('#path').val();
    var tableId = 'orderDetailTable';
    custom_rule();

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
                if(data[i].supplieruuid==supplierUUID){
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
            }
            return html.join('');
        }
    }

    var orderDetailTable = initTable(tableId);

    //初始化下拉框
    initSelect(null,'supplieruuid');
    //定义事件集合
    var active = {
        addRow : function () {//添加行方法
            var uuid = createUUID();
            var oldData = table.cache[tableId];
            var newData = {id:uuid,uuid:null,outprice:null,num:null,money:null};
            oldData.push(newData);
            orderDetailTable.reload({
                data : oldData
            });
        },
        updateRow: function(obj){
            var oldData = table.cache[tableId];
            if(obj.uuid==null||obj.uuid==0||obj.uuid==''){
                for(var j=0;j<oldData.length;j++){
                    if(oldData[j].id==obj.id){
                        delete oldData[j]['money'];
                        delete oldData[j]['num'];
                        delete oldData[j]['outprice'];
                        delete oldData[j]['uuid'];
                        orderDetailTable.reload({
                            data : oldData
                        });
                        return;
                    }
                }
            }
            for(var i=0, row; i < oldData.length; i++){
                row = oldData[i];
                if(row.id == obj.id){
                    $.extend(oldData[i], obj);

                    for(var j=0;j<GoodsResult.length;j++){
                        if(obj.uuid==GoodsResult[j].uuid){
                            var outprice = {outprice:GoodsResult[j].outprice}
                            $.extend(oldData[i],outprice);
                            break;
                        }
                    }
                    break;
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
        },
        removeAll : function () {
            orderDetailTable.reload({
                data : []
            });
        },
        saveOrders: function(){
            var oldData = table.cache[tableId];
            var supplieruuid = $('#supplieruuid option:selected').val();

            if(supplieruuid==0 || supplieruuid==null){
                layer.msg("请选择供应商！", { icon: 5 }); //提示
                return;
            }
            if(oldData.length==0){
                layer.msg("请添加订单！", { icon: 5 }); //提示
                return;
            }

            for(var i=0, row; i < oldData.length; i++){
                row = oldData[i];
                if(!row.uuid){
                    layer.msg("检查每一行，请选择商品！", { icon: 5 }); //提示
                    return;
                }
                if(row.num==0 || row.num==null){
                    layer.msg("检查每一行，请输入数量！", { icon: 2 }); //提示
                    return;
                }
            }

            var totalmoney = 0;
            var json = [];
            for(var i=0;i<oldData.length;i++){
                totalmoney+=oldData[i].money;
                var ordersDeatildata = {
                    uuid : oldData[i].uuid,
                    num : oldData[i].num,
                    money : oldData[i].money
                };
                json.push(queryGoods(ordersDeatildata));
            }


            var Goodsjson = JSON.stringify(json);	//使用JSON.stringify() 格式化输出JSON字符串
            $.ajax({
                url : path+'/orders/addOrders',
                data : {type:"采购",state:'未审核',supplieruuid:supplieruuid,totalmoney:totalmoney,goodsJson:Goodsjson},
                dataType : 'json',
                type : 'post',
                async : false,
                success : function (data) {
                    layer.msg(data.message, { icon: 1 }); //提示
                    activeByType("removeAll");
                    $('#ff')[0].reset();
                }
            });
        }
    };

    //激活事件
    var activeByType = function (type, arg) {//第一个参数是定义的事件名
        if(arguments.length === 2){//判断有几个参数值(为undefined不算一个)
            //使用call()来实现继承：写一个方法，然后让另外一个新的对象来继承它（而不是在新对象中再写一次这个方法）。当前例子:当前function继承active方法(不需要在创建active方法)
            active[type] ? active[type].call(this, arg) : '';//可以让call()中的对象调用当前对象所拥有的function,当前例子:在activeByType中调用active方法
        }else{
            active[type] ? active[type].call(this) : '';
        }
    };

    //注册按钮事件
    $(document).on('click','#addRow', function () {
        if(supplierUUID==''||supplierUUID==null){
            layer.msg('请选择供应商');
            return;
        }
        var type = $(this).data('type');//获取当前点击按钮的data-type属性值
        activeByType(type);//调用activeByType方法
    });

    $(document).on('click','#saveOrders', function () {
        var type = $(this).data('type');//获取当前点击按钮的data-type属性值
        activeByType(type);//调用activeByType方法
    });

    table.on('edit(orderDetailTab)',function (obj) {
        var value = obj.value, //得到所在行所有键值
                data=obj.data,//得到修改后的值
                field=obj.field;//得到字段

        if(!data.uuid){
            layer.msg('请选择商品');
            return;
        }

        var num = data.num;
        var reg = /^[-]{0,1}[0-9]{1,}$/;

        if(!reg.test(num)){
            layer.msg('请输入数字');
            return;
        }

        var oldData = table.cache[tableId];

        for(var i=0,row;i<oldData.length;i++){
            row = oldData[i];
            if(row.id==data.id){
                if(row.outprice!=null){
                    var money = {money:(data.outprice*data.num)};
                    $.extend(oldData[i],money);
                }
                break;
            }
        }
        orderDetailTable.reload({
            data : oldData
        });

    })

    //监听select下拉选中事件
    form.on('select(goods)', function(data){
        var elem = data.elem; //得到select原始DOM对象

        // supplierUUID=d
        $(elem).prev("a[lay-event='goods']").trigger("click");//触发(点击)有lay-event='goods'的a标签[进入到监听工具条中]

    });

    form.on('select(supplier)', function(data){
        supplierUUID=data.value;
        GoodsResult = getGoods(supplierUUID);
        var oldData = table.cache[tableId];
        for (var i=0;i<oldData.length;i++){
            delete oldData[i]['money'];
            delete oldData[i]['num'];
            delete oldData[i]['outprice'];
            delete oldData[i]['uuid'];
        }
        orderDetailTable.reload({
            data : oldData
        });
    });

    //监听工具条
    table.on('tool(orderDetailTab)', function (obj) {
        var data = obj.data, event = obj.event, tr = obj.tr; //获得当前行 tr 的DOM对象;
        // console.log(event);

        switch(event){
            case "goods":
                var select = tr.find("select[name='uuid']");
                if(select){
                    var selectedVal = select.val();
                    if(!selectedVal){//js中的!是取反,即把真变假
                        layer.tips("请选择一个分类", select.next('.layui-form-select'), { tips: [3, '#FF5722'] }); //吸附提示
                    }
                    $.extend(obj.data, {'uuid': selectedVal});//将{'uuid': selectedVal}合并到obj.data里中

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
            {field:'uuid', width:'20%', title: '商品',align:'center',templet:function(obj){
                    var options = GoodsObj.renderSelectOptions(GoodsResult, {valueField: "uuid", textField: "name", selectedValue: obj.uuid});
                    return '<a lay-event="goods"></a><select name="uuid" id="goods'+obj.LAY_INDEX+'" class="name" lay-filter="goods"><option value=""></option>' + options + '</select>';
                }},
            {field:'outprice', width:'12%', title: '价格',align:'center',templet : function (row) {
                    if(row.uuid!=null){
                        return row.outprice+'$';
                    }else{
                        return '';
                    }}
                },
            {field:'num', width:'12%', title: '数量',align:'center', edit: 'text',templet:function (row) {
                if(row.uuid!=null){
                    var num = row.num!=null ? parseInt(row.num) : 0;
                    return '<div lay-event="editNum">'+num+'</div>';
                }else{
                    return '<div lay-event="editNum"></div>';
                }
             }},
            {field:'money', width:'12%', title: '金额',align:'center',templet : function (row) {
                if(row.uuid!=null){
                    var num = row.num!=null ? parseInt(row.num)*row.outprice : 0;
                    return num+'$';
                }else {
                    return '';
                }
                }},
            {field:'操作', width:'15%', title: '操作',align:'center',templet:function (row) {
                    return '<a class="layui-btn layui-btn-sm layui-btn-normal" lay-event="del" lay-id="'+row.uuid+'"><i class="layui-icon"></i></a>';
             }}
        ]],
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

function getGoods(supplierUUID){
    var result = [];
    $.ajax({
        url : path+'/goods/queryGoodsLikePager',
        data : {supplieruuid:supplierUUID},
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

function queryGoods(data){
    var result = {};
    for (var i=0;i<GoodsResult.length;i++){
        if(data.uuid==GoodsResult[i].uuid){
            result = GoodsResult[i];
            result.num=data.num;
            result.money=data.money;
            break;
        }
    }
    return result;
}