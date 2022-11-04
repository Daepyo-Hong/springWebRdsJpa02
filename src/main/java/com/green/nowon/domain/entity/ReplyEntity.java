package com.green.nowon.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@ToString(exclude = "board")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "gen_seq_reply"
                , sequenceName = "seq_reply"
                , allocationSize = 1
                , initialValue = 1)
@Entity
public class ReplyEntity {
    @Id
    @GeneratedValue(generator = "gen_seq_reply", strategy = GenerationType.SEQUENCE)
    private int rno;
    @Column(nullable = false)
    private String text;
    private String writer;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;
    //private int bno;
    //1:n n:1 == 이론적으로는 모두 일대다
    //다대 일 관계에요
   // @JoinColumn(name = "bno")
   // @ManyToOne
   // BoardEntity board; //관계설정
    //FK컬럼명 : board_bno : 객체.pk이름-> 객체이름_pk이름

    @JoinColumn(nullable = false) //양방향관계에서 Many 엔티티를 owns 엔티티로 선언
    @ManyToOne  //mappedBy가 존재하지 않아요
    BoardEntity board; //관계설정
}
