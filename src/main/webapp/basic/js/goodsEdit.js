var path;
layui.use(['form','jquery','layer'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    initSelect();
    $(document).on('click','#editGoods',function () {
        editGoods();
    })
});

function editGoods(){
    // var table = window.parent.layui.table;
    // var result = table.cache.goodsTable;
    // var uuid = $('#uuid').val();
    // var name = $('#name').val();
    // if(null==name || ''==name){
    //     layer.msg('类型名称不能为空');
    //     return;
    // }
    //
    // for (var i=0;i<result.length;i++){
    //     if(result[i].name==name){
    //         layer.msg('类型名称重复');
    //         return;
    //     }
    // }
    //
    // $.ajax({
    //     url : path+'/goods/editGoods',
    //     data : {uuid:uuid,name:name},
    //     dataType : 'json',
    //     type : 'post',
    //     async : false,
    //     success : function (data) {
    //         layer.msg(data.message);
    //         window.parent.queryGoodsType();
    //         var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    //         parent.layer.close(index);
    //     },
    //     error:function(result) {
    //
    //     }
    // });

}

function initSelect(){
    var form = layui.form;
    // alert();
    $.get(path + '/goodsType/queryGoodsTypePager', {}, function (data) {
        var goodsType = "";
        if (data.data != null) {
            $.each(data.data, function (index, item) {
                console.log(item);
                if (item.uuid){
                    goodsType += "<option class='generate' value='" + item.uuid + "'>" + item.name + "</option>";
                }else{
                    goodsType += "<option value='" + item.uuid + "'>" + item.name + "</option>";
                }
            });
            $("select[name='goodstypeuuid']").append(goodsType);
            //反选
            // $("select[name='???']").val($("#???").val());
            //append后必须从新渲染
            form.render('select');
        }
    });
}