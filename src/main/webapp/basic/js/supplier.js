var path;
var index;
layui.use(['jquery','form','layer','table'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    initTable();
    $(document).on('click','#supplierQuery',function () {
       querySupplier();
    });
    $(document).on('click','#addButton',function () {
        addForm();
    });
    layui.table.on('tool(supplierTab)',function (obj) {
        var data = obj.data;
        if(obj.event=="del"){
            del(data.uuid);
        }else if(obj.event=="edit"){
            edit(obj);
        }
    });
    $(document).on('click','#editButton',function () {
        editForm();
    });
});

function initTable(){
    var table = layui.table;
    table.render({
        elem : '#supplierTable',
        id : 'supplierTable',
        toolbar : '#toolbarTop',
        height: 600,
        data : [],
        page: true, //开启分页
        cols: [[ //表头
            {type:'checkbox',width:'3%'},
            {field:'uuid', width:'18%', title: '编号',align:'center'},
            {field:'name', width:'10%', title: '名称',align:'center'},
            {field:'address', width:'15%', title: '地址',align:'center'},
            {field:'contact', width:'13%', title: '联系人',align:'center'},
            {field:'tele', width:'10%', title: '电话',align:'center'},
            {field:'email', width:'18%', title: 'Email',align:'center'},
            {field:'操作', width:'15%', title: '操作',align:'center',toolbar:'#crud'}
        ]],
    });
}

function querySupplier() {
    var name = $('#name').val();
    var address = $('#address').val();
    var contact = $('#contact').val();
    var tele = $('#tele').val();
    var email = $('#email').val();
    var url = path+'/supplier/querySupplierLikePager?1=1';

    if(null!=name && ''!=name){
        url+='&name='+name;
    }
    if(null!=address && ''!=address){
        url+='&address='+address;
    }
    if(null!=contact && ''!=contact){
        url+='&contact='+contact;
    }
    if(null!=tele && ''!=tele){
        url+='&tele='+tele;
    }
    if(null!=email && ''!=email){
        url+='&email='+email;
    }

    layui.table.reload("supplierTable", { //此处是上文提到的 初始化标识id
        url: url
    });
}


function add(){
    var addDiv = $('#addDiv').html();
    //弹出一个页面层
    layer.open({
        skin : 'layer-ext-Select',
        type: 1,
        area: ['700px', '340px'],
        shadeClose: true, //点击遮罩关闭
        content: addDiv,
        title : '新增供应商'
    });
}

function addForm() {
    var result = [];
    $.ajax({
        url : path+'/supplier/querySupplierLikePager',
        data : {},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            result = data.data;
        }
    });

    var name = $('#name1').val();
    var address = $('#address1').val();
    var contact = $('#contact1').val();
    var tele = $('#tele1').val();
    var email = $('#email1').val();
    if(null==name || ''==name){
        layer.msg('名称不能为空');
        return;
    }
    for(var i=0;i<result.length;i++){
        if(result[i].name==name){
            layer.msg('已有该名称的供应商');
            return;
        }
    }
    $.ajax({
        url : path+'/supplier/addSupplier',
        data : {name:name,address:address,contact:contact,tele:tele,email:email},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            layer.msg(data.message);
            querySupplier();
            $('#ff')[0].reset();
        },
        error : function(result){
            console.log(result);
        }
    });
    return false;
}

function del(uuid) {
    layer.confirm('确定执行删除操作嘛?', function(index){
        $.ajax({
            url : path+'/supplier/delSupplier',
            data : {uuid:uuid},
            dataType : 'json',
            type : 'post',
            async : false,
            success : function (data) {
                // layer.close(index);
                layer.msg(data.message);
                querySupplier();
            },
            error:function(result) {

            }
        });
    });
}

function edit(obj){
    var obj = obj.data;
    var editDiv = $('#editDiv').html();
    //弹出一个页面层
    index = layer.open({
        skin : 'layer-ext-Select',
        type: 1,
        area: ['700px' , '450px'],
        shadeClose: true, //点击遮罩关闭
        content: editDiv,
        title : '编辑供应商信息'
    });
    $('#uuid').val(obj.uuid);
    $('#name2').val(obj.name);
    $('#address2').val(obj.address);
    $('#contact2').val(obj.contact);
    $('#tele2').val(obj.tele);
    $('#email2').val(obj.email);

}


function editForm() {
    var result = [];
    var arr = {};
    $.ajax({
        url : path+'/supplier/querySupplierLikePager',
        data : {},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            result = data.data;
        }
    });

    var uuid = $('#uuid').val();
    var name = $('#name2').val();
    var address = $('#address2').val();
    var contact = $('#contact2').val();
    var tele = $('#tele2').val();
    var email = $('#email2').val();

    var data = {uuid:uuid,name:name,address:address,contact:contact,tele:tele,email:email};

    for(var i=0;i<result.length;i++){
        if(result[i].uuid==uuid){
            arr = result[i];
            break;
        }
    }

    if(arr.name!=data.name){
        for(var i=0;i<result.length;i++){
            if(result[i].name==name){
                layer.msg('已有该商品名称');
                return;
            }
        }
    }

    $.ajax({
        url : path+'/supplier/editSupplier',
        data : data,
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            layer.msg(data.message);
            querySupplier();
            layer.close(index);
            // $('#ff1')[0].reset();
        }
    });
    return false;
}
