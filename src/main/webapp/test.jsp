<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/head.jsp" %>
    <style type="text/css">
        /*您可以将下列样式写入自己的样式表中*/
        /*.childBody{padding: 15px;}*/

        /*layui 元素样式改写*/
        /*.layui-btn-sm{line-height: normal; font-size: 12.5px;}*/
        /*.layui-table-view .layui-table-body{min-height: 256px;}*/
        /*.layui-table-cell .layui-input.layui-unselect{height: 30px; line-height: 30px;}*/

        /*!*设置 layui 表格中单元格内容溢出可见样式*!
        .table-overlay .layui-table-view,
        .table-overlay .layui-table-box,
        .table-overlay .layui-table-body{overflow: visible;}
        .table-overlay .layui-table-cell{height: auto; overflow: visible;}*/

        /*文本对齐方式*/
        /*.text-center{text-align: center;}*/
    </style>
</head>
<body class="childBody">
<section class="layui-col-md10" style="margin: 0 auto; float: none;">
    <div class="layui-card">
        <div class="layui-card-header">基于 layui table 添加一行并实现在编辑行记录后保存数据的方法</div>
        <div class="layui-card-body layui-text">
            <div id="toolbar">
                <div>
                    <button type="button" class="layui-btn layui-btn-sm" data-type="addRow" title="添加一行">
                        <i class="layui-icon layui-icon-add-1"></i> 添加一行
                    </button>
                </div>
            </div>
            <div id="tableRes" class="table-overlay">
                <table id="dataTable" lay-filter="dataTable" class="layui-hide"></table>
            </div>
            <div id="action" class="text-center">
                <button type="button" name="btnSave" class="layui-btn" data-type="save"><i class="layui-icon layui-icon-ok-circle"></i>保存</button>
                <button type="reset" name="btnReset" class="layui-btn layui-btn-primary">取消</button>
            </div>
        </div>
    </div>

    <!--保存结果输出-->
    <div class="layui-card">
        <div class="layui-card-header">保存结果输出</div>
        <div class="layui-card-body layui-text">
            <blockquote class="layui-elem-quote layui-quote-nm">
                <pre id="jsonResult"><span class="layui-word-aux">请点击“保存”后查看输出信息……</span></pre>
            </blockquote>
        </div>
    </div>
