var path;
layui.use(['tree','element','jquery'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    initTree();
})

function initTree(){
    var treeJson=[];
    $.ajax({
        url : '/erp/authority/queryModuleLike',
        data : {},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data){
            treeJson=data;
        }
    });
    layui.tree({
        elem : '#tree',
        skin : 'sidebar',
        nodes : treeJson
    });
}

function initTab(text,url,id) {

    var element = layui.element;


    if ( $(".layui-tab-title li[lay-id="+id+"]").length > 0 ) {
        //切换到指定Tab项
        element.tabChange('demo', id);
        //已经存在
        return;
    }
    element.tabAdd("demo",{
        title:text+'<i class="layui-icon layui-unselect layui-tab-close">&#x1006;</i>',
        content : "<iframe frameborder='0' src='"+"/erp"+"/"+url+"' scrolling='auto' style='width:100%;height:100%;'></iframe>",
        id : id
    });

    //切换到指定Tab项
    element.tabChange('demo', id);

    //增加点击关闭事件  
    var r = $(".layui-tab-title").find("li");
    //每次新打开tab都是最后一个，所以只对最后一个tab添加点击关闭事件  
    r.eq(r.length - 1).children("i").on("click", function () {
        element.tabDelete("demo", $(this).parent("li").attr('lay-id'));
    }), element.tabChange("demo", r.length - 1);

}