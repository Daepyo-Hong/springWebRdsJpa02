package com.green.nowon.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@ToString(exclude = "replies")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(
        name = "gen_seq_bo",    //SequenceGenerator 이름
        sequenceName = "seq_bo",//시퀀스 이름  mariadb : nextval(seq_bo) 로 사용
        initialValue = 1,       //start with 1
        allocationSize = 1)     //increment by 1
@Table(name = "jpa_board")  //카멜로 써도 알아서 변환해줘요
@Entity //ORM 기술 표준 jpa, 물리DB의 테이블과 매핑되는 클래스 : 클래스이름 == table이름, 필드이름(caMel) == column명(under_score)
public class BoardEntity {    //접속객체(DAO : Repository) 같이 만듭시다.

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //mariadb가능 : auto_increment
    @GeneratedValue(generator = "gen_seq_bo", strategy = GenerationType.SEQUENCE)//oracle,mariadb가능
    private int bno;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "LONGTEXT not null")   //mariadb
   // @Column(columnDefinition = "CLOB not null") //oracle
    private String content;
    private int readCount;
    private String writer;


    @CreationTimestamp  //hibernate 어노테이션
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(columnDefinition = "timestamp(6)")   //mariadb에서 timestamp 적용
    private LocalDateTime updatedDate;


    
    
    //1:n   
    //@JoinColumn(name = "bno") // 다 쪽 테이블에 생성되는 컬럼명 : 연관테이블이 만들어지지 않음
    //@JoinColumn     //다 쪽 테이블에 fk컬럼명 replies_bno 생성 객체변수이름_pk이름
    //@OneToMany  //기본적으로 연계테이블을 생성해서 두 테이블을 join한다.: 불편함- 원치않은 테이블이 생성될 수 있다.
    //List<ReplyEntity> replies;

    //관계 설정은 단방향 기준, 양방향 쓰면 문제 발생 가능
    //양방향 쓰려면 무한참조 문제 해결위해 @ToString(exclude = "replies") 같은걸 설정
    //두 엔티티에서 설정한 양방향설정에서는 주(owns:소유) 엔티티는 @JoinColumn 설정된 쪽임
    //연계 테이블을 만들지 않게끔 설정 해주어야함,
    //


    @OneToMany(mappedBy = "board") //mappedBy를 이용해서 : owns 에서 만들어주는 FK 같이 사용
    List<ReplyEntity> replies; // = new Vector<>();
}
