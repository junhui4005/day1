view();

function view(){
    $.ajax({
        url: '/view' ,
        success : function( board ){
            let html =
                           ' <div>게시물번호 : '+board.bno+'</div>'+
                            '<div>게시물제목 : '+board.btitle+' </div>'+
                            '<div>게시물내용 : '+board.bcontent+' </div>'+
                            '<button onclick="bdelete('+board.bno+')"> 삭제 </button>';
            $("#boarddiv").html(html);
        }
    });
}
function bdelete(){
function board_delete( bno ){
      $.ajax({
         url : "/delete" ,
         data : { "bno" : bno } ,
         method : "DELETE",
         success : function( re ){
            alert( re );
         }
     });
}