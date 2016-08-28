<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div id="Header" class="clf">
    <div id="firstArea"><h1>Tシャツ、ポロ シャツ、トレーナー、ブルゾンなどのプリンタブルウェアを販売 トムス株式会社</h1></div>
    <div id="langArea">
        <ul class="clf"><!--
							-->
            <li class="start"><a href="./123/トムス株式会社.html" class="current">
                <img src="<%request.getContextPath(); %>/resources/images/btn_cmn_01.gif"
                     width="56" height="11" alt="日本語"
                     class="btn"></a></li><!--
							-->
            <li><a href="http://www.tomsj.com/english/">
                <img src="<%request.getContextPath(); %>/resources/images/btn_cmn_02.gif" width="46" height="11"
                     alt="英語" class="btn"></a></li><!--
							-->
            <li><a href="http://www.tomsj.com/chinese/">
                <img src="<%request.getContextPath(); %>/resources/images/btn_cmn_03.gif" width="47" height="11"
                     alt="中国語" class="btn"></a></li><!--
						--></ul>
    </div>
</div>
<div id="naviArea" class="clf">
    <p id="corpLogo"><a href="http://www.tomsj.com/index.html">
        <img src="<%request.getContextPath(); %>/resources/images/lgo_cmn_01.gif" width="86"
             height="11" alt="トムス株式会社"></a></p>
    <ul><!--
						-->
        <li>
            <a href="http://www.tomsj.com/about/">
                <%--<img src="<%request.getContextPath(); %>/resources/images/gnv_cmn_01.gif" width="110" height="27"
                     alt="トムスについて" class="btn"></a>--%>
                <h4><b style="color: black;"><spring:message code="hi"></spring:message></b></h4>
                <h5><p style="color:red;text-align: left;">for first</p></h5>
            </a>
        </li><!--
						-->
        <li><a href="http://www.tomsj.com/first/">
            <img src="<%request.getContextPath(); %>/resources/images/gnv_cmn_02.gif" width="140" height="27"
                 alt="はじめてのお客様へ" class="btn"></a></li><!--
						-->
        <li><a href="http://www.tomsj.com/company/">
            <img src="<%request.getContextPath(); %>/resources/images/gnv_cmn_04.gif" width="87" height="27"
                 alt="会社案内" class="btn"></a></li><!--
						-->
        <li><a href="http://www.tomsj.com/recruit/" target="_blank">
            <img src="<%request.getContextPath(); %>/resources/images/gnv_cmn_05.gif" width="87"
                 height="27" alt="採用情報" class="btn"></a>
        </li><!--
						-->
        <li><a href="http://www.tomsj.com/topics/">
            <img src="<%request.getContextPath(); %>/resources/images/gnv_cmn_06.gif" width="90" height="27"
                 alt="トピックス" class="btn"></a></li><!--
						-->
        <li class="end"><a href="https://sv128.xserver.jp/~tomsj/contact/catalog.html">
            <img
                    src="<%request.getContextPath(); %>/resources/images/gnv_cmn_07.gif" width="167" height="27"
                    alt="カタログ請求／お問い合わせ" class="btn"></a></li><!--
					--></ul>
</div>
