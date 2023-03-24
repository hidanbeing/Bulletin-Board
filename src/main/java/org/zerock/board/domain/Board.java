package org.zerock.board.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity{

    // key를 생성하는 방법
    // 1. IDENTITY : auto_increment 데이터베이스에 위임
    // 2. SEQUENCE : 데이터베이스 시퀀스 오브젝트 사용 -> @SequenceGenerator
    // 3. TABLE : 키 생성용 테이블 사용 -> @TableGenerator
    // 4. AUTO : 기본 값


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    private String writer;

    public void change(String title, String content){
        this.title = title;
        this.content = content;
    }

}
