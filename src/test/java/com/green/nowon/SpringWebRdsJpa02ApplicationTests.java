package com.green.nowon;

import com.green.nowon.domain.dao.MyBoardMapper;
import com.green.nowon.domain.dto.mybatis.MyBoardDTO;
import com.green.nowon.domain.entity.BoardEntity;
import com.green.nowon.domain.entity.BoardEntityRepository;
import com.green.nowon.domain.entity.ReplyEntity;
import com.green.nowon.domain.entity.ReplyEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
class SpringWebRdsJpa02ApplicationTests {
    @Autowired
    BoardEntityRepository repository;

    @Autowired
    ReplyEntityRepository replyEntityRepository;

    @Autowired
    MyBoardMapper myBoardMapper;

    @Test
    void insertTest(){
        MyBoardDTO obj= MyBoardDTO.builder()
                .title("제목테스트").content("내용테스트").writer("작성자Text")
                .build();

        myBoardMapper.save(obj);
    }

    @Test
    void 댓글생성(){
        // IntStream.rangeClosed(1, 100).forEach(i->{
        //int bno=205;
        replyEntityRepository.save(ReplyEntity.builder()
                        .text("번의 댓글입니다.2")
                        .writer("작성자2")
                        //.board(BoardEntity.builder().bno(bno).build())  //FK 객체의 PK
                        .build());
        // });

    }

    @Test
    void 더미() {
        IntStream.rangeClosed(4, 104).forEach(i->{
            repository.save(
                    BoardEntity.builder()
                            .title("제목"+i)
                            .content("내용"+i)
                            .build());
        });
    }

    @Test
    void contextLoads() {
        repository.save(
                BoardEntity.builder()
                        .title("제목02")
                        .content("내용02")
                        .build());
    }

    @Test
    void 데이터_모두_삭제(){
        repository.deleteAll();
    }

    @Test
    void 삭제_id(){
        repository.deleteById(4);
    }

    @Test
    void 게시글_상세페이지(){
        int bno=205;
        BoardEntity result= repository.findById(bno).orElseThrow();
        System.out.println(result);
        System.out.println(">>>>>>>>>>댓글");
        List<ReplyEntity> replyResult = replyEntityRepository.findByBoardEntityBno(bno);
        for(ReplyEntity r: replyResult){
            System.out.println(r);
        }
    }
    @Transactional
    @Test
    void 게시글_상세페이지2(){
        int bno=205;
        BoardEntity result= repository.findById(bno).orElseThrow(); //세션이 종료됨 --> @Transactipnal 이용하거나
        System.out.println(result);                         //지연로딩 하지말고 무조건 읽어줘 = fetch EAGER 옵션사용 -->비추천(데이터양 많으면 오래걸림)
                                                            //@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
        result.getReplies().forEach(System.out::println);
    }
}
