var path;
var index;
layui.use(['jquery','form','layer','table'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    custom_rule();
    initTable();
    initSelect(null,"empuuid");
    $(document).on('click','#storeQuery',function () {
       queryStore();
    });
    layui.form.on('submit(addStore)',function (obj) {
        var data = obj.field;
        addForm(data);
        return false;
    })
    layui.table.on('tool(storeTab)',function (obj) {
        var data = obj.data;
        if(obj.event=='edit'){
            edit(data);
        }else if(obj.event=='del'){
            del(data.uuid);
        }
    });
    layui.form.on('submit(editStore)',function (obj) {
        var data = obj.field;
        editForm(data);
        return false;
    })
    // $(document).on('click','#addButton',function () {
    //     addForm();
    // });
    // layui.table.on('tool(supplierTab)',function (obj) {
    //     var data = obj.data;
    //     if(obj.event=="del"){
    //         del(data.uuid);
    //     }else if(obj.event=="edit"){
    //         edit(obj);
    //     }
    // });
    // $(document).on('click','#editButton',function () {
    //     editForm();
    // });
});

function initTable(){
    var table = layui.table;
    table.render({
        elem : '#storeTable',
        id : 'storeTable',
        toolbar : '#toolbarTop',
        height: 600,
        data : [],
        page: true, //开启分页
        cols: [[ //表头
            {type:'checkbox',width:'3%'},
            // {field:'uuid', width:'18%', title: '编号',align:'center'},
            {field:'name', width:'10%', title: '名称',align:'center'},
            {field:'address', width:'15%', title: '地址',align:'center'},
            {field:'empuuid', width:'13%', title: '仓库管理员',align:'center',
                templet:function (row) {
                    var result='';
                    $.ajax({
                        url : path+'/emp/querySingleEmp',
                        data : {uuid:row.empuuid},
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
    // alert();
    $.get(path + '/emp/queryEmpStoreRole', {id:'37f82c85039311e9899800e04c824916'}, function (data) {
        var goodsType = "";
        if (data != null) {
            $.each(data, function (index, item) {
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


function add(){
    var addDiv = $('#addDiv').html();
    //弹出一个页面层
    layer.open({
        skin : 'layer-ext-Select',
        type: 1,
        area: ['700px', '260px'],
        shadeClose: true, //点击遮罩关闭
        content: addDiv,
        title : '新增仓库'
    });
    initSelect(null,'empuuid2');
}

function addForm(data) {
    var result = [];
    var data = data;
    $.ajax({
        url : path+'/store/queryStoreLikePager',
        data : {},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            result = data.data;
        }
    });

    if(null==data.name || ''==data.name){
        layer.msg('仓库名不能为空');
        return;
    }
    for(var i=0;i<result.length;i++){
        if(result[i].name==data.name){
            layer.msg('已有该名称的仓库');
            return;
        }
    }
    $.ajax({
        url : path+'/store/addStore',
        data : data,
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            layer.msg(data.message);
            queryStore();
            $('#addFF')[0].reset();
        },
        error : function(result){
        }
    });
}

function del(uuid) {
    layer.confirm('确定执行删除操作嘛?', function(index){
        $.ajax({
            url : path+'/store/delStore',
            data : {uuid:uuid},
            dataType : 'json',
            type : 'post',
            async : false,
            success : function (data) {
                // layer.close(index);
                layer.msg(data.message);
                queryStore();
            },
            error:function(result) {

            }
        });
    });
}

function edit(obj){
    var data = obj;
    var editDiv = $('#editDiv').html();
    //弹出一个页面层
    index = layer.open({
        skin : 'layer-ext-Select',
        type: 1,
        area: ['500px' , '360px'],
        shadeClose: true, //点击遮罩关闭
        content: editDiv,
        title : '编辑供应商信息'
    });
    initSelect(data.empuuid,'empuuidEdit');
    layui.form.val("editForm",data);

}


function editForm(data) {
    var result = [];
    var arr = {};
    $.ajax({
        url : path+'/store/queryStoreLikePager',
        data : {},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            result = data.data;
        }
    });

    var data = data;

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
        url : path+'/store/editStore',
        data : data,
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            layer.msg(data.message);
            queryStore();
            layer.close(index);
            // $('#ff1')[0].reset();
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
        ,empuuid: function (value) {
            if(value==0){
                return "请选择库管员";
            }
        }
    });
}