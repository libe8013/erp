var path;
var xtree;
var rid;
layui.use(['table','layer','jquery','tree','form'],function () {
    var table=layui.table;
    path = $('#path').val();
    intiTable(table);
    queRoleMoudle();
    XTree();

    $(document).on('click','#save',function () {
        // if()
        saveAuth();
    })



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
            {field:'id', width:'96%', hide:true,align:'center'},
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
        xtree = new layuiXtree({
            elem: 'demo1' //放xtree的容器（必填，只能为id，注意不带#号）
            , form: form              //layui form对象 （必填）
            ,checked:true
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
            },click: function (data) {  //节点选中状态改变事件监听，全选框有自己的监听事件
                var s=xtree.GetChecked();//获取选中的节点
                //遍历选中的节点
                for(var a=1;a<s.length;a++){
                   console.log(s[a].checked);
               }
                  form.render();
            }
        });
    layui.table.on('row(AuthTab)', function(obj){
        rid = obj.data.id;
        var tree=xtree.GetAllCheckBox();
        for (var a=0;a<tree.length;a++) {
            tree[a].checked=false;
        }
        $.ajax({
            url:path+'/roleModule/queryRoleModule',
            data:{roleid:rid},
            dataType:'json',
            type:'post',
            asyns:false,
            success:function (data) {
                var rue = data.data;
                for (var a=0;a<tree.length;a++) {
                    for (var i = 0; i < rue.length; i++) {
                        if (tree[a].value == rue[i].value) {
                            console.log(tree[a].checked);
                            tree[a].checked = true;

                        } else if (tree[a].value == "-1") {
                            tree[a].checked = true;

                        }
                    }
                }
                form.render();
            },error:function (success) {
                alert(111);
            }
        });
    });

}


function saveAuth() {
    var arr=new Array();
    var all = xtree.GetAllCheckBox();
    for(var i=0;i<all.length;i++){
        if(all[i].checked==true){
            arr.push(all[i].value);
        }
    }
    var arrJson = JSON.stringify(arr);
    $.ajax({
        url:path+'/roleModule/saveRoleMoudle',
        data:{arrJson:arrJson,roleid:rid},
        dataType:'json',
        type:'post',
        asyns:false,
        success:function (data) {
            var rue = data.message
            layer.msg(rue);
        }
    });
    var s=xtree.GetAllCheckBox();//获取所以节点
    s.checked=false;
    xtree.render();
}





