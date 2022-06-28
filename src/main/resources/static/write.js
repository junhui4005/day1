
function save(){
    let form = $("#save")[0];
        let formdata = new FormData( form );
        $.ajax({
            url : "/write" ,
            data : formdata ,
            method : "POST",
            processData : false ,
            contentType : false ,
            success : function( re ){
                if( re == true ){
                        alert("쓰기완");
                        location.href = "/";
                }else{
                        alert("쓰기 실패");
                }
            }
        });
}
