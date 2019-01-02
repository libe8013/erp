var path;
layui.use(['jquery','form','layer','table','laydate'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    initDate();
    initTable();


    $(document).on('click','#querySalesStat',function () {
        querySalesStat();
    });
    $('#btn_ICR').click(function(){

        location.href=$('#path').val()+'/statistic/jsp/HighchSalesTrend.jsp?';
    });


});


function initDate() {
    var laydate=layui.laydate;
    laydate.render({
        elem:'#endtime'
        ,type: 'year'
    });

}

function initTable(){
    var table = layui.table;

    table.render({
        elem : '#salesTable',
        id : 'salesTable',
        toolbar : '#salesTab',
        height: 700,
        data : [],
        page: true, //开启分页
        cols: [[ //表头
            {type:'checkbox',width:'2%'},
            // {field:'uuid', width:'20%', title: '编号',align:'center'},
            {field:'months', width:'10%', title: '月份',align:'center'},
            {field:'money', width:'10%', title: '金额',align:'center'},
          ]]
    });
}


function querySalesStat() {

    var endtime=$('#endtime').val();

    var url = path+'/sales/salesStatMonth?1=1';

    if(null!=endtime && ''!=endtime ){
        url+='&endtime='+endtime;
    }




    // alert(url)
    layui.table.reload("salesTable", { //此处是上文提到的 初始化标识id
        url: url

    });
}
