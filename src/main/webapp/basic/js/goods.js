var path;
var index;
layui.use(['jquery','form','layer','table'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    var form = layui.form;
    var layer = layui.layer;
    initTable();
    initSelect(null,'goodstypeuuid2');
    custom_rule();
    $(document).on('click','#goodsQuery',function () {
        queryGoodsType();
    });
    $(document).on('submit','#ff',function () {
        addForm();
        return false;
    });
    form.on('submit(edit)',function (obj) {
        editForm(obj.field);
        return false;
    });
    layui.table.on('tool(goodsTab)',function (obj) {
        var data = obj.data;
        if(obj.event=="del"){
            del(data.uuid);
        }else if(obj.event=="edit"){
            edit(data);
        }
    });
});

function initTable(){
    var table = layui.table;
    table.render({
        elem : '#goodsTable',
        id : 'goodsTable',
        toolbar : '#toolbarTop',
        height: 600,
        data : [],
        page: true, //开启分页
        cols: [[ //表头
            {type:'checkbox',width:'2%'},
            // {field:'uuid', width:'18%', title: 'ID',align:'center'},
            {field:'name', width:'10%', title: '商品名称',align:'center'},
            {field:'origin', width:'10%', title: '产地',align:'center'},
            {field:'producer', width:'13%', title: '厂家',align:'center'},
            {field:'unit', width:'10%', title: '计量单位',align:'center'},
            {field:'inprice', width:'10%', title: '进货价格',align:'center'},
            {field:'outprice', width:'10%', title: '销售价格',align:'center'},
            {field:'goodstypeuuid', width:'15%', title: '商品类型',align:'center',templet: function(row){//一行中的数据
                    var result='';
                    $.ajax({
                        url : path+'/goodsType/queryGoodsTypeSingle',
                        data : {uuid:row.goodstypeuuid},
                        dataType : 'json',
                        type : 'post',
                        async : false,
                        success : function (data) {
                            result=data.name;
                        }
                    });
                    return result;
                }},
            {field:'操作', width:'15%', title: '操作',align:'center',toolbar:'#crud'}
        ]],
    });
}

function queryGoodsType() {
    var name = $('#name').val();
    var origin = $('#origin').val();
    var PRODUCER = $('#PRODUCER').val();
    var goodsTypeId = $('#gtypeuuid option:selected').val();
    var url = path+'/goods/queryGoodsLikePager?1=1';

    if(null!=name && ''!=name){
        url+='&name='+name;
    }
    if(null!=origin && ''!=origin){
        url+='&origin='+origin;
    }
    if(null!=PRODUCER && ''!=PRODUCER){
        url+='&producer='+PRODUCER;
    }
    if(0!=goodsTypeId){
        url+="&goodstypeuuid="+goodsTypeId;
    }
    layui.table.reload("goodsTable", { //此处是上文提到的 初始化标识id
        url: url,
        page : {
            curr : 1
        }
    });
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

function add(){
    var addDiv = $('#addDiv').html();
    //弹出一个页面层
    layer.open({
        skin : 'layer-ext-Select',
        type: 1,
        area: ['700px', '440px'],
        shadeClose: true, //点击遮罩关闭
        content: addDiv,
        title : '新增商品分类'
    });
    initSelect(null,'goodstypeuuid');
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
    for(var i=0;i<result.length;i++){
        if(result[i].name==name){
            layer.msg('已有该商品名称');
            return;
        }
    }
    $.ajax({
        url : path+'/goods/addGoods',
        data : {name:name,origin1:origin,producer:producerl,unit:unit,inprice:inprice,outprice:outprice,goodstypeuuid:goodstypeuuid},
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
        }
    });
}

function del(uuid) {
    layer.confirm('确定执行删除操作嘛?', function(index){
        $.ajax({
            url : path+'/goods/delGoods',
            data : {uuid:uuid},
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
        area: ['700px' , '470px'],
        shadeClose: true, //点击遮罩关闭
        content: editDiv,
        title : '编辑商品信息'
    });
    initSelect(obj.goodstypeuuid,'goodstypeuuid');
    $("#goodstypeuuid2").find("option[value='"+obj.goodstypeuuid+"']").prop("selected",true);
    $('#uuid').val(obj.uuid);
    $('#name2').val(obj.name);
    $('#origin2').val(obj.origin);
    $('#PRODUCER2').val(obj.producer);
    $('#unit2').val(obj.unit);
    $('#inprice2').val(obj.inprice);
    $('#outprice2').val(obj.outprice);

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
            queryGoodsType();
            layer.close(index);
            // $('#ff1')[0].reset();
        }
    });
    return false;
}
