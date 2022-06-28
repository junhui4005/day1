
alert('jjj');
//
//bview();
//function bview(){
//alert("ss");
//    $.ajax({
//        url: '/view' ,
//        method : "GET",
//        success : function( board ){
//        console.log(board)
//            let html =
//                           ' <div>게시물번호 : '+board.bno+'</div>'+
//                            '<div>게시물제목 : '+board.btitle+' </div>'+
//                            '<div>게시물내용 : '+board.bcontent+' </div>'+
//                            '<button onclick="bdelete('+board.bno+')"> 삭제 </button>';
//            $("#board").html(html);
//        }
//    });
//}
//function bdelete( bno){
//      $.ajax({
//         url : "/delete" ,
//         data : { "bno" : bno } ,
//         method : "DELETE",
//         success : function( re ){
//            alert( re );
//         }
//     });
//}