</section>
<!--recommended script position-->
<script type="text/javascript">
    //准备视图对象
    window.viewObj = {
        tbData: [{
            tempId: new Date().valueOf(),
            type: 2,
            name: '测试项名称',
            state: 1
        }],
        typeData: [
            {id: 1, name: '分类一'},
            {id: 2, name: '分类二'},
            {id: 3, name: '分类三'},
            {id: 4, name: '分类四'}
        ],
        renderSelectOptions: function(data, settings){
            var valueField = settings.valueField || 'value',
                textField = settings.textField || 'text',
                selectedValue = settings.selectedValue || "";
            // alert("settins");

            var html = [];
            for(var i=0, item; i < data.length; i++){
                item = data[i];
                html.push('<option value="');
                html.push(item[valueField]);
                html.push('"');
                if(selectedValue && item[valueField] == selectedValue ){
                    html.push(' selected="selected"');
                }
                html.push('>');
                html.push(item[textField]);
                html.push('</option>');
            }

            return html.join('');
        }
    };

    //layui 模块化引用
    layui.use(['jquery', 'table', 'layer'], function(){
        var $ = layui.$, table = layui.table, form = layui.form, layer = layui.layer;

        //数据表格实例化
        var tbWidth = $("#tableRes").width();
        var layTableId = "layTable";
        var tableIns = table.render({
            elem: '#dataTable',
            id: layTableId,
            data: [],
            width: tbWidth,
            page: true,
            loading: true,
            even: false, //不开启隔行背景
            cols: [[
                {title: '序号', type: 'numbers'},
                {field: 'type', title: '分类（type）', templet: function(d){
                    alert("b.type");
                    console.log(d);
                        var options = viewObj.renderSelectOptions(viewObj.typeData, {valueField: "id", textField: "name", selectedValue: d.type});
                        return '<a lay-event="type"></a><select name="type" lay-filter="type"><option value="">请选择分类</option>' + options + '</select>';
                    }},
                {field: 'name', title: '名称（name）', edit: 'text'},
                {field: 'state', title: '是否启用（state）', event: 'state', templet: function(d){
                        var html = ['<input type="checkbox" name="state" lay-skin="switch" lay-text="是|否"'];
                        html.push(d.state > 0 ? ' checked' : '');
                        html.push('/>');
                        return html.join('');
                    }},
                {field: 'tempId', title: '操作', templet: function(d){
                        return '<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del" lay-id="'+ d.tempId +'"><i class="layui-icon layui-icon-delete"></i>移除</a>';
                    }}
            ]],
            done: function(res, curr, count){
                viewObj.tbData = res.data;
            }
        });

        //定义事件集合
        var active = {
            addRow: function(){	//添加一行
                // alert("Addrows");
                var oldData = table.cache[layTableId];
                console.log(oldData);
                var newRow = {tempId: new Date().valueOf(), type: null, name: '请填写名称', state: 0};
                console.log(oldData);
                oldData.push(newRow);
                tableIns.reload({
                    data : oldData
                });
            },
            updateRow: function(obj){
                var oldData = table.cache[layTableId];
                console.log(oldData);
                console.log(oldData[0]);
                for(var i=0, row; i < oldData.length; i++){
                    row = oldData[i];
                    if(row.tempId == obj.tempId){
                        $.extend(oldData[i], obj);
                        return;
                    }
                }
                tableIns.reload({
                    data : oldData
                });
            },
            removeEmptyTableCache: function(){
                var oldData = table.cache[layTableId];
                for(var i=0, row; i < oldData.length; i++){
                    row = oldData[i];
                    if(!row || !row.tempId){
                        oldData.splice(i, 1);    //删除一项
                    }
                    continue;
                }
                tableIns.reload({
                    data : oldData
                });
            },
            save: function(){
                var oldData = table.cache[layTableId];
                console.log(oldData);
                for(var i=0, row; i < oldData.length; i++){
                    row = oldData[i];
                    if(!row.type){
                        layer.msg("检查每一行，请选择分类！", { icon: 5 }); //提示
                        return;
                    }
                }
                document.getElementById("jsonResult").innerHTML = JSON.stringify(table.cache[layTableId], null, 2);	//使用JSON.stringify() 格式化输出JSON字符串
            }
        }

        //激活事件
        var activeByType = function (type, arg) {
            if(arguments.length === 2){
                active[type] ? active[type].call(this, arg) : '';
            }else{
                active[type] ? active[type].call(this) : '';
            }
        }

        //注册按钮事件
        $('.layui-btn[data-type]').on('click', function () {
            var type = $(this).data('type');
            activeByType(type);

        });

        //监听select下拉选中事件
        form.on('select(type)', function(data){
            var elem = data.elem; //得到select原始DOM对象
            // console.log(elem);
            var oldData = table.cache[layTableId];
            // console.log(oldData);
            // console.log("=====");
            // alert(0);
// alert(0);
            $(elem).prev("a[lay-event='type']").trigger("click");
            // alert(2);
            // console.log("==============");
        });

        //监听工具条
        table.on('tool(dataTable)', function (obj) {
            var data = obj.data, event = obj.event, tr = obj.tr; //获得当前行 tr 的DOM对象;
            // alert(1);
            // console.log(data);
            switch(event){
                case "type":
                    //console.log(data);
                    var select = tr.find("select[name='type']");
                    // alert(1111);
                    var oldData = table.cache[layTableId];
                    // console.log(oldData);
                    if(select){

                        var selectedVal = select.val();
                        if(!selectedVal){
                            layer.tips("请选择一个分类", select.next('.layui-form-select'), { tips: [3, '#FF5722'] }); //吸附提示
                        }

                        // console.log(selectedVal);
                        $.extend(obj.data, {'type': selectedVal});
                        activeByType('updateRow', obj.data);	//更新行记录对象
                    }
                    break;
                case "state":
                    var stateVal = tr.find("input[name='state']").prop('checked') ? 1 : 0;
                    $.extend(obj.data, {'state': stateVal})
                    activeByType('updateRow', obj.data);	//更新行记录对象
                    break;
                case "del":
                    layer.confirm('真的删除行么？', function(index){
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        activeByType('removeEmptyTableCache');
                    });
                    break;
            }
        });
    });
</script>
</body>
</html>