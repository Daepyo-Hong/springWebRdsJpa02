package com.green.nowon.domain.dto.mybatis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MyBoardDTO {

    private long bno;
    private String title;
    private String content;
    private int readCount;
    private String writer;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

}
