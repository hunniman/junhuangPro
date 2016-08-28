<%--
  Created by IntelliJ IDEA.
  User: pengweiyuan
  Date: 7/4/16
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<% request.getContextPath();%>/resources/back/css/index.css" type="text/css"
          media="screen"/>
    <script type="text/javascript" src="<% request.getContextPath();%>/resources/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="<% request.getContextPath();%>/resources/back/js/tendina.min.js"></script>
    <script type="text/javascript" src="<% request.getContextPath();%>/resources/back/js/common.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#menu .childUlLi li >a").bind("click",function () {
                //alert($(this).text());
                var url=$(this).attr("url");
                $("#page_content").load(url);
            })
        });
    </script>
</head>
<body>
<%--<input type="hidden" id="projectPath" value="<% request.getContextPath();%>>--%>
<!--顶部-->
<div class="layout_top_header">
    <div style="float: left"><span
            style="font-size: 16px;line-height: 45px;padding-left: 20px;color: #8d8d8d">沙王管理后台</h1></span></div>
    <div id="ad_setting" class="ad_setting">
        <a class="ad_setting_a" href="javascript:; ">
            <i class="icon-user glyph-icon" style="font-size: 20px"></i>
            <span>管理员</span>
            <i class="icon-chevron-down glyph-icon"></i>
        </a>
        <ul class="dropdown-menu-uu" style="display: none" id="ad_setting_ul">
            <li class="ad_setting_ul_li"><a href="javascript:;"><i class="icon-user glyph-icon"></i> 个人中心 </a></li>
            <li class="ad_setting_ul_li"><a href="javascript:;"><i class="icon-cog glyph-icon"></i> 设置 </a></li>
            <li class="ad_setting_ul_li"><a href="javascript:;"><i class="icon-signout glyph-icon"></i> <span
                    class="font-bold">退出</span> </a></li>
        </ul>
    </div>
</div>
<!--顶部结束-->
<!--菜单-->
<div class="layout_left_menu">
    <ul id="menu">
        <li class="childUlLi">
            <a href="main.html" target="menuFrame"><i class="glyph-icon icon-home"></i>首页</a>
            <ul>
                <li><a href="javascript:void(0);" url="getUser"><i class="glyph-icon icon-chevron-right"></i>用户列表</a>
                </li>
            </ul>
        </li>
        <li class="childUlLi">
            <a href="user.html" target="menuFrame"> <i class="glyph-icon icon-reorder"></i>成员管理</a>
            <ul>
                <li><a href="javascript:void(0);" url="user"><i class="glyph-icon icon-chevron-right"></i>用户列表</a>
                <li><a href="#"><i class="glyph-icon icon-chevron-right"></i>数据管理</a></li>
            </ul>
        </li>
        <li class="childUlLi">
            <a href="role.html" target="menuFrame"> <i class="glyph-icon icon-reorder"></i>角色</a>
            <ul>
                <li><a href="javascript:void(0);" url="roleIndex"><i class="glyph-icon icon-chevron-right"></i>角色列表</a></li>
            </ul>
        </li>
        <li class="childUlLi">
            <a href="#"> <i class="glyph-icon  icon-location-arrow"></i>菜单管理</a>
            <ul>
                <li><a href="javascript:void(0);" url="menuIndex"><i class="glyph-icon icon-chevron-right"></i>前台菜单</a></li>
            </ul>
        </li>
    </ul>
</div>
<!--菜单-->
<div id="layout_right_content" class="layout_right_content">

    <%--<div class="route_bg">
        <a href="#">主页</a><i class="glyph-icon icon-chevron-right"></i>
        <a href="#">菜单管理</a>
    </div>--%>
    <div class="mian_content">
        <div id="page_content">
            <iframe id="menuFrame" name="menuFrame" src="main.html" style="overflow:visible;"
                    scrolling="yes" frameborder="no" width="100%" height="100%"></iframe>
        </div>
    </div>
</div>
<div class="layout_footer">
    <p>Copyright © 2016 - 沙王科技</p>
</div>
</body>
</html>
