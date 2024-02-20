
$(function()){
    $("#img").on("change",function( event ){
        var file = event.target.files[0];
        var reader = new FileReader();
        reader.onload=function(e){
            $("#preview").css("background", "url("+e.target.result+") no-repeat center");
            $("#priview").css("background-size","contain");
        };
        reader.readAsDataURL( file);
    });
}