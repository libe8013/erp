var path;
var chart;
var datas=[];
layui.use(['jquery','form','layer','table','laydate'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    initDate();
    initHigcharts();
    $(document).on('click','#querySalesStat',function () {

        initHigcharts();
    });
    $('#btn_ICR').click(function(){
        location.href=$('#path').val()+'/statistic/jsp/salesTrend.jsp';
    });


    function initDate() {
        var laydate=layui.laydate;

        laydate.render({
            elem:'#endtime'
            ,type: 'year'
        });

    }




    function initHigcharts(){

        var endtime=$('#endtime').val();
        $.ajax({
            url:path+'/sales/salesStatMonth?1=1',
            data:{'endtime':endtime},
            dataType:'json',
            type:'post',
            async:false,
            success:function(data) {
                console.log(data)
                var da=data.data;
                if(data) {
                    for (var i = 0; i<da.length; i++) {
                        datas.push({
                            'name': da[i].endtime,
                            'y': da[i].money


                        })
                    }
                }


            }

        });


        chart = Highcharts.chart('container', {
            chart: {
                type: 'line'
            },
            title: {
                text: '各月份的销售额统计'
            },

            xAxis: {
                categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
            },
            yAxis: {
                title: {
                    text: '金额 元'
                }
            },
            plotOptions: {
                line: {
                    dataLabels: {
                        // 开启数据标签
                        enabled: true
                    },
                    // 关闭鼠标跟踪，对应的提示框、点击事件会失效
                    enableMouseTracking: false
                }
            },
            series: [{
                name: '金额',
                data:datas
            }]
        });
    }
});