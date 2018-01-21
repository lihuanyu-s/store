<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<%@ include file="/common/mystyle.jsp" %>
<body class="easyui-layout">
<!-- easyUI  HTML 代码 -->
<div id="easyui-panel"  data-options="fit:true" style="height:100%">



        <!-- 定义工具栏 -->
        <div id="toolbarId">
            <!-- <div class="easyui-linkbutton" onclick="addGoods();" data-options="iconCls:'icon-add'">新增</div>
            <div class="easyui-linkbutton" onclick="deleteGoods();" data-options="iconCls:'icon-remove'">删除</div>
            <div class="easyui-linkbutton" onclick="editGoodsGloble();" data-options="iconCls:'icon-edit'">修改</div> -->
        </div>
        <table id="userData"></table>

</div>
<script type="text/javascript">
    $(function(){
        $('#userData').datagrid({
            url:'<%=request.getContextPath()%>/user/seleUserlist.do',
            fit:true,
            //开启分页功能
            pagination:true,
            //每页要展示的条数
            pageSize:5,
            //选择性每页要展示的条数
            pageList:[3,5,7],
            //singleSelect:true,
            ctrlSelect:true,
            pagePosition:"both",
            //引入工具栏
            toolbar:"#toolbarId",
            columns:[[
                {field:'checkThis',checkbox:true,width:2},
                {field:'user_id',title:'ID',align:'center',width:20},
                {field:'user_name',title:'用户姓名',align:'center',width:60},
                {field:'user_account',title:'账号',align:'center',width:50},
                {field:'user_pass',title:'密码',align:'center',width:80,
                    formatter:function(value,row,index){
                        $("#pwd").attr("onclick","checkPwd("+row.userPass+")");
                        return $("#pwdDiv").html();
                        //return '<a href="#"  class="easyui-linkbutton" plain="true" iconCls="icon-edit" onclick="giveUserRole('+row.userId+');">用户赋角色</a>';
                    }
                },
                {field:'user_address',title:'地址',align:'center',width:50},
                {field:'user_type',title:'用户类型',align:'center',width:55,
                    formatter:function(value,row,index){
                        return row.userType==1?"单位":"个人";
                    }
                },
                {field:'user_sex',title:'性别',align:'center',width:30,
                    formatter:function(value,row,index){
                        return row.userSex==1?"男":"女";
                    }
                },
                {field:'user_age',title:'年龄',align:'center',width:30},


                {field:'user_mail',title:'邮箱',align:'center',width:120},
                {field:'user_info',title:'个人信息',align:'center',width:200},
                {field:'create_time',title:'注册时间',align:'center',width:130
                },

                {field:'action',title:'操作',align:'center',width:95,
                    formatter:function(value,row,index){
                        $("#atag").attr("onclick","giveUserRole("+row.userId+")");
                        return $("#actionRole").html();
                        //return '<a href="#"  class="easyui-linkbutton" plain="true" iconCls="icon-edit" onclick="giveUserRole('+row.userId+');">用户赋角色</a>';
                    }
                },
                <%-- {field:'goodsImgId',title:'商品图',align:'center',width:90,
                   formatter:function(value,row,index){
                       $("#showImg").attr("src","${pageContext.request.contextPath}"+value);
                       //$("#showImg").attr("src","<%=request.getContextPath()%>/goods/showGoodsImg.do?goodsImgId='+value+'");
                       return '<img alt="none" class="img-responsive img-circle"   width="100" heigth="100" src="<%=request.getContextPath()%>/book/showBookImg.do?bookImgId='+value+'">';
                       return $("#imgDiv").html();
                   }
               } --%>

            ]]
        });
    });


    function giveUserRole(userId){
        getDatagrid("<%=request.getContextPath() %>/user/requestRoleDatagrid.do?userId="+userId,userId,"给用户赋角色","<%=request.getContextPath() %>/user/toSaveUserRole.do");
    }

    function getDatagrid(requestDatagridPage,usrId,title,saveUserRoleUrl){
        var updateUserRole=$("<div></div>").dialog({
            title:title,
            //content中的href 引用的内容
            content:requestDatagrid(requestDatagridPage),
            //模态模式
            modal:true,
            width:500,
            height:300,
            //底部图标
            buttons:

                [{
                    text:'取消',
                    iconCls:"icon-cancel",
                    handler:function(){
                        updateUserRole.dialog("destroy");
                    }
                },{

                    text:'更新',
                    iconCls:"icon-add",
                    handler:function(){

                        //ajax向后台发送请求  成功回调函数中销毁对话框 刷新数据表格
                        $.ajax({
                            url:saveUserRoleUrl,
                            type:"post",
                            data:{"roleIds":roids,"userId":usrId},
                            dataType:"text",
                            success:function (data){
                                $.messager.alert("Success！","更新"+data+"条数据");
                                updateUserRole.dialog("destroy");
                                $('#userData').datagrid("reload");
                            },error:function (){
                                $.messager.alert("Failed","更新失败");
                            }
                        })

                    }
                }]
        })

    }

    //同步请求dialog框
    function requestDatagrid(requestDatagridPage){

        var datagridPage = "";
        $.ajax({
            url:requestDatagridPage,
            type:"post",
            async:false,
            success:function (data){
                datagridPage = data;
            },error:function (){
                alert("获取弹框失败");
            }
        })

        return datagridPage;
    }

    //弹出密码
    function checkPwd(pwd){
        alert(pwd);
    }

</script>
</body>
</html>
