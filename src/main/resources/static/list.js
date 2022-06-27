list();
function list(){
        $.ajax({
            url : "/list" ,
             method : "POST",
            success : function( list ){
                console.log(list);
                let html = "";
                for( let i = 0 ; i<list.length ; i++ ){
                    html +=
                            '<tr>'+
                                    '<td>'+list[i].bno+'</td> '+
                                    '<td><a href="/board/view/'+list[i].bno+'">'+list[i].btitle+'<a></td> '+
                             '</tr>';
                }
                $("#listtable").html( html );
            }
        });
}