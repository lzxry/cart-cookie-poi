//自动判断主体区域的高度；
window.onload = window.onresize = function(){
    var headerH=$("header").height();
    var footerH = $("footer").height();
    var allHeight = $(window).height();
    var containerHeight = headerH +footerH+ $(".wrap").height();
    if(containerHeight > allHeight){
        $(".wrap").css("height","auto");
        $(".if-bot2").removeClass("fixed");
    }else{
    	if (footerH !=null) {
    		$(".wrap").css("height",allHeight-headerH-footerH)
    	}else{
    		$(".wrap").css("height",allHeight-headerH)
    	}
    }
}

// 会员中心左侧手风琴菜单
$('.main_left>ul>li>a').click(function () {
    var dom = $(this).next();
    dom.toggle();
    var i = $(this).find('i');
    if (i.hasClass('fa-chevron-right'))
    {
        i.removeClass('fa-chevron-right').addClass('fa-chevron-down');
       
    }
    else
    {
        i.removeClass('fa-chevron-down').addClass('fa-chevron-right');
        
    }
});
$('.main_left>ul li> a').click(function(){
    $('.main_left>ul li a').removeClass('active')
    $(this).addClass('active');

})

// 首页轮播
$(document).ready(function(){
    // 焦点图
    $('.bxslider').bxSlider({
        speed: 800,
        controls: false, 
        autoHover: true,  
        auto: true
    });
});
 // 首页tab切换
$('#myTab a').click(function (e) {
    e.preventDefault();
    $(this).tab('show');
})


// 文本滚动函数

function autoScroll(obj, ul_bz){
    $(obj).find(ul_bz).animate({
        marginTop : "-44px"
    },500,function(){
        $(this).css({marginTop : "0px"}).find("li:first").appendTo(this);
    });
    }
setInterval('autoScroll("#scrollDiv", "#scrollList")',3000)

$(function(){
    // 商品分类
    $('.index_shop_fl').hover(function(){
        $('.shop_All').show()

    },function(){
    $('.shop_All').hide()
    })
    $('.shop_All>ul>li').hover(function(){
        $('.shop_erji').hide()
        $(this).find('.shop_erji').show()
        // alert(1)
    },function(){
        $('.shop_erji').hide()
    })

    // 分类搜索结果
    $('.shaix_more').click(function(){
        var atr_class=$('.shaixuan_cont').attr('class');
        if (atr_class=='shaixuan_cont') {
            $('.shaixuan_cont').addClass('active')
            $(this).find('i').removeClass('fa-angle-down').addClass('fa-angle-up')
        }else{
            $('.shaixuan_cont').removeClass('active')
            $(this).find('i').removeClass('fa-angle-up').addClass('fa-angle-down')
        }
    })

    $('.shaixuan_cont ul li div h4 a').click(function(){
        $(this).addClass('act').siblings().removeClass('act')
    })
    $('.paixu_cont .table tr td p').click(function(){
        var td_p_cla=$(this).find('i').attr('class');
         $('.paixu_cont .table tr td').removeClass('active')
            $(this).parent().addClass('active')
        if (td_p_cla=='fa fa-arrow-down') {
            $(this).find('i').removeClass('fa-arrow-down').addClass('fa-arrow-up')
        }else{
            $(this).find('i').removeClass('fa-arrow-up').addClass('fa-arrow-down')
        }
        

    })
    $('.pinpai_list a').click(function(){
        var a_attr=$(this).attr('class');
        if (a_attr==undefined || a_attr=='') {
           
            $(this).addClass('active')
        }else{
             $(this).removeClass('active')
        }
        
    })
      // 服务商搜索结果页
      $('.fws_sousuo_list dl dd h4 a').click(function(){
            var a_attr2=$(this).attr('class');
            if (a_attr2==undefined || a_attr2=='') {
               
                $(this).addClass('font_red')
            }else{
                 $(this).removeClass('font_red')
            }
      })
      // banner图片的宽度
      
          $('.banner_imgs li a img').each(function(){
                var banner_img_w=parseInt($(this).width()),
                banner_img_left=-(banner_img_w/2);
                $(this).css('margin-left',banner_img_left)
          })

    // 结束
})

//$('.first-floor .biao .qing').bind('click',function(){
//    $(' .first-floor .biao .zhongxin').css({display:'block'});
//    $('.quan').css({display:'block'});
//})
//$('.second-floor .biao .qing').bind('click',function(){
//    $(' .second-floor .biao .zhongxin').css({display:'block'});
//    $('.quan').css({display:'block'});
//})
//$('.third-floor .biao .qing').bind('click',function(){
//    $(' .third-floor .biao .zhongxin').css({display:'block'});
//    $('.quan').css({display:'block'});
//})
//$('.first-floor .biao .zhongxin .quxiao').bind('click',function(){
//     $(' .first-floor .biao .zhongxin').css({display:'none'});
//    $('.quan').css({display:'none'});
//})
//$('.second-floor .biao .zhongxin .quxiao').bind('click',function(){
//     $(' .second-floor .biao .zhongxin').css({display:'none'});
//    $('.quan').css({display:'none'});
//})
//$('.third-floor .biao .zhongxin .quxiao').bind('click',function(){
//     $(' .third-floor .biao .zhongxin').css({display:'none'});
//    $('.quan').css({display:'none'});
//})
//
//
//$('.first-floor .biao .zhongxin .que').bind('click',function(){
//     $(' .first-floor .biao .zhongxin').css({display:'none'});
//    $('.quan').css({display:'none'});
//})
//$('.second-floor .biao .zhongxin .que').bind('click',function(){
//     $(' .second-floor .biao .zhongxin').css({display:'none'});
//    $('.quan').css({display:'none'});
//})
//$('.third-floor .biao .zhongxin .que').bind('click',function(){
//     $(' .third-floor .biao .zhongxin').css({display:'none'});
//    $('.quan').css({display:'none'});
//})