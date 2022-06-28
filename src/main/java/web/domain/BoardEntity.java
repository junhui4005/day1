package web.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor@ToString
@Table(name="board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int bno;

    private String btitle;

    private String bcontent;
}
