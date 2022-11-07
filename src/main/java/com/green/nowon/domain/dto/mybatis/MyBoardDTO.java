package com.green.nowon.domain.dto.mybatis;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter     //htmlpage에 EL로 데이터를 표기하기 위해 필요
@Setter     //page -> Controller의 파라미터 매핑을 위해 필요
public class MyBoardDTO {

    private long bno;
    private String title;
    private String content;
    private int readCount;
    private String writer;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

}
