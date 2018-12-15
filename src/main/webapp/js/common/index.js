layui.use('tree',function () {
    initTree();
})

function initTree(){
    layui.tree({
        elem : '#tree',
        skin : 'sidebar',
        nodes : [{
            name : 'id-0',
            children : [{
                name : 'id-01'
            }, {
                name: 'id-02'
            }]
        },{
            name : 'id-1',
            children : [{
                name : 'id-11'
            },{
                name : 'id-12'
            }]
        }]
    });
}