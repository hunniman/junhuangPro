<%--
  Created by IntelliJ IDEA.
  User: pengweiyuan
  Date: 7/4/16
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>沙皇网络科技有限公司</title>
    <%--<link rel="stylesheet" href="<%request.getContextPath(); %>/resources/css/import.css" type="text/css" media="all">
    <link rel="stylesheet" href="<%request.getContextPath(); %>/resources/css/style_news.css" type="text/css"
          media="all">
    <script src="<%request.getContextPath(); %>/resources/js/jquery-1.3.1.js" type="text/javascript"></script>
    <script src="<%request.getContextPath(); %>/resources/js/yuga.js" type="text/javascript"></script>--%>

    <jsp:include page="common/css.jsp"></jsp:include>
    <jsp:include page="common/script.jsp"></jsp:include>
    <!--[if lte IE 6]>
    <!--<script src="common/js/minmax.js" type="text/javascript"></script>--><![endif]-->
    <script type="text/javascript" src="<%request.getContextPath(); %>/resources/js/swfobject.js"></script>
    <script type="text/javascript">

        <!--
        //        $(function () {
        //            $("#topicsBox").load("http://www.tomsj.com/topics/news_20160226.html");
        //        });
        // -->
    </script>

</head>
<body>
<div id="Container">
    <div id="pageArea">
        <jsp:include page="common/header.jsp"></jsp:include>
        <div id="homeArea">
            <div id="flaArea">
                <div id="flashcontent">
                    <embed type="application/x-shockwave-flash" src="index.swf" width="920" height="400"
                           style="undefined" id="index" name="index" bgcolor="#F5F5F5" quality="high"
                           allowfullscreen="false" allowscriptaccess="sameDomain" menu="false"
                           flashvars="xmlPath=docs/banner.xml">
                </div>
                <script type="text/javascript">
                    var so = new SWFObject("index.swf", "index", "920", "400", "9", "#F5F5F5");
                    so.addParam("allowFullScreen", "false");
                    so.addParam("allowScriptAccess", "sameDomain");
                    so.addParam("menu", "false");
                    so.addParam("flashVars", "xmlPath=docs/banner.xml");
                    so.write("flashcontent");
                </script>
            </div>
            <center>
                <table>
                    <tbody>
                    <tr>
                        <td align="left"><br><b>4月14日に発生した「平成28年熊本地震」により被災された方々へ謹んでお見舞い申し上げますとともに、<br>不幸にして犠牲になられた方々のご冥福を謹んでお祈り申し上げます。<br>皆様の安全と一日も早い復興を心より願っております。</b>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </center>
            <div id="topicsArea">
                <div id="topicsTop">
                    <div id="topicsBody">
                        <h2><img src="<%request.getContextPath(); %>/resources/images/ttl_home_01.gif" width="64" height="20" alt="TOPICS"></h2>
                        <div id="topicsBox">


                            <meta http-equiv="Imagetoolbar" content="no">
                            <meta http-equiv="content-style-type" content="text/css">
                            <meta http-equiv="content-script-type" content="text/javascript">
                            <meta name="keywords" content="">
                            <meta name="description" content="">
                            <title>新着情報 | トムス株式会社</title>


                            <div id="newsArea">
                                <dl>
                                    <dt>2016.2.26</dt>
                                    <dd><a href="http://www.tomsj.com/topics/2016/02/post-13.html" target="_top">2016 SS
                                        カタログのe-bookを更新しました。</a></dd>
                                </dl>
                            </div>


                        </div>
                        <p><a href="http://www.tomsj.com/topics/">
                            <img src="<%request.getContextPath(); %>/resources/images/btn_home_01.gif" width="90"
                                                                       height="20" alt="トピックス一覧" class="off"></a></p>
                    </div>
                </div>
            </div>
            <div id="contentsArea">
                <ul class="clf">
                    <li><a href="http://www.tomsj.com/about/technology.html">
                        <img src="<%request.getContextPath(); %>/resources/images/btn_print_01.jpg" alt="加工"
                                                                                  width="450" height="175" class="btn"></a>
                    </li>
                    <li><a href="http://www.tomsj.com/about/graphic.html">
                        <img src="<%request.getContextPath(); %>/resources/images/btn_graphic_01.jpg"
                                                                               alt="グラフィック企画" width="450" height="175"
                                                                               class="btn"></a></li>
                    <li><a href="http://www.tomsj.com/about/custom.html">
                        <img src="<%request.getContextPath(); %>/resources/images/btn_custom_01.jpg" alt="別注企画"
                                                                              width="450" height="175" class="btn"></a>
                    </li>
                    <li><a href="http://www.tomsj.com/about/contents.html">
                        <img src="<%request.getContextPath(); %>/resources/images/btn_contents_01.jpg"
                                                                                alt="コンテンツ企画" width="450" height="175"
                                                                                class="btn"></a></li>
                </ul>
            </div>
        </div>
    </div>
    <div id="Footer">


        <form action="http://192.168.20.137:8080/ae/register/upload   " method="post" enctype="multipart/form-data">

            <p>
                Select a file : <input type="file" name="uploadedFile" size="50" />
            </p>

            <input type="submit" value="Upload It" />
        </form>



        <div id="fotterArea" class="clf">
            <ul class="linkList fs12"><!--
						-->
                <li><a href="http://www.tomsj.com/guide/sitemap.html">サイトマップ</a></li><!--
						-->
                <li><a href="http://www.tomsj.com/guide/policy.html">プライバシーポリシー</a></li><!--
						-->
                <li><a href="http://www.tomsj.com/guide/terms.html">サイトご利用条件</a></li><!--
						-->
                <li><a href="http://www.tomsj.com/guide/banners.html">バナーダウンロード</a></li><!--
					--></ul>
            <div id="adminArea" class="clf">
                <p class="copyRight">
                    <img src="<%request.getContextPath(); %>/resources/images/copyright.gif" width="206" height="8"
                                          alt="Copyright (c) TOMS,Inc. All rights reserved."></p>
                <p class="siteLogo"><img src="<%request.getContextPath(); %>/resources/images/lgo_cmn_01.gif" width="86" height="11" alt="トムス株式会社"></p>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var gaJsHost = (("https:" == document.location.protocol) ?
            "https://ssl." : "http://www.");
    document.write(unescape("%3Cscript src='" + gaJsHost +
            "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script src="<%request.getContextPath(); %>/resources/js/ga.js" type="text/javascript"></script>
<script type="text/javascript">
    var pageTracker = _gat._getTracker("UA-681978-1");
    pageTracker._initData();
    pageTracker._trackPageview();
</script>

</body>
</html>
