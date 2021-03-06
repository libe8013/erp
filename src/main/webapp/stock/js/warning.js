var path;
var index;
layui.use(['jquery','form','layer','table'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    var form = layui.form;
    var layer = layui.layer;
    initTable();
    custom_rule();
    $(document).on('click','#goodsQuery',function () {
        queryGoodsType();
    });
    layui.table.on('toolbar(goodsTab)',function (obj) {
        layer.confirm('确定执行删除操作嘛?', function(index){
           $.ajax({
               url : path+'/email/test',
               data : {},
               dataType : 'json',
               type : 'post',
               async : false,
               success : function (obj) {
                   result = obj;
               }
           });
        });
    });

    layui.table.on('row(goodsTab)',function (obj) {
        var data = obj.data;
        var result = {};
        $.ajax({
            url : path+'/emp/querySingleEmp',
            data : {uuid : data.empuuid},
            dataType : 'json',
            type : 'post',
            async : false,
            success : function (obj) {
                result = obj;
            }
        });
        layer.open({
            type: 2,
            title: '邮件发送',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['800px' , '300px'],
            content: path+'/stock/jsp/EmailText.jsp',
            success : function (layero,index) {
                var body = layer.getChildFrame('body',index);
                var inputBody = body.find('input');
                $.each(result, function(j) {
                    for (var i=0;i<inputBody.length;i++){
                        if(inputBody[i].id==j){
                            $(inputBody[i]).val(result[j]);
                        }
                    }
                });
            }
        });
    });
});

function initTable(){
    var table = layui.table;
    table.render({
        elem : '#goodsTable',
        id : 'goodsTable',
        toolbar : '#warning',
        height: 600,
        data : [],
        page: true, //开启分页
        cols: [[ //表头
            {type:'checkbox',width:'2%'},
            // {field:'uuid', width:'18%', title: 'ID',align:'center'},
            {field:'goodsname', width:'10%', title: '商品名称',align:'center'},
            {field:'empuuid',hide:true},
            {field:'inventory', width:'10%', title: '库存',align:'center'},
            {field:'num', width:'10%', title: '待发货数量',align:'center'},
        ]],
    });
}

function queryGoodsType(page) {
    var name = $('#name').val();
    var url = path+'/stock/queryWarning?1=1';

    if(null!=name && ''!=name){
        url+='&name='+name;
    }
    if(page!=''||page!=null){
        layui.table.reload("goodsTable", { //此处是上文提到的 初始化标识id
            url: url,
            page : {
                curr : page
            }
        });
    }else{
        layui.table.reload("goodsTable", { //此处是上文提到的 初始化标识id
            url: url,
            page : {
                curr : 1
            }
        });
    }

}

function initSelect(id,htmlid){
    var form = layui.form;
    // alert();
    $.get(path + '/goodsType/queryGoodsTypePager', {}, function (data) {
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
            $("select[name='"+htmlid+"']").append(goodsType);
            //反选
            // $("select[name='???']").val($("#???").val());
            //append后必须从新渲染
            form.render('select');
        }
    });
}

function initSelectSupplier(id,htmlid){
    var form = layui.form;
    // alert();
    $.get(path + '/supplier/querySupplierLikePager', {}, function (data) {
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
            $("select[name='"+htmlid+"']").append(goodsType);
            //反选
            // $("select[name='???']").val($("#???").val());
            //append后必须从新渲染
            form.render('select');
        }
    });
}

function add(){
    var addDiv = $('#addDiv').html();
    //弹出一个页面层
    layer.open({
        skin : 'layer-ext-Select',
        type: 1,
        area: ['740px', '440px'],
        shadeClose: true, //点击遮罩关闭
        content: addDiv,
        title : '新增商品分类'
    });
    initSelect(null,'goodstypeuuid');
    initSelectSupplier(null,'supplieruuid');
}

