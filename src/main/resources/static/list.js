list();
function list(){
        $.ajax({
            url : "/list" ,
             method : "POST",
            success : function( list ){
                console.log(list);
                let html = "";
                for( let i = 0 ; i<list.list.length ; i++ ){
                    html +=
                            '<tr>'+
                                    '<td>'+list.list[i].bno+'</td> '+
                                    '<td><a href="/view/'+list.list[i].bno+'">'+list.list[i].btitle+'<a></td> '+
                             '</tr>';
                }
                $("#listtable").html( html );
            }
        });
}