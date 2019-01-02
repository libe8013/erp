var path;
layui.use(['jquery','form','layer','table','laydate'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    initDate();
    initTable();
    initSelect();

    $(document).on('click','#EmpQuery',function () {
        queryEmp();
    });
    layui.table.on('tool(empTab)',function (obj) {
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
        elem : '#empTable',
        id : 'empTable',
        toolbar : '#toolbarTop',
        height: 700,
        data : [],
        page: true, //开启分页
        cols: [[ //表头
            {type:'checkbox',width:'2%'},
           // {field:'uuid', width:'20%', title: '编号',align:'center'},
            {field:'username', width:'10%', title: '登陆名',align:'center'},
            {field:'name', width:'10%', title: '真实姓名',align:'center'},
            {field:'gender', width:'6%', title: '性别',align:'center'},
            {field:'email', width:'10%', title: 'email',align:'center'},
            {field:'tele', width:'10%', title: '电话',align:'center'},
            {field:'address', width:'8%', title: '地址',align:'center'},
            {field:'birthday', width:'10%', title: '出生年月日',align:'center',templet:function (obj) {
                    return createTime(obj.birthday);
                }},
            {field:'deptname', width:'10%', title: '部门',align:'center'},
            {field:'操作', width:'15%', title: '操作',align:'center',toolbar:'#crud'}
        ]],
    });
}


function createTime(v){
    var date = new Date(v);
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    m = m<10?'0'+m:m;
    var d = date.getDate();
    d = d<10?("0"+d):d;
    var h = date.getHours();
    h = h<10?("0"+h):h;
    var M = date.getMinutes();
    M = M<10?("0"+M):M;
    var str = y+"-"+m+"-"+d+" "+h+":"+M;
    return str;
}
function queryEmp() {

    var username = $('#username').val();
    var name = $('#name').val();
    var tele = $('#tele').val();
    var address = $('#address').val();
    var email = $('#email').val();
    var birthday=$('#birthday').val();
    var endtime=$('#endtime').val();

    var depuuid = $('#deptname option:selected').val();
    var gender=$('input[name="gender"]:checked').val();

    var url = path+'/emp/queryEmpListPager?1=1';


    if(null!=username && ''!=username){
        url+='&username='+username;
    }
    if(null!=name && ''!=name){
        url+='&name='+name;
    }
    if(null!=tele && ''!=tele){
        url+='&tele='+tele;
    }
    if(null!=address && ''!=address){
        url+='&address='+address;
    }
    if(null!=email && ''!=email){
        url+='&email='+email;
    }

    if(null!=endtime && ''!=endtime && ''!=birthday && null!=birthday){
        url+='&birthday='+birthday;
        url+='&endtime='+endtime;

    }

    if(null!=depuuid && null!=depuuid){
        url+='&depuuid='+depuuid;


    }
    if(null!=gender && ''!=gender){
        url+='&gender='+gender;


    }

    layui.table.reload("empTable", { //此处是上文提到的 初始化标识id
        url: url

    });
}



function initDate() {
    var laydate=layui.laydate;
    laydate.render({
        elem:'#birthday'
    });
    laydate.render({
        elem:'#endtime'
    });

}



//获取下拉框部门名称

function initSelect(){

    var form = layui.form;

    $.get(path + '/emp/queryDeptList',{}, function (data) {
        var deptname = "";  //定义要查询的内容
        if (data.data != null) {
            $.each(data.data, function (index, item) {
              //  console.log(item);
                if (item.uuid){
                    deptname += "<option  value='" + item.uuid + "'>" + item.name + "</option>";
                }else{
                    deptname += "<option value='" + item.uuid + "'>" + item.name + "</option>";
                }
            });
            $("select[name='deptname']").append(deptname);

            //append后必须从新渲染
            form.render('select');
        }
    });
}



function add(){

    //弹出一个iframe层
    layer.open({
        type: 2,
        title: '新增部门信息',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area : ['440px' , '480px'],
        content: path+'/personnel/jsp/addemp.jsp',
        success : function (layero,index) {

        }
    });
}


function edit(obj){

    //弹出一个iframe层
    layer.open({
        type: 2,
        title: '编辑员工信息',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area : ['440px' , '520px'],
        content: path+'/personnel/jsp/empEdit.jsp',
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
function del(uuid) {

    layer.confirm('确定删除该选项?', function(index){
        $.ajax({
            url : path+'/emp/delEmp',
            data : {uuid:uuid},
            dataType : 'json',
            type : 'post',
            async : false,
            success : function (data) {
                layer.close(index);
                layer.msg("删除成功");
                queryEmp();
            },
            error:function(result) {

            }
        });
    });
}