function addForm() {
    var result = [];
    $.ajax({
        url : path+'/goods/queryGoodsLikePager',
        data : {},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            result = data.data;
        }
    });

    var name = $('#name1').val();
    var origin1 = $('#origin1').val();
    var producerl = $('#PRODUCER1').val();
    var unit = $('#unit').val();
    var inprice = $('#inprice').val();
    var outprice = $('#outprice').val();
    var goodstypeuuid = $('#goodstypeuuid1 option:selected').val();
    var supplieruuid = $('#supplier option:selected').val();
    for(var i=0;i<result.length;i++){
        if(result[i].name==name && result[i].supplieruuid==supplieruuid){
            layer.msg('该供应商已有该商品名称');
            return;
        }
    }
    $.ajax({
        url : path+'/goods/addGoods',
        data : {name:name,origin1:origin,producer:producerl,unit:unit,inprice:inprice,outprice:outprice,goodstypeuuid:goodstypeuuid,supplieruuid:supplieruuid},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            layer.msg("添加成功");
            queryGoodsType();
            $('#ff')[0].reset();
        }
    });
    return false;
}

function custom_rule(){
    //自定义验证规则
    layui.form.verify({
        goodsName: function(value){
            if(value.length < 1){
                return '商品名称不能为空';
            }
        }
        ,unit: function (value) {
            if(value.length < 1){
                return '计量单位不能为空';
            }
        }
        ,inprice: function (value) {
            if(value.length < 1){
                return '进货价格不能为空';
            }
        }
        ,outprice: function (value) {
            if(value.length < 1){
                return '销售价格不能为空';
            }
        }
        ,goodstypeuuid: function (value) {
            if(value==0){
               return "请选择商品类型";
            }
        },
        supplier : function (value) {
            if(value==0){
                return "请选择供应商";
            }
        }
    });
}

function del(uuid,supplieruuid) {
    layer.confirm('确定执行删除操作嘛?', function(index){
        $.ajax({
            url : path+'/goods/delGoods',
            data : {uuid:uuid,supplieruuid:supplieruuid},
            dataType : 'json',
            type : 'post',
            async : false,
            success : function (data) {
                layer.close(index);
                layer.msg(data.message);
                queryGoodsType();
            },
            error:function(result) {

            }
        });
    });
}

function edit(obj){
    var editDiv = $('#editDiv').html();
    //弹出一个页面层
    index = layer.open({
        skin : 'layer-ext-Select',
        type: 1,
        area: ['720px' , '425px'],
        shadeClose: true, //点击遮罩关闭
        content: editDiv,
        title : '编辑商品信息',
    });
    initSelect(obj.goodstypeuuid,'goodstypeuuid');
    initSelectSupplier(obj.supplieruuid,'supplieruuid');
    $("#goodstypeuuid2").find("option[value='"+obj.goodstypeuuid+"']").prop("selected",true);
    $('#uuid').val(obj.uuid);
    $('#name2').val(obj.name);
    $('#origin2').val(obj.origin);
    $('#PRODUCER2').val(obj.producer);
    $('#unit2').val(obj.unit);
    $('#inprice2').val(obj.inprice);
    $('#outprice2').val(obj.outprice);
    // layui.form.val('goodsEdit',obj);
}


function editForm(obj) {
    var result = [];
    var arr = {};
    var data = obj;
    $.ajax({
        url : path+'/goods/queryGoodsLikePager',
        data : {},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            result = data.data;
        }
    });

    for(var i=0;i<result.length;i++){
        if(result[i].uuid==data.uuid){
            arr = result[i];
            break;
        }
    }

    if(arr.name!=data.name){
        for(var i=0;i<result.length;i++){
            if(result[i].name==data.name){
                layer.msg('已有该商品名称');
                return;
            }
        }
    }

    $.ajax({
        url : path+'/goods/editGoods',
        data : data,
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            layer.msg(data.message);
            var page = $(".layui-laypage-skip").find("input").val();
            queryGoodsType(page);
            layer.close(index);
            // $('#ff1')[0].reset();
        }
    });
    return false;
}
