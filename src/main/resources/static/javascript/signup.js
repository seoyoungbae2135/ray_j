//20240215-5
$(function(){
    $(".step1").css("color","#222");

// 약관 동의
    $("#allAgree").on("change",function(){
                  var isChk = $(this).is(":checked");
                  if(isChk){
                      $("input[name=accept]").prop('checked',true);
                      $("#join_btn").addClass("on");
                  }else{
                      $("input[name=accept]").prop('checked',false);
                      $("#join_btn").removeClass("on");
                  }
          })
    $("input[name=accept]").on("change",function(){
            var isChk = true;
            var isEssential = $("#agree1").is(":checked") && $("#agree2").is(":checked") && $("#agree3").is(":checked");
            $("input[name=accept]").each(function(i,v){
                    if( !$(v).is(":checked") ){
                        isChk=false;
                        return;
                    }
            })
            $("#allAgree").prop('checked',isChk);
            if(isEssential)
                $("#join_btn").addClass("on");
            else
                $("#join_btn").removeClass("on");
    });

// 가입 양식
    $(".write_list input").on("keyup",function(){
        var isValue=true;
        $(".write_list input").each(function(i,v){
            if( $(v).val()==''  ){
                isValue=false;
                return;
            }
        });

        if( isValue ){
            $("#submit_btn").addClass("on");
        }else{
            $("#submit_btn").removeClass("on");
        }


    });


});

function agreeBt(){
    var hasOn = $("#join_btn").hasClass("on");
        if( !hasOn ){
            alert("필수 약관 동의를 해주세요");
        }else{
            $("#agree_wrap").hide();
            $("#signup_wrap").show();
            $(".step1").css("color","#b7b7b7");
            $(".step2").css("color","#222");
    }
}
function submit(){
    var hasOn = $("#submit_btn").hasClass("on");
    if( hasOn ){
        $("#signFm").submit();
    }else{
        alert("양식을 모두 입력 하세요");
    }
}