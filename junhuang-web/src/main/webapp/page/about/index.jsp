<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: pengweiyuan
  Date: 7/5/16
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="hi"></spring:message></title>
    <jsp:include page="../common/css.jsp"></jsp:include>
    <jsp:include page="../common/script.jsp"></jsp:include>
    <link rel="stylesheet" href="<%request.getContextPath(); %>/resources/css/topslide.css" type="text/css" media="all">
</head>
<script type="text/javascript">

    $(function () {
        $('#slides').slidesjs({
            width: 600,
            height: 298,
            navigation: {
                effect: "fade"
            },
            pagination: {
                effect: "fade"
            },
            effect: {
                fade: {
                    speed: 800
                }
            },
            play: {
                auto: true,
                interval: 3500,
                pauseOnHover: true,
                effect: "fade",
                auto: true,
                pauseOnHover: false,
                restartDelay: 3000
            },
            callback: {
                start: function () {
                    setTimeout(function () {
                        $("img.slidesjs-slide").each(function () {
                            $(this).css("width", "600");
                        });
                    }, 10);
                }
            }
        });
    });
</script>
<body>
<div id="Container">
    <div id="pageArea">
        <jsp:include page="../common/header.jsp"></jsp:include>

        <div id="aboutArea">
            <div class="clf" id="columnArea">
                <div id="mainArea">
                    <h2 class="mainTitle"><img src="<%request.getContextPath(); %>/resources/images/ttl_main_01.png"
                                               alt="ABOUT TOMS" width="68"
                                               height="21">トムスについて</h2>
                    <div class="mainSection bottomLine pt20">
                        <div id="topSlideAreaOuter">
                            <div class="containerOuter">
                                <div class="container">
                                    <div id="slides" style="overflow: hidden; display: block;">
                                        <div class="slidesjs-container"
                                             style="overflow: hidden; position: relative; width: 600px; height: 298px;">
                                            <div class="slidesjs-control"
                                                 style="position: relative; left: 0px; width: 600px; height: 298px;">
                                                <img alt="" class="w600 slidesjs-slide" height="298"
                                                     src="images/about/img_slide_01.jpg" width="600" slidesjs-index="0"
                                                     style="position: absolute; top: 0px; backface-visibility: hidden; display: none; left: 0px; z-index: 0; width: 600px;"><img
                                                    alt="" class="w600 slidesjs-slide" height="298"
                                                    src="images/about/img_slide_02.jpg" width="600" slidesjs-index="1"
                                                    style="position: absolute; top: 0px; backface-visibility: hidden; display: none; left: 0px; z-index: 0; width: 600px;"><img
                                                    alt="" class="w600 slidesjs-slide" height="298"
                                                    src="images/about/img_slide_03.jpg" width="600" slidesjs-index="2"
                                                    style="position: absolute; top: 0px; backface-visibility: hidden; display: none; left: 0px; z-index: 0; width: 600px;"><img
                                                    alt="" class="w600 slidesjs-slide" height="298"
                                                    src="images/about/img_slide_04.jpg" width="600" slidesjs-index="3"
                                                    style="position: absolute; top: 0px; backface-visibility: hidden; display: block; left: 0px; width: 600px; z-index: 0;"><img
                                                    alt="" class="w600 slidesjs-slide" height="298"
                                                    src="images/about/img_slide_05.jpg" width="600" slidesjs-index="4"
                                                    style="position: absolute; top: 0px; backface-visibility: hidden; display: none; left: 0px; z-index: 0; width: 600px;"><img
                                                    alt="" class="w600 slidesjs-slide" height="298"
                                                    src="images/about/img_slide_06.jpg" width="600" slidesjs-index="5"
                                                    style="position: absolute; top: 0px; backface-visibility: hidden; display: none; left: 0px; z-index: 0; width: 600px;"><img
                                                    alt="" class="w600 slidesjs-slide" height="298"
                                                    src="images/about/img_slide_07.jpg" width="600" slidesjs-index="6"
                                                    style="position: absolute; top: 0px; backface-visibility: hidden; display: none; left: 0px; z-index: 0; width: 600px;"><img
                                                    alt="" class="w600 slidesjs-slide" height="298"
                                                    src="images/about/img_slide_08.jpg" width="600" slidesjs-index="7"
                                                    style="position: absolute; top: 0px; backface-visibility: hidden; display: none; left: 0px; z-index: 0; width: 600px;"><img
                                                    alt="" class="w600 slidesjs-slide" height="298"
                                                    src="images/about/img_slide_09.jpg" width="600" slidesjs-index="8"
                                                    style="position: absolute; top: 0px; backface-visibility: hidden; display: none; left: 0px; z-index: 0; width: 600px;"><img
                                                    alt="" class="w600 slidesjs-slide" height="298"
                                                    src="images/about/img_slide_10.jpg" width="600" slidesjs-index="9"
                                                    style="position: absolute; top: 0px; backface-visibility: hidden; display: none; left: 0px; z-index: 0; width: 600px;">
                                            </div>
                                        </div>


                                        <a class="slidesjs-previous slidesjs-navigation" href="#" title="前へ">前へ</a><a
                                            class="slidesjs-next slidesjs-navigation" href="#" title="次へ">次へ</a>
                                        <ul class="slidesjs-pagination">
                                            <li class="slidesjs-pagination-item"><a href="#" data-slidesjs-item="0"
                                                                                    class="">1</a></li>
                                            <li class="slidesjs-pagination-item"><a href="#" data-slidesjs-item="1"
                                                                                    class="">2</a></li>
                                            <li class="slidesjs-pagination-item"><a href="#" data-slidesjs-item="2"
                                                                                    class="">3</a></li>
                                            <li class="slidesjs-pagination-item"><a href="#" data-slidesjs-item="3"
                                                                                    class="active">4</a></li>
                                            <li class="slidesjs-pagination-item"><a href="#" data-slidesjs-item="4"
                                                                                    class="">5</a></li>
                                            <li class="slidesjs-pagination-item"><a href="#" data-slidesjs-item="5"
                                                                                    class="">6</a></li>
                                            <li class="slidesjs-pagination-item"><a href="#" data-slidesjs-item="6"
                                                                                    class="">7</a></li>
                                            <li class="slidesjs-pagination-item"><a href="#" data-slidesjs-item="7"
                                                                                    class="">8</a></li>
                                            <li class="slidesjs-pagination-item"><a href="#" data-slidesjs-item="8"
                                                                                    class="">9</a></li>
                                            <li class="slidesjs-pagination-item"><a href="#" data-slidesjs-item="9"
                                                                                    class="">10</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <h3><img alt="私たちは「プリンタブルウェア」のリーディングカンパニーです。" height="70"
                                 src="<%request.getContextPath(); %>/resources/images/cpt_about_01.gif"
                                 width="403"></h3>
                        <p class="mainFactor readBox pt30">
                            無地の衣料に思い思いのデザインをプリントできる。そのことをプリンタブルと呼びます。プリンタブルの活用価値はさまざまです。たとえば服を、街をいきかうコミュニケーションメディアに変身させ、セールスプロモーションにご活用頂けます。また、アパレル企画・販売企業の皆様には、在庫リスクをトムスが担保することで、企画〜生産〜物流まで、トータルでの貢献を約束できます。広告・SP、企業ユニフォーム、スポーツ、テーマパーク、アパレルとビジネス用途で活用されるプリンタブルウェア市場。トムスはそのリーディングカンパニーです。</p>
                    </div>
                    <div class="mainSection">
                        <h4 class="subTitle">プリンタブルウェアをもっと良く知る</h4>
                        <div class="aboutBox pt30 clf">
                            <dl>
                                <dt class="fs14"><a href="printable.html"><img alt="" height="60"
                                                                               src="images/about/thm_printable_01.jpg"
                                                                               width="180"></a><span><a class="lnk"
                                                                                                        href="printable.html">プリンタブルウェアとは</a></span>
                                </dt>
                                <dd class="fs12">企業のユニフォームからコンサートグッズまで。ビジネスのさまざまな場面で、活用されています。</dd>
                            </dl>
                            <dl>
                                <dt class="fs14"><a href="business.html"><img alt="" height="60"
                                                                              src="images/about/thm_business_01.jpg"
                                                                              width="180"></a><span><a class="lnk"
                                                                                                       href="business.html">ビジネスモデル</a></span>
                                </dt>
                                <dd class="fs12">プリンタブルウェアとは、ビジネスモデルのご提案です。</dd>
                            </dl>
                            <dl class="end">
                                <dt class="fs14"><a href="technology.html"><img alt="" height="60"
                                                                                src="images/about/thm_technology_01.jpg"
                                                                                width="180"></a><span><a class="lnk"
                                                                                                         href="technology.html">プリンタブル技術</a></span>
                                </dt>
                                <dd class="fs12">ほしいときに、ほしいだけの枚数をはやく、正確に、お届けします。</dd>
                            </dl>
                        </div>
                        <div class="aboutBox pt40 clf">
                            <dl>
                                <dt class="fs14"><a href="logistics.html">
                                    <img alt="" height="60"
                                                                               src="images/about/thm_logistics_01.jpg"
                                                                               width="180"></a><span><a class="lnk"
                                                                                                        href="logistics.html">サプライチェーン</a></span>
                                </dt>
                                <dd class="fs12">安定供給・高品質・スピード化を追求するシステム。</dd>
                            </dl>
                            <dl>
                                <dt class="fs14"><a href="office.html"><img alt="" height="60"
                                                                            src="images/about/thm_office_01.jpg"
                                                                            width="180"></a><span><a class="lnk"
                                                                                                     href="office.html">事業・組織体制</a></span>
                                </dt>
                                <dd class="fs12">アジア各地に営業所があります。１枚からでもご発注いただけます。</dd>
                            </dl>
                            <dl class="end">
                                <dt class="fs14"><a href="mission.html"><img alt="" height="60"
                                                                             src="images/about/thm_mission_01.jpg"
                                                                             width="180"></a><span><a class="lnk"
                                                                                                      href="mission.html">いちばんの約束</a></span>
                                </dt>
                                <dd class="fs12">リーディングカンパニー・トムスのミッション</dd>
                            </dl>
                        </div>
                        <div class="aboutBox pt40 clf">
                            <dl>
                                <dt class="fs14"><a href="graphic.html"><img alt="" height="60"
                                                                             src="images/about/thm_graphic_01.jpg"
                                                                             width="180"></a><span><a class="lnk"
                                                                                                      href="graphic.html">グラフィック企画</a></span>
                                </dt>
                                <dd class="fs12">プロのグラフィックデザイナーが、お客様のニーズに合わせたグラフィックを、最適な方法でご提供します。</dd>
                            </dl>
                            <dl>
                                <dt class="fs14"><a href="custom.html"><img alt="" height="60"
                                                                            src="images/about/thm_custom_01.jpg"
                                                                            width="180"></a><span><a class="lnk"
                                                                                                     href="custom.html">別注企画</a></span>
                                </dt>
                                <dd class="fs12">自社の生産ノウハウを活かし、オリジナルウェア、ノベルティーなどの商品を、企画から生産までワンストップで提供します。</dd>
                            </dl>
                            <dl class="end">
                                <dt class="fs14"><a href="contents.html"><img alt="" height="60"
                                                                              src="images/about/thm_contents_01.jpg"
                                                                              width="180"></a><span><a class="lnk"
                                                                                                       href="contents.html">コンテンツ企画</a></span>
                                </dt>
                                <dd class="fs12">キャラクター、アーティスト、ブランドなどのコンテンツのブッキングから商品化まで、パッケージでお客様に提案します。</dd>
                            </dl>
                        </div>
                    </div>
                </div>
                <div class="fs12" id="sideArea">
                    <div id="menuBox">
                        <p id="menuTitle"><img alt="ABOUT TOMS" height="24"
                                               src="<%request.getContextPath(); %>/resources/images/ttl_menu_01.gif"
                                               width="210"></p>
                        <ul id="menuList"><!--
									-->
                            <li class="now"><a href="index.html" class="current">トムスについて&nbsp;-&nbsp;TOP</a></li><!--
									-->
                            <li><a href="printable.html">プリンタブルウェアとは</a></li><!--
									-->
                            <li><a href="business.html">ビジネスモデル</a></li><!--
									-->
                            <li><a href="technology.html">プリンタブル技術</a></li><!--
									-->
                            <li><a href="logistics.html">サプライチェーン</a></li><!--
									-->
                            <li><a href="graphic.html">グラフィック企画</a></li><!--
									-->
                            <li><a href="custom.html">別注企画</a></li><!--
									-->
                            <li><a href="contents.html">コンテンツ企画</a></li><!--
									-->
                            <li><a href="office.html">事業・組織体制</a></li><!--
									-->
                            <li><a href="mission.html">いちばんの約束</a></li><!--
								--></ul>
                    </div>
                    <dl class="pt30">
                        <dt><a href="../brand/index.html" target="_blank"><img
                                src="<%request.getContextPath(); %>/resources/images/bnr_cmn_01.gif"
                                width="200" height="60" alt="BLANDS"></a>
                        </dt>
                        <dd><a href="../brand/index.html" class="lnk">トムス ブランドサイト</a></dd>
                    </dl>
                    <dl class="pt20">
                        <dt><a href="../lab/index.html" target="_blank"><img
                                src="<%request.getContextPath(); %>/resources/images/bnr_cmn_02.gif"
                                width="200" height="60"
                                alt="Printable Lab."></a></dt>
                        <dd><a href="../lab/index.html" target="_blank" class="lnk">プリンタブル ラボラトリー</a></dd>
                    </dl>
                    <dl class="pt20">
                        <dt><a href="../ebook/index.html" target="_blank"><img
                                src="<%request.getContextPath(); %>/resources/images/bnr_cmn_03.jpg"
                                width="200" height="60"
                                alt="Digital catalog"></a></dt>
                        <dd><a href="../ebook/index.html" target="_blank" class="lnk">電子カタログ</a></dd>
                    </dl>
                </div>
            </div>
            <p id="pageTop"><a href="#Container"><img src="../common/images/btn_cmn_04.gif" width="70" height="21"
                                                      alt="このページの先頭へ"></a></p>
        </div>
    </div>
</div>
</body>
</html>
