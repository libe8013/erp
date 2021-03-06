var path;
layui.use(['table','layer','jquery','form','laydate'],function () {
    layui.form.render();
    $ = layui.jquery;
    path = $('#path').val();
    var table = layui.table;
    intiTable(table);
    initdata();

    $(document).on('click','#queryInvrecord',function () {
        queryRegister();
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
        height:370,
        id:'InverecordTab',
        page:true,
        toolbar : '#toolbarTop',
        cols:[[
            {type:'checkbox',fixed:'left',width:'4%'},
            {field:'sname', width:'10%', title: '仓库',align:'center'},
            {field:'gname', width:'10%', title: '商品',align:'center'},
            {field:'stNum', width:'10%', title: '数量',align:'center'},
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
            {field:'state', width:'10%', title: '状态',align:'center',},
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
    //类型
    var type =  $('input[name="type"]:checked ').val()//获取选中的值
    if(type==1){
        type="盘盈";
    }else if(type==2){
        type="盘亏";
    }


    var url=path+'/stock/queryInventoryPager?1=1';
    if(null!=type && ''!=type && 0!=type){
        url+='&type='+type;
    }
    layui.table.reload("InverecordTab",{
        url:url
    });
}
