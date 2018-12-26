var path;
var layuiXtree;
layui.use(['table','layer','jquery','tree','form'],function () {
    var table=layui.table;
    path = $('#path').val();
    intiTable(table);
    queRoleMoudle();
    XTree();
});

//监听行单击事件
layui.table.on('row(AuthTab)', function(obj){
    console.log(obj.tr) //得到当前行元素对象
    console.log(obj.data) //得到当前行数据
});




function intiTable(table) {
    table.render({
        elem:'#roleAuth',
        height:395,
        id:'AuthTab',
        url : '',
        page:true,
        cols:[[
            {type:'checkbox',fixed:'left',width:'4%'},
            {field:'rolename', width:'96%', title: '角色名称',align:'center'},
        ]],
    })
}

//查询角色列表
function queRoleMoudle() {
    var rolename = $('#rolename').val();
    var url=path+'/authorityrole/queryRole?1=1';
    layui.table.reload('AuthTab',{
        url:url
    });
}






// //初始化XTree
function XTree() {
        var form = layui.form;
        var xtree = new layuiXtree({
            elem: 'demo1' //放xtree的容器（必填，只能为id，注意不带#号）
            , form: form              //layui form对象 （必填）
            , data: path+'/authority/queryModuleAll'              //数据，结构请参照下面 （必填）
            , isopen: false      //初次加载时全部展开，默认true （选填）
            , color: {       //三种图标颜色，独立配色，更改几个都可以
                open: "#EE9A00"        //节点图标打开的颜色
                , close: "#EEC591"     //节点图标关闭的颜色
                , end: "#828282"       //末级节点图标的颜色
            }
            , icon: {                   //图标样式 （选填）
                open: "&#xe623"       //节点打开的图标
                , close: "&#xe623"    //节点关闭的图标
                , end: "&#xe623"      //末尾节点的图标
            }
        });
    // var oCks = xtree.GetAllChecked(); //获取全部选中的末级节点checkbox对象，返回的为Array
    // console.log(oCks);
    // for (var i = 0; i < oCks.length; i++) {
    //     console.log(oCks[i].value);
    // }
    // xtree.render('checkbox');
}






