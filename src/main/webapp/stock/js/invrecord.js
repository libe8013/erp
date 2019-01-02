var path;
layui.use(['table','layer','jquery','form','laydate'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    var table = layui.table;
    intiTable(table);
    initSelect(path+"/emp/queryEmp",{},'empName');
    initSelect(path+"/store/queryStoreLikePager",{},'sname');
    initSelect(path+"/goods/queryGoodsLikePager",{},'gname');
    $(document).on('click','#Query',function () {
        queryRecord(table);
    })
});

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

//初始化表格
function intiTable(table) {
    table.render({
        elem:'#queryRecord',
        height:600,
        id:'recordsTable',
        url : '',
        page:true,
        cols:[[
            {type:'checkbox',fixed:'left',width:'4%'},
            {field:'empName', width:'15%', title: '员工',align:'center'},
            {field:'opertime', width:'15%', title: '操作时间',align:'center',
                templet:function (row) {
                    return createTime(row.opertime);
                }},
            {field:'sname', width:'15%', title: '仓库名称',align:'center'},
            {field:'gname', width:'15%', title: '商品名称',align:'center'},
            {field:'num', width:'15%', title: '数量',align:'center'},
            {field:'type', width:'15%', title: '类型',align:'center'},
        ]]
    })
}

function queryRecord(table) {
    var empName = $('#empName option:selected').val();
    var sname = $('#sname option:selected').val();
    var gname = $('#gname option:selected').val();
    var type = $('#type option:selected').val();

    var url=path+'/stock/queryRecordsPager?1=1';

    if (0!=empName){
        url+="&empName="+empName
    }
    if (0!=sname){
        url+="&sname="+sname
    }
    if (0!=gname){
        url+="&gname="+gname
    }
    if (0!=type){
        url+="&type="+type
    }
    table.reload('recordsTable',{
        url:url
    });
}



//时间控件
function initdata() {
    layui.laydate.render({
        elem: '#czbeg'
    });
    layui.laydate.render({
        elem: '#czend'
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
