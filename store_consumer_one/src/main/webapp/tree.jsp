<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/21 0021
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<%@ include file="/common/mystyle.jsp" %>
<head>
    <title>ztree</title>

    <link rel="stylesheet" href="<%=request.getContextPath() %>/js/zTree/css/demo.css" type="text/css">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/js/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">

    <script type="text/javascript" src="<%=request.getContextPath() %>/js/zTree/js/jquery.ztree.core.js"></script>

</head>
<body>
<script type="text/javascript">

    var setting = {
        async: {
            enable: true,
            url:"<%=request.getContextPath()%>/tr/asyncTreeList.do",
            autoParam:["id"],

        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pid",

            },
            key:{
                url:"Xurl",
            }
        },
        callback:{
            onClick: zTreeOnClick
        }
    };


    $(document).ready(function(){
        $.fn.zTree.init($("#treeDemo"), setting);
        $("#addAfterSaveBtn").hide();
    });


    function zTreeOnClick(event, treeId, treeNode) {
        // alert(treeNode.tId + ", " + treeNode.name);

        if(treeNode!=null){
            //获得父节点的名称和id
            var parentNode  =treeNode.getParentNode();
            $("#async_parentId").text(parentNode.id);
            $("#async_parentName").text(parentNode.name);
            $("#pid").val(parentNode.id);
            $("#id").val(treeNode.id);
            $("#name").val(treeNode.name);
            $("#icon").val(treeNode.icon);
            $("#target").val(treeNode.target);
            $("#type").val(treeNode.type);
        }else{
            $("#async_parentId").text("");
            $("#async_parentName").text("");
            $("#pid").val("");
            $("#id").val("");
            $("#name").val("");
            $("#icon").val("");
            $("#target").val("");
            $("#type").val("");
        }

    };


</script>



<div style="border:1px red solid;width: 300px;height: 400px;margin-top: 10px;margin-left: 10px;float: left;">
    <div id="treeDemo" class="ztree"></div>
</div>
<div style="border: 1px green solid ;width: 500px;height: 400px;margin-top: 10px;margin-left: 10px;float: left;">
    <div style="margin-top: 3px">
        <input type="button" value="修改后保存" id="updateAfterSaveBtn" onclick="updateAfterSave()">
        <input type="button" value="新建菜单" id="addTreeBtn" onclick="addTreeNode()">
        <input type="button" value="删除菜单" id="deleteTreeBtn" onclick="deleteTree()">
        <input type="button" value="新建后保存" id="addAfterSaveBtn" onclick="addAfterSave()">
    </div>
    <div style="margin-top: 3px">
        <form id="async_form">
            &nbsp; &nbsp; &nbsp; &nbsp;父节点Id： &nbsp; &nbsp; &nbsp; &nbsp;<span id="async_parentId"></span>
            <input type="hidden" id="pid" name="pid">
            <br><br>
            &nbsp; &nbsp; &nbsp; &nbsp;父节点名称： &nbsp; &nbsp; &nbsp; &nbsp;<span id="async_parentName">
          </span>
            <input type="text" id="id" name="id">
            <br><br>
            &nbsp; &nbsp; &nbsp; &nbsp;节点名称： &nbsp; &nbsp; <input type="text" id="name" name="name" width="188px"><br><br>
            &nbsp; &nbsp; &nbsp; &nbsp;节点图标：  &nbsp;<input type="text" id="icon" name="icon"  width="188px"><br><br>
            &nbsp; &nbsp; &nbsp; &nbsp;   URL： &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input type="text" id="url" name="url"  width="188px"><br><br>
            &nbsp; &nbsp; &nbsp; &nbsp;展开方式：<select id="target" name="target"  width="188px">
            <option value="1">_blank</option>
            <option value="2">_parent</option>
            <option value="3">_top</option>
            <option value="4">_self</option>
            <option value="5">main</option>
        </select><br><br>
            &nbsp; &nbsp; &nbsp; &nbsp; 菜单类型：<select id="type" name="type"  width="188px">
            <option value="0">菜单</option>
            <option value="1">功能</option>
        </select>
        </form>
    </div>


</div>

</body>
</html>
