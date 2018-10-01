<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/resources/inc/inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
	<link rel="stylesheet" href="<%=path%>/resources/bootstrap/JSCSS/bootstrap.css"/>
    <link rel="stylesheet" href="<%=path%>/resources/bootstrap/JSCSS/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path%>/resources/bootstrap/JSCSS/buttons.css">
    <link rel="stylesheet" href="<%=path%>/resources/csss/jquery.bxslider.css">
    <!---->
    <link rel="stylesheet" href="<%=path%>/resources/csss/base.css"/>
    <link rel="stylesheet" href="<%=path%>/resources/csss/index.css"/>
    <link rel="stylesheet" href="<%=path%>/resources/csss/order.css"/>
</head>
<body>
<!-- 头部开始 -->
<header>
    <div class="index_topbar">
        <div class="container">
            <div class="pull-left">
                <span>你好，欢迎来到众陶联平台；</span>
                <p><a href="javascript:;">登录</a><a href="javascript:;">注册</a></p>
            </div>
            <div class="pull-right index_top_list">
                <ul>
                    <li>
                        <a href="javascript:;">我的订单</a>
                    </li>
                    <li>
                        <a href="javascript:;">会员中心</a>
                    </li>
                    <li>
                        <a href="javascript:;">收藏夹</a>
                    </li>
                    <li>
                        <a href="javascript:;"><img src="<%=path%>/resources/images/logo_03.png" alt="">积分商城</a>
                    </li>
                    <li>
                        <a href="javascript:;">在线客服</a>
                    </li>
                    <li>
                        <span>免费热线：400-888-665</span>
                    </li>
                </ul>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="index_Logo">
        <div class="container">
            <div class="pull-left">
                <a href="/shopping/list" class="index_logo"><img src="<%=path%>/resources/images/logo_07.png" alt=""></a>
            </div>
            <div class="pull-left index_search">
                <div class="search_input">
                    <select name="" id="">
                        <option value="1">服务商</option>
                        <option value="1">供货商</option>
                    </select>
                    <input type="text" value="李引的购物车">
                    <input type="button" value="搜索">
                    <div class="clear"></div>
                </div>
                <div class="gjc">
                    <p>
                        <a href="javascript:;">混筒</a>
                        <a href="javascript:;">纸箱</a>
                        <a href="javascript:;">混筒印</a>
                        <a href="javascript:;">泡沫</a>
                        <a href="javascript:;">大包袋</a>
                        <a href="javascript:;">耗材</a>
                    </p>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="index_nav">
        <div class="container">
            <div class="pull-left index_shop_fl">
                <h4 class="shop_top"><i class="fa fa-list-ul"></i>商品分类</h4>
                <div class="shop_All">
                    <ul>
                        <li>
                            <div class="shop_all_list">
                                <h5><img src="<%=path%>/resources/images/shop_03.png" alt=""><span class="pull-right">&gt;</span>砂泥原料</h5>
                                <p>
                                    <span>砂类</span>
                                    <span>滑石类</span>
                                    <span>超白料</span>
                                </p>
                            </div>
                            <div class="shop_erji">
                                <div class="pull-left">
                                    <ol>
                                        <li>
                                            <strong>砂类</strong>
                                            <a href="javascript:;">高温砂</a>
                                            <a href="javascript:;">中温砂</a>
                                            <a href="javascript:;">低温砂</a>
                                        </li>
                                        <li>
                                            <strong>滑石类</strong>
                                            <a href="javascript:;">石粉类</a>
                                            <a href="javascript:;">石粒类</a>
                                            <a href="javascript:;">加工长石类</a>
                                        </li>
                                        <li>
                                            <strong>超白科</strong>
                                            <a href="javascript:;">超白类</a>
                                            <a href="javascript:;">超白石类</a>
                                        </li>
                                    </ol>
                                </div>
                                <div class="pull-right">
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_03.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_06.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_08.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_12.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_16.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="shop_all_list">
                                <h5><img src="<%=path%>/resources/images/shop_06.png" alt=""><span class="pull-right">&gt;</span>化工原料</h5>
                                <p>
                                    <span>坯用色料</span>
                                    <span>釉用色料</span>
                                </p>
                            </div>
                            <div class="shop_erji">
                                <div class="pull-left">
                                    <ol>
                                        <li>
                                            <strong>坯用色料</strong>
                                            <a href="javascript:;">高温砂</a>
                                            <a href="javascript:;">中温砂</a>
                                            <a href="javascript:;">低温砂</a>
                                        </li>
                                        <li>
                                            <strong>釉用色料</strong>
                                            <a href="javascript:;">石粉类</a>
                                            <a href="javascript:;">石粒类</a>
                                            <a href="javascript:;">加工长石类</a>
                                        </li>
                                    </ol>
                                </div>
                                <div class="pull-right">
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_03.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_06.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_08.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_12.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_16.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="shop_all_list">
                                <h5><img src="<%=path%>/resources/images/shop_09.png" alt=""><span class="pull-right">&gt;</span>燃料</h5>
                                <p>
                                    <span>煤炭</span>
                                    <span>燃油</span>
                                    <span>重油</span>
                                </p>
                            </div>
                            <div class="shop_erji">
                                <div class="pull-left">
                                    <ol>
                                        <li>
                                            <strong>煤炭</strong>
                                            <a href="javascript:;">高温砂</a>
                                            <a href="javascript:;">中温砂</a>
                                            <a href="javascript:;">低温砂</a>
                                        </li>
                                        <li>
                                            <strong>燃油</strong>
                                            <a href="javascript:;">石粉类</a>
                                            <a href="javascript:;">石粒类</a>
                                            <a href="javascript:;">加工长石类</a>
                                        </li>
                                        <li>
                                            <strong>重油</strong>
                                            <a href="javascript:;">超白类</a>
                                            <a href="javascript:;">超白石类</a>
                                        </li>
                                    </ol>
                                </div>
                                <div class="pull-right">
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_03.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_06.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_08.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_12.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_16.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="shop_all_list">
                                <h5><img src="<%=path%>/resources/images/shop_12.png" alt=""><span class="pull-right">&gt;</span>包装材料</h5>
                                <p>
                                    <span>纸箱</span>
                                    <span>泡沫</span>
                                    <span>打包带</span>
                                </p>
                            </div>
                            <div class="shop_erji">
                                <div class="pull-left">
                                    <ol>
                                        <li>
                                            <strong>纸箱</strong>
                                            <a href="javascript:;">高温砂</a>
                                            <a href="javascript:;">中温砂</a>
                                            <a href="javascript:;">低温砂</a>
                                        </li>
                                        <li>
                                            <strong>泡沫</strong>
                                            <a href="javascript:;">石粉类</a>
                                            <a href="javascript:;">石粒类</a>
                                            <a href="javascript:;">加工长石类</a>
                                        </li>
                                        <li>
                                            <strong>打包带</strong>
                                            <a href="javascript:;">超白类</a>
                                            <a href="javascript:;">超白石类</a>
                                        </li>
                                    </ol>
                                </div>
                                <div class="pull-right">
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_03.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_06.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_08.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_12.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_16.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="shop_all_list">
                                <h5><img src="<%=path%>/resources/images/shop_16.png" alt=""><span class="pull-right">&gt;</span>五金设备</h5>
                                <p>
                                    <span>机械配件</span>
                                    <span>电器设备</span>
                                </p>
                            </div>
                            <div class="shop_erji">
                                <div class="pull-left">
                                    <ol>
                                        <li>
                                            <strong>机械配件</strong>
                                            <a href="javascript:;">高温砂</a>
                                            <a href="javascript:;">中温砂</a>
                                            <a href="javascript:;">低温砂</a>
                                        </li>
                                        <li>
                                            <strong>电器设备</strong>
                                            <a href="javascript:;">石粉类</a>
                                            <a href="javascript:;">石粒类</a>
                                            <a href="javascript:;">加工长石类</a>
                                        </li>
                                    </ol>
                                </div>
                                <div class="pull-right">
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_03.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_06.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_08.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_12.png" alt=""></a>
                                    <a href="javascript:;"><img src="<%=path%>/resources/images/erj_16.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="pull-left index_nav_ls">
                <ul>
                    <li><a href="javascript:;">首页</a></li>
                    <li><a href="javascript:;">交易大厅</a></li>
                    <li><a href="javascript:;">众陶商城</a></li>
                    <li><a href="javascript:;">众陶融</a></li>
                    <li><a href="javascript:;">众陶通</a></li>
                    <li><a href="javascript:;">品牌馆</a></li>
                    <li><a href="javascript:;">服务中心</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
