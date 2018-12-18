var path;
layui.use(['table','form','layer','jquery'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    initTable();
    $(document).on('click','#goodsTypeQuery',function () {
        queryGoodsType();
    })
    $(document).on('click','#addForm',function () {
       addForm();
    });
    // $(document).on('click','#delButton',function () {
    //     var uuid = "";
    //
    // });
    layui.table.on('tool(goodsTypeTab)', function(obj){
        var data = obj.data;
        if(obj.event=="del"){
            delDiv(data.uuid);
        }else if(obj.event=="edit"){
            edit(data);
        }
    });

});


function initTable(){
    var table = layui.table;
        table.render({
            elem : '#goodsTypeTab',
            height: 600,
            toolbar : '#toolbarTop',
            id : 'goodsTypeTable',
            // url: '', //数据接口
            page: true, //开启分页
            cols: [[ //表头
                {type:'checkbox',width:'4%'},
                {field:'uuid', width:'23%', title: 'ID',align:'center'},
                {field:'name', width:'23%', title: '类型名称',align:'center'},
                {field:'操作', width:'50%', title: '操作',align:'center',toolbar: '#crud'}
            ]],
        });

}

function queryGoodsType() {
    var name = $('#name').val();
    var url = path+'/goodsType/queryGoodsTypePager';
    if(null!=name && ''!=name){
        url+='?name='+name;
    }
    layui.table.reload("goodsTypeTable", { //此处是上文提到的 初始化标识id
        url: url
    });
}

function add(){
    var addDiv = $('#addDiv').html();
    //弹出一个页面层
    layer.open({
        type: 1,
        area: ['440px', '150px'],
        shadeClose: true, //点击遮罩关闭
        content: addDiv,
        title : '新增商品分类'
    });
}

function addForm() {
    var result = [];
    $.ajax({
        url : path+'/goodsType/queryGoodsTypePager',
        data : {},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            result = data.data;
        }
    });
    var name = $('#gname').val();
    if(null==name || ''==name){
        layer.msg('类型名称不能为空');
        return;
    }

    for (var i=0;i<result.length;i++){
        if(result[i].name==name){
            layer.msg('类型名称重复');
            return;
        }
    }

    $.ajax({
        url : path+'/goodsType/addGoodsType',
        data : {name:name},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            layer.msg(data.message);
            queryGoodsType();
        },
        error:function(result) {

        }
    });
}

function delDiv(uuid) {
    layer.confirm('确定执行删除操作嘛?', function(index){
        $.ajax({
            url : path+'/goodsType/delGoodsType',
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
    var table = layui.table;
    var result = table.cache.goodsTypeTable;
    //弹出一个iframe层
    layer.open({
        type: 2,
        title: '编辑商品类型',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area : ['500px' , '270px'],
        content: path+'/basic/jsp/goodsTypeEdit.jsp',
        success : function (layero,index) {
            var body = layer.getChildFrame('body',index);
            var inputBody = body.find('input');
            for (var i=0;i<inputBody.length;i++){
                if(inputBody[i].id=="uuid"){
                    $(inputBody[i]).val(obj.uuid);
                }else if(inputBody[i].id=="name"){
                    $(inputBody[i]).val(obj.name);
                }
            }
        }
    });
}