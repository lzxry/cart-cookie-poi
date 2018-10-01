/**
 * Created by pfmaoa on 2016/8/5.
 */
$(function(){
    $(".goods-sm-img div img").hover(function(){
        $(".goods-sm-img div").removeClass("active");
        $(this).parent().addClass("active");
        $(".goods-bigimg").attr("src",$(this).attr("src"));
    })
    if(h=$(".goods-box-right-ul li").length>0){
        h=$(".goods-box-right-ul li").css("height").replace("px","")
        height=h*$(".goods-box-right-ul li").length;
        $(".goods-box-right-ul").css("height",height);

        $(".goods-ul-next").click(function(){
            num=parseInt($(".num-position").text());
            if($(".goods-box-right-ul li").length>3){
                if($(".goods-box-right-ul li").length-num<=3){
                    return false
                }
                $(".goods-box-right-ul").animate({top:'-=140px'}, 800);
                $(".num-position").text(num+1);
            }

        })
        $(".goods-ul-prev").click(function(){
            num=parseInt($(".num-position").text());
            if($(".goods-box-right-ul li").length>3){
                if(num<=0){
                    return false;
                }
                $(".goods-box-right-ul").animate({top:"+=140px"},800);
                $(".num-position").text(num-1);
            }

        })
    }


    $(".g-goods-title h1").click(function(){
        num=$(this).index();
        $(".g-goods-title h1").removeClass("active")
        $(this).addClass("active");
        $(".jieshu-tab").addClass("hide");
        $(".jieshu-tab").eq(num).removeClass("hide");
    })
    $(".xieyi").click(function(){
        if($(this).hasClass("active")){
           // alert(1);
            $(this).removeClass("active");
             $('.jingpai-price button').css('background','#ccc')
             $('.jingpai-price button').attr('disabled',true)
        }
        else{
            $(this).addClass("active");
            $('.jingpai-price button').css('background','#3a7dda')
            $('.jingpai-price button').attr('disabled',false)
        }
    })

    $(".sc-name").click(function(){
        //alert(1);
        if( $(this).find("i").hasClass("active")){

            $(this).find("i").removeClass("active")
        }else{
            $(this).find("i").addClass("active")
        }

    })


    $(".sc-selectall input").change(function(){
        if($(this).is(':checked')){
           /// alert(1);
            $(this).prop({checked:true});

            $(".sc-name i").addClass("active");
        }
        else{
            $(this).prop({checked:false});
            $(".sc-name i").removeClass("active");
        }
    })
    $(".jian").click(function(){
        val=$(".jicai-num").val();


        if(val=="" || val==0){
            return false;
        }
        else{
            val=parseInt(val);
            val-=1;
            //alert(val);
            $(".jicai-num").val(val);
        }

    })
    $(".jia").click(function(){
        val=$(".jicai-num").val();


        if(val==""){
            $(".jicai-num").val(1);
        }
        else{
            val=parseInt(val);
            val+=1;
            //alert(val);
            $(".jicai-num").val(val);
        }

    })
    $(".bank-list ul li").click(function(){
        //alert(1);
        if( $(this).find("b").hasClass("active")){

            $(this).find("b").removeClass("active")
        }else{
            $(".bank-list ul li b").removeClass("active");
            $(this).find("b").addClass("active")
        }

    })

    $("input[name^='pwd']").each(function() {
        $(this).focus(function(e){
            e = window.event || e;
            var k = e.keyCode || e.which;
            if($(this).prev().val()==""){
                $(this).prev().focus();

            }
        })
        $(this).keyup(function(e) {

            if ($(this).val().length > 0) {
                $(this).next().focus();

            }

        })
    })

    $(".add-address-c").click(function(){
        $(".add-address").hide();
    })


    //收银台  9.4开始
    $(".money-type span").click(function(){
        $(".money-type span").find("b").removeClass("active");
        $(this).find("b").addClass("active");
    })
    //收银台  9.4结束
})