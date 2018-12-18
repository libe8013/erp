var path;
layui.use(['jquery','form','layer','table'],function () {
    $ = layui.jquery;
    path = $('#path').val();
    initTable();
    initSelect();
    $(document).on('click','#goodsQuery',function () {
        queryGoodsType();
    });
});

function initTable(){
    var table = layui.table;
    table.render({
        elem : '#goodsTable',
        id : 'goodsTable',
        toolbar : '#toolbarTop',
        height: 600,
        url : '',
        page: true, //开启分页
        cols: [[ //表头
            {type:'checkbox',width:'2%'},
            {field:'uuid', width:'18%', title: 'ID',align:'center'},
            {field:'name', width:'10%', title: '商品名称',align:'center'},
            {field:'origin', width:'8%', title: '产地',align:'center'},
            {field:'producer', width:'13%', title: '厂家',align:'center'},
            {field:'unit', width:'8%', title: '计量单位',align:'center'},
            {field:'inprice', width:'8%', title: '进货价格',align:'center'},
            {field:'outprice', width:'8%', title: '销售价格',align:'center'},
            {field:'goodstypeuuid', width:'10%', title: '商品类型',align:'center'},
            {field:'操作', width:'15%', title: '操作',align:'center',toolbar:'#crud'}
        ]],
    });
}

function queryGoodsType() {
    var name = $('#name').val();
    var origin = $('#origin').val();
    var PRODUCER = $('#PRODUCER').val();
    var goodsTypeId = $('#goodstypeuuid option:selected').val();
    var url = path+'/goods/queryGoodsLikePager?1=1';

    if(null!=name && ''!=name){
        url+='&name='+name;
    }
    if(null!=origin && ''!=origin){
        url+='&origin='+origin;
    }
    if(null!=PRODUCER && ''!=PRODUCER){
        url+='&PRODUCER='+PRODUCER;
    }
    if(0!=goodsTypeId){
        url+="&goodstypeuuid="+goodsTypeId;
    }

    layui.table.reload("goodsTable", { //此处是上文提到的 初始化标识id
        url: url
    });
}

function initSelect(){
    var form = layui.form;
    $.get(path + '/goodsType/queryGoodsTypePager', {}, function (data) {
        var goodsType = "";
        if (data.data != null) {
            $.each(data.data, function (index, item) {
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

function add(){
    var addDiv = $('#addDiv').html();
    //弹出一个页面层
    layer.open({
        type: 1,
        area: ['700px', '440px'],
        shadeClose: true, //点击遮罩关闭
        content: addDiv,
        title : '新增商品分类'
    });
    initSelect();
}

function addForm() {
    var name = $('#name1').val();
    var origin1 = $('#origin1').val();
    var PRODUCER1 = $('#PRODUCER1').val();
    var unit = $('#unit').val();
    var inprice = $('#inprice').val();
    var outprice = $('#outprice').val();
    var goodstypeuuid = $('#goodstypeuuid option:selected').val();
    console.log(name+"_"+origin1+"_"+PRODUCER1+"_"+unit+"_"+inprice+"_"+outprice+"_"+outprice+"_"+goodstypeuuid);
}