package web.dto;

import lombok.*;
import web.domain.BoardEntity;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardDto {

    private int bno;
    private String btitle;
    private String bcontent;


    public BoardEntity toentity(){
        return BoardEntity.builder()
                .bno(this.bno)
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .build();
    }
}
