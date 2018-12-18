var path;
layui.use(['jquery','form','layer','table'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    initTable();
    initSelect();
    custom_rule();
    $(document).on('click','#goodsQuery',function () {
        queryGoodsType();
    });
    $(document).on('submit','#ff',function () {
        addForm();
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
            {field:'uuid', width:'18%', title: 'ID',align:'center'},
            {field:'name', width:'10%', title: '商品名称',align:'center'},
            {field:'origin', width:'8%', title: '产地',align:'center'},
            {field:'producer', width:'13%', title: '厂家',align:'center'},
            {field:'unit', width:'8%', title: '计量单位',align:'center'},
            {field:'inprice', width:'8%', title: '进货价格',align:'center'},
            {field:'outprice', width:'8%', title: '销售价格',align:'center'},
            {field:'goodstypeuuid', width:'10%', title: '商品类型',align:'center'},
            {field:'操作', width:'15%', title: '操作',align:'center',toolbar:'#crud'}
        ]],
    });
}

function queryGoodsType() {
    var name = $('#name').val();
    var origin = $('#origin').val();
    var PRODUCER = $('#PRODUCER').val();
    var goodsTypeId = $('#goodstypeuuid option:selected').val();
    var url = path+'/goods/queryGoodsLikePager?1=1';

    if(null!=name && ''!=name){
        url+='&name='+name;
    }
    if(null!=origin && ''!=origin){
        url+='&origin='+origin;
    }
    if(null!=PRODUCER && ''!=PRODUCER){
        url+='&PRODUCER='+PRODUCER;
    }
    if(0!=goodsTypeId){
        url+="&goodstypeuuid="+goodsTypeId;
    }

    layui.table.reload("goodsTable", { //此处是上文提到的 初始化标识id
        url: url
    });
}

function initSelect(){
    var form = layui.form;
    // alert();
    $.get(path + '/goodsType/queryGoodsTypePager', {}, function (data) {
        var goodsType = "";
        if (data.data != null) {
            $.each(data.data, function (index, item) {
                    if (item.uuid){
                        goodsType += "<option class='generate' value='" + item.uuid + "'>" + item.name + "</option>";
                    }else{
                        goodsType += "<option value='" + item.uuid + "'>" + item.name + "</option>";
                    }
            });
            $("select[name='goodstypeuuid']").append(goodsType);
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
    initSelect();
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
            layer.msg('商品名称不能为空');
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
    // var table = layui.table;
    // var result = table.cache.goodsTable;
    // console.log(result);
    //弹出一个iframe层
    layer.open({
        type: 2,
        title: '编辑商品信息',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area : ['700px' , '470px'],
        content: path+'/basic/jsp/goodsEdit.jsp',
        success : function (layero,index) {
            var body = layer.getChildFrame('body',index);
            var inputBody = body.find('input');
            $.each(obj, function(j) {
                for (var i=0;i<inputBody.length;i++){
                    if(inputBody[i].id==j){
                        $(inputBody[i]).val(obj[j]);
                    }
                }
            });
        }
    });
}