</header>
<!-- 头部结束 -->

<section>
    <div class="container mt15 mb15">
        <div class="g-goods-title">
            <h1 class="active">全部商品</h1>
        </div>

        <div class="catbox">
            <table id="cartTable">
                <thead>
                <tr>
                    <th style="text-align: center"><label>
                        <input class="check-all check" type="checkbox"/>&nbsp;&nbsp;全选</label></th>
                    <th>商品信息 </th>
                    <th style="text-align: center">商品名</th>
                    <th style="text-align: center">赠品</th>
                    <th style="text-align: center">单价</th>
                    <th style="text-align: center">数量</th>
                    <th style="text-align: center">金额</th>
                    <th style="text-align: center">操作</th>
                </tr>
                </thead>
                <tbody class="buycar-tbody">
                <tr>
                    <td colspan="6" align="left">
                        店铺：北京Lzxry铺子
                    </td>
                </tr>
             <c:forEach items="${cartGoods }" var="goods" varStatus="vs">
                <tr class="goods-tr">
                    <td class="checkbox-goods" valign="top"><input class="check-one check" type="checkbox"/></td>
                    <td  valign="middle">
                        <div class="pull-left"> <img class="img-thumbnail img-responsive" alt="图片仅供参考" src="${goods.img_path }" width="100px" height="100px"></div>
                    </td>
                     <td class="count-input">
                                     ${goods.name }
                                    </td>
                     <td class="count-input">
                                       赠:${goods.gift }
                                    </td>
                    <td class="price">${goods.price }</td>
                    <td class="count"><span class="reduce">-</span>
                        <input class="count-input" id="${goods.id}" type="text" value="${goods.number } "/>
                        <input class="count-input" type="hidden" value="${goods.id } "/>
                        <span class="add" >+</span></td>
                    <td class="subtotal">${goods.price*goods.number }</td>
                    <td class="operation"><span class="delete">删除</span></td>
                </tr>
             </c:forEach>
                </tbody>
                <tbody class="buycar-tbody">
                </tbody>
            </table>
            <div class="foot" id="foot">
                <label class="fl select-all"><input type="checkbox" class="check-all check"/>&nbsp;&nbsp;全选</label>
                <a class="fl delete" id="deleteAll" href="javascript:;">选中删除</a>
                <div class="fr closing" onclick="getTotal();">结 算</div>
                <input type="hidden" id="cartTotalPrice" />
                <div class="fr total">合计：￥<span id="priceTotal">0.00</span></div>
                <div class="fr selected" id="selected">已选商品
                    <span id="selectedTotal">0</span>件
                </div>
                <div class="selected-view">
                    <div id="selectedViewList" class="clearfix">
                        <div><img src="#"><span>取消选择</span></div>
                    </div>
                    <span class="arrow">◆<span>◆</span></span> </div>
            </div>
        </div>

    </div>
