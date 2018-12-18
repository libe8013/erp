var path;
layui.use(['form','jquery','layer'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    $(document).on('click','#editGoodsType',function () {
        editGoodsType();
    })
});

function editGoodsType(){
    var table = window.parent.layui.table;
    var result = table.cache.goodsTypeTable;
    var uuid = $('#uuid').val();
    var name = $('#name').val();
    if(null==name || ''==name){
        layer.msg('类型名称不能为空');
        return;
    }

    for (var i=0;i<result.length;i++){
        if(result[i].name==name){
            layer.msg('类型名称重复');
            return;
        }
    }

    $.ajax({
        url : path+'/goodsType/editGoodsType',
        data : {uuid:uuid,name:name},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data) {
            layer.msg(data.message);
            window.parent.queryGoodsType();
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
        },
        error:function(result) {

        }
    });

}