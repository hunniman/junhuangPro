<%--
  Created by IntelliJ IDEA.
  User: pengweiyuan
  Date: 7/14/16
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<script type="text/javascript" src="<% request.getContextPath();%>/resources/back/js/jquery.min.js"></script>--%>

        <jsp:include page="../../page/common/admin/css.jsp" />
        <jsp:include page="../../page/common/admin/js.jsp" />
        <jsp:include page="../../page/common/admin/validator.jsp" />
        <jsp:include page="../../page/common/admin/loading.jsp" />
        <jsp:include page="../../page/common/admin/dataGrid.jsp" />

    <title>角色管理</title>

    <script type="text/javascript">
        $(function () {
            var projectPath=$("#projectPath").val();
            var $table = $('#table');
            var initTable=function(d){
                var userId=$("#ddlUser  option:selected").val();
                if(userId===undefined){
                    userId=0;
                }
                $('#table').bootstrapTable({
// 			    data:d.rows,
                    url: projectPath+'/back/getUser',
                    pagination: true,
                    pageSize: 10,
                    pageNumber:1,
                    columns: [{
                        field: 'id',
                        title: 'ID',
                        width:60,
                    }, {
                        field: 'userName',
                        title: '用户名',
                        width:100
                    }, {
                        field: 'mobile',
                        title: '电话号码',
                        width:100
                    }, {
                        field: 'nickName',
                        title: '昵称',
                        width:100
                    }, {
                        field: 'email',
                        title: '邮箱',
                        width:100
                    }, {
                        field: 'email',
                        title: '邮箱',
                        width:100
                    }, {
                        field: 'sex',
                        title: '性别',
                        width:100
                    }, {
                        field: 'role',
                        title: '角色'
                    }, {
                        field: 'createTime',
                        title: '创建时间'
                    },{
                        field: 'operate',
                        title: '操作',
                        align: 'center',
                        events: operateEvents,
                        width:100,
                        formatter: operateFormatter
                    }]
                });
            };


            function operateFormatter(value, row, index) {
                return [
                    '<a class="like" href="javascript:void(0)" title="Like">',
                    '<i class="glyphicon glyphicon-edit"></i>',
                    '</a>  ',
                    '<a class="remove" href="javascript:void(0)" title="Remove">',
                    '<i class="glyphicon glyphicon-remove"></i>',
                    '</a>'
                ].join('');
            };


            window.operateEvents = {
                'click .like': function (e, value, row, index) {
// 		        	alert(row.id);
// 		            alert('You click like action, row: ' + JSON.stringify(row));
                    $("#page_content").load(projectPath+"/back/userAdd?id="+row.id);
                   // window.open(projectPath+"/back/saveRole?id="+row.id,"_self");
                },
                'click .remove': function (e, value, row, index) {
                    Modal.confirm(
                            {
                                msg: "确认删除？"
                            }).on( function (e) {
                                if(!e){
                                    return;
                                }
                                $.ajax({
                                    type: "get",
                                    dataType: "json",
                                    url: projectPath+"/back/deleteMenu",
                                    data: {id:row.id},
                                    success: function(data) {
                                        if(data.code==="1"){
                                            toastr.success('删除成功');
                                            $table.bootstrapTable('remove', {
                                                field: 'id',
                                                values: [row.id]
                                            });
                                        }else{
                                            toastr.error('删除失败');
                                        }
                                    },
                                    error: function(err) {
                                        toastr.error('删除数据失败');
                                    }
                                });
                            });
                }
            };


            $("#btnRAdd").bind("click",function(){
               // window.open("roleAdd", "_self");
                $("#page_content").load("menuAdd?id=''");
            });

            initTable();


        });

    </script>
</head>
<body>
   <input id="projectPath" type="hidden" value="<%=request.getContextPath()%>">
   <div class="rows" style="float:right;">
       <button id="btnRAdd" class="btn btn-primary ladda-button" data-style="expand-right" type="button">
           <span class="ladda-label">添加用户</span>
       </button>
   </div>
   <table id="table" data-pagination="true" data-id-field="id" data-side-pagination="server" >
   </table>



   <!-- system modal start -->
   <div id="ycf-alert" class="modal">
       <div class="modal-dialog modal-sm">
           <div class="modal-content">
               <div class="modal-header">
                   <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                   <h5 class="modal-title"><i class="fa fa-exclamation-circle"></i> [Title]</h5>
               </div>
               <div class="modal-body small">
                   <p>[Message]</p>
               </div>
               <div class="modal-footer" >
                   <button type="button" class="btn btn-primary ok" data-dismiss="modal">[BtnOk]</button>
                   <button type="button" class="btn btn-default cancel" data-dismiss="modal">[BtnCancel]</button>
               </div>
           </div>
       </div>
   </div>
   <!-- system modal end -->
</body>
</html>
