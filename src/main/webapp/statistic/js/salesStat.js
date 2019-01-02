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

        location.href=$('#path').val()+'/statistic/jsp/HighchSalesStat.jsp?';
    });

});
function initTable(){
    var table = layui.table;
    table.render({
        elem : '#salesTable',
        id : 'salesTable',
        toolbar : '#toolbarTop',
        height: 700,
        data : [],
        page: true, //开启分页
        cols: [[ //表头
            {type:'checkbox',width:'2%'},
            {field:'typename', width:'10%', title: '商品类型',align:'center'},
            {field:'totalmoney', width:'10%', title: '总金额',align:'center'}
        ]],
    });
}

function initDate() {
    var laydate=layui.laydate;
    laydate.render({
        elem:'#starttime'
    });
    laydate.render({
        elem:'#endtime'
    });

}

function querySalesStat() {
    var starttime=$('#starttime').val();
    var endtime=$('#endtime').val();

    var url = path+'/sales/salesStat?1=1';

    if(null!=endtime && ''!=endtime && ''!=starttime && null!=starttime){
        url+='&starttime='+starttime;
        url+='&endtime='+endtime;
    }




    // alert(url)
    layui.table.reload("salesTable", { //此处是上文提到的 初始化标识id
        url: url

    });
}
