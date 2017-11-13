<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div id="toolbar">
    <div style="padding: 5px; background-color: #fff;">
        <label>商品名称：</label>
        <input class="easyui-textbox" type="text" id="title">
        <label>商品状态：</label>
        <select id="status" class="easyui-combobox" >
            <option value="0">全部</option>
            <option value="1">上架</option>
            <option value="2">下架</option>
        </select>
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="tool('确认要删除？',3)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        <button onclick="tool('确认要下架？',2)" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
        <button onclick="tool('确认要上架？',1)" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
    </div>
</div>
<table id="dg">

</table>
<script>
    function  add() {
        ddshop.addTabs('item-add','新增商品')
    }
    function searchForm() {

        $("#dg").datagrid('load',{
            title:$('#title').val(),
            status:$('#status').combobox('getValue')
        });
        alert(123);

    }
    function tool(message, state) {

        var selections = $("#dg").datagrid('getSelections');
        if (selections.length == 0) {
            //选中的条数为0
            $.messager.alert('提示', '请选择');
        }
        //选中条数不为0
        $.messager.confirm('确认', message, function (r) {
            if (r) {
                //存放id集合
                var ids = [];
                //遍历selections
                for (var i = 0; i < selections.length; i++) {
                    ids.push(selections[i].id);
                }
                $.post(
                    //url
                    "items/batch",
                    //data：前台提交到后台的shuju
                    {'ids[]': ids, state: state},
                    //callback:后台成功调用的函数
                    function (data) {
                        $('#dg').datagrid('reload');
                    },
                    //datatype:返回的shuju
                    'json'
                )
            }
        });
    }
    //初始化数据表格
    $('#dg').datagrid({
        //允许多行排序
        multiSort:true,
        //将工具栏添加到数据表格中
        toolbar: '#toolbar',
        //请求远程服务器上的URL http://localhost:8080/ddshop/items
        url: 'items',
        //隔行变色，斑马线效果
        striped: true,
        //添加分页工具栏
        pagination: true,
        //每行的前面显示行号
        rownumbers: true,
        //使得数据表格自适应填充父容器
        fit: true,
        //默认显示10条，这样的话就显示20条
        pageSize: 20,
        //分页列表
        pageList: [20, 50, 100],
        //列属性
        columns: [[
            //field title width列属性
            {field: 'ck', checkbox: true},
            {field: 'id', title: '商品编号', width: 100},
            {field: 'title', title: '商品名称', width: 100,sortable:true},
            {field: 'sellPoint', title: '卖点', width: 100},
            {
                field: 'status', title: '商品状态',sortable:true, formatter: function (value, row, index) {
                switch (value) {
                    case 1:
                        return '正常';
                        break;
                    case 2:
                        return '下架';
                        break;
                    case 3:
                        return '删除';
                        break;
                    default:
                        return '未知';
                        break;
                }

            }
            },
            {field: 'catName', title: '分类名称', width: 100},
            {field: 'priceView', title: '价格', width: 100},
            {field: 'createTime', title: '创建时间'},
            {field: 'updateTime', title: '更新时间'}
        ]]
    });


</script>



