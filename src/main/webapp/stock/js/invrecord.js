var path;
layui.use(['table','layer','jquery','form'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    var table = layui.table;
    intiTable(table);
    $(document).on('click','#Query',function () {
        queryRecord(table);
    })
});

//初始化表格
function intiTable(table) {
    table.render({
        elem:'#queryRecord',
        height:312,
        id:'recordsTable',
        url : '',
        page:true,
        cols:[[
            {type:'checkbox',fixed:'left',width:'4%'},
            {field:'empName', width:'17%', title: '员工',align:'center'},
            {field:'opertime', width:'17%', title: '操作时间',align:'center'},
            {field:'sname', width:'17%', title: '仓库名称',align:'center'},
            {field:'gname', width:'17%', title: '商品名称',align:'center'},
            {field:'num', width:'17%', title: '数量',align:'center'},
            {field:'type', width:'17%', title: '类型',align:'center'},
        ]]
    })
}

function queryRecord(table) {
    var empName = $('#empName option:selected').val();
    var sname = $('#sname option:selected').val();
    var gname = $('#gname option:selected').val();
    var type = $('#type option:selected').val();

    if (0!=empName){
        url+="&empName="+empName
    }
    if (0!=sname){
        url+="&sname="+sname
    }
    if (0!=gname){
        url+="&gname"+gname
    }
    if (0!=type){
        url+="&type"+type
    }

    var url=path+'/stock/queryRecordsPager?1=1';
    table.reload('recordsTable',{
        url:url
    });
}



//时间控件
/*function initDate() {
    laydate.render({
        elem: '#czbeg'
        ,format: 'yyyy年MM月dd日'
    });
}*/


//下拉列表
/*function initSelect() {
    var form = layui.form;
    $.get(path+'/stock/',{},function (data) {
        var empType="";
            if (data.data !=null){
                $.each(data.data,function (index,item) {
                        console.log(item);
                        if (item.empName){
                            empName += "<option class='generate' value='" + item.empName + "'> + item.empName + "</option>"
                        }else{
                            empName += "<opyion value='"+item.empName+ ">'" + item.empName + "</option>"
                        }
                    });
            }
            $("select[name ='empName']").append(empType);

            //渲染
            form.render('select');
    });
}*/
