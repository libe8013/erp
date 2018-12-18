var path;
layui.use(['tree','element','jquery'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    initTree();
})

function initTree(){
    var tree='[{';
    $.ajax({
        url : '/erp/authority/queryModuleLike',
        data : {pid:-1},
        dataType : 'json',
        type : 'post',
        async : false,
        success : function (data){
            for (var i=0;i<data.length;i++) {
                tree+='"name": "'+data[i].text+'",';
                tree+='"children": [';
                $.ajax({
                    url : '/erp/authority/queryModuleLike',
                    data : {pid:data[i].id},
                    dataType : 'json',
                    type : 'post',
                    async : false,
                    success : function (data1){
                        var arr  = data1.length;
                        var j = 0;
                        while (true){
                            tree+="{";
                            if(j>=arr){
                                // tree+="]";
                                break
                            };
                            tree+='"name":"'+data1[j].text+'",';
                            // tree+='"href":"'+data1[j].url+'",';
                            tree+='"href":"javascript:initTab(&quot;'+data1[j].text+'&quot;,&quot;'+data1[j].url+'&quot;,&quot;'+data1[j].id+'&quot;)"';
                            tree+="},";
                            j+=1;
                        }
                    }
                });
                tree = tree.substring(0,tree.length-2);
                tree+="]},";
                tree+="{";
            }
        }
    });
    tree = tree.substring(0,tree.length-2);
    tree+=']';
    var treeJSON = JSON.parse(tree);
    layui.tree({
        elem : '#tree',
        skin : 'sidebar',
        nodes : treeJSON
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