<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="toolbar">
    <div>
        <button type="button" onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button type="button" onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button type="button" onclick="del()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">删除</button>
    </div>
</div>
<table id="table"></table>

<script>
    $(function(){

        //列表
        $('#table').datagrid({
            title: '商品规格模板列表',
            url:'itemParams',
            fit: true,
            rownumbers: true,
            pagination: true,
            pageSize:20,
            toolbar: '#toolbar',
            columns:[[
                {field:'ck', checkbox: true},
                {field:'id',title:'ID', sortable: true},
                /* {field:'itemCatId',title:'商品类目ID'}, */
                {field:'itemCatName',title:'商品类目'},
                {field:'paramData',title:'规格(只显示分组名称)', formatter:function(value,row,index){
                    var json = JSON.parse(value);
                    var array = [];
                    $.each(json,function(i,e){
                        array.push(e.group);
                    });
                    return array;
                }},
                {field:'created',title:'创建日期', formatter:function(value,row,index){
                    return moment(value).format('YYYY年MM月DD日,hh:mm:ss');
                }},
                {field:'updated',title:'更新日期', formatter:function(value,row,index){
                    return moment(value).format('YYYY年MM月DD日,hh:mm:ss');
                }}
            ]]

        });
    });
    function add(){
        ddshop.addTabs('item-param-add', '新增商品规格模板');
    }
    function edit(){

    }
    function del(){
        //ttshop.executeOperation('未选中商品规格模板!', '确定删除所选商品规格模板吗？', 'item/param/delete?');
    }
</script>
