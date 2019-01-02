var path;
var chart;
var datas=[];
layui.use(['jquery','form','layer','table','laydate'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    initDate();
    initHigcharts();
    $(document).on('click','#querySalesStat',function () {
        datas=[];
        initHigcharts();

    });
    $('#btn_ICR').click(function(){
        location.href=$('#path').val()+'/statistic/jsp/salesStat.jsp';
    });

});
function initDate() {
    var laydate=layui.laydate;
    laydate.render({
        elem:'#starttime'
    });
    laydate.render({
        elem:'#endtime'
    });

}

function initHigcharts(){
    var starttime=$('#starttime').val();
    var endtime=$('#endtime').val();
    $.ajax({
        url:path+'/sales/salesStat?1=1',
        data:{'starttime':starttime,'endtime':endtime},
        dataType:'json',
        type:'post',
        async:false,
        success:function(data) {
            console.log(data);
            var da=data.data;
            if (data){

                for(var i=0;i<da.length;i++){

                    datas.push({
                        'name':da[i].typename,
                        'y':da[i].totalmoney

                    })
                }
            }

        }

    });


    chart =Highcharts.chart('container', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: '销售额统计分析'
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
            }
        }
    },
    series: [{
        name: 'Brands',
        colorByPoint: true,
        data: datas
    }]
});
}