</section>


<!-- 底部菜单 -->
<div class="footer">
    <div class="container">
        <div class="foot_title">
            <a href="javascript:;">
                <img src="<%=path%>/resources/images/img_97.png" alt="">
                <span>智能物流</span>
            </a>
            <a href="javascript:;">
                <img src="<%=path%>/resources/images/img_100.png" alt="">
                <span>定制生产</span>
            </a>
            <a href="javascript:;">
                <img src="<%=path%>/resources/images/img_102.png" alt="">
                <span>标准产品</span>
            </a>
            <a href="javascript:;">
                <img src="<%=path%>/resources/images/img_105.png" alt="">
                <span>账期担保</span>
            </a>
            <a href="javascript:;">
                <img src="<%=path%>/resources/images/img_108.png" alt="">
                <span>服务中心</span>
            </a>
            <div class="clear"></div>
        </div>
        <div class="foot_list">
            <div class="pull-left fl_left">
                <ul>
                    <li>
                        <h4>我的采购</h4>
                    </li>
                    <li>
                        <a href="javascript:;">发布采购产品</a>
                    </li>
                    <li>
                        <a href="javascript:;">创建采购申请</a>
                    </li>
                    <li>
                        <a href="javascript:;">发布询价单</a>
                    </li>
                    <li>
                        <a href="javascript:;">采购优选</a>
                    </li>
                    <li>
                        <a href="javascript:;">采购确认订单</a>
                    </li>
                    <li>
                        <a href="javascript:;">订单收货</a>
                    </li>
                    <li>
                        <a href="javascript:;">订单付款</a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <h4>我的销售</h4>
                    </li>
                    <li>
                        <a href="javascript:;">发布供应产品</a>
                    </li>
                    <li>
                        <a href="javascript:;">报价</a>
                    </li>
                    <li>
                        <a href="javascript:;">确认订单</a>
                    </li>
                    <li>
                        <a href="javascript:;">订单发货</a>
                    </li>
                    <li>
                        <a href="javascript:;">订单收款</a>
                    </li>
                    <li>
                        <a href="javascript:;">订阅采购信息</a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <h4>员工及企业管理</h4>
                    </li>
                    <li>
                        <a href="javascript:;">新增员工</a>
                    </li>
                    <li>
                        <a href="javascript:;">设置员工上下级关系</a>
                    </li>
                    <li>
                        <a href="javascript:;">维护企业信息</a>
                    </li>
                    <li>
                        <a href="javascript:;">申请企业认证</a>
                    </li>
                    <li>
                        <a href="javascript:;">维护企业门户</a>
                    </li>
                    <li>
                        <a href="javascript:;">维护企业地址</a>
                    </li>
                </ul>
                <ul>
                    <li>
                        <h4>注册及登录问题</h4>
                    </li>
                    <li>
                        <a href="javascript:;">注册</a>
                    </li>
                    <li>
                        <a href="javascript:;">登录</a>
                    </li>
                    <li>
                        <a href="javascript:;">找回密码</a>
                    </li>
                </ul>
                <div class="clear"></div>
            </div>
            <div class="pull-right fl_right">
                <dl>
                    <dt><img src="<%=path%>/resources/images/img_116.jpg" alt=""></dt>
                    <dd><span>官方微信</span></dd>
                </dl>
                <dl>
                    <dt><img src="<%=path%>/resources/images/img_116.jpg" alt=""></dt>
                    <dd><span>App下载</span></dd>
                </dl>
            </div>
        </div>
    </div>
</div>
<!-- 底部菜单结束 -->
<!-- 版权等 -->
<footer>
    <div class="container">
        <p>
            <a href="javascript:;">关于众陶联</a>|
            <a href="javascript:;">联系我们</a>|
            <a href="javascript:;">认证机构登录</a>|
            <a href="javascript:;">客服热线：400-888-666</a>
        </p>
        <p>Copyright © 2015 Powered by Ndtech</p>
        <p>
            <img src="<%=path%>/resources/images/ft_03.jpg" alt="">
            <img src="<%=path%>/resources/images/ft_05.jpg" alt="">
            <img src="<%=path%>/resources/images/ft_07.jpg" alt="">
        </p>
    </div>
</footer>
<!-- 版权结束 -->

<!-- 轮播图js -->
<script src="<%=path%>/resources/jss/jquery.bxslider.min.js"></script>

<script src="<%=path%>/resources/jss/index.js"></script>
<script src="<%=path%>/resources/jss/goods.js"></script>
<script src="<%=path%>/resources/jss/buyCar.js"></script>

</body>
</html>