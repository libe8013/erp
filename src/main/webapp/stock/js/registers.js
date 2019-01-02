var path;
layui.use(['table','layer','jquery','form','laydate'],function () {
    layui.form.render();
    $ = layui.jquery;
    path = $('#path').val();
    var table = layui.table;
    intiTable(table);
    initdata();
    custom_rule();
    $(document).on('click','#queryInvrecord',function () {
        queryRegister();
    });
    layui.form.on('submit(addForm)',function (obj) {
        var data = obj.field;
        $.ajax({
            url : path+'/stock/addnventory',
            data : data,
            dataType : 'json',
            type : 'post',
            async : false,
            success : function (data) {
                layer.close(layer.index);
                layer.msg(data.message);
                queryRegister();
            }
        });
    });
});

function initdata() {
    layui.laydate.render({
        elem: '#djbeg'
    });
    layui.laydate.render({
        elem: '#djend'
    });
    layui.laydate.render({
        elem: '#shbeg'
    });
    layui.laydate.render({
        elem: '#shend'
    });
}


//初始化表格
function intiTable(table) {
    table.render({
        elem:'#InverecordTab',
        height:600,
        id:'InverecordTab',
        page:true,
        toolbar : '#toolbarTop',
        cols:[[
            {type:'checkbox',fixed:'left',width:'4%'},
            {field:'sname', width:'10%', title: '仓库',align:'center'},
            {field:'gname', width:'10%', title: '商品',align:'center'},
            // {field:'stNum', width:'10%', title: '数量',align:'center'},
            {field:'num', width:'10%', title: '数量',align:'center'},
            {field:'type', width:'10%', title: '类型',align:'center'},
            {field:'createtime', width:'10%', title: '登录日期',align:'center',templet:function (obj) {
                    return createTime(obj.createtime);
                }},
            {field:'checktime', width:'10%', title: '审核日期',align:'center',templet:function (obj) {
                    if(obj.checktime!=null && obj.checktime!="" && obj.checktime!=undefined){
                        return createTime(obj.checktime);
                    }else{
                        return "";
                    }
                }},
            {field:'ename', width:'10%', title: '登记人',align:'center'},
            {field:'checker', width:'10%', title: '审核人',align:'center'},
            {field:'state', width:'10%', title: '状态',align:'center'},
        ]],
    });
}

//下拉列表
function initSelect(url,data,htmlid) {
    var form = layui.form;
    $.get(url,data,function (data) {
        var empType="";
        if(data.data==undefined){
            if (data !=null){
                $.each(data,function (index,item) {
                    empType += "<option class='generate' value='" + item.uuid + "'>" + item.name + "</option>"
                });
            }
        }else{
            if (data.data !=null){
                $.each(data.data,function (index,item) {
                    empType += "<option class='generate' value='" + item.uuid + "'>" + item.name + "</option>"
                });
            }
        }
        $("select[name ='"+htmlid+"']").append(empType);

        //渲染
        form.render('select');
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

//遍历表格数据
function queryRegister() {
    // 登记时间
    var djbeg = $('#djbeg').val();
    var djend = $('#djend').val();
    if (null!=createtime && ''!=createtime || null!=djend && ''!=djend){
        djbeg=djbeg
        djend=djend
    }
    if (null!=shbeg && ''!=shbeg || null!=shend && ''!=shend){
        shbeg=shbeg
        shend=shend

    }
    // 审核时间
    var shbeg = $('#shbeg').val();
    var shend = $('#shend').val();
    var url=path+'/stock/queryInventoryPager?1=1';

    //类型
    var type =  $('input[name="type"]:checked ').val()//获取选中的值
    if(type==1){
        type="盘盈";
    }else if(type==2){
        type="盘亏";
    }


    if(null!=type && ''!=type && 0!=type){
        url+='&type='+type;
    }
    layui.table.reload("InverecordTab",{
        url:url
    });
}

//点击添加按钮弹出页面
function add() {
    var addDiv = $('#addDiv').html();
    //弹出一个页面
    layer.open({
        skin : 'layer-ext-Select',
        type:1,
        area: ['440px', '350px'],
        shadeClose: true, //点击遮罩关闭
        content: addDiv,
        title : '盘盈盘亏登记',
        success : function () {
            layui.form.render();
            initSelect(path+"/store/queryStoreLikePager",{},'storeuuid');
            initSelect(path+"/goods/queryGoodsLikePager",{},'goodsuuid');
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
        ,goodsuuid: function (value) {
            if(value==0){
                return "请选择商品";
            }
        },num : function (value) {
            if(value==0 || value=="" || value==null){
                return "请输入数量";
            }
        }
    